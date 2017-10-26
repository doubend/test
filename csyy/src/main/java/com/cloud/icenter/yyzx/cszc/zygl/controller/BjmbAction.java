package com.cloud.icenter.yyzx.cszc.zygl.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.BjmbPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.BjmbService;
import com.cloud.icenter.yyzx.cszc.zygl.service.JbxxService;

/** 
* @author zhucy 
* @version 2017年3月24日 下午2:11:40 
* 资源分类>部件码表
*/
@Controller
@RequestMapping("/bjmb")
public class BjmbAction extends ModelAction<BjmbPojo>{
	
	@Autowired
	private BjmbService bjmbService;
	
	@Autowired
	private JbxxService jbxxService;
	
	@RequestMapping(value = "/toZyfl",method=RequestMethod.GET)
	public String toZyfl(){
		return "cszc/zygl/bjmb-list";
	}
	
	/**
	 * 查询资源分类tree
	 * @param param
	 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void query(BjmbPojo param) {
		
		String id=getId();
		
		List<BjmbPojo> BjmbPojos=bjmbService.getChildren(id, "0");
		List tree=new ArrayList(BjmbPojos.size());
		
		for(BjmbPojo f:BjmbPojos) {
			TreeNode node=new TreeNode();
			node.setId(f.getId());
			node.setText(f.getMc());
			if(f.getType()==BjmbPojo.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-folder");
			} else {
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-file");
			}
			node.getAttributes().put("parentId", f.getSjbh());
			node.getAttributes().put("type", f.getType());
			tree.add(node);
		}
		printJson(tree);
	}
	
	
	/**
	 * 查询资源分类tree,自动选中已选
	 * @param param
	 */
	@RequestMapping(value="/queryById",method=RequestMethod.POST)
	public void queryById() {
		
		String id=getId();
		
		List<BjmbPojo> BjmbPojos=bjmbService.getChildren(id, "0");
		List tree=new ArrayList(BjmbPojos.size());
		String checkId=getParameter("checkId");//选中的节点
		for(BjmbPojo f:BjmbPojos) {
			TreeNode node=new TreeNode();
			node.setId(f.getId());
			node.setText(f.getMc());
			if(f.getType()==BjmbPojo.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-folder");
			} else {
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-file");
			}
			if(f.getId().equals(checkId)){//设置选中状态
				node.setChecked(true);
			}
			node.getAttributes().put("parentId", f.getSjbh());
			node.getAttributes().put("type", f.getType());
			tree.add(node);
		}
		printJson(tree);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
   	public String add(@RequestParam(required=false) String parentId) {
    	if(!StringUtils.isBlank(parentId)) {
    		BjmbPojo parent=bjmbService.get(parentId);
    		setAttribute("parent", parent);
    	}
   		return "cszc/zygl/bjmb-update";
   	}
   	
   	@RequestMapping(value="/add",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doAdd(BjmbPojo bjmbPojo) {
   		bjmbPojo.setCreatorId(getLoginUser().getUserId());
   		if(bjmbService.checkDm(bjmbPojo.getDm()))
   		{
   			return jsonResult(-1, "代码已经存在!");
   		}
   		try {
   			bjmbPojo.setCreateTime(new Date());
   	   		bjmbPojo.setDeleteStatus("0");
   			bjmbService.add(bjmbPojo);
   		} catch(Exception e) {
   			return jsonResult(-1, e.getMessage());
   		}
   		return jsonResult(200, "OK");
   	}
   	
   	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
   	public String update(@PathVariable String id) {
   		BjmbPojo bjmbPojo=bjmbService.get(id);
   		setAttribute("bjmbPojo", bjmbPojo);
   		if(!StringUtils.isBlank(bjmbPojo.getSjbh())) {
    		BjmbPojo parent=bjmbService.get(bjmbPojo.getSjbh());
    		setAttribute("parent", parent);
    	}
   		return "cszc/zygl/bjmb-update";
   	}
   	
   	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doUpdate(@PathVariable String id,BjmbPojo param) {
   		BjmbPojo bjmbPojo=bjmbService.get(id);
   		if(bjmbPojo==null) {
   			return jsonResult(-1, "分类不存在!");
   		}
   		//add by YHT
   		if(!StringUtils.isBlank(param.getDm()) && bjmbService.checkDm(param.getDm()) && !bjmbPojo.getDm().equals(param.getDm()))
   		{
   			return jsonResult(-1, "代码已经存在!");
   		}
   		if (!bjmbPojo.getType().equals(param.getType())) {
   			List<JbxxPojo> jbxxPojos = jbxxService.getListByFenlei(id);
   			if(null != jbxxPojos && jbxxPojos.size() > 0 ){
   				return jsonResult(-1, "此分类下含有资产信息,不允许修改节点类型!");
   			}
		}
   		bjmbPojo.setMc(param.getMc());
   		bjmbPojo.setType(param.getType());
   		bjmbPojo.setDm(param.getDm());
   		bjmbPojo.setSjbh(param.getSjbh());
   		bjmbPojo.setCreateTime(new Date());
   		bjmbPojo.setDeleteStatus("0");
   		bjmbPojo.setCreatorId(getLoginUser().getCreatorId());
   		try {
   			bjmbService.update(bjmbPojo);
   			return jsonResult(200, "OK");
   		} catch(Exception e) {
   			return jsonResult(-1, e.getMessage());
   		}
   	}
   	
   	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doDelete(@PathVariable String id) {
   		try {
			bjmbService.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return jsonResult(-1, e.getMessage());
		}
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
		bjmbService.move(targetId, sourceId, point);
		return jsonResult(200, "OK");
	}
	

}
