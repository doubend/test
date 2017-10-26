package com.cloud.icenter.yyzx.dpzs.lz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketDay;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketNow;
import com.cloud.icenter.yyzx.dpzs.lz.service.SourceDayService;
import com.cloud.icenter.yyzx.dpzs.lz.service.TicketDayService;
import com.cloud.icenter.yyzx.dpzs.lz.service.TicketNowService;


@Controller
@RequestMapping(value="/lz_whly")
public class TourismAction extends BaseAction{
	
	@Autowired private TicketNowService hourService;
	@Autowired private TicketDayService dayService;
	@Autowired private SourceDayService sourceDayService;
	@RequestMapping(value="/whly",method=RequestMethod.GET)
	public String getLzLy(){
		
		List<Tourism> hourList=hourService.getHourTicket();
		setAttribute("hourList",hourList);	
		
		List<Tourism> dayList=dayService.getDayTicket();
		setAttribute("dayList",dayList);
		
		List<Tourism> yearList=dayService.getYearTicket();
		setAttribute("yearList",yearList);
		
		List<Tourism> sourceDayList=sourceDayService.getDaySource();
		setAttribute("sourceDayList",sourceDayList);
		
		return "/dpzs/lz/ly";
	}
}
