package com.cloud.icenter.yyzx.fzjc.whly.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TourismTime;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:07
*/
public interface TourismTimeService extends BaseService<TourismTime> {
	public List<TourismTime> getYkl();
}