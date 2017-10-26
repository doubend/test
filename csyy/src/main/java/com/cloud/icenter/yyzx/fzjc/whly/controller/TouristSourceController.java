package com.cloud.icenter.yyzx.fzjc.whly.controller;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TouristSource;
import com.cloud.icenter.yyzx.fzjc.whly.service.TouristSourceService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-14 15:34:32
*/
@Controller
@RequestMapping(value="/whly")
public class TouristSourceController extends ModelAction<TouristSource>  {

@Autowired private TouristSourceService touristSourceService;
/*
 * 游客特征
 */
	@RequestMapping(value="/yktz",method=RequestMethod.GET)
	public String list() {		
		List<Map<String,Object>> resultList=touristSourceService.getAll();
		setAttribute("resultList",resultList);
		return "fzjc/whly/tourismFeatures";
	}
	/*
	 * 游客特征——总游客量
	 */
	@RequestMapping(value="/getZykl",method=RequestMethod.POST)	
	public void getZykl(){
		String resultList=JsonUtil.toJson(touristSourceService.getZykl());
		printJson(resultList);
	}
   
}

