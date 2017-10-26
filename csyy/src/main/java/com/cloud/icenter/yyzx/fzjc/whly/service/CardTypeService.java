package com.cloud.icenter.yyzx.fzjc.whly.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.CardType;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:51:08
*/
public interface CardTypeService extends BaseService<CardType> {
	public List<CardType> getCardType();
}