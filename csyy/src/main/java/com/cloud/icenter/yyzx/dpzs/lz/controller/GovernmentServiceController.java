package com.cloud.icenter.yyzx.dpzs.lz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovServiceCount;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovernmentService;
import com.cloud.icenter.yyzx.dpzs.lz.service.GovernmentServiceService;
import com.cloud.icenter.yyzx.dpzs.lz.service.IGovServiceCountService;
import com.cloud.icenter.yyzx.dpzs.lz.service.ServiceCategoryService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
@Controller
@RequestMapping(value="/lz_zwfw")
public class GovernmentServiceController extends ModelAction<GovernmentService>  {

@Autowired private GovernmentServiceService governmentService;

@Autowired
private IGovServiceCountService govServiceCountService;

@Autowired private ServiceCategoryService categoryService;
/*
 * 政务服务
 */
    @RequestMapping(value="/zwfw",method=RequestMethod.GET)
	public String getZwfw() {
    	// 注释代码勿删，由于爬虫数据是统计数据，因此做了修改，后面可能会改回去
    	/*
    	List<Tourism> dayEvent=governmentService.getDayData();
    	setAttribute("dayEvent",dayEvent);
    	List<Tourism> monthEvent=governmentService.getMonthData();
    	setAttribute("monthEvent",monthEvent);
    	List<Tourism> yearEvent=governmentService.getYearData();
    	setAttribute("yearEvent",yearEvent);
    	*/
    	GovServiceCount dayEvent=govServiceCountService.getCurrDayData();
    	setAttribute("event",dayEvent);
    	List<Tourism> xzspEvent=categoryService.getEventCount();
    	setAttribute("xzspEvent",xzspEvent);
    	List<Tourism> onlineEvent=categoryService.getOnlineCount();
    	setAttribute("onlineEvent",onlineEvent);
		// return "/dpzs/lz/zw";
		return "/dpzs/lz/zw_xzsp";
	}  
    
    @RequestMapping(value="/getData",method=RequestMethod.POST)
	public void getAllData() { 
    	//事项数及子项数
    	JSONObject jsonobj= categoryService.getAllData();
    	printJson(jsonobj);
    }

}

