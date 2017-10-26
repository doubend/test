package com.cloud.icenter.yyzx.dpzs.lz.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.IndustryIncome;
import com.cloud.icenter.yyzx.dpzs.lz.service.IndustryIncomeService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:45:23
*/
@Controller
@RequestMapping(value="/industryincome")
public class IndustryIncomeAction extends ModelAction<IndustryIncome>  {

@Autowired private IndustryIncomeService industryIncomeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "industryincome/industryincome-list";
	}
    
   
}

