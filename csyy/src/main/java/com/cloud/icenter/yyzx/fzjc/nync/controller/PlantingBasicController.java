
package com.cloud.icenter.yyzx.fzjc.nync.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.PrimaryIndustry;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingBasic;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingSpecies;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingBasicService;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingSpeciesService;


/**
* @author: yaoli
* 农业农村——种植业基本信息
* Date: 2017-03-02 18:32:09
*/
@Controller
@RequestMapping(value="/plantingbasic")
public class PlantingBasicController extends ModelAction<PlantingBasic>  {

@Autowired private PlantingBasicService plantingBasicService;
@Autowired private PlantingSpeciesService plantingSpeciesService;
/*
 *根据类别获取产量产值
 *蔬菜，水果
 */
@RequestMapping(value="/top5",method=RequestMethod.POST)
public void queryTwoTypes(int cate1,int cate2){
	try{		
		DetachedCriteria criteria=getPagination().getCriteria();
		getPagination().setPage(1);
		getPagination().setPageSize(10);
		Disjunction dis=Restrictions.disjunction();  
		dis.add(Restrictions.eq("category", cate1));
		dis.add(Restrictions.eq("category", cate2));
		criteria.add(dis); 
		
		criteria.addOrder(Order.asc("category"));
		criteria.addOrder(Order.asc("year"));
		plantingBasicService.find(getPagination());
		String json=JsonUtil.toJson(getPagination().getDataList());
		printJson(json);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
/*
 * 近5年蔬菜、水果、药材
 * 面积、单价
 */
@RequestMapping(value="/top15",method=RequestMethod.POST)
public void queryThreeTypes(int cate1,int cate2,int cate3){
	try{		
		DetachedCriteria criteria=getPagination().getCriteria();
		getPagination().setPage(1);
		getPagination().setPageSize(15);
		Disjunction dis=Restrictions.disjunction();
		dis.add(Restrictions.eq("category", cate1));
		dis.add(Restrictions.eq("category", cate2));
		dis.add(Restrictions.eq("category", cate3));
		criteria.add(dis);
		criteria.addOrder(Order.asc("category"));
		criteria.addOrder(Order.asc("year"));
		plantingBasicService.find(getPagination());
		String json=JsonUtil.toJson(getPagination().getDataList());
		printJson(json);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
/*
 * 查询当年各类别面积产量产值
 */
@RequestMapping(value="/gk",method=RequestMethod.POST)
public void queryAllTypes(int year){
	try{		
		DetachedCriteria criteria=getPagination().getCriteria();
		getPagination().setPage(1);
		getPagination().setPageSize(5);
		
		criteria.add(Restrictions.eq("year", year));
		criteria.addOrder(Order.asc("category"));
		plantingBasicService.find(getPagination());
		String json=JsonUtil.toJson(getPagination().getDataList());
		printJson(json);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
/*
 *总的指标值
 *粮食：面积、产量、产值
 *经济作物：面积、产量、产值
 */
/**
 * 辅助决策—农业农村——种植业发展概况
 * @return
 */
@RequestMapping(value="/zzy",method=RequestMethod.GET)
public String zzyInfo() {
	     List<PlantingBasic> cropList=plantingBasicService.getCropsValues();		
		 int sumArea=0;
		 float sumOutput=0;
		 int sumYeild=0;
		 int area=0;
		 float output=0;
		 int yeild=0;
		 int flag=0;
		 for(PlantingBasic pojo:cropList){
			 if(flag==0){
				 area=pojo.getArea();
				 output=pojo.getOutput();
				 yeild=pojo.getYeild();
			 }	   			 
			sumArea+=pojo.getArea();
			sumOutput+=pojo.getOutput();
			sumYeild+=pojo.getYeild();
			flag++;
		 }
		 setAttribute("foodArea",Math.ceil(area)); 
		 setAttribute("foodOutput",Math.ceil(output)); 
		 setAttribute("foodYeild",Math.ceil(yeild)); 
		 setAttribute("ecoAreaSum",Math.ceil(sumArea-area)); 
		 setAttribute("ecoOutputSum",Math.ceil(sumOutput-output)); 
		 setAttribute("ecoYeildSum",Math.ceil(sumYeild-yeild)); 
	
	return "fzjc/nync/cropFarming";
}
@RequestMapping(value="/areaCl",method=RequestMethod.POST)
public void getAreaCl(String qy){
	List<PlantingSpecies> areaClList=plantingSpeciesService.getAreaClByName(qy);
	String json=JsonUtil.toJson(areaClList);
	printJson(json);
}
@RequestMapping(value="/area",method=RequestMethod.POST)
public void getArea(String qy){
	List<PlantingSpecies> areaClList=plantingSpeciesService.getAreaByName(qy);
	String json=JsonUtil.toJson(areaClList);
	printJson(json);
}
@RequestMapping(value="/fruit",method=RequestMethod.POST)
public void getFruit(String qy){
	List<PlantingSpecies> areaClList=plantingSpeciesService.getFruitByName(qy);
	String json=JsonUtil.toJson(areaClList);
	printJson(json);
}
}

