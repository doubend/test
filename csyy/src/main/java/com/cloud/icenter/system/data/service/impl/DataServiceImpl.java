package com.cloud.icenter.system.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.pojo.SysDict;
import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.data.dao.DataDao;
import com.cloud.icenter.system.data.service.DataService;
import com.cloud.icenter.system.logs.pojo.Logging;

@Logging
@Service
public class DataServiceImpl extends BaseServiceImpl<SysDict> implements DataService {

	@Autowired private DataDao dataDao;
	
	@Override
	public List<SysDict> getChildren(String parentId, Integer status) {
		return dataDao.getChildren(parentId, status);
	}

	@Override
	public List<SysDict> getChildren(String code) {
		return dataDao.getChildren(code);
	}

	@Override
	public SysDict getByCode(String code) {
		return dataDao.getByCode(code);
	}

	@Override
	public void move(String targetId, String sourceId, String point) {
		dataDao.move(targetId, sourceId, point);
	}

	@Override
	public SysDict getByCode(String code, String value) {
		return dataDao.getByCode(code, value);
	}

	@Override
	public List<SysDict> getSysDictById(List<String> ids) {
		return dataDao.getSysDictById(ids);
	}

	@Override
	public SysDict getByTextAndType(String text, int type) {
		return dataDao.getByTextAndType(text,type);
	}

	@Override
	public List<SysDict> getAllDict() {
		return dataDao.getAllDict();
	}

	@Override
	public List<TreeNode> queryDictByCode(String code) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		SysDict dict = getByCode(code);
		if (dict != null) {
			TreeNode node = new TreeNode();
			node.setId(dict.getDictId());
			node.setText(dict.getText());
			node.setIconCls("fa fa-folder");
			node.setState(TreeNode.STATE_OPEN);
			
			//递归调用循环到底
			queryChildrenByParentId(node);
			result.add(node);
		}
		return result;
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
		List<SysDict> result = getChildren(parentId, SysDict.STATUS_DEFAULT);
		List<TreeNode> tree = new ArrayList<TreeNode>(result.size());
		for (SysDict o: result) {
			TreeNode node = convert(o);
			tree.add(node);
		}
		return tree;
	}
	
	private TreeNode convert(SysDict sysDict) {
		TreeNode node = new TreeNode();
		if (sysDict != null) {
			node.setId(sysDict.getDictId());
			node.setText(sysDict.getText());
			if (sysDict.getType() == SysDict.TYPE_DIRECTORY) {
				node.setIconCls("fa fa-folder");
			} else {
				node.setIconCls("fa fa-file");
			}
		}
		return node;
	}

}
