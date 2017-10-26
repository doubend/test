package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.PrimaryIndustry;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:41:24
*/
public interface PrimaryIndustryService extends BaseService<PrimaryIndustry> {
	public List<PrimaryIndustry> getPrimaryIndustry();
}