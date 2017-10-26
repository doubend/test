package com.cloud.icenter.yyzx.ztfx.jtcx.service;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjxlPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzbPojo;

public interface JtcxService {
	public List<GjcPojo> getSixYear();

	public GjcPojo getGjcByYear(int year);

	public List<GjzbPojo> getCurGjzb();

	public List<GjzbPojo> getGjzbByYear(int year);
	public List<GjxlPojo> getAll();
	//公交车停车时间
	public List<?> getStopTimeList(String name, String dir);
	//公交车线路分析
	public List<Map<String,Object>> getGjxlList(String name, String dir);
	//出租车空载率情况
	public List<Map<String, Object>> getKzlList();
	//出租车的运营情况
	public List<Object> getYsList();
	//出租车工作日平均速度
	public List<Object> getWorkSpeedList();
	//出租车周末平均速度
	public List<Object> getWeekSpeedList();
	//出租车实时待客和载客总数
	public List<Map<String, Object>> getZkDkList(String hour);
	//当前时间载客和待客
	public List<Map<String, Object>> getSsZkDkList(String hour);
	//出租车上客点排名
	public List<Object> getTaxiSkdList(String type);
	//出租车下客点排名
	public List<Object> getTaxiXkdList(String type);
	
	


}
