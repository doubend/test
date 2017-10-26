package com.cloud.icenter.yyzx.dpzs.lz.dao;


import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketNow;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:43:47
*/
public interface TicketNowDao extends BaseDao<Tourism> {
	public List<Tourism> getHourTicket();
}