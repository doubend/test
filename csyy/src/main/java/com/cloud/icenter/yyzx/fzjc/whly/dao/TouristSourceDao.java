package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TouristSource;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-14 15:34:32
*/
public interface TouristSourceDao extends BaseDao<TouristSource> {
	public List<Map<String,Object>> getAll();
	public List<TouristSource> getZykl();
}