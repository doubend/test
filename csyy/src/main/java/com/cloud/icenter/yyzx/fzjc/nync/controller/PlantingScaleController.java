
package com.cloud.icenter.yyzx.fzjc.nync.controller;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirPollution;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingScale;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingScaleService;


/**
* @author: yaoli
* 农业农村——种植规模信息
* Date: 2017-03-02 18:18:32
*/
@Controller
@RequestMapping(value="/plantscale")
public class PlantingScaleController extends ModelAction<PlantingScale>  {

@Autowired private PlantingScaleService plantScaleService;

@RequestMapping(value="/queryZzgm",method=RequestMethod.POST)
public void queryZzgm(int year){
	try{
	DetachedCriteria criteria=getPagination().getCriteria();
	getPagination().setPage(0);
	getPagination().setPageSize(0);
	if(year>0){
		criteria.add(Restrictions.eq("year",year));
	}		
	plantScaleService.find(getPagination());
	String json=JsonUtil.toJson(getPagination().getDataList());
	printJson(json);	
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

}

