package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TourismTime;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:07
*/
public interface TourismTimeDao extends BaseDao<TourismTime> {
	public List<TourismTime> getYkl();
}