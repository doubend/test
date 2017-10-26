package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.Transportation;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:42:49
*/
public interface TransportationDao extends BaseDao<Transportation> {
	public List<Transportation> getTrans();
}