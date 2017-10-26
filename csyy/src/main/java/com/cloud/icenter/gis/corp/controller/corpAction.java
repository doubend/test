package com.cloud.icenter.gis.corp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.gis.corp.service.CorpService;
import com.cloud.icenter.system.user.pojo.User;




@RequestMapping(value="/gis")
@Controller
public class corpAction{

private static final long serialVersionUID = 1L;
	
	
	// @Autowired private CorpService corpService;
	@RequestMapping(value = "/test")	
	public void zfrDjzx() {
		//this.getView().setViewName("gis/zfrDjzx");
		//Map<String,Object> result = corpService.corpRegistNumber();
		//setAttribute("result", result);
		//return "system/user/user-update";
		
	}
}
