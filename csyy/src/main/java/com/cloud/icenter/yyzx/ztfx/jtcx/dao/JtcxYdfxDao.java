package com.cloud.icenter.yyzx.ztfx.jtcx.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzdPojo;

/** 
 * @author zhucy 
 * @version 2017年7月26日 下午5:01:21 
 * 说明 
 */
public interface JtcxYdfxDao extends BaseDao<GjzdPojo>{
	
	/**
	  * @author zhucy 
	  * @version 2017年7月26日 下午5:02:57 
	  * 说明:早晚高峰运行速度排行
	 */
	public Map<String, Object> getGfsdYdph();
	/**
	  * @author zhucy 
	  * @version 2017年7月28日 上午9:31:33 
	  * 说明:各时段站点之间拥堵分析
	 */
	public void dataHandleSx(Map<String, Object> map);
	
	/**
	  * @author zhucy 
	  * @version 2017年7月28日 上午9:31:33 
	  * 说明:各时段站点之间拥堵分析
	 */
	public void dataHandleXx(Map<String, Object> map);
	
	/**
	  * @author zhucy 
	  * @version 2017年8月3日 下午2:07:40 
	  * 说明:获取所有线路
	 */
	public List<Map<String, Object>> getXl();
}
