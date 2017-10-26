package com.cloud.icenter.yyzx.cszc.tjfx.controller;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.BaseInfo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.BaseInfoService;


/**
* Created with gender.
* @author: liyao
* Date: 2017-04-23 17:57:20
*/
@Controller
@RequestMapping(value="/streetlight")
public class BaseInfoAction extends ModelAction<BaseInfo>  {

@Autowired private BaseInfoService baseInfoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		List<String> yearList=baseInfoService.getYears();
		List<CategorySum>  yearOneList=baseInfoService.getRegionCount(yearList.get(0));
		List<CategorySum>  yearTwoList=baseInfoService.getRegionCount(yearList.get(1));
		List<CategorySum>  yearthreeList=baseInfoService.getRegionCount(yearList.get(2));
		List<CategorySum>  yearFourList=baseInfoService.getRegionCount(yearList.get(3));
		List<CategorySum>  yearFiveList=baseInfoService.getRegionCount(yearList.get(4));
		List<CategorySum>  reasonList=baseInfoService.getRepairTimeByReason();
		List<CategorySum>  regionList=baseInfoService.getRepairTimeByRegion();
		List<CategorySum>  getYearCount=baseInfoService.getYearCount("07");
		setAttribute("yearList",yearList);
		setAttribute("year1",JsonUtil.toJson(yearOneList));
		setAttribute("year2",JsonUtil.toJson(yearTwoList));
		setAttribute("year3",JsonUtil.toJson(yearthreeList));
		setAttribute("year4",JsonUtil.toJson(yearFourList));
		setAttribute("year5",JsonUtil.toJson(yearFiveList));
		setAttribute("reasonList",JsonUtil.toJson(reasonList));
		setAttribute("regionList",JsonUtil.toJson(regionList));
		setAttribute("getYearCount",JsonUtil.toJson(getYearCount));
				
		return "cszc/statistics/streetLight";
	}
	/**
	 * 根据类型获取不同年份各类型部件的坐标
	 * @param ejflbh二级分类编号
	 */
	@RequestMapping(value="/getXYdata",method=RequestMethod.POST)
	public void getXYdata(String ejflbh) { 
		JSONObject  nfDataList=baseInfoService.getAllData(ejflbh);
		String json=JsonUtil.toJson(nfDataList);
    	printJson(json);
    }	
	/*
	 * 不同类型部件
	 * 各年份数量统计
	 */
	@RequestMapping(value="/getYeardata",method=RequestMethod.POST)
	public void getYearCount(String ejflbh) { 
		List<CategorySum>  nfDataList=baseInfoService.getYearCount(ejflbh);
		String json=JsonUtil.toJson(nfDataList);
		printJson(json);
    }
}

