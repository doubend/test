package com.cloud.icenter.system.user.dao.impl;

import java.sql.Timestamp;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.common.utils.Md5Util;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.user.dao.UserDao;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.pojo.UserRole;

/**
 * 用户数据访问实现类
 * @author zhangle
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public void add(User obj) {
		obj.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		obj.setLoginNum(0);
		obj.setLogonAt(null);
		obj.setNickname(StringUtils.isBlank(obj.getNickname())?obj.getUsername():obj.getNickname());
		obj.setSalt(Md5Util.randomUUID());	//生成32位UUID
		obj.setPassword(Md5Util.makePassword(obj.getPassword(), obj.getSalt()));
		getSession().save(obj);
		
		//添加用户与角色的关联
		addUserRole(obj.getUserId(), obj.getCheckedRoleId());
		addPublicRole(obj.getUserId());
	}
	
	/**
	 * 默认为用户关联public角色
	 * 如果存在public角色则关联,如果不存在,则不关联
	 * @param userId
	 */
	private void addPublicRole(String userId) {
		
		String publicRoleName=SystemConfig.getProperty("system.role.public");
		if(StringUtils.isBlank(publicRoleName)) return;
		
		Role publicRole=super.get(Role.class, "roleName", publicRoleName);
		if(publicRole==null) return;
		
		Criteria criteria=getCriteria(UserRole.class)
				.add(Restrictions.eq("userId", userId))
				.add(Restrictions.eq("roleId", publicRole.getRoleId()));
				
		if(countRow(criteria)==0) {		//如果没有关联public角色,则关联
			addUserRole(userId, new String[]{publicRole.getRoleId()});
		}
	}
	
	/**
	 * 更新用户
	 * 此方法不允许修改用户密码,因此从数据库查询一次,覆盖新密码
	 */
	@Override
	public void update(User obj) {
		User temp=get(obj.getUserId());
		obj.setPassword(temp.getPassword());
		obj.setSalt(temp.getSalt());
		getSession().merge(obj);
		
		//添加用户与角色的关联
		if(obj.getCheckedRoleId()!=null) {
			deleteUserRole(obj.getUserId());
			addUserRole(obj.getUserId(), obj.getCheckedRoleId());
		}
	}
	
	@Override
	public void delete(String id) {
		executeUpdate("delete UserRole where userId=?",id);
		super.delete(id);
	}
	
	@Override
	public User getUserByName(String username) {
		return super.get(User.class, "username", username);
	}

	@Override
	public void updatePassword(String userId, String password) {
		
		User user=get(userId);
		String _tmppwd=Md5Util.makePassword(password, user.getSalt());
		if(user.getPassword().equals(_tmppwd)) {
			throw new RuntimeException("新密码不能与旧密码相同!");
		}
		
		String salt=Md5Util.randomUUID();	//生成32位UUID
		String newpwd=Md5Util.makePassword(password, salt);
		
		Query updateQuery=createQuery("update User set password=:password,salt=:salt where userId=:userId");
		updateQuery.setString("password", newpwd);
		updateQuery.setString("salt", salt);
		updateQuery.setString("userId", user.getUserId());
		updateQuery.executeUpdate();
	}

	@Override
	public void updateAllPassword(String password) {

		Query updateQuery=createQuery("update User set password=:password where userId=:userId");
		Iterator<User> it=getSession().createQuery("from User").iterate();
		while(it.hasNext()) {
			User user=it.next();
			String newpd=Md5Util.makePassword(password, user.getSalt());
			updateQuery.setString("password", newpd);
			updateQuery.setString("userId", user.getUserId());
			updateQuery.executeUpdate();
		}
	}

	/**
	 * 添加用户与角色的关联
	 * @param userId	关联的用户ID
	 * @param roleId	关联的角色ID数组
	 */
	public void addUserRole(String userId, String[] roleId) {
		if(userId==null || roleId==null || roleId.length==0) return;
		for(String _rid:roleId) {
			UserRole ur=new UserRole();
			ur.setUserId(userId);
			ur.setRoleId(_rid);
			getSession().save(ur);
		}
	}
	
	/**
	 * 删除用户与角色的所有关联
	 * @param userId	需要删除关联的用户ID
	 */
	public void deleteUserRole(String userId) {
		if(userId==null) return;
		executeUpdate("delete UserRole where userId=?",userId);
	}

	@Override
	public void updateLoginParams(User user) {
		Query query=createQuery("update User set loginNum=:loginNum,logonAt=:logonAt where userId=:userId");
		query.setInteger("loginNum", user.getLoginNum());
		query.setTimestamp("logonAt", user.getLogonAt());
		query.setString("userId", user.getUserId());
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void findUsersByOrgId(final Pagination<User> pagin, final String[] orgIds , final String params) {
		final StringBuilder hql = new StringBuilder(" SELECT new com.cloud.icenter.system.user.pojo.User(u.userId , ou.id AS organUserId , u.username , u.nickname , u.status , u.loginNum , u.description) ");
		hql.append(" FROM User u , OrganUser ou WHERE u.userId = ou.userId AND ou.orgId IN (:orgId) AND status = :status ");
		if(!StringUtils.isEmpty(params)){
			hql.append(" AND (username LIKE :params OR nickname LIKE :params )");
		}
		Query query = this.createQuery(hql.toString());
		Query countQuery = this.createQuery(hql.toString());
		query.setParameter("status", User.STATUS_DEFAULT);
		query.setParameterList("orgId", orgIds);
		countQuery.setParameter("status", User.STATUS_DEFAULT);
		countQuery.setParameterList("orgId", orgIds);
		if(!StringUtils.isEmpty(params)){
			query.setParameter("params", "%" + params + "%");
			countQuery.setParameter("params", "%" + params + "%");
		}
		pagin.setTotalCount(countQuery.list().size());
		query.setFirstResult((pagin.getPage()-1) * pagin.getPageSize());
		query.setMaxResults(pagin.getPage() * pagin.getPageSize());
		pagin.setDataList(query.list());
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.user.dao.UserDao#findNotInOrg(com.cloud.icenter.common.utils.Pagination, java.lang.String, java.lang.String)
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void findNotInOrg(final Pagination<User> pagin, final String orgId, final String params) {
		final StringBuilder hql = new StringBuilder(" FROM User WHERE id NOT IN (SELECT userId FROM OrganUser WHERE orgId = :orgId) AND status = :status ");
		if(!StringUtils.isEmpty(params)){
			hql.append(" AND (userName LIKE :params OR nickname LIKE :params) ");
		}
		Query query = this.createQuery(hql.toString());
		Query countQuery = this.createQuery(hql.toString());
		query.setParameter("orgId", orgId);
		query.setParameter("status", User.STATUS_DEFAULT);
		countQuery.setParameter("orgId", orgId);
		countQuery.setParameter("status", User.STATUS_DEFAULT);
		if(!StringUtils.isEmpty(params)){
			query.setParameter("params", "%" + params + "%");
			countQuery.setParameter("params", "%" + params + "%");
		}
		pagin.setTotalCount(countQuery.list().size());
		query.setFirstResult((pagin.getPage()-1) * pagin.getPageSize());
		query.setMaxResults(pagin.getPage() * pagin.getPageSize());
		pagin.setDataList(query.list());
	}
	// 根据Unicode编码完美的判断中文汉字和符号
    private  boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
 
    // 完整的判断中文汉字和符号
    public  boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }
}

