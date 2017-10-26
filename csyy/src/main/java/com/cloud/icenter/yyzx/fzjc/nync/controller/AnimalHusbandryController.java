
package com.cloud.icenter.yyzx.fzjc.nync.controller;
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
import com.cloud.icenter.yyzx.common.query.AnimalClCl;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalHusbandry;
import com.cloud.icenter.yyzx.fzjc.nync.service.AnimalHusbandryService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:25
*/
@Controller
@RequestMapping(value="/animalhusbandry")
public class AnimalHusbandryController extends ModelAction<AnimalHusbandry>  {

@Autowired private AnimalHusbandryService animalHusbandryService;
/*
 * 最近一个年度猪牛羊马出栏量及产值
 */
@RequestMapping(value="/getCurrentSum",method=RequestMethod.POST)
public void getCurrentSum(){	
	String json=JsonUtil.toJson(animalHusbandryService.getCurrentSum());
	printJson(json);
}
/*
 * 根据类别获取最近一个年度的存栏量出栏量数据
 * lb[1:猪；2：牛；3：羊；4：马；5：鸡；6：鸭；]
 */
@RequestMapping(value="/getHistoryStock",method=RequestMethod.POST)
public void getHistoryStock(int lb){	
	String json=JsonUtil.toJson(animalHusbandryService.getHistoryStock(lb));
	printJson(json);
}
/*
 * 获取近五年牲畜总的出栏量、存栏量、出栏率
 */
@RequestMapping(value="/getHistoryList",method=RequestMethod.POST)
public void getHistoryList(){
	String json=JsonUtil.toJson(animalHusbandryService.getHistoryList());
	printJson(json);
}
/*
 * 获取当前一个年度总的出栏量、产值；
 * 牲畜总出栏量、产值
 * 家禽总出栏量、产值
 */
@RequestMapping(value="/xmy",method=RequestMethod.GET)
public String getCurrentList(){
	List<AnimalClCl> list=animalHusbandryService.getCurrentList();
	setAttribute("currentList",list);
	return "fzjc/nync/animalHusbandry";
}
}

