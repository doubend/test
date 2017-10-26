package com.cloud.icenter.system.organ.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganData;

@Service
public interface OrganService extends BaseService<Organ>{
	
	/**
	 * 获取子机构
	 * @param parentId	父机构ID,当parentId==null时,返回顶级机构
	 * @param status	状态,当status==null时,返回所有状态的机构,状态值详见Organ.STATUS_*属性
	 * @return
	 */
	public List<Organ> getChildren(String parentId,Integer status);
	
	/**
	 * 获取子机构
	 * @param parentId	父机构ID,当parentId==null时,返回顶级机构
	 * @param status	状态,当status==null时,返回所有状态的机构,状态值详见Organ.STATUS_*属性
	 * @param type	状态,当type==null时,返回所有状态的机构,状态值详见Organ.TYPE_*属性
	 * @return
	 */
	public List<Organ> getChildren(String parentId,Integer status,Integer type);

	
	/**
	 * 获取所有的子部门，包括子部门下的，逻辑上path包含parentId
	 * @param parentId
	 * @param status
	 * @return
	 */
	public List<Organ> getAllChildren(String parentId , Integer status);
	
	public List<String> getChildrenIds(String parentId , Integer status);
	
	/**
	 * 获取所有的子部门，包括子部门下的，逻辑上path包含parentId
	 * @param parentId
	 * @param status
	 * @return
	 */
	public List<String> getAllChildrenIds(String parentId , Integer status);
	
	
	/**
	 * 获取子部门
	 * @param parentId	父机构ID,当parentId==null时,返回顶级机构
	 * @param status	状态,当status==null时,返回所有状态的机构,状态值详见Organ.STATUS_*属性
	 * @return
	 */
	public List<Organ> getChildrenDept(String parentId,Integer status);
	
	/**
	 * 排序
	 * 传进来的Organ对象中,只有id,name,seqNum三个属性是正确的,其它的都不正常,请匆使用其它属性
	 * @param menus
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
	
	/**
	 * 获取组织节点的绑定数据
	 * @param organId
	 * @return
	 */
	public List<OrganData> getOrganDataByOrganId(String organId);
	
	/**
	 * 批量更新组织数据
	 * @return
	 */
	public void addOrganDatas(String organId,OrganData[] organDatas);
	
	/**
	 * 获取组织结构树形结构
	 * @param parentId 父节点ID
	 * @param sync 是否同步,同步 true ,异步 false
	 * @author xieyanan
	 * @return list
	 */
	public List<TreeNode> queryOrganTree(String parentId, boolean sync);
	
	/**
	 * 获取组织机构树形结构
	 * @param rootType  根节点：0 - 政府机构   1 - 企业
	 * @param childrenType 子节点： 2 政府部门 3 - 企业部门
	 * @param xieyanan
	 * @return 
	 */
	public List<TreeNode> queryOrganTree(int rootType, int childrenType);
	
	/**
	 * 查询组织结构信息
	 * @param rootType 根节点
	 * @param sync 是否同步加载： 同步 true ,异步 false
	 * @author xieyanan
	 * @return
	 */
	public List<TreeNode> queryOrganTree(int rootType, boolean sync);
	
	/**
	 * 查询组织结构信息
	 * @param organ 根节点
	 * @param sync 是否同步加载： 同步 true ,异步 false
	 * @author xieyanan
	 * @return
	 */
	public List<TreeNode> queryOrganTree(Organ organ, boolean sync);

	/**
	 * 根据组织机构类型查询组织机构
	 * @param orgtype
	 * @return
	 * @author zhaojianda
	 */
	public List<Organ> getAllOrgans(int orgtype);
	
	/**
	 * 通过类型查找对应机构
	 * @param type
	 * @return
	 */
	public List<Organ> getByType(int type);
	
	/**
	 * 获取组织机构的ID
	 * @param name 参数是：名称
	 * @return 
	 */
	public String getOrgByName(String name);

	/**
	 * 删除组织机构
	 */
	public void deleteOrgan(String id);
	
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
	 * 查询组织机构
	 * @return
	 */
	public List<TreeNode> queryOrganTree();
	/**
	 * 查询组织机构返回list
	 * @return
	 */
	public List<TreeNode> getRootOrgan_SystemList();
	
	/**
	 * 查询组织机构根节点
	 * @return
	 */
	public Organ getRootOrgan();
	
	/**
	 * 根据系统编码查询机构信息
	 * @param sysCode
	 * @return
	 */
	public Organ getOrganBySyscode(String sysCode);
	
	/**
	 * 查询系统的所有根节点
	 * @return
	 */
	public List<Organ> queryRootOrgan();
	
	/**
	 * 查询所有组织机构信息
	 * @return
	 */
	public List<TreeNode> queryTreeNode(boolean flag);
	
	/**
	 * 根据父节点ID查询子节点
	 * @param parentId 父节点ID
	 * @return
	 */
	public List<TreeNode> queryTreeNode(String parentId);
}
