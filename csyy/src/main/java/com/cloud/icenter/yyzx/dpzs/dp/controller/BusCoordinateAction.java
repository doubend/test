package com.cloud.icenter.yyzx.dpzs.dp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.BusCoordinate;
import com.cloud.icenter.yyzx.dpzs.dp.service.BusCoordinateService;


/**
* Created with gender.
* @author: liyao
* Date: 2017-05-27 10:59:02
*/
@Controller
@RequestMapping(value="/locate")
public class BusCoordinateAction extends ModelAction<BusCoordinate>  {

@Autowired private BusCoordinateService busCoordinateService;	
	
	@RequestMapping(value="/bus")
	public void getBusCoordinates() { 
		JSONObject nfDataList=busCoordinateService.getBusCoordinates();
		String json=JsonUtil.toJson(nfDataList);
    	printJson(json);
    }	
	@RequestMapping(value="/taxi")
	public void getTaxiCoordinates() { 
		JSONObject  nfDataList=busCoordinateService.getTaxiCoordinates();
		String json=JsonUtil.toJson(nfDataList);
    	printJson(json);
    }	
	/*
	 * 根据公交线路名称，运营方向，查询该线路所有站点信息
	 */
	@RequestMapping(value="/stations")
	public void getBusStations(String linename,String dir){
		JSONObject bustations=busCoordinateService.getBusStations(linename, dir);
		String json=JsonUtil.toJson(bustations);
		printJson(json);
	}
	@RequestMapping(value="/lines")
	public void getBusLines(){
		JSONObject buslines=busCoordinateService.getBusLines();
		String json=JsonUtil.toJson(buslines);
		printJson(json);
	}
	@RequestMapping(value="/onlineBus")
	public void getOnlineBus(String linename,String dir){
		JSONObject onlineBus=busCoordinateService.queryBusByLine(linename, dir);
		String json=JsonUtil.toJson(onlineBus);
		printJson(json);
	}
	@RequestMapping(value="/lineStartEnd")
	public void lineStartEnd(){
		JSONObject lineStartEnd=busCoordinateService.lineStartEnd();
		String json=JsonUtil.toJson(lineStartEnd);
		printJson(json);
	}

}

