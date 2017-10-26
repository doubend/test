
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
import com.cloud.icenter.yyzx.cstz.service.BusinessIndexDataService;
import com.cloud.icenter.yyzx.cstz.pojo.BusinessIndexData;


/**
* Created with gender.
* @author: whcai
* Date: 2017-03-20 15:54:44
*/
@Controller
@RequestMapping(value="/businessindexdata")
public class BusinessIndexDataAction extends ModelAction<BusinessIndexData>  {

@Autowired private BusinessIndexDataService businessIndexDataService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "businessindexdata/businessindexdata-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "businessindexdata/businessindexdata-query";
    }
    
   @RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "businessindexdata/businessindexdata-add";
	}
    
    /**
 	 * 查询
 	 */
     @RequestMapping(value="/query",method=RequestMethod.POST)
 	public void query(BusinessIndexData param) {
 		businessIndexDataService.find(getPagination());
 		printJson(getPagination());
 	}
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody BusinessIndexData businessIndexData) {
		try {
		//businessIndexData.setCreateDate(new Date());
		//businessIndexData.setCreateUserId(getLoginUser().getUserId());
		businessIndexDataService.add(businessIndexData);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		BusinessIndexData businessIndexData=businessIndexDataService.get(id);
		setAttribute("businessIndexData", businessIndexData);
		return "businessindexdata/businessindexdata-update";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		try {
		businessIndexDataService.delete(id);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody BusinessIndexData param) {
		try {
		//param.setEditDate(new Date());
		//param.setEditUserId(getLoginUser().getUserId());
		BusinessIndexData businessIndexData=businessIndexDataService.get(id);
						
		businessIndexData.setYwzbId (param.getYwzbId()); // 业务指标ID 				
		businessIndexData.setYwzbsj (param.getYwzbsj ()); // 业务指标数据值 				
		businessIndexData.setDataTime (param.getDataTime ()); // 数据时间 				
		businessIndexData.setCreateTime (param.getCreateTime ()); // 创建时间 				
		businessIndexData.setUpdateTime (param.getUpdateTime ()); // 更新时间 				
		businessIndexData.setDeleteTime (param.getDeleteTime ()); // 删除时间 				
		businessIndexData.setDeleteStatus (param.getDeleteStatus ()); // 删除状态：0正常，1删除 				
		businessIndexData.setCreator (param.getCreator ()); // 创建者 		
		businessIndexDataService.update(businessIndexData);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

}

