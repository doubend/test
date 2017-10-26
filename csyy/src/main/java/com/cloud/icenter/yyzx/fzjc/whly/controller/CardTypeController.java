
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
import com.cloud.icenter.yyzx.fzjc.whly.pojo.CardType;
import com.cloud.icenter.yyzx.fzjc.whly.service.CardTypeService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:51:08
*/
@Controller
@RequestMapping(value="/cardtype")
public class CardTypeController extends ModelAction<CardType>  {
/*
 * 游客特征——证件类型
 */
@Autowired private CardTypeService cardTypeService;
	
	@RequestMapping(value="/getCardType",method=RequestMethod.POST)
	public void getCardType(){
		String result=JsonUtil.toJson(cardTypeService.getCardType());
		printJson(result);
	}
}

