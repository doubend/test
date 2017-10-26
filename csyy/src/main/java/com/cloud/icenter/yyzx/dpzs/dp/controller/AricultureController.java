package com.cloud.icenter.yyzx.dpzs.dp.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.common.query.AnimalClCl;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.PrimaryIndustry;
import com.cloud.icenter.yyzx.dpzs.dp.service.PrimaryIndustryService;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingBasic;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;
import com.cloud.icenter.yyzx.fzjc.nync.service.AnimalHusbandryService;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingBasicService;
import com.cloud.icenter.yyzx.fzjc.nync.service.SpecialProductService;


@Controller
@RequestMapping(value="/big_nync")
public class AricultureController extends BaseAction{
	
	@Autowired private SpecialProductService specialProductService;
	@Autowired private AnimalHusbandryService animalHusbandryService;
	@Autowired private PlantingBasicService plantingBasicService;
	@Autowired private PrimaryIndustryService primaryIndustryService;
	/*
	 * 侧屏首页
	 */
	@RequestMapping(value="/cp_index",method=RequestMethod.GET)
	public String showCpIndex(){
		return "/dpzs/dp/cp_index";
	}
	/*
	 * 大屏首页
	 */
	@RequestMapping(value="/led_index",method=RequestMethod.GET)
	public String showDpIndex(){
		return "/dpzs/dp/led_index";
	}
	/*
	 * 侧屏导航页面
	 */
	@RequestMapping(value="/cp_navigation",method=RequestMethod.GET)
	public String showCpNavigation(){
		return "/dpzs/dp/cp_navigation";
	}
	/*
	 * 大屏导航页面
	 */
	@RequestMapping(value="/dp_navigation",method=RequestMethod.GET)
	public String showLedNavigation(){
		return "/dpzs/dp/led_navigation";
	}
	/*
	 * 农业农村大屏页面
	 */
	@RequestMapping(value="/nync",method=RequestMethod.GET)
	public String getBifNync(){
		try{
	   		 List<SpecialProduct> specialList=specialProductService.getSpecialSummary(); 
	   	 	 setAttribute("result",specialList);
	   	 	 List<BigDecimal> dpzblist=animalHusbandryService.getDpzbList();	   	 	 
	   	 	 BigDecimal animalCll,animalCz,poultryCll,poultryCz;
	         animalCll=dpzblist.get(1);
	         animalCz=dpzblist.get(0);
	         poultryCll=dpzblist.get(3);
	         poultryCz=dpzblist.get(2);
	        
	   	     setAttribute("animalCll",formatValue(animalCll)); 
	   	     setAttribute("animalCz",formatValue(animalCz)); 
	   	     setAttribute("poultryCll",formatValue(poultryCll)); 
	   	     setAttribute("poultryCz",formatValue(poultryCz));
	   		 List<PlantingBasic> cropList=plantingBasicService.getCropsValues();
	   		
	   		 List<PrimaryIndustry> primaryIndustryList=primaryIndustryService.getPrimaryIndustry();
	   		
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
	   		
	   		
	   		 setAttribute("primaryIndustryList",primaryIndustryList);
	   	 	 return "/dpzs/dp/nync";
	   	 }
	   	 catch(Exception e){
	   		 e.printStackTrace();
	   	 }
	  		return null;
		
	}	
	public String formatValue(BigDecimal data){
		DecimalFormat   df   =new   DecimalFormat("#.0");  
		return df.format(data);
	}
}
