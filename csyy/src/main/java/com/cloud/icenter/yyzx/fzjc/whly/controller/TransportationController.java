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
import com.cloud.icenter.yyzx.fzjc.whly.pojo.Transportation;
import com.cloud.icenter.yyzx.fzjc.whly.service.TransportationService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:42:49
*/
@Controller
@RequestMapping(value="/transportation")
public class TransportationController extends ModelAction<Transportation>  {

@Autowired private TransportationService transportationService;
/*
 * 游客特征——交通方式
 */
	@RequestMapping(value="/getTrans",method=RequestMethod.POST)
	public void getTrans(){
		String result=JsonUtil.toJson(transportationService.getTrans());
		printJson(result);
	}
    
  
}

