package com.cloud.icenter.yyzx.dpzs.dp.dao;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.BusCoordinate;

/**
* Created with gender.
* @author: liyao
* Date: 2017-05-27 10:59:02
*/
public interface BusCoordinateDao extends BaseDao<BusCoordinate> {
	public JSONObject getBusCoordinates();
	public JSONObject getTaxiCoordinates();
	public JSONObject getBusStations(String linename,String dir);
	public JSONObject getBusLines();
	public JSONObject queryBusByLine(String linename,String dir);
	public JSONObject lineStartEnd();
}