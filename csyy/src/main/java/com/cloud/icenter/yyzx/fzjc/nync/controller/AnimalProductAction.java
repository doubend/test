
package com.cloud.icenter.yyzx.fzjc.nync.controller;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalProduct;
import com.cloud.icenter.yyzx.fzjc.nync.service.AnimalProductService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:41
*/
@Controller
@RequestMapping(value="/animalproduct")
public class AnimalProductAction extends ModelAction<AnimalProduct>  {

@Autowired private AnimalProductService animalProductService;
/*
 * 根据类别获取最近一个年度的畜牧产品价格数据
 * lb[1:猪肉；2：牛肉；3：羊肉；4：鸡蛋；]
 */
@RequestMapping(value="/getHistoryPrice",method=RequestMethod.POST)
public void getHistoryStock(int lb){	
	String json=JsonUtil.toJson(animalProductService.getHistoryPrice(lb));
	printJson(json);
}
	
}

