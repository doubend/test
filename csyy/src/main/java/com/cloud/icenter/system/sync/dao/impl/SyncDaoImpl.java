package com.cloud.icenter.system.sync.dao.impl;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganUser;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.sync.dao.SyncDao;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.pojo.UserRole;

/**
 * 数据同步实现类
 * @author wuym
 *
 */
@Repository
public class SyncDaoImpl extends BaseDaoImpl<Object> implements SyncDao{

	@Override
	public void saveUserRole(String userId, String roleNames) {
		Query query = this.createQuery("delete from UserRole where userId='"+userId+"'");
		query.executeUpdate();
		String[] roles = roleNames.split(",");
		for(String roleName:roles){
			//认证服务器给的roleId与本地不同 要从本地通过syncId重新获取role对象
			Role role = this.getRoleByName(roleName);
			if(role!=null){
				UserRole userrole= new UserRole();
				userrole.setUserId(userId);
				userrole.setRoleId(role.getRoleId());
				this.add(userrole);
			}
		}
	}

	@Override
	public void saveOrganUser(String userId, String orgIds) {
		String[] orgs = orgIds.split(",");
		for(String orgId:orgs){
			//认证服务器给的orgId与本地不同 要从本地通过syncId重新获取Organ对象
			Organ organ = this.getOrganById(orgId);
			if(organ!=null){
				OrganUser organuser= new OrganUser();
				organuser.setUserId(userId);
				organuser.setOrgId(organ.getOrgId());
				organuser.setCreateAt(new Timestamp(System.currentTimeMillis()));
				this.add(organuser);
			}
		}
	}

	@Override
	public Organ getOrganById(String syncId) {
		Organ organ = null;
		Query query = this.createQuery("from Organ where orgId='"+syncId+"'");
		List l = query.list();
		if(l.size()>0){
			organ = (Organ) l.get(0);
		}
		return organ;
	}

	@Override
	public Role getRoleByName(String roleName) {
		Role role = null;
		Query query = this.createQuery("from Role where roleName='"+roleName+"'");
		List l = query.list();
		if(l.size()>0){
			role = (Role) l.get(0);
		}
		return role;
	}

	@Override
	public void deleteByIds(String[] orgIds) {
		final String sql = " DELETE FROM T_DMP_SYS_ORG WHERE org_id IN (:orgIds) ";
		Query query = this.createSQLQuery(sql);
		query.setParameterList("orgIds", orgIds);
		query.executeUpdate();
	}

	@Override
	public void saveBatch(Organ[] orgs) {
		if(!ArrayUtils.isEmpty(orgs)){
			for(Organ org : orgs){
				String sql = "INSERT INTO t_dmp_sys_org(ORG_ID,EMP_NO,NAME,SHORT_NAME,OFFICE_PHONE,ADDRESS,"
						+ "MAIL,PARENT_ID,DESCRIPTION,SEQ_NUM,STATUS,TYPE,CODE,PATH,SYSCODE) VALUES(?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,?)";
				Query query = this.createSQLQuery(sql);
				query.setParameter(0, org.getOrgId());
				query.setParameter(1, org.getEmpNo());
				query.setParameter(2, org.getName());
				query.setParameter(3, org.getShortName());
				query.setParameter(4, org.getOfficePhone());
				query.setParameter(5, org.getAddress());
				query.setParameter(6, org.getMail());
				query.setParameter(7, org.getParentId());
				query.setParameter(8, org.getDescription());
				query.setParameter(9, org.getSeqNum());
				query.setParameter(10, org.getStatus());
				query.setParameter(11, org.getType());
				query.setParameter(12, org.getCode());
				query.setParameter(13, org.getPath());
				query.setParameter(14, org.getSysCode());
				query.executeUpdate();
			}
		}
	}

}
