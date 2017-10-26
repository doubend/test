
package com.cloud.icenter.yyzx.fzjc.nync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingDistributionService;
import com.cloud.icenter.yyzx.fzjc.nync.service.SpecialProductService;


/**
* @author: yaoli
* 农业农村——特色农产品信息
* Date: 2017-03-02 18:32:42
*/
@Controller
@RequestMapping(value="/specialproduct")
public class SpecialProductController extends ModelAction<SpecialProduct>  {

@Autowired private SpecialProductService specialProductService;
@Autowired private PlantingDistributionService plantingDistributionService;  
     /**
 	 * 查询2016年度特色农产品概况信息
 	 */
     @RequestMapping(value="/getSummary",method=RequestMethod.POST)
 	public void getSummary() {
    	 try{
    		 List<SpecialProduct> specialList=specialProductService.getSpecialSummary(); 		
    		 String json=JsonUtil.toJson(specialList);
    	 	 printJson(json);
    	 }
    	 catch(Exception e){
    		 e.printStackTrace();
    	 }    	
 	}
     /**
  	 * 查询特色农产品历年政策投资资金
  	 */
      @RequestMapping(value="/getInvestment",method=RequestMethod.POST)
	 public void getSpecialInvestment(int specialType){
    	  try{
     		 List<SpecialProduct> specialTypeList=specialProductService.getSpecialInvestment(specialType); 		
     		 String json=JsonUtil.toJson(specialTypeList);
     	 	 printJson(json);
     	 }
     	 catch(Exception e){
     		 e.printStackTrace();
     	 }
    	
	 }
      /**
  	 * 辅助决策——农业农村——特色农产品 
  	 */
  	@RequestMapping(value="/tsncp",method=RequestMethod.GET)
  	public String ncpInfo(){  		
	  	try{
	   		 List<SpecialProduct> specialList=specialProductService.getSpecialSummary(); 
	   	 	 setAttribute("result",specialList);
	   	 	 return "fzjc/nync/agriProduct";
	   	 }
	   	 catch(Exception e){
	   		 e.printStackTrace();
	   	 }
	  		return null;
  	}
  	  
    @RequestMapping(value="/distribution",method=RequestMethod.POST)
 	public void query() {
 		String json=JsonUtil.toJson(plantingDistributionService.getDistribution());
 		printJson(json);
 	}
       
}

