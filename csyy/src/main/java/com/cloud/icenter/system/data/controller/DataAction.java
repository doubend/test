package com.cloud.icenter.system.data.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.base.pojo.SysDict;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.data.service.DataService;
import com.cloud.icenter.system.data.utils.DictUtils;

@Controller
@RequestMapping(value="/system/data")
public class DataAction extends ModelAction<SysDict> {
	
	@Autowired 
	private DataService dataService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "system/data/data-list";
	} 
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "system/data/data-query";
    }
    @RequestMapping(value="/query",method=RequestMethod.POST)
	public void query(SysDict param) {
		
		String id=getId(); 
		
		List<SysDict> datas=dataService.getChildren(id, SysDict.STATUS_DEFAULT);
		List<TreeNode> tree=new ArrayList<TreeNode>(datas.size());
		
		for(SysDict m:datas) {
			TreeNode node=new TreeNode();
			node.setId(m.getDictId());
			node.setText(m.getText());
			if(m.getType()==SysDict.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-folder");
			} else {
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-file");
			}
			node.getAttributes().put("parentId", m.getParentId());
			node.getAttributes().put("type", m.getType());
			tree.add(node);
		}
		printJson(tree);
	}
    
    /**
     * 异步加载数据， 根据配置的code加载该code下的信息
     * @param code
     */
    @RequestMapping(value="/queryByCode/{code}",method={RequestMethod.GET,RequestMethod.POST})
   	public void queryByCode(@PathVariable String code) {

    	String id = getId();
    	if (id == null) {
    		SysDict sysDict = dataService.getByCode(code);
    		id = sysDict.getDictId();
    	}
    	
   		List<SysDict> datas=dataService.getChildren(id, SysDict.STATUS_DEFAULT);
   		List<TreeNode> tree=new ArrayList<TreeNode>(datas.size());
   		
   		for(SysDict m:datas) {
   			TreeNode node=new TreeNode();
   			node.setId(m.getDictId());
   			node.setText(m.getText());
   			if(m.getType()==SysDict.TYPE_DIRECTORY) {
   				node.setState(TreeNode.STATE_CLOSED);
   				node.setIconCls("fa fa-folder");
   			} else {
   				node.setState(TreeNode.STATE_OPEN);
   				node.setIconCls("fa fa-file");
   			}
   			node.getAttributes().put("parentId", m.getParentId());
   			node.getAttributes().put("type", m.getType());
   			tree.add(node);
   		}
   		printJson(tree);
   	}
    
    @RequestMapping(value="/queryComboContext/{code}/{metedataId}",method={RequestMethod.GET,RequestMethod.POST})
   	public void queryComboContext(@PathVariable String code, @PathVariable String metedataId) {

    	String id = getId();
    	if (id == null) {
    		SysDict sysDict = dataService.getByCode(code);
    		id = sysDict.getDictId();
    	}
    	
   		List<SysDict> datas=dataService.getChildren(id, SysDict.STATUS_DEFAULT);
   		List<TreeNode> tree=new ArrayList<TreeNode>(datas.size());
   		
   		for(SysDict m:datas) {
   			TreeNode node=new TreeNode();
   			//设置combobox的ID = 元数据ID + 数据字典ID
   			String textId = metedataId+"-"+m.getDictId();
   			node.setId(textId);
   			node.setText(m.getText());
   			if(m.getType()==SysDict.TYPE_DIRECTORY) {
   				node.setState(TreeNode.STATE_CLOSED);
   				node.setIconCls("fa fa-folder");
   			} else {
   				node.setState(TreeNode.STATE_OPEN);
   				node.setIconCls("fa fa-file");
   			}
   			node.getAttributes().put("parentId", m.getParentId());
   			node.getAttributes().put("type", m.getType());
   			tree.add(node);
   		}
   		printJson(tree);
   	}
    
   
    /**
     * 根据code获取数据 同步加载
     * @param code
     */
    @RequestMapping(value="/queryCode/{code}/{sid}",method={RequestMethod.GET,RequestMethod.POST})
    public void queryCode(@PathVariable String code,@PathVariable String sid) {
     	try {
     		if(sid!=""&&sid!=null){
     			sid = new String(sid.getBytes("ISO8859-1"),"UTF-8");
     		}
 		} catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
		}
      	String id = getId();
    	if (id == null) {
    		SysDict sysDict = dataService.getByCode(code);
    		id = sysDict.getDictId();
    	}
    	//选中的节点id
    	//String sid = getParameter("sid");
    	//向上追溯到根节点，我们要去的数据不是根节点，是根节点的下一个节点
    	SysDict dict = getParent(sid, id);
    	
		List<TreeNode> tree = getTreeNodeByParentId(id);
		for (TreeNode node : tree) {
			String _pid = node.getId();
			List<TreeNode> branch = getTreeNodeByParentId(_pid);
			node.setState(TreeNode.STATE_CLOSED);
			node.setChildren(branch);
			//因为该节点被选中，所以，在此遍历该节点下的所有数据，加载到tree当中
			if (dict != null && node.getId() != null && node.getId().equals(dict.getDictId())) {
				recursion(node);
			}
		}
		printJson(tree);
    }
    
    //递归调用，直到找到根节点的下个节点对象
    private SysDict getParent(String sid, String id) {
     	SysDict sysDict = dataService.get(sid);
     	if (sysDict != null&&sysDict.getParentId()!=null) {
     		if(!sysDict.getParentId().equals(id)){
     			return getParent(sysDict.getParentId(), id);
     		}else{
     			return sysDict;
     		}
     	} else {
    		return sysDict;
    	}
    }
    
    /**
     * 查询该code下的所有数据,递归调用
     * @param code
     */
    @RequestMapping(value="/queryAllCode/{code}",method={RequestMethod.GET,RequestMethod.POST})
    public void queryAllCode(@PathVariable String code) {

    	String id = getId();
    	if (id == null) {
    		SysDict sysDict = dataService.getByCode(code);
    		id = sysDict.getDictId();
    	}
    
		List<TreeNode> tree = getTreeNodeByParentId(id);
		for (TreeNode node : tree) {
			recursion(node);
		}
		printJson(tree);
    }
    
    //根据父节点，查询子节点信息
    private List<TreeNode> getTreeNodeByParentId(String parentId) {
    	List<SysDict> datas = dataService.getChildren(parentId, SysDict.STATUS_DEFAULT);
    	List<TreeNode> tree = new ArrayList<TreeNode>(datas.size());
    	for (SysDict m : datas) {
    		TreeNode node = new TreeNode();
			node.setId(m.getDictId());
			node.setText(m.getText());
			if(m.getType()==SysDict.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-folder");
			} else {
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-file");
			}
			node.getAttributes().put("parentId", m.getParentId());
			node.getAttributes().put("type", m.getType());
			tree.add(node);
    	}
    	return tree;
    }
    
    //递归调用
    public void recursion(TreeNode treeNode) {
    	List<TreeNode> treeList = new ArrayList<TreeNode>();
    	List<SysDict> datas = dataService.getChildren(treeNode.getId(), SysDict.STATUS_DEFAULT);
    	if (datas != null && datas.size() > 0) {
    		for (SysDict m : datas) {
        		TreeNode node = new TreeNode();
    			node.setId(m.getDictId());
    			node.setText(m.getText());
    			if(m.getType()==SysDict.TYPE_DIRECTORY) {
    				node.setState(TreeNode.STATE_CLOSED);
    				node.setIconCls("fa fa-folder");
    			} else {
    				node.setState(TreeNode.STATE_OPEN);
    				node.setIconCls("fa fa-file");
    			}
    			node.getAttributes().put("parentId", m.getParentId());
    			node.getAttributes().put("type", m.getType());
    			treeList.add(node);
    			//递归调用
    			recursion(node);
        	}
        	treeNode.setChildren(treeList);
    	}
    }
	
    @RequestMapping(value="/add",method=RequestMethod.GET)
   	public String add(@RequestParam(required=false) String parentId) {
    	if(!StringUtils.isBlank(parentId)) {
    		SysDict parent=dataService.get(parentId);
    		setAttribute("parent", parent);
    	}
   		return "system/data/data-update";
   	}
   	
   	@RequestMapping(value="/add",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doAdd(SysDict data) {
   		data.setCreatorId(getLoginUser().getUserId());
   		//设置path路径为：父节点ID+/+本身节点ID
   		if(!StringUtils.isEmpty(data.getParentId())){
   			SysDict parentData = dataService.get(data.getParentId());
   			if (null != parentData && StringUtils.isEmpty(parentData.getPath())) {
   				data.setPath(parentData.getPath()+data.getDictId());
   			}
   		}
   		try {
   			data.setStatus(SysDict.STATUS_DEFAULT);
   			dataService.add(data);
   			//缓存数据字典
   	    	DictUtils.cache();
   		} catch(Exception e) {
   			return jsonResult(-1, e.getMessage());
   		}
   		return jsonResult(200, "OK");
   	}
   	
   	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
   	public String update(@PathVariable String id) {
   		SysDict data=dataService.get(id);
   		setAttribute("data", data);
   		if(!StringUtils.isBlank(data.getParentId())) {
   			SysDict parent=dataService.get(data.getParentId());
    		setAttribute("parent", parent);
    	}
   		return "system/data/data-update";
   	}
   	
   	
   	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doUpdate(@PathVariable String id,SysDict param) {
   		SysDict data=dataService.get(id);
   		if(data==null) {
   			return jsonResult(-1, "基础数据不存在!");
   		}
   		data.setText(param.getText());
   		data.setValue(param.getValue());
   		data.setCode(param.getCode());
   		data.setStatus(SysDict.STATUS_DEFAULT);	
   		data.setType(param.getType());
   		data.setDiscription(param.getDiscription());
   		//设置path路径为：父节点ID+/+本身节点ID
   		if (null != data.getParentId()) {
			SysDict parentData = dataService.get(data.getParentId());
			if (!StringUtils.isEmpty(parentData.getPath())) {
				data.setPath(parentData.getPath() + data.getDictId());
			}
		}
   		try {
   			dataService.update(data);
   			//缓存数据字典
   	    	DictUtils.cache();
   			return jsonResult(200, "OK");
   		} catch(Exception e) {
   			return jsonResult(-1, e.getMessage());
   		}
   	}
   	
   	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doDelete(@PathVariable String id) {
   		dataService.delete(id);
   		//缓存数据字典
	    DictUtils.cache();
   		return jsonResult(200, "OK");
   	}
	
   	/**
	 * 移动节点
	 * @param targetId		目标节点id
	 * @param sourceId		源节点id
	 * @param point			操作类型	取值范围: append,top,bottom
	 */
	@RequestMapping(value="/move",method=RequestMethod.POST)
   	@ResponseBody
	public JsonResult move(@RequestParam String targetId,@RequestParam String sourceId,@RequestParam String point) {
		dataService.move(targetId, sourceId, point);
		//缓存数据字典
	    DictUtils.cache();
		return jsonResult(200, "OK");
	}
	
	@RequestMapping(value="/check_code",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult checkCode(@RequestParam(required=false) String id,@RequestParam String code) {
		SysDict data=dataService.getByCode(code);
		//如果是添加,那么判断是否已有同名数据
		if(StringUtils.isBlank(id)) {
			if(data==null) {
				return jsonResult(200, "OK");
			} else {
				return jsonResult(-1, "Code已存在!");
			}
		} else {
			//否则是更新,判断是否有同名角色,如果同名且ID相同,那么通过;否则同名且ID不相同,那么不通过
			if(data==null) return jsonResult(200, "OK");;
			if(id.equals(data.getDictId())) {
				return jsonResult(200, "OK");
			} else {
				return jsonResult(-1, "Code已存在!");
			}
		}
   	}
}
