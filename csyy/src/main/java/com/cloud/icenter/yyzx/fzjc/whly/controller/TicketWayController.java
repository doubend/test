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
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketType;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketWay;
import com.cloud.icenter.yyzx.fzjc.whly.service.TicketWayService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:39:29
*/
@Controller
@RequestMapping(value="/whly")
public class TicketWayController extends ModelAction<TicketWay>  {

@Autowired private TicketWayService ticketWayService;
/*
 * 旅游时间分布——购票方式
 */
	@RequestMapping(value="/ticketWay",method=RequestMethod.POST)
	public void getTicketWay() {		
	  List<TicketWay> resultList=ticketWayService.getYkl();
	  String result=JsonUtil.toJson(resultList);
	  printJson(result); 
	}   
}

