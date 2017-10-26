package com.cloud.icenter.system.role.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.menu.pojo.Menu;
import com.cloud.icenter.system.menu.pojo.MenuCache;
import com.cloud.icenter.system.menu.pojo.MenuFunction;
import com.cloud.icenter.system.role.dao.RoleDao;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.role.pojo.RoleFunction;
import com.cloud.icenter.system.user.pojo.UserRole;

/**
 * 角色数据访问实现类
 * 
 * @author zhangle
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
	private List<String> menulist = new ArrayList<String>();
	private String developerRole = SystemConfig.getProperty("system.role.developer");
	@Override
	public void add(Role obj) {
		obj.setSeqNum(getNextSeqNum());
		obj.setCreatedAt(new Date());
		getSession().save(obj);

		// 添加角色与功能的关联
		addRoleFunction(obj.getRoleId(), obj.getCheckedFunctionId());
		// 添加角色与菜单的关联 add by YHT
		if (!StringUtils.isBlank(developerRole)) {
			Role developer = getRoleByName(developerRole);
			if (developer.getRoleId().equals(obj.getRoleId())) {
				addDevloperMenu(obj.getRoleId());
			} else {
				addRoleMenu(obj.getRoleId());
			}
		}
	}

	@Override
	public void update(Role obj) {
		getSession().update(obj);
		deleteRoleFunction(obj.getRoleId(), obj.getUncheckdFunctionId());
		deleteRoleFunction(obj.getRoleId(), obj.getCheckedFunctionId());
		//deleteRoleMenu(obj.getId(), obj.getUncheckdFunctionId());
	
		addRoleFunction(obj.getRoleId(), obj.getCheckedFunctionId());
		// 添加角色与菜单的关联 add by YHT
		if (!StringUtils.isBlank(developerRole)) {
			Role developer = getRoleByName(developerRole);
			if (developer.getRoleId().equals(obj.getRoleId())) {
				addDevloperMenu(obj.getRoleId());
			} else {
				addRoleMenu(obj.getRoleId());
			}
		}
	}

	@Override
	public void delete(String id) {
		executeUpdate("delete UserRole where roleId=?", id);
		executeUpdate("delete RoleFunction where roleId=?", id);
		// add by YHT
		Query query = createQuery("delete MenuCache where dataId=:dataId and type=:type");
		query.setParameter("dataId", id);
		query.setParameter("type", MenuCache.TYPE_ROLE);
		query.executeUpdate();
		super.delete(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findRoleByUserId(String userId, Integer status) {

		Criteria criteria = getCriteria();
		if (status != null) {
			criteria.add(Restrictions.eq("status", status));
		}

		DetachedCriteria subquery = DetachedCriteria.forClass(UserRole.class);
		subquery.add(Restrictions.eq("userId", userId));
		subquery.setProjection(Projections.property("roleId"));
		criteria.add(Subqueries.propertyIn("id", subquery));
		criteria.addOrder(Order.asc("seqNum"));

		return criteria.list();
	}

	@Override
	public Role getRoleByName(String name) {
		return super.get(Role.class, "roleName", name);
	}

	@Override
	public void sort(Role[] roles) {
		if (roles == null || roles.length == 0)
			return;

		Query sortQuery = createQuery("update Role set seqNum=:seqNum where roleId=:roleId");
		for (Role r : roles) {
			Role po = get(r.getRoleId());
			if (po.getSeqNum()==r.getSeqNum())
				continue;
			sortQuery.setLong("seqNum", r.getSeqNum());
			sortQuery.setString("roleId", r.getRoleId());
			sortQuery.executeUpdate();
		}
	}

	/**
	 * 添加角色与功能的关联
	 * 
	 * @param roleId
	 *            关联的角色ID
	 * @param functionId
	 *            关联的功能ID数组
	 */
	public void addRoleFunction(String roleId, String[] functionId) {
		if (roleId == null || functionId == null || functionId.length == 0)
			return;
		for (String _fid : functionId) {
			RoleFunction rf = new RoleFunction();
			rf.setRoleId(roleId);
			rf.setFunctionId(_fid);
			getSession().save(rf);
		}
	}

	/**
	 * 添加角色与菜单的关联
	 * 
	 * @param roleId
	 *            关联的角色ID
	 * @param functionId
	 *            关联的功能ID数组
	 * @author yuhaitao
	 */
	public void addRoleMenu(String roleId) {
		if ( roleId == null)
			return;
		//Query queryFunction = createQuery("select functionId");
		Query query = createQuery("select menuId from MenuFunction where functionId in(select functionId from RoleFunction where roleId=:roleId)");
		query.setParameter("roleId", roleId);
		List<String> list = query.list();
		if(list.size()==0) return;
		//删除关联
		Query queryMenu = createQuery("delete from MenuCache where dataId=:dataId and type=:type");
		queryMenu.setParameter("dataId",  roleId);
		queryMenu.setParameter("type", MenuCache.TYPE_ROLE);
		queryMenu.executeUpdate();
		
		List<Menu> menus = getCriteria(Menu.class).list();
		menulist.clear();
		for (Menu menu : menus) {
			if (list.contains(menu.getMenuId())) {
				addMenuCache(roleId, menu);
			}
		}

	}
	/**
	 * 开发者角色与菜单关联
	 * @param roleId
	 */
	private void addDevloperMenu(String roleId){
		List<Menu> menus = getCriteria(Menu.class).list();
		Query queryMenu = createQuery("select menuId from MenuCache where dataId=:dataId and type=:type");
		queryMenu.setParameter("dataId", roleId);
		queryMenu.setParameter("type", MenuCache.TYPE_ROLE);
		List<String> list = queryMenu.list();
		
		for (Menu menu : menus) {
			if (!list.contains(menu.getMenuId())) {
				MenuCache cache = new MenuCache();
				cache.setMenuId(menu.getMenuId());
				cache.setDataId(roleId);
				cache.setType(MenuCache.TYPE_ROLE);
				getSession().save(cache);
			}
		}
	}
	private void addMenuCache(String organId, Menu menu) {

		if (!menulist.contains(menu.getMenuId())) {
			MenuCache cache = new MenuCache();
			cache.setMenuId(menu.getMenuId());
			cache.setDataId(organId);
			cache.setType(MenuCache.TYPE_ROLE);
			getSession().save(cache);
			menulist.add(menu.getMenuId());
		}

		// 递归缓存父菜单
		if (menu.getParentId() != null) {
			Menu parent = (Menu) getSession().get(Menu.class,
					menu.getParentId());
			addMenuCache(organId, parent);
		}
	}
	/**
	 * 删除角色与功能的所有关联
	 * 
	 * @param userId
	 *            需要删除关联的角色ID
	 */
	public void deleteRoleFunction(String roleId, String[] functionId) {
		if (roleId == null || functionId == null || functionId.length == 0)
			return;
		Query query = createQuery("delete RoleFunction where roleId=:roleId and functionId in(:functionId)");
		query.setString("roleId", roleId);
		query.setParameterList("functionId", functionId);
		query.executeUpdate();

	}

	// 删除功能角色与功能的所有关联，同时删除功能上菜单与角色的关联
	public void deleteRoleMenu(String roleId, String[] functionId) {
		if (functionId == null || functionId.length == 0)
			return;
		Query query = getNamedQuery("system.GetMenuFunction");
		query.setParameterList("functionId", functionId);
		@SuppressWarnings("unchecked")
		List<MenuFunction> lists = query.list();
		if (lists.size() == 0)
			return;
		String menuid = lists.get(0).getMenuId();
		List<String> mfs = new ArrayList<String>();
		List<String> deleteMenu = new ArrayList<String>();
		List<String> list = new ArrayList<String>(functionId.length);
		for (String mf : functionId) {
			list.add(mf);
		}
		int index = 0;
		for (MenuFunction mf : lists) {
			index++;
			if (!menuid.equals(mf.getMenuId()) || index >= lists.size()) {
				if (list.containsAll(mfs)) {
					deleteMenu.add(menuid);
				}
				mfs.clear();
				menuid = mf.getMenuId();
				mfs.add(mf.getFunctionId());
			} else {
				mfs.add(mf.getFunctionId());
			}
		}
		if (deleteMenu.size() == 0)
			return;
		
		Query queryMenu = createQuery("delete MenuCache where dataId=:dataId and type=:type and menuId in (:menuId)");
		queryMenu.setParameter("dataId", roleId);
		queryMenu.setParameter("type", MenuCache.TYPE_ROLE);

		queryMenu.setParameterList("menuId", deleteMenu.toArray());
		queryMenu.executeUpdate();
	}

	@Override
	public List<Role> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class)
				.add(Restrictions.eq("status", Role.STATUS_DEFAULT))
				.addOrder(Order.asc("seqNum"));

		return super.find(criteria);
	}
}
