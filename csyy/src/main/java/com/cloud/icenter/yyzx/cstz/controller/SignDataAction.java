
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
import com.cloud.icenter.yyzx.cstz.service.SignDataService;
import com.cloud.icenter.yyzx.cstz.pojo.SignData;


/**
* Created with gender.
* @author: whcai
* Date: 2017-03-20 15:53:01
*/
@Controller
@RequestMapping(value="/signdata")
public class SignDataAction extends ModelAction<SignData>  {

@Autowired private SignDataService signDataService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "signdata/signdata-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "signdata/signdata-query";
    }
    
   @RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "signdata/signdata-add";
	}
    
    /**
 	 * 查询
 	 */
     @RequestMapping(value="/query",method=RequestMethod.POST)
 	public void query(SignData param) {
 		signDataService.find(getPagination());
 		printJson(getPagination());
 	}
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody SignData signData) {
		try {
		//signData.setCreateDate(new Date());
		//signData.setCreateUserId(getLoginUser().getUserId());
		signDataService.add(signData);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		SignData signData=signDataService.get(id);
		setAttribute("signData", signData);
		return "signdata/signdata-update";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		try {
		signDataService.delete(id);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody SignData param) {
		try {
		//param.setEditDate(new Date());
		//param.setEditUserId(getLoginUser().getUserId());
		SignData signData=signDataService.get(id);
						
		signData.setTzId(param.getTzId()); // 体征ID 				
		signData.setTzz (param.getTzz ()); // 体征值：0.0-10.0 				
		signData.setTzzk (param.getTzzk ()); // 体征状况：优、良、中、差 				
		signData.setDataTime (param.getDataTime ()); // 数据时间 				
		signData.setCreateTime (param.getCreateTime ()); // 创建时间 				
		signData.setUpdateTime (param.getUpdateTime ()); // 更新时间 				
		signData.setDeleteTime (param.getDeleteTime ()); // 删除时间 				
		signData.setDeleteStatus (param.getDeleteStatus ()); // 删除状态：0正常，1删除 				
		signData.setCreator (param.getCreator ()); // 创建者 		
		signDataService.update(signData);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

}

