package com.cloud.icenter.yyzx.fzjc.whly.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.Transportation;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:42:49
*/
public interface TransportationService extends BaseService<Transportation> {
	public List<Transportation> getTrans();
}