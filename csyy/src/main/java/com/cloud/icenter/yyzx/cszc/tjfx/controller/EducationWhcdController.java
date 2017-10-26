package com.cloud.icenter.yyzx.cszc.tjfx.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.WhcdNCPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.WhcdPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.EducationService;
import com.cloud.icenter.yyzx.cszc.tjfx.service.impl.EducationServiceImpl;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjResult;

/**
 * 教育分析----文化程度
 * @date 2017年10月11日
 * @author dxliug
 */
@RequestMapping(value="/education")
@Controller
public class EducationWhcdController extends BaseAction {
	
	@Autowired
	private EducationService educationService;
	/**
	 * 人口教育 ----文化程度
	 * @return
	 */
	@RequestMapping(value="/whcd",method = {RequestMethod.POST, RequestMethod.GET})
	public String getWhcd(){
		
		return "/cszc/statistics/whcd";
	}
	/**
	 * 文化程度基本信息--师生情况
	 * 默认查询桓台县的数据,桓台县的数据为全县的数据
	 * @param year
	 * @return
	 */
	@RequestMapping(value="/getWhcdResult",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getWhcdResult(@RequestParam(required = false) String year){
		
		if (year == null) {
			Calendar a = Calendar.getInstance();
			year = a.get(Calendar.YEAR) + "";
		}
		List<WhcdPojo> result = educationService.getWhcdResult(year,WhcdPojo.areas);
		return jsonResult(200, "数据获取成功", result);
	}
	/**
	 * 各行政区域受教育情况
	 * @param year
	 * @return
	 */
	@RequestMapping(value="/getWhcdArea",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getWhcdArea(@RequestParam(required = false) String year){
		
		if (year == null) {
			Calendar a = Calendar.getInstance();
			year = a.get(Calendar.YEAR) + "";
		}
		List<WhcdPojo> result = educationService.getWhcdArea(year,WhcdPojo.areas);
		return jsonResult(200, "数据获取成功", result);
	}
	/**
	 * 文化程度基本信息--教育占比
	 * 默认查询桓台县的数据,桓台县的数据为全县的数据
	 * @param year
	 * @return
	 */
	@RequestMapping(value="/getWhcdZB",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getWhcdZB(@RequestParam(required = false) String year){
		
		if (year == null) {
			Calendar a = Calendar.getInstance();
			year = a.get(Calendar.YEAR) + "";
		}
		List<WhcdPojo> result = educationService.getWhcdZB(year,WhcdPojo.areas);
		return jsonResult(200, "数据获取成功", result);
	}
	/**
	 * 文化程度基本信息--农村城镇人口文化
	 * 默认查询桓台县的数据,桓台县的数据为全县的数据
	 * @param year
	 * @return
	 */
	@RequestMapping(value="/getWhcdNC",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getWhcdNC(@RequestParam(required = false) String year){
		
		if (year == null) {
			Calendar a = Calendar.getInstance();
			year = a.get(Calendar.YEAR) + "";
		}
		List<WhcdNCPojo> result = educationService.getWhcdNC(year,WhcdPojo.areas);
		return jsonResult(200, "数据获取成功", result);
	}
}
