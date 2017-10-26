package com.cloud.icenter.yyzx.fzjc.rk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Eduincome;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Jobdistribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migrant;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migration;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Outflowsource;
import com.cloud.icenter.yyzx.fzjc.rk.service.PmigrantService;
/**
 * 人口流动
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/fzjc/migrant")
public class PmigrantController extends BaseAction{
	
	@Autowired
	private PmigrantService pmigrantService;
	
	/**
	 * 全市流动人口变化
	 * @return
	 */
	@RequestMapping(value = "/getMigrantList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getMigrantList(){
		List<Migrant> mlist = pmigrantService.getMigrantList();
		return jsonResult(200, "数据获取成功", mlist);
	}
	
	/**
	 * 流出人口学历及收入（元）
	 * @return
	 */
	@RequestMapping(value = "/getEduincomeList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getEduincomeList(){
		List<Eduincome> elist = pmigrantService.getEduincomeList();
		return jsonResult(200, "数据获取成功", elist);
	}
	
	/**
	 * 流出(入)人口职业分布(单位：万人)
	 * @param type 1流出人口，2流入人口
	 * @return json
	 */
	@RequestMapping(value = "/getJobdistributionByType", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getJobdistributionByType(@RequestParam String type){
		List<Jobdistribution> jlist = pmigrantService.getJobdistributionByType(type);
		return jsonResult(200, "数据获取成功", jlist);
	}
	
	
	/**
	 * 流出人口来源分布
	 * @param year 年份
	 * @return json
	 */
	@RequestMapping(value = "/getOutflowsourceListByYear", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getOutflowsourceListByYear(@RequestParam(required=false) String year){
		List<Outflowsource> jlist = pmigrantService.getOutflowsourceListByYear(year);
		return jsonResult(200, "数据获取成功", jlist);
	}
	
	
	/**
	 * 人口流动图
	 * @return json
	 */
	@RequestMapping(value = "/getMigrationList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getMigrationList(){
		List<Migration> jlist = pmigrantService.getMigrationList();
		return jsonResult(200, "数据获取成功", jlist);
	}
	
	
	/**
	 * 获取地图数据
	 * type 1 流出  0流入
	 * @return
	 */
	@RequestMapping(value = "/getDtsj", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getDtsj(String type){
		List<Migration> jlist = pmigrantService.getDtsj(type);
		return jsonResult(200, "数据获取成功", jlist);
	}

}
