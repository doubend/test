package com.cloud.icenter.system.organ.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.TreeNode;

import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.organ.dao.OrganDao;
import com.cloud.icenter.system.organ.dao.OrganDataDao;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganData;
import com.cloud.icenter.system.organ.pojo.OrganUser;
import com.cloud.icenter.system.organ.service.OrganService;
import com.cloud.icenter.system.organ.service.OrganUserService;

@Logging
@Service
public class OrganServiceImpl extends BaseServiceImpl<Organ> implements OrganService {

	@Autowired private OrganDao organDao;
	@Autowired private OrganDataDao organDataDao;
	

	
	@Autowired
	private OrganUserService organUserService;

	@Override
	public List<Organ> getChildren(String parentId,Integer status) {
		return organDao.getChildren(parentId,status);
	}
	
	@Override
	public List<Organ> getChildrenDept(String parentId,Integer status) {
		return organDao.getChildrenDept(parentId, status);
	}

	@Override
	public void sort(Organ[] organs) {
		organDao.sort(organs);
	}
	
	@Override
	public void move(String targetId, String sourceId, String point) {
		organDao.move(targetId, sourceId, point);
	}

	@Override
	public void functionSetup(String organId, String[] checkedFuncId,String[] uncheckedFuncId){
		organDao.functionSetup(organId, checkedFuncId, uncheckedFuncId);
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganService#getMainEmployee(java.lang.String)
	 *
	 */
	@Deprecated
	@Override
	public Organ getMainEmployee(String userId) {
		return organDao.getMainEmployee(userId);
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganService#getDepartment(java.lang.String)
	 *
	 */
	@Deprecated
	@Override
	public Organ getDepartment(String empOrganId) {
		return organDao.getDepartment(empOrganId);
	}
	
	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganService#getMainDepartment(java.lang.String)
	 *
	 */
	@Deprecated
	@Override
	public Organ getMainDepartment(String userId) {
		return organDao.getMainDepartment(userId);
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganService#getParents(java.lang.String)
	 *
	 */
	@Override
	public List<Organ> getParents(String organId) {
		return organDao.getParents(organId);
	}
	
	/**
	 * 根据userId获取用户的所有职位信息
	 * @param userId
	 * @return
	 */
	@Deprecated
	@Override
	public List<Organ> getOrgansByUserId(String userId) {
		return organDao.getOrgansByUserId(userId);
	}

	/**
	 * 设置用户的主要员工
	 * @param userId
	 */
	@Override
	@Deprecated
	public void setMainEmployee(String userId,String organId) {
		organDao.setMainEmployee(userId, organId);
	}
	
	/**
	 * 根据roleId获取用户的所有职位信息
	 * 获取拥有该角色的所有用户,并在组织机构表中找到该用户设置为主要的职位
	 * @param roleId
	 * @return
	 */
	@Override
	@Deprecated
	public List<Organ> getOrgansByRoleId(String roleId) {
		return organDao.getOrgansByRoleId(roleId);
	}

	@Override
	public List<OrganData> getOrganDataByOrganId(String organId) {
		return organDataDao.getDataByOrganId(organId);
	}

	@Override
	public void addOrganDatas(String organId, OrganData[] datas) {
		organDataDao.add(organId, datas);
	}

	@Override
	public List<TreeNode> queryOrganTree(String parentId, boolean sync) {
		if (sync) {
			//同步加载
			List<TreeNode> list = getChildrenByParentId(parentId);
			for (TreeNode node: list) {
				queryChildrenByParentId(node);
			}
			return list;
		} else {
			//异步加载
			List<TreeNode> list = getChildrenByParentId(parentId);
			for (TreeNode o: list) {
				String pid = o.getId();
				List<TreeNode> children = getChildrenByParentId(pid);
				o.setState(TreeNode.STATE_OPEN);
				o.setChildren(children);
			}
			return list;
		}
	}
	
	/**
	 * 数据递归调用，一次性全部加载成功
	 * @param node
	 */
	private void queryChildrenByParentId(TreeNode node) {
		List<TreeNode> list = getChildrenByParentId(node.getId());
		if (list != null && !list.isEmpty()) {
			node.setState(TreeNode.STATE_CLOSED);
			node.setChildren(list);
			for (TreeNode n: list) {
				queryChildrenByParentId(n);
			}
		}
	}
	
	
	/**
	 * 根据父节点获取子节点数据
	 * @param parentId 父节点ID
	 * @return 
	 */
	private List<TreeNode> getChildrenByParentId(String parentId) {
		List<Organ> result = organDao.queryChildByParentId(parentId);
		List<TreeNode> tree = new ArrayList<TreeNode>(result.size());
		for (Organ o: result) {
			tree.add(convert(o));
		}
		return tree;
	}
	
	/**
	 * 组织机构数据转换为：TreeNode数据
	 * @param organ 组织机构数据对象
	 * @return TreeNode 对象
	 */
	private TreeNode convert(Organ organ) {
		TreeNode node = new TreeNode();
		node.setId(organ.getOrgId());
		node.setText(organ.getName());
		if (organ.getType() == Organ.TYPE_FOLDER) {
			node.setState(TreeNode.STATE_OPEN);
			node.setIconCls("fa fa-folder");
		} else {
			node.setState(TreeNode.STATE_OPEN);
			node.setIconCls("fa fa-sitemap");
		}
		node.getAttributes().put("parentId", organ.getParentId());
		node.getAttributes().put("type", organ.getType());
		node.getAttributes().put("nodeType", "1");
		return node;
	}

	@Override
	public List<TreeNode> queryOrganTree(int rootType, int childrenType) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		//根据rootType类型获取机构或者企业
		List<Organ> list = organDao.getAllOrgans(rootType); 
		for (Organ o : list) {
			TreeNode node =	convert(o);
			String pid = node.getId();
			//获取机构或者企业下的子节点
			List<TreeNode> children = getOrganByParentId(pid, childrenType);
			node.setChildren(children);
			result.add(node);
		}
		return result;
	}
	
	/**
	 * 根据父节点和类型获取子节点
	 * @param parentId 父节点ID
	 * @param childrenType 子节点类型
	 * @return
	 */
	private List<TreeNode> getOrganByParentId(String parentId, int childrenType) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		List<Organ> list = organDao.queryOrgan(parentId, childrenType);
		for (Organ o : list) {
			result.add(convert(o));
		}
		return result;
	}

	@Override
	public List<TreeNode> queryOrganTree(int rootType, boolean sync) {
		List<Organ> rootList = organDao.getAllOrgans(rootType);
		if (rootList != null && !rootList.isEmpty()) {
			String parentId = rootList.get(0).getOrgId();
			if (sync) {
				//同步加载
				List<TreeNode> list = getChildrenByParentId(parentId);
				for (TreeNode node: list) {
					queryChildrenByParentId(node);
				}
				return list;
			} else {
				//异步加载
				List<TreeNode> list = getChildrenByParentId(parentId);
				for (TreeNode o: list) {
					String pid = o.getId();
					List<TreeNode> children = getChildrenByParentId(pid);
					o.setState(TreeNode.STATE_OPEN);
					o.setChildren(children);
				}
				return list;
			}
		}
		return null;
	}
	
	@Override
	public List<TreeNode> queryOrganTree(Organ organ, boolean sync) {
		if (organ != null) {
			if (sync) {
				//同步加载
				List<TreeNode> list = getChildrenByParentId(organ.getOrgId());
				for (TreeNode node: list) {
					queryChildrenByParentId(node);
				}
				return list;
			} else {
				//异步加载
				List<TreeNode> list = getChildrenByParentId(organ.getOrgId());
				for (TreeNode o: list) {
					String pid = o.getId();
					List<TreeNode> children = getChildrenByParentId(pid);
					o.setState(TreeNode.STATE_OPEN);
					o.setChildren(children);
				}
				return list;
			}
		}
		return null;
	}

	@Override
	public List<Organ> getAllOrgans(int orgtype) {
		return organDao.getAllOrgans(orgtype);
	}
	
	@Override
	public List<Organ> getByType(int type) {
		return organDao.getByType(type);
	}

	@Override
	public String getOrgByName(String name) {
		return organDao.getOrgByName(name);
	}

	@Override
	public List<String> getChildrenIds(String parentId, Integer status) {
		return organDao.getChildrenIds(parentId, status);
	}

	@Override
	public List<Organ> getAllChildren(String parentId, Integer status) {
		if(!StringUtils.isEmpty(parentId) && status != null){
			return organDao.getAllChildren(parentId, status);
		}
		return new ArrayList<>(0);
	}

	@Override
	public List<String> getAllChildrenIds(String parentId, Integer status) {
		if(!StringUtils.isEmpty(parentId) && status != null){
			return organDao.getAllChildrenIds(parentId, status);
		}
		return new ArrayList<>(0);
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public void deleteOrgan(String id) {
		if(!StringUtils.isEmpty(id)){
			List<String> childrenIds = this.getAllChildrenIds(id, Organ.STATUS_DEFAULT);
			childrenIds.add(id);
			if(childrenIds != null && !childrenIds.isEmpty()){
				for(String str : childrenIds){
					//先查找所有记录
					List<OrganUser> orgUserList = organUserService.findByOrgId(str);
					if(orgUserList != null && !orgUserList.isEmpty()){
						for(OrganUser temp : orgUserList){
							List<OrganUser> t = organUserService.findByUserId(childrenIds.toArray(new String[0]), temp.getUserId());
							if(t == null || t.isEmpty()){
								organUserService.addUserToOther(temp.getUserId());
							}
						}
					}
					//删除原有记录
					organUserService.deleteFromOrgId(str);
					this.delete(str);
				}
			}
		}
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganService#findByUserId(java.lang.String)
	 *
	 */
	@Override
	public List<Organ> findByUserId(String userId) {
		if(!StringUtils.isEmpty(userId)){
			return organDao.findByUserId(userId);
		}
		return null;
	}
	
	
	@Override
	public List<Organ> getAllOrgDept() {
		return organDao.getAllOrgDept();
	}

	@Override
	public List<Organ> getChildren(String parentId, Integer status, Integer type) {
		return organDao.getChildren(parentId,status,type);
	}

	@Override
	public List<TreeNode> queryOrganTree() {
		List<TreeNode> result = new ArrayList<TreeNode>();
		Organ rootOrgan = organDao.getRootOrgan();
		if (rootOrgan != null) {
			TreeNode root = new TreeNode();
			root.setId(rootOrgan.getOrgId());
			root.setText(rootOrgan.getName());
			root.setState(TreeNode.STATE_OPEN);
			root.setIconCls("fa fa-sitemap");
			root.getAttributes().put("nodeType", "0");
			//queryChildrenByParentId(root);
			List<TreeNode> childNode = getChildrenByParentId(rootOrgan.getOrgId());
			root.setChildren(childNode);
			result.add(root);
		}
		return result;
	}
	
	@Override
	public List<TreeNode> getRootOrgan_SystemList() {
		List<TreeNode> result = new ArrayList<TreeNode>();
		List<Organ> list = organDao.getRootOrgan_SystemList();
		int count=0;
		for (Organ rootOrgan : list) {
			if (rootOrgan != null) {
				TreeNode root = new TreeNode();
				root.setId(rootOrgan.getOrgId());
				root.setText(rootOrgan.getName());
				root.setState(TreeNode.STATE_OPEN);
				root.setIconCls("fa fa-sitemap");
				root.getAttributes().put("nodeType", String.valueOf(count));
				List<TreeNode> childNode = getChildrenByParentId(rootOrgan.getOrgId());
				root.setChildren(childNode);
				result.add(root);
			}
			count++;
		}
		return result;
	}

	@Override
	public Organ getRootOrgan() {
		return organDao.getRootOrgan();
	}

	@Override
	public Organ getOrganBySyscode(String sysCode) {
		return organDao.getOrganBySyscode(sysCode);
	}

	@Override
	public List<Organ> queryRootOrgan() {
		return organDao.getRootOrgan_SystemList();
	}

	@Override
	public List<TreeNode> queryTreeNode(boolean flag) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		//查询所有的组织机构信息
		List<Map<String, Object>> list = organDao.queryOrganTree();
		if (list != null && !list.isEmpty()) {
			for (Map<String, Object> m : list) {
				TreeNode node = new TreeNode();
				node.setId(String.valueOf(m.get("ORG_ID")));
				node.setText(String.valueOf(m.get("NAME")));
				node.setParentId(m.get("PARENT_ID")==null?"0":String.valueOf(m.get("PARENT_ID")));
				node.setPath(String.valueOf(m.get("PATH")));//路径
				node.setSysCode(m.get("SYSCODE")==null?"":String.valueOf(m.get("SYSCODE"))); //组织机构SYSCODE
				node.setNodeType(Integer.parseInt(String.valueOf(m.get("TYPE"))));//节点类型
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-sitemap");// 图标:组织机构
				result.add(node);
			}
		}
		return result;
	}
	
	@Override
	public List<TreeNode> queryTreeNode(String parentId) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		//查询所有的组织机构信息
		List<Map<String, Object>> list = organDao.queryTreeNode(parentId);
		if (list != null && !list.isEmpty()) {
			for (Map<String, Object> m : list) {
				TreeNode node = new TreeNode();
				node.setId(String.valueOf(m.get("ORG_ID")));
				node.setText(String.valueOf(m.get("NAME")));
				node.setParentId(m.get("PARENT_ID")==null?"0":String.valueOf(m.get("PARENT_ID")));
				node.setPath(String.valueOf(m.get("PATH")));//路径
				node.setSysCode(m.get("SYSCODE")==null?"":String.valueOf(m.get("SYSCODE"))); //组织机构SYSCODE
				node.setNodeType(Integer.parseInt(String.valueOf(m.get("TYPE"))));//节点类型
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-sitemap");// 图标:组织机构
				node.setLeaf(false); //判断是否叶子节点：非叶子节点
				result.add(node);
			}
		}
		return result;
	}
}