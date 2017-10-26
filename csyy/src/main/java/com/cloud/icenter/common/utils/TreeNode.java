package com.cloud.icenter.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TreeNode
 * @Description:
 */
public class TreeNode {

	public static final String STATE_OPEN="open";
	public static final String STATE_CLOSED="closed";
	
	public static final int NODE_TYPE_DEFINE=-1;//自定义的节点类型，代表非组织机构表产生的
	
	private String id;
	private String text;
	private String state;		//节点状态 open, close
	private boolean checked;
	private String iconCls;
	private Map<String,Object> attributes;
	private List<TreeNode> children;
	private String pluginUrl;
	private String parentId;//父节点id，为生成递归加载树
	private String path;//路径
	private int nodeType;
	private String sysCode;
	
	private boolean isLeaf; //是否叶子节点
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, Object> getAttributes() {
		if (attributes == null) attributes = new HashMap<String, Object>();
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<TreeNode> getChildren() {
		if (children == null) children = new ArrayList<TreeNode>();
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}


	public int getNodeType() {
		return nodeType;
	}

	public void setNodeType(int nodeType) {
		this.nodeType = nodeType;
	}

	public String getPluginUrl() {
		return pluginUrl;
	}

	public void setPluginUrl(String pluginUrl) {
		this.pluginUrl = pluginUrl;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
}