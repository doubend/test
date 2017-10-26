package com.cloud.icenter.yyzx.ztfx.jjyx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Economy;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Equipment;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Industrytotal;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Situation;
import com.cloud.icenter.yyzx.ztfx.jjyx.service.EconomyService;

/**
 * 工业经济总体表
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/ztfx/jjyx")
public class EconomyController extends ModelAction<Economy>{
	
	@Autowired
	private EconomyService economyService;
	
	
	@RequestMapping(value="/toIndustryEconomic",method=RequestMethod.GET)
	public String toIndustryEconomic(){
		return "ztfx/jjyx/industryEconomic";
	}
	
	/**
	 * 工业经济总体数据
	 * @return
	 */
	@RequestMapping(value = "/getEconomyLizt", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getEconomyLizt(){
		List<Economy> elist = economyService.getEconomyLizt();
		return jsonResult(200, "数据获取成功", elist);
	}
	
	
	/**
	 *  7大行业工业总产值 （单位：亿元）
	 * @return
	 */
	@RequestMapping(value = "/getIndustrytotalListByYear", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getIndustrytotalListByYear(){
		String year = "2016";  //暂时写死，后面谁接手谁弄
		List<Industrytotal> elist = economyService.getIndustrytotalListByYear(year);
		return jsonResult(200, "数据获取成功", elist);
		
	}
	
	
	/**
	 * 重点装备制造企业主营收入情况 （单位：亿元）
	 * @return
	 */
	@RequestMapping(value = "/getEquipmentListByYear", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getEquipmentListByYear(){
		String year = "2016";  //暂时写死，后面谁接手谁弄
		List<Equipment> elist = economyService.getEquipmentListByYear(year);
		return jsonResult(200, "数据获取成功", elist);
	}
	
	
	/**
	 * 工业经济概况
	 * @return
	 */
	@RequestMapping(value = "/getMaxSituation", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getMaxSituation(){
		Situation situation = economyService.getMaxSituation();
		return jsonResult(200, "数据获取成功", situation);
	}
	
	

}
