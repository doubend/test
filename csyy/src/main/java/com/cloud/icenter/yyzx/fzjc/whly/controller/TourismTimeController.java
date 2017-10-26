package com.cloud.icenter.yyzx.fzjc.whly.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TourismTime;
import com.cloud.icenter.yyzx.fzjc.whly.service.TourismTimeService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:07
*/
@Controller
@RequestMapping(value="/whly")
public class TourismTimeController extends ModelAction<TourismTime>  {

@Autowired private TourismTimeService tourismTimeService;
/*
 * 旅游时间分布——游客当天入园出园情况
 */
	@RequestMapping(value="/time",method=RequestMethod.POST)
	public void getTouristTime() {		
	  List<TourismTime> resultList=tourismTimeService.getYkl();
	  String result=JsonUtil.toJson(resultList);
	  printJson(result); 
	}  
}

