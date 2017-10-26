package com.cloud.icenter.yyzx.dpzs.slp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.service.TicketDayService;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketWay;
import com.cloud.icenter.yyzx.fzjc.whly.service.HolidayTouristService;
import com.cloud.icenter.yyzx.fzjc.whly.service.TouristSourceService;

@Controller
@RequestMapping(value="/slp_whly")
public class TourismSlpController extends BaseAction{

	@Autowired private TicketDayService ticketDayService;
	@Autowired private TouristSourceService touristSourceService;
	@Autowired private HolidayTouristService holidayTouristService;
	
	@RequestMapping(value="/whly",method=RequestMethod.GET)
	public String getSlpLy(){
		List<Tourism> year2016=ticketDayService.getOneYearTicket(2017);
		setAttribute("jdl",year2016); 
		List<Map<String,Object>> resultList=touristSourceService.getAll();
		setAttribute("resultList",resultList);
		List<HolidayTourist> holidayList=holidayTouristService.getYkl();		
		setAttribute("holidayList",holidayList);
		setAttribute("holidayJson",JsonUtil.toJson(holidayList));
		return "/dpzs/slp/whly";
	}
}
