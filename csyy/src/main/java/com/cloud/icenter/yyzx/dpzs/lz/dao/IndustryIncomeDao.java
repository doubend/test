package com.cloud.icenter.yyzx.dpzs.lz.dao;



import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.common.query.Industry;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.IndustryIncome;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:45:23
*/
public interface IndustryIncomeDao extends BaseDao<Industry> {
	public List<Industry> getIndustryIncome();
}