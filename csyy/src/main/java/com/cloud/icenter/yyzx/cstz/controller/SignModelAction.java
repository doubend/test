
package com.cloud.icenter.yyzx.cstz.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.cstz.service.SignModelService;
import com.cloud.icenter.yyzx.cstz.pojo.SignModel;


/**
* Created with gender.
* @author: whcai
* Date: 2017-03-20 15:49:08
*/
@Controller
@RequestMapping(value="/signmodel")
public class SignModelAction extends ModelAction<SignModel>  {

	@Autowired private SignModelService signModelService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "signmodel/signmodel-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "signmodel/signmodel-query";
    }
    
   @RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "signmodel/signmodel-add";
	}
    
    /**
 	 * 查询
 	 */
     @RequestMapping(value="/query",method=RequestMethod.POST)
 	public void query(SignModel param) {
 		signModelService.find(getPagination());
 		printJson(getPagination());
 	}
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody SignModel signModel) {
		try {
		//signModel.setCreateDate(new Date());
		//signModel.setCreateUserId(getLoginUser().getUserId());
		signModelService.add(signModel);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		SignModel signModel=signModelService.get(id);
		setAttribute("signModel", signModel);
		return "signmodel/signmodel-update";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		try {
		signModelService.delete(id);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody SignModel param) {
		try {
		//param.setEditDate(new Date());
		//param.setEditUserId(getLoginUser().getUserId());
		SignModel signModel=signModelService.get(id);
						
		signModel.setParentId (param.getParentId ()); // 父级体征ID，若没有则为空 				
		signModel.setTzmc (param.getTzmc ()); // 体征名称：如居民生活用水缺口指数 				
		signModel.setTzlx (param.getTzlx ()); // 体征类型：0：综合体征；1：主题体征；2：专题体征；3：业务指标体征 				
		signModel.setQz (param.getQz ()); // 占上级体征的权重（0.0-1.0），若没有上级体征则为1.0 				
		signModel.setMrz (param.getMrz ()); // 体征默认值：指数值（0.0-10.0） 				
		signModel.setGjz (param.getGjz ()); // 告警值：当指标指数低于该值时出现告警提示 				
		signModel.setTzzt (param.getTzzt ()); // 体征状态：0：启用；1：未启用（删除） 				
		signModel.setCreateTime (param.getCreateTime ()); // 创建时间 				
		signModel.setUpdateTime (param.getUpdateTime ()); // 更新时间 				
		signModel.setDeleteTime (param.getDeleteTime ()); // 删除时间 				
		signModel.setDeleteStatus (param.getDeleteStatus ()); // 删除状态：0正常，1删除 				
		signModel.setCreator (param.getCreator ()); // 创建者 		
		signModelService.update(signModel);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

}

