package com.cloud.icenter.yyzx.ztfx.jtcx.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzbPojo;

public interface GjzbDao extends BaseDao<GjzbPojo> {
	/**
	 * 获取当前年份的贫困概况
	 * 
	 * @param name
	 * @return
	 */
	public List<GjzbPojo> getCurGjzb();

	public List<GjzbPojo> getGjzbByYear(int year);
	//公交车停车时间
	public List<?> getStopTimeList(String name, String dir);
	//公交线路
	public List<Map<String,Object>> getGjxlList(String name, String dir);
	//出租车空载率
	public List<Map<String, Object>> getKzlList();
	//出租车平均营收情况
	public List<Object> getYsList();
	//出租车工作日平均速度
	public List<Object> getWorkSpeedList();
	//车租车周末平均速度
	public List<Object> getWeekSpeedList();
	//出租车实时待客和载客情况
	public List<Map<String, Object>> getZkDkList(String hour);
	//出租车实时待客和载客情况当前时间
	public List<Map<String, Object>> getSsZkDkList(String hour);
	//上客点排名
	public List<Object> getTaxiSkdList(String type);
	//下课点排名
	public List<Object> getTaxiXkdList(String type);



	


}
