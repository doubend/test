package com.cloud.icenter.system.organ.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.system.organ.pojo.Organ;

/**
 * 
 * @author liufu update 2015/12/17
 * 方法追加
 */
public interface OrganDao extends BaseDao<Organ>{
	
	/**
	 * 获取子菜单
	 * @param parentId	父菜单ID,当parentId==null时,返回顶级菜单
	 * @param status	状态,当status==null时,返回所有状态的菜单,状态值详见Organ.STATUS_*属性
	 * @return
	 */
	public List<Organ> getChildren(String parentId,Integer status);
	
	public List<Organ> getChildren(String parentId,Integer status,Integer type);
	
	public List<Organ> getAllChildren(String parentId , Integer status);
	
	public List<String> getChildrenIds(String parentId , Integer status);
	
	public List<String> getAllChildrenIds(String parentId , Integer status);
	
	/**
	 * 获取子部门
	 * @param parentId 父菜单ID,当parentId==null时,返回顶级菜单
	 * @param status 状态,当status==null时,返回所有状态的菜单,状态值详见Organ.STATUS_*属性
	 * @return
	 */
	public List<Organ> getChildrenDept(String parentId, Integer status);
	
	/**
	 * 排序
	 * 传进来的Organ对象中,只有id,name,seqNum三个属性是正确的,其它的都不正常,请匆使用其它属性
	 * @param Organ
	 */
	public void sort(Organ[] organs);
	
	/**
	 * 移动功能
	 * @param targetId		目标机构id
	 * @param sourceId		源机构id
	 * @param point			操作类型	取值范围: append,top,bottom
	 */
	public void move(String targetId,String sourceId,String point);
	
	/**
	 * 权限设置
	 * @param organId
	 * @param checkedFuncId			已选中的功能ID
	 * @param uncheckedFuncId		未选中的功能ID
	 */
	public void functionSetup(String organId, String[] checkedFuncId,String[] uncheckedFuncId);
	
	/**
	 * 获取用户的主要员工对象
	 * @param userId
	 * @return
	 */
	@Deprecated
	public Organ getMainEmployee(String userId);
	
	/**
	 * 获取用户的主要部门对象
	 * @param userId
	 * @return
	 */
	@Deprecated
	public Organ getMainDepartment(String userId);

	/**
	 * 获取员工的部门对象
	 * @param empOrganId
	 * @return
	 */
	@Deprecated
	public Organ getDepartment(String empOrganId);
	
	/**
	 * 获取节点的所有父节点,包括本节点
	 * @param organId
	 * @return
	 */
	public List<Organ> getParents(String organId);
	
	/**
	 * 根据userId获取用户的所有职位信息
	 * @param userId
	 * @return
	 */
	@Deprecated
	public List<Organ> getOrgansByUserId(String userId);
	
	/**
	 * 设置用户的主要员工
	 * 先清除用户的主要员工,再根据organId设置主要员工
	 * @param userId		
	 * @param organId		当为null时,不设置主要员工
	 */
	@Deprecated
	public void setMainEmployee(String userId,String organId);
	
	/**
	 * 根据roleId获取用户的所有职位信息
	 * 获取拥有该角色的所有用户,并在组织机构表中找到该用户设置为主要的职位
	 * @param roleId
	 * @return
	 */
	@Deprecated
	public List<Organ> getOrgansByRoleId(String roleId);
	
	//根据userId获取父级组织机构ID
	@Deprecated
	public String getOrganByUserId(String userId);
	
	//同步用删除接口,同步时不会产生其他数据，所以不用删除权限相关
	@Deprecated
	public void deleteByUserAndParent(String userID,String[] pids) ;
	
	@Deprecated
	public void deleteByUserID(String userID);
	
	@Deprecated
	public void updateOrganNameByUserID(String userID,String Name);
	
	/**
	 * 根据组织机构类型获得所有组织机构
	 * @author liufu
	 * @param type 组织机构类型
	 * @return
	 */
	public List<Organ> getAllOrgans(int type);
	
	/**
	 * 查询组织结构信息
	 * @param parentId 父节点
	 * @param type 类型
	 * @return
	 */
	public List<Organ> queryOrgan(String parentId, int type);
	
	/**
	 * 通过类型查找组织机构
	 * @param type
	 * @return
	 * @author zhaojianda
	 */
	public List<Organ> getByType(int type);
	
	
	/**
	 * 获取组织机构的ID
	 * @param name 参数是：名称
	 * @return 
	 */
	public String getOrgByName(String name);
	
	/**
     * 获取组织机构的ID
     * @param name 参数是：名称
     * @return 
     */
    public String getOrgByName(int type,String name);
	
	/**
	 * 根据人员查找其所属组织机构
	 * @param userId
	 * @return
	 */
	public List<Organ> findByUserId(String userId);
	
		/**
	 * 
	* @Title: getAllOrgDept 
	* @Description: 查询所有部门和单位的组织机构信息
	* @param @return    设定文件 
	* @return List<Organ>    返回类型 
	* @throws
	 */
	public List<Organ> getAllOrgDept();
	
	/**
	 * 查询根节点组织机构
	 * @return
	 */
	public Organ getRootOrgan();
	
	/**
	 * 根据父节点查询子机构数据
	 * @param parentId
	 * @return
	 */
	public List<Organ> queryChildByParentId(String parentId);
	/**
	 * 关于应用系统双节点返回list集合
	 */
	public List<Organ> getRootOrgan_SystemList();

	public Organ getOrganBySyscode(String sysCode);
	
	/**
	 * 查询所有有效的组织机构信息
	 * @return
	 */
	public List<Map<String, Object>> queryOrganTree();
	
	/**
	 * 根据父节点查询子节点数据
	 * @param parentId 父节点ID
	 * @return
	 */
	public List<Map<String, Object>> queryTreeNode(String parentId);
}
