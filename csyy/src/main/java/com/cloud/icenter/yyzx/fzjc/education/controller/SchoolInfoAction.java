
package com.cloud.icenter.yyzx.fzjc.education.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.fzjc.education.service.SchoolInfoService;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolInfo;


/**
* Created with gender.
* @author: whcai
* Date: 2017-07-04 17:37:40
*/
@Controller
@RequestMapping(value="/education")
public class SchoolInfoAction extends ModelAction<SchoolInfo>  {

@Autowired private SchoolInfoService schoolInfoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "schoolinfo/schoolinfo-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "schoolinfo/schoolinfo-query";
    }
    
   @RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "schoolinfo/schoolinfo-add";
	}
    
     /**
 	 * 查询
 	 */
     @RequestMapping(value="/query",method=RequestMethod.POST)
 	public void query(SchoolInfo param) {
 		schoolInfoService.find(getPagination());
 		printJson(getPagination());
 	}
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody SchoolInfo schoolInfo) {
		try {
		//schoolInfo.setCreateDate(new Date());
		//schoolInfo.setCreateUserId(getLoginUser().getUserId());
		schoolInfoService.add(schoolInfo);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		SchoolInfo schoolInfo=schoolInfoService.get(id);
		setAttribute("schoolInfo", schoolInfo);
		return "schoolinfo/schoolinfo-update";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		try {
		schoolInfoService.delete(id);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody SchoolInfo param) {
		try {
		//param.setEditDate(new Date());
		//param.setEditUserId(getLoginUser().getUserId());
		SchoolInfo schoolInfo=schoolInfoService.get(id);
						
		schoolInfo.setXxbh (param.getXxbh ()); // 学校编号 				
		schoolInfo.setXxmc (param.getXxmc ()); // 学校名称 				
		schoolInfo.setXxjc (param.getXxjc ()); // 学校简称 				
		schoolInfo.setSzdxzqhbm (param.getSzdxzqhbm ()); // 所在地行政区划编码：753420 				
		schoolInfo.setSzdxzqhmc (param.getSzdxzqhmc ()); // 所在地行政区划名称：大武口区 				
		schoolInfo.setXxlx (param.getXxlx ()); // 学校类型：1幼儿园； 2小学； 3初中； 4高中 等 				
		schoolInfo.setDizhi (param.getDizhi ()); // 地址 				
		schoolInfo.setX (param.getX ()); // 经度 				
		schoolInfo.setY (param.getY ()); // 纬度 				
		schoolInfo.setTrsyrq (param.getTrsyrq ()); // 投入使用日期：YYYY-MM-DD 				
		schoolInfo.setXxb (param.getXxb ()); // 学校办别：教育部门和集体办；企业办；等 		
		schoolInfoService.update(schoolInfo);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

}

