package com.cloud.icenter.system.organ.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.system.menu.pojo.Menu;
import com.cloud.icenter.system.menu.pojo.MenuCache;
import com.cloud.icenter.system.menu.pojo.MenuFunction;
import com.cloud.icenter.system.organ.dao.OrganDao;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganFunction;

@Repository
public class OrganDaoImpl extends BaseDaoImpl<Organ> implements OrganDao {

    private List<String> menulist = new ArrayList<String>();

    @Override
    public void add(Organ obj) {

        // if (getChild(obj.getParentId(), obj.getName()) != null) {
        // throw new RuntimeException("重复的名称!");
        // }

        obj.setSeqNum(getNextSeqNum());
        if (StringUtils.isBlank(obj.getParentId())) {
            obj.setParentId(null);
            // obj.setPath(path);
        } else {
            Organ parent = get(obj.getParentId());
            if (null != parent) {
                obj.setPath((StringUtils.isBlank(parent.getPath()) ? "" : parent.getPath()) + parent.getOrgId() + "/");
            }
        }
        if (StringUtils.isBlank(obj.getShortName())) { // 简称未填时默认与名称相同
            obj.setShortName(obj.getName());
        }
        if (!StringUtils.isBlank(obj.getUserId())) { // 当uesrId不为空时进行相关业务逻辑处理
            if (countOrganByUser(obj.getUserId())) { // 如果是第一设置,默认为主要职务
                obj.setMain(Organ.MAIN_YES);
            } else if (obj.getMain() == Organ.MAIN_YES) { // 如果当前员工为主要职务,那么将其它员工设置为"非主要职务"
                setMainEmployee(obj.getUserId(), null);
            }
        }
        obj.setStatus(Organ.STATUS_DEFAULT);
        obj.setCreatedAt(new Date());
        super.add(obj);
    }

    @Override
    public void update(Organ obj) {

        if (StringUtils.isBlank(obj.getShortName())) { // 简称未填时默认与名称相同
            obj.setShortName(obj.getName());
        }
        if (StringUtils.isBlank(obj.getParentId())) {
            obj.setParentId(null);
        } else {
            Organ parent = get(obj.getParentId());
            if (null != parent) {
                obj.setPath((StringUtils.isBlank(parent.getPath()) ? "" : parent.getPath()) + parent.getOrgId() + "/");
            }
        }
        if (obj.getUserId() != null) { // 当uesrId不为空时进行相关业务逻辑处理
            if (countOrganByUser(obj.getUserId())) { // 如果是第一设置,默认为主要职务
                obj.setMain(Organ.MAIN_YES);
            } else if (obj.getMain() == Organ.MAIN_YES) { // 如果当前员工为主要职务,那么将其它员工设置为"非主要职务"
                setMainEmployee(obj.getUserId(), null);
            }
        }
        super.update(obj);
        // Organ organ = getChild(obj.getParentId(), obj.getName());
        // if (organ == null) {
        // super.update(obj);
        // return;
        // }
        //
        // if (organ.getOrgId().equals(obj.getOrgId())) {
        // getSession().merge(obj);
        // } else {
        // throw new RuntimeException("重复的名称!");
        // }
    }

    /**
     * 获取子节点
     * 
     * @param parentId
     *            父节点id
     * @param name
     *            子节点名称
     * @return
     */
    @SuppressWarnings("unchecked")
    private Organ getChild(String parentId, String name) {
        List<Organ> organs = getCriteria()
                .add(StringUtils.isBlank(parentId) ? Restrictions.isNull("parentId") : Restrictions.eq("parentId",
                        parentId)).add(Restrictions.eq("name", name))
                .add(Restrictions.eq("status", Organ.STATUS_DEFAULT)).list();
        if (organs.isEmpty())
            return null;
        return organs.get(0);
    }

    /**
     * 统计用户已关联几个员工
     * 
     * @param userId
     * @return
     */
    private boolean countOrganByUser(String userId) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("status", Organ.STATUS_DEFAULT));
        return countRow(criteria) == 0;
    }

    /**
     * 递归删除菜单
     */
    @Override
    public void delete(String id) {

        List<Organ> organs = getChildren(id, null);
        for (Organ o : organs) {
            // 删除机构数据表的关联数据
            executeUpdate("delete OrganData where orgId=?", o.getOrgId());
            executeUpdate("delete OrganFunction where organId=?", o.getOrgId());
            // add by YHT
            Query query = createQuery("delete MenuCache where dataId=:dataId and type=:type");
            query.setParameter("dataId", id);
            query.setParameter("type", MenuCache.TYPE_ORGAN);
            query.executeUpdate();
            if (o.getType() == Organ.TYPE_EMPLOYEE) { // 如果是叶子节点,那么直接删除,否则是目录节点,需要递归删除所有子节点
                // this.logicDelete(o.getOrgId());
                this.trueDelete(id);
            } else {
                delete(o.getOrgId());
            }
        }
        // 删除机构数据表的关联数据
        executeUpdate("delete OrganData where orgId=?", id);
        executeUpdate("delete OrganFunction where organId=?", id);
        // add by YHT
        Query query = createQuery("delete MenuCache where dataId=:dataId and type=:type");
        query.setParameter("dataId", id);
        query.setParameter("type", MenuCache.TYPE_ORGAN);
        query.executeUpdate();
        // this.logicDelete(id);
        this.trueDelete(id);
    }

    private void trueDelete(String id) {
        executeUpdate("delete Organ where orgId=?", id);
    }

    /**
     * 改变节点状态,做逻辑删除
     * 
     * @param id
     */
    @Override
    public void logicDelete(String id) {
        executeUpdate("update Organ set status=? where orgId=?", Organ.STATUS_DELETED, id);
    }

    @Override
    public List<Organ> getChildren(String parentId, Integer status) {
        Criteria criteria = getCriteria();
        if (StringUtils.isBlank(parentId)) {
            criteria.add(Restrictions.isNull("parentId"));
        } else {
            criteria.add(Restrictions.eq("parentId", parentId));
        }
        if (status != null) {
            criteria.add(Restrictions.eq("status", status));
        }
        criteria.addOrder(Order.asc("seqNum"));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getChildrenIds(String parentId, Integer status) {
        final StringBuilder hql = new StringBuilder(" SELECT id FROM Organ ");
        if (StringUtils.isBlank(parentId)) {
            hql.append(" WHERE parentId IS NULL ");
        } else {
            hql.append(" WHERE parentId = :parentId ");
        }
        if (status != null) {
            hql.append(" AND status = :status ");
        }
        Query query = this.createQuery(hql.toString());
        if (!StringUtils.isBlank(parentId)) {
            query.setParameter("parentId", parentId);
        }
        if (status != null) {
            query.setParameter("status", status);
        }
        return query.list();
    }

    @Override
    public List<Organ> getChildrenDept(String parentId, Integer status) {
        Criteria criteria = getCriteria();
        if (StringUtils.isBlank(parentId)) {
            criteria.add(Restrictions.isNull("parentId"));
        } else {
            criteria.add(Restrictions.eq("parentId", parentId));
        }
        if (status != null) {
            criteria.add(Restrictions.eq("status", status));
        }
        // criteria.add(Restrictions.eq("type", 2));
        // 1 代表企业 2 代表部门
        criteria.add(Restrictions.in("type", new Integer[] { 1, 2 }));
        criteria.addOrder(Order.asc("seqNum"));

        return criteria.list();
    }

    @Override
    public void sort(Organ[] organs) {
        if (organs == null || organs.length == 0)
            return;

        Query sortQuery = createQuery("update Organ set seqNum=:seqNum where orgId=:orgId");

        for (Organ o : organs) {
            Organ po = get(o.getOrgId());
            if (po.getSeqNum() == o.getSeqNum()) {
                continue;
            } else {
                sortQuery.setLong("seqNum", o.getSeqNum());
                sortQuery.setString("orgId", o.getOrgId());
                sortQuery.executeUpdate();
            }
        }
    }

    @Override
    public void move(String targetId, String sourceId, String point) {
        Organ target = get(targetId);
        Organ source = get(sourceId);

        if (target.getType() == Organ.TYPE_EMPLOYEE && point.equals("append")) {
            throw new RuntimeException("移动功能失败:叶子节点不允许追加子节点!");
        }

        if (point.equals("append")) { // 如果是追加操作,那么直接追加到父节点下
            source.setParentId(target.getOrgId());
            source.setSeqNum(getNextSeqNum());
            update(source);
        } else { // 否则是排序操作,那么移动为与目标节点同级,再执行同级排序
            source.setParentId(target.getParentId());
            source.setSeqNum(getNextSeqNum());
            update(source);

            sortForMove(target, source, point);
        }
    }

    /**
     * 为移动操作排序
     * 
     * @param target
     * @param source
     * @param point
     */
    private void sortForMove(Organ target, Organ source, String point) {
        List<Organ> children = getChildren(target.getParentId(), null);
        int index = 0;
        for (; index < children.size(); index++) {
            Organ f = children.get(index);
            if (target.equals(f)) {
                if (point.equals("top")) { // 插入源节点到适当的位置
                    children.add(index, source);
                } else if (point.equals("bottom")) {
                    children.add(index + 1, source);
                    index = index + 1; // 保存源节点的索引号
                }
                break;
            }
        }
        children.remove(children.size() - 1); // 删除重复的源节点(固定为最后一个节点),因为前面循环中,插入了一个源节点

        Integer _seqNum = source.getSeqNum(); // 保存源节点的排序号
        for (; index < children.size(); index++) { // 重新设置源节点和之后的节点排序号
            Organ f = children.get(index);
            if (index < children.size() - 1) {
                f.setSeqNum(children.get(index + 1).getSeqNum());
            } else {
                f.setSeqNum(_seqNum);
            }
        }
    }

    @Override
    public void functionSetup(String organId, String[] checkedFuncId, String[] uncheckedFuncId) {

        if (checkedFuncId == null || uncheckedFuncId == null || uncheckedFuncId.length == 0)
            return;

        // 先删除未选与已选的原有关联
        Query query = createQuery("delete OrganFunction where organId=:organId and functionId in(:functionId)");
        query.setString("organId", organId);
        query.setParameterList("functionId", uncheckedFuncId);
        query.executeUpdate();
        if (checkedFuncId.length > 0) {
            query.setParameterList("functionId", checkedFuncId);
            query.executeUpdate();
        }

        // 再重新添加已选关联
        for (String id : checkedFuncId) {
            OrganFunction of = new OrganFunction();
            of.setOrganId(organId);
            of.setFunctionId(id);
            getSession().save(of);
        }
        // 添加组织机构菜单关联
        addoOrganMenu(organId, checkedFuncId);
    }

    /**
     * 添加菜单与组织机构的关联
     * 
     * @param organId
     * @param functionId
     */
    public void addoOrganMenu(String organId, String[] functionId) {
        if (organId == null || functionId == null || functionId.length == 0)
            return;
        Query query = createQuery("select menuId from MenuFunction where functionId in(select functionId from OrganFunction where organId=:organId)");
        query.setParameter("organId", organId);
        List<String> list = query.list();
        if (list.size() == 0)
            return;
        // 删除关联
        Query queryMenu = createQuery("delete from MenuCache where dataId=:dataId and type=:type");
        queryMenu.setParameter("dataId", organId);
        queryMenu.setParameter("type", MenuCache.TYPE_ORGAN);
        queryMenu.executeUpdate();
        List<Menu> menus = getCriteria(Menu.class).list();
        menulist.clear();
        for (Menu menu : menus) {
            if (list.contains(menu.getMenuId())) {
                addMenuCache(organId, menu);
            }
        }
    }

    private void addMenuCache(String organId, Menu menu) {

        if (!menulist.contains(menu.getMenuId())) {
            MenuCache cache = new MenuCache();
            cache.setMenuId(menu.getMenuId());
            cache.setDataId(organId);
            cache.setType(MenuCache.TYPE_ORGAN);
            getSession().save(cache);
            menulist.add(menu.getMenuId());
        }

        // 递归缓存父菜单
        if (menu.getParentId() != null) {
            Menu parent = (Menu) getSession().get(Menu.class, menu.getParentId());
            addMenuCache(organId, parent);
        }
    }

    /**
     * 删除功能角色与功能的所有关联，同时删除功能上菜单与角色的关联
     * 
     * @param roleId
     * @param functionId
     */
    public void deleteOrganMenu(String organId, String[] functionId) {
        if (functionId == null || functionId.length == 0)
            return;
        Query query = createQuery("select m from MenuFunction m where functionId in (:functionId) order by m.menuId");
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
        queryMenu.setParameter("dataId", organId);
        queryMenu.setParameter("type", MenuCache.TYPE_ORGAN);

        queryMenu.setParameterList("menuId", deleteMenu.toArray());
        queryMenu.executeUpdate();
    }

    @Override
    public Organ getMainEmployee(String userId) {

        List<Organ> organList = getOrgansByUserId(userId);
        if (!organList.isEmpty())
            return organList.get(0);
        return null;
    }

    @Override
    public Organ getMainDepartment(String userId) {

        Organ emp = getMainEmployee(userId);
        if (emp == null)
            return null;
        return getDepartment(emp.getOrgId());
    }

    @Override
    public Organ getDepartment(String empOrganId) {
        List<Organ> organList = getParents(empOrganId);
        for (Organ organ : organList) {
            if (organ.getType() == Organ.TYPE_DEPARTMENT)
                return organ;
        }
        return null;
    }

    @Override
    public List<Organ> getParents(String organId) {

        List<Organ> organList = new ArrayList<Organ>();
        while (organId != null) {
            Organ organ = get(organId);
            if (organ == null)
                break;
            organList.add(organ);
            organId = organ.getParentId();
        }
        return organList;
    }

    /**
     * 根据userId获取用户的所有职位信息
     * 
     * @param userId
     * @return
     */
    @Deprecated
    @Override
    public List<Organ> getOrgansByUserId(String userId) {
        Criteria criteria = getCriteria().add(Restrictions.eq("status", Organ.STATUS_DEFAULT))
                .add(Restrictions.eq("userId", userId)).add(Restrictions.ge("type", Organ.TYPE_DEPARTMENT_ADMIN))
                .addOrder(Order.desc("main")).addOrder(Order.asc("seqNum"));

        return criteria.list();
    }

    // 同步用的
    @Override
    @Deprecated
    public String getOrganByUserId(String userId) {
        Criteria criteria = getCriteria().add(Restrictions.eq("status", Organ.STATUS_DEFAULT))
                .add(Restrictions.eq("userId", userId))
                // .add(Restrictions.ge("type",Organ.TYPE_DEPARTMENT_ADMIN))
                .addOrder(Order.desc("main")).addOrder(Order.asc("seqNum"));

        List<Organ> organlist = criteria.list();
        String str = "";
        for (Organ organ : organlist) {
            str += organ.getParentId() + ",";
        }
        return str.indexOf(",") > 0 ? str.substring(0, str.length() - 1) : str;
    }

    // 同步用删除接口,同步时不会产生其他数据，所以不用删除权限相关
    @Override
    @Deprecated
    public void deleteByUserAndParent(String userID, String[] pids) {
        for (String pid : pids) {
            executeUpdate("delete Organ where parentId=? and userId=?", pid, userID);
        }
    }

    @Override
    @Deprecated
    public void deleteByUserID(String userID) {
        executeUpdate("delete Organ where userId=?", userID);
    }

    @Deprecated
    @Override
    public void setMainEmployee(String userId, String organId) {
        executeUpdate("update Organ set main=? where userId=?", Organ.MAIN_NO, userId);
        if (organId != null) {
            executeUpdate("update Organ set main=? where orgId=?", Organ.MAIN_YES, organId);
        }
    }

    /**
     * 根据roleId获取用户的所有职位信息 获取拥有该角色的所有用户,并在组织机构表中找到该用户设置为主要的职位
     * 
     * @param roleId
     * @return
     */
    @Deprecated
    @Override
    public List<Organ> getOrgansByRoleId(String roleId) {
        return executeQuery(
                "select o from Organ o where main=? and status =? and userId in (select userId from UserRole where roleId = ? )",
                Organ.MAIN_YES, Organ.STATUS_DEFAULT, roleId);
    }

    @Deprecated
    @Override
    public void updateOrganNameByUserID(String userID, String name) {
        executeUpdate("update Organ set name=? where userId=?", name, userID);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Organ> getAllOrgans(int type) {
        StringBuilder hql = new StringBuilder();
        // 组织机构表
        hql.append(" from Organ ");
        // 类型为2:政府部门
        hql.append(" where type = ? ");
        // 未删除组织机构
        hql.append(" and status = ? ");
        return executeQuery(hql.toString(), type, Organ.STATUS_DEFAULT);
    }

    @Override
    public List<Organ> queryOrgan(String parentId, int type) {
        return executeQuery("select t from Organ t where t.parentId=? and t.type=? and t.status=?", parentId, type,
                Organ.STATUS_DEFAULT);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Organ> getByType(int type) {
        String hql = "from Organ o where o.type = ? and o.status = ?";
        List<Organ> list = executeQuery(hql, type, Constants.DATA_STATUS_VALID);
        return list;
    }

    // 根据组织机构的名称查询组织机构ID
    @Override
    public String getOrgByName(String name) {
        String hql = "select t.orgId from Organ t where t.status=? and t.name=?";
        List list = executeQuery(hql, Organ.TYPE_FOLDER, name.trim());
        if (list != null && !list.isEmpty()) {
            return list.get(0).toString();
        }
        return null;
    }

    @Override
    public String getOrgByName(int type, String name) {
        String hql = "select t.orgId from Organ t where t.type=? and t.name=?";
        List list = executeQuery(hql, type, name.trim());
        if (list != null && !list.isEmpty()) {
            return list.get(0).toString();
        }
        return null;
    }

    /**
	 * 
	 */
    @SuppressWarnings("unchecked")
    @Override
    public List<Organ> getAllChildren(final String parentId, final Integer status) {
        final StringBuilder hql = new StringBuilder(" FROM Organ WHERE status = :status AND path LIKE :path ");
        Query query = this.createQuery(hql.toString());
        query.setParameter("status", status);
        query.setParameter("path", parentId + "%");
        return query.list();
    }

    /**
	 * 
	 */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getAllChildrenIds(final String parentId, final Integer status) {
        final String hql = " SELECT id FROM Organ WHERE status = :status AND path LIKE :path ";
        Query query = this.createQuery(hql);
        query.setParameter("status", status);
        query.setParameter("path", "%" + parentId + "%");
        return query.list();
    }

    /**
     * 
     * (non-Javadoc)
     * 
     * @see com.cloud.icenter.system.organ.dao.OrganDao#findByUserId(java.lang.String)
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Organ> findByUserId(final String userId) {
        final String hql = " FROM Organ WHERE status = :status AND orgId IN (SELECT orgId FROM OrganUser WHERE userId = :userId) ORDER BY PATH DESC ";
        Query query = this.createQuery(hql.toString());
        query.setParameter("status", Organ.STATUS_DEFAULT);
        query.setParameter("userId", userId);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Organ> getAllOrgDept() {
        StringBuilder hql = new StringBuilder();
        // 组织机构表
        hql.append(" from com.cloud.icenter.system.organ.pojo.Organ ");
        // 类型为1:政府2:政府部门
        hql.append(" where type in (1,2) ");
        // 未删除组织机构
        hql.append(" and status = ? ");
        hql.append(" order by seqNum");
        return executeQuery(hql.toString(), Organ.STATUS_DEFAULT);
    }

    @Override
    public List<Organ> getChildren(String parentId, Integer status, Integer type) {
        Criteria criteria = getCriteria();
        if (StringUtils.isBlank(parentId)) {
            criteria.add(Restrictions.isNull("parentId"));
        } else {
            criteria.add(Restrictions.eq("parentId", parentId));
        }
        if (status != null) {
            criteria.add(Restrictions.eq("status", status));
        }
        if (type != null) {
            criteria.add(Restrictions.eq("type", type));
        }
        criteria.addOrder(Order.asc("seqNum"));
        return criteria.list();
    }

	@Override
	public Organ getRootOrgan() {
		String hql = "select t from Organ t where t.status='"+Organ.STATUS_DEFAULT+"' and t.type='"+Organ.TYPE_FOLDER+"'";
		List<Organ> list = executeQuery(hql, null);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public List<Organ> getRootOrgan_SystemList() {
		String hql = "select t from Organ t where t.status='"+Organ.STATUS_DEFAULT+"' and t.type='"+Organ.TYPE_FOLDER+"'";
		List<Organ> list = executeQuery(hql, null);
		if (list != null && !list.isEmpty()) {
			return list;
		}
		return null;
	}
	

	@Override
	public List<Organ> queryChildByParentId(String parentId) {
		String hql = "select t from Organ t where t.status='"+Organ.STATUS_DEFAULT+"' and t.parentId = '"+parentId+"'";
		return executeQuery(hql, null);
	}

	@Override
	public Organ getOrganBySyscode(String sysCode) {
		String hql = "select t from Organ t where t.sysCode = '"+sysCode+"'";
		List<Organ> data = executeQuery(hql, null);
		if(data != null && data.size() > 0){
			return data.get(0);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> queryOrganTree() {
		StringBuffer sql = new StringBuffer("");
		sql.append(" SELECT ");
		sql.append("			TDSO.ORG_ID, ");
		sql.append("			TDSO.NAME, ");
		sql.append("			TDSO.PARENT_ID, ");
		sql.append("			TDSO.TYPE,");
		sql.append("			TDSO.PATH, ");
		sql.append("            TDSO.SYSCODE ");
		sql.append("			FROM  ");
		sql.append("			T_DMP_SYS_ORG TDSO WHERE 1=1 ");
		sql.append("			AND TDSO.STATUS="+Constants.DATA_STATUS_INVALID);//未删除的组织机构,有效
		sql.append("			ORDER BY TDSO.SEQ_NUM ASC ");
		return this.getListMapBySql(sql.toString(),new Object[]{});
	}

	@Override
	public List<Map<String, Object>> queryTreeNode(String parentId) {
		StringBuffer sql = new StringBuffer("");
		sql.append(" SELECT ");
		sql.append("			TDSO.ORG_ID, ");
		sql.append("			TDSO.NAME, ");
		sql.append("			TDSO.PARENT_ID, ");
		sql.append("			TDSO.TYPE,");
		sql.append("			TDSO.PATH, ");
		sql.append("            TDSO.SYSCODE ");
		sql.append("			FROM  ");
		sql.append("			T_DMP_SYS_ORG TDSO WHERE 1=1 ");
		sql.append("			AND TDSO.STATUS="+Constants.DATA_STATUS_INVALID);//未删除的组织机构,有效
		if (parentId != null && !parentId.equals("")) {
			sql.append("		AND TDSO.PARENT_ID='"+parentId+"'");//父节点
		} else {
			sql.append("		AND TDSO.PARENT_ID IS NULL");//父节点为null的是根节点
		}
		sql.append("			ORDER BY TDSO.SEQ_NUM ASC ");
		return this.getListMapBySql(sql.toString(),new Object[]{});
	}

}