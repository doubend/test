package com.cloud.icenter.yyzx.dpzs.lz.dao;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.ServiceCategory;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-04-01 11:36:04
*/
public interface ServiceCategoryDao extends BaseDao<ServiceCategory> {
	public List<Tourism> getEventCount();
	public List<Tourism> getOnlineCount();
	public List<Tourism> getBureauOverview(String ssdw);
	public List<ServiceCategory> getEventList(String ssdw);
	public JSONObject getAllData();
}