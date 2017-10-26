package com.cloud.icenter.yyzx.fzjc.whly.service;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TouristSource;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-14 15:34:32
*/
public interface TouristSourceService extends BaseService<TouristSource> {
	public List<Map<String,Object>> getAll();
	public List<TouristSource> getZykl();
}