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
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketWay;
import com.cloud.icenter.yyzx.fzjc.whly.service.HolidayTouristService;
import com.cloud.icenter.yyzx.fzjc.whly.service.TicketWayService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:40:00
*/
@Controller
@RequestMapping(value="/whly")
public class HolidayTouristController extends ModelAction<HolidayTourist>  {

@Autowired private HolidayTouristService holidayTouristService;
@Autowired private TicketWayService ticketWayService;	
/**
 * 文化旅游——旅游时间分析 
 */
@RequestMapping(value="/lysj",method=RequestMethod.GET)
public String tourismTime(){
	List<HolidayTourist> holidayList=holidayTouristService.getYkl();
	List<TicketWay> ticketWayList=ticketWayService.getYkl();
	setAttribute("holidayList",holidayList);
	setAttribute("holidayJson",JsonUtil.toJson(holidayList));
	setAttribute("ticketWayList",ticketWayList);
	return "fzjc/whly/tourismTime";
}
}

