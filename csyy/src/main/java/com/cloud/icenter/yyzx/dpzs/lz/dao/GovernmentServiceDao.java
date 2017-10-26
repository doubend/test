package com.cloud.icenter.yyzx.dpzs.lz.dao;


import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovernmentService;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
public interface GovernmentServiceDao extends BaseDao<GovernmentService> {
	public List<Tourism> getDayData();
	public List<Tourism> getMonthData();
	public List<Tourism> getYearData();
}