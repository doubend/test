package com.cloud.icenter.yyzx.dpzs.lz.dao;


import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketDay;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:43:34
*/
public interface TicketDayDao extends BaseDao<TicketDay> {
	public List<Tourism> getDayTicket();
	public List<Tourism> getYearTicket();
	public List<Tourism> getOneYearTicket(int year);
}