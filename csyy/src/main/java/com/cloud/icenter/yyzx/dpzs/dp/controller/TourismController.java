package com.cloud.icenter.yyzx.dpzs.dp.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.common.query.Industry;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.IndustryIncome;
import com.cloud.icenter.yyzx.dpzs.lz.service.IndustryIncomeService;
import com.cloud.icenter.yyzx.dpzs.lz.service.TicketDayService;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingBasic;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.service.HolidayTouristService;
import com.cloud.icenter.yyzx.fzjc.whly.service.TouristSourceService;

@Controller
@RequestMapping(value="/big_whly")
public class TourismController extends BaseAction{
	@Autowired private TouristSourceService touristSourceService;
	@Autowired private IndustryIncomeService industryIncomeService;
	@Autowired private TicketDayService ticketDayService;
	@Autowired private HolidayTouristService holidayTouristService;
	@RequestMapping(value="/whly",method=RequestMethod.GET)
	public String getTourism(){
		List<Map<String,Object>> resultList=touristSourceService.getAll();
		List<Industry> industryIncomeList=industryIncomeService.getIndustryIncome();
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		List<Tourism> year2016=ticketDayService.getOneYearTicket(curYear);
		List<HolidayTourist> holidayList=holidayTouristService.getYkl();
		setAttribute("holidayJson",JsonUtil.toJson(holidayList));
		setAttribute("resultListJson",JsonUtil.toJson(resultList));		
		setAttribute("resultList",resultList);
		setAttribute("incomeList",industryIncomeList);
		setAttribute("jdl",year2016); 
		return "dpzs/dp/whly";
	}
}
