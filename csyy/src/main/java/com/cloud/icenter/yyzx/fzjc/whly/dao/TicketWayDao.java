package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketWay;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:39:29
*/
public interface TicketWayDao extends BaseDao<TicketWay> {
	public List<TicketWay> getYkl();
}