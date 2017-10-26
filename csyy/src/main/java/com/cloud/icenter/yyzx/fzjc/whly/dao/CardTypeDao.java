package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.CardType;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:51:08
*/
public interface CardTypeDao extends BaseDao<CardType> {
	public List<CardType> getCardType();
}