package com.cloud.icenter.yyzx.fzjc.whly.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.CardTypeDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.CardType;
import com.cloud.icenter.yyzx.fzjc.whly.service.CardTypeService;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:51:08
*/
@Logging
@Service
public class CardTypeServiceImp extends BaseServiceImpl<CardType>  implements CardTypeService{
	@Autowired
	private CardTypeDao cardDao;
	public List<CardType> getCardType(){
		return cardDao.getCardType();
	}
}