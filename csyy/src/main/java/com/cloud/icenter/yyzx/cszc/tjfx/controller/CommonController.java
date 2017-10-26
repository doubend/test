
package com.cloud.icenter.yyzx.cszc.tjfx.controller;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.RepairInfo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.RepairInfoService;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TourismTime;


/**
* Created with gender.
* @author: liyao
* Date: 2017-04-19 14:27:14
*/
@Controller
@RequestMapping(value="/cszc")
public class CommonController extends ModelAction<RepairInfo>  {


	/*
	 *城市资产概况
	 */	
    @RequestMapping(value="/zcgk",method=RequestMethod.GET)
	public String zcgk() {	
    	return "cszc/statistics/facilitiesOverview";
    }
    /*
	 *基础设施发展
	 */	
   @RequestMapping(value="/jcssfz",method=RequestMethod.GET)
	public String jcssfz() {	
   	return "cszc/statistics/facilitiesDevelop";
   }   
}
    
