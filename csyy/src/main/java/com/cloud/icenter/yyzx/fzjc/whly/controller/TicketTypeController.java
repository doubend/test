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
import com.cloud.icenter.yyzx.fzjc.whly.pojo.MonthTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketType;
import com.cloud.icenter.yyzx.fzjc.whly.service.TicketTypeService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:40:50
*/
@Controller
@RequestMapping(value="/whly")
public class TicketTypeController extends ModelAction<TicketType>  {

@Autowired private TicketTypeService ticketTypeService;

/*
 * 旅游时间分布——门票类型
 */
	@RequestMapping(value="/ticketType",method=RequestMethod.POST)
	public void getTicketType() {		
	  List<TicketType> resultList=ticketTypeService.getYkl();
	  String result=JsonUtil.toJson(resultList);
	  printJson(result); 
	} 

}

