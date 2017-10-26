package com.cloud.icenter.system.data.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.cloud.icenter.base.pojo.SysDict;
import com.cloud.icenter.common.utils.EHcacheUtils;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.data.service.DataService;

/**
 * 
* @ClassName: DictUtils 
* @Description: 获取数据字典相关的数据信息 
* @author menglit 
* @date 2016年9月23日 上午10:22:17 
*
 */
@Component
public class DictUtils {
	public static final String SYS_DICTIONARY = "SYS_DICTIONARY";
	
	private static DataService dataService;
	
	
	//缓存元数据数据字典信息
	public static void cache(){
		//获取数据字典信息
		List<SysDict> dict = dataService.getAllDict();
		//把数据字典进行缓存
		EHcacheUtils.set(SYS_DICTIONARY, dict);
	}


	@Resource
	public void setDataService(DataService dataService) {
		DictUtils.dataService = dataService;
	}
	
	/**
	 * 
	* @Title: getChildByCode 
	* @Description: 根据数据字典获取直接下级节点
	* @param @param code
	* @param @return    设定文件 
	* @return List<SysDict>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public static List<SysDict> getChildByCode(String code){
		if(StringUtils.isBlank(code)) return null;
		List<SysDict> dict = (List<SysDict>) EHcacheUtils.get(SYS_DICTIONARY);
		List<SysDict> children = new ArrayList<SysDict>();
		String parentId = null;
		for(SysDict tmp:dict){
			if(code.equals(tmp.getCode())){
				parentId = tmp.getDictId();
				break;
			}
		}
		if(StringUtils.isBlank(parentId)) return null;
		for(SysDict tmp:dict){
			if(parentId.equals(tmp.getParentId())){
				children.add(tmp);
			}
		}
		return children;
	}
	
	/**
	 * 根据ID获取所有的子节点
	 * @param id 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<SysDict> getChildById(String id){
		if(StringUtils.isBlank(id)) return null;
		List<SysDict> dict = (List<SysDict>) EHcacheUtils.get(SYS_DICTIONARY);
		List<SysDict> children = new ArrayList<SysDict>();
		for(SysDict tmp:dict){
			if(id.equals(tmp.getParentId())){
				children.add(tmp);
			}
		}
		return children;
	}
	
	/**
	 * 
	 * @Title: getChildByCode 
	 * @Description: 根据code获取数据字典对象(如果没有则返回空)
	 * @param @param code
	 * @param @return    设定文件 
	 * @return List<SysDict>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static SysDict getDictByCode(String code){
		if(StringUtils.isBlank(code)) return null;
		List<SysDict> dict = (List<SysDict>) EHcacheUtils.get(SYS_DICTIONARY);
		for(SysDict tmp:dict){
			if(code.equals(tmp.getCode())){
				return tmp;
			}
		}
		return null;
	}
	
	/**
	 * 
	* @Title: getDictById 
	* @Description: 根据ID获取数据字典对象(如果没有则返回空)
	* @param @param id
	* @param @return    设定文件 
	* @return SysDict    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public static SysDict getDictById(String id){
		if(StringUtils.isBlank(id)) return null;
		List<SysDict> dict = (List<SysDict>) EHcacheUtils.get(SYS_DICTIONARY);
		for(SysDict tmp:dict){
			if(id.equals(tmp.getDictId())){
				return tmp;
			}
		}
		return null;
	}
	
	/**
	* @Title: getDictNameByCode 
	* @Description: 根据code获取字典的名称(无对应记录时返回null) 
	* @param @param code
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public static String getDictNameByCode(String code){
		if(StringUtils.isBlank(code)) return null;
		List<SysDict> dict = (List<SysDict>) EHcacheUtils.get(SYS_DICTIONARY);
		for(SysDict tmp:dict){
			if(code.equals(tmp.getCode())){
				return tmp.getText();
			}
		}
		return null;
	}
	
	/**
	* @Title: getDictNameByCode 
	* @Description: 根据code以及值获取字典的名称(无对应记录时返回null) 
	* @param @param code
	* @param @param value
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getDictNameByCodeAndValue(String code,String value){
		if(StringUtils.isBlank(code) || StringUtils.isBlank(value)) return null;
		List<SysDict> children = getChildByCode(code);
		for(SysDict dict:children){
			if(value.equals(dict.getValue())){
				return dict.getText();
			}
		}
		return null;
	}
	
	/**
	 * 根据code递归获取所有的子节点
	 * @param code
	 * @return
	 */
	public static List<TreeNode> queryDictByCode(String code) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		SysDict dict = getDictByCode(code);
		if (dict != null) {
			TreeNode node = new TreeNode();
			node.setId(dict.getDictId());
			node.setText(dict.getText());
			
			//递归调用循环到底
			queryChildrenByParentId(node);
			
			node.setIconCls("fa fa-folder");
			node.setState(TreeNode.STATE_OPEN);
			result.add(node);
		}
		return result;
	}
	
	/**
	 * 数据递归调用，一次性全部加载成功
	 * @param node
	 */
	private static void queryChildrenByParentId(TreeNode node) {
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
	private static List<TreeNode> getChildrenByParentId(String parentId) {
		List<SysDict> result = getChildById(parentId);
		List<TreeNode> tree = new ArrayList<TreeNode>(result.size());
		for (SysDict o: result) {
			TreeNode node = convert(o);
			tree.add(node);
		}
		return tree;
	}
	
	private static TreeNode convert(SysDict sysDict) {
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
