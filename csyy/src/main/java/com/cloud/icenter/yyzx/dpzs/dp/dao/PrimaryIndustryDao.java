package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.PrimaryIndustry;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:41:24
*/
public interface PrimaryIndustryDao extends BaseDao<PrimaryIndustry> {
	public List<PrimaryIndustry> getPrimaryIndustry();
}