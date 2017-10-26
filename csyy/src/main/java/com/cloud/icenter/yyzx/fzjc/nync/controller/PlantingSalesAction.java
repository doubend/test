
package com.cloud.icenter.yyzx.fzjc.nync.controller;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingSales;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingSalesService;


/**
* @author: yaoli
* 农业农村——种植业销量信息
* Date: 2017-03-02 18:33:16
*/
@Controller
@RequestMapping(value="/plantingsales")
public class PlantingSalesAction extends ModelAction<PlantingSales>  {

@Autowired private PlantingSalesService plantingSalesService;
@RequestMapping(value="/queryXsqd",method=RequestMethod.POST)
public void queryZzgm(int year){
	try{
	DetachedCriteria criteria=getPagination().getCriteria();
	getPagination().setPage(0);
	getPagination().setPageSize(0);
	if(year>0){
		criteria.add(Restrictions.eq("year",year));
	}		
	plantingSalesService.find(getPagination());
	String json=JsonUtil.toJson(getPagination().getDataList());
	printJson(json);	
	}
	catch(Exception e){
		e.printStackTrace();
	}
}	

}

