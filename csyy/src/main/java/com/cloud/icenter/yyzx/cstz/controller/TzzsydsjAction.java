
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
import com.cloud.icenter.yyzx.cstz.service.TzzsydsjService;
import com.cloud.icenter.yyzx.cstz.pojo.Tzzsydsj;


/**
* Created with gender.
* @author: whcai
* Date: 2017-03-27 17:20:02
*/
@Controller
@RequestMapping(value="/cstz/tzzsydsj")
public class TzzsydsjAction extends ModelAction<Tzzsydsj>  {

	@Autowired private TzzsydsjService tzzsydsjService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "tzzsydsj/tzzsydsj-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "tzzsydsj/tzzsydsj-query";
    }
    
   @RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "tzzsydsj/tzzsydsj-add";
	}
    
    /**
 	 * 查询
 	 */
     @RequestMapping(value="/query",method=RequestMethod.POST)
 	public void query(Tzzsydsj param) {
 		tzzsydsjService.find(getPagination());
 		printJson(getPagination());
 	}
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody Tzzsydsj tzzsydsj) {
		try {
		//tzzsydsj.setCreateDate(new Date());
		//tzzsydsj.setCreateUserId(getLoginUser().getUserId());
		tzzsydsjService.add(tzzsydsj);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		Tzzsydsj tzzsydsj=tzzsydsjService.get(id);
		setAttribute("tzzsydsj", tzzsydsj);
		return "tzzsydsj/tzzsydsj-update";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		try {
		tzzsydsjService.delete(id);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody Tzzsydsj param) {
		try {
		//param.setEditDate(new Date());
		//param.setEditUserId(getLoginUser().getUserId());
		Tzzsydsj tzzsydsj=tzzsydsjService.get(id);
						
		tzzsydsj.setTzId(param.getTzId()); // 体征ID 				
		tzzsydsj.setNf (param.getNf ()); // 年份 				
		tzzsydsj.setYf (param.getYf ()); // 月份 				
		tzzsydsj.setTzz (param.getTzz ()); // 体征值：0.0-10.0 				
		tzzsydsj.setTzzk (param.getTzzk ()); // 体征状况：优、良、中、差 				
		tzzsydsj.setCreateTime (param.getCreateTime ()); // 创建时间 				
		tzzsydsj.setUpdateTime (param.getUpdateTime ()); // 更新时间 				
		tzzsydsj.setDeleteTime (param.getDeleteTime ()); // 删除时间 				
		tzzsydsj.setDeleteStatus (param.getDeleteStatus ()); // 删除状态：0正常，1删除 				
		tzzsydsj.setCreator (param.getCreator ()); // 创建者 		
		tzzsydsjService.update(tzzsydsj);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

}

