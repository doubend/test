package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketType;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:40:50
*/
public interface TicketTypeDao extends BaseDao<TicketType> {
	public List<TicketType> getYkl();
}