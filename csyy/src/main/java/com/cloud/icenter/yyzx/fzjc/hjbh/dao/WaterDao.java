package com.cloud.icenter.yyzx.fzjc.hjbh.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterPollution;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterQualityCity;
/**
 * 
 * @author Administrator
 *
 */
public interface WaterDao extends BaseDao<WaterPollution>{

	public List<WaterPollution> getWaterPollutionList(int num);
	
	/**
	 * 如果时间为空的情况下，默认取当前向前七天数据
	 * @param sttime 开始时间
	 * @param edtime 结束时间
	 * @return list
	 */
	public List<WaterQualityCity> getWaterQualityCityForSeven(Timestamp sttime,Timestamp edtime);
	
	/**
	 * 获取一天的数据
	 * @param date 当天日期
	 * @return list
	 */
	public List<WaterQualityArea> getWaterQualityAreaByDate(String date);
	/**
	  * @author zhucy 
	  * @version 2017年7月19日 上午11:39:22 
	  * 说明 获取河流分组
	 */
	public List<String> getHlfz();
	
	/**
	  * @author zhucy 
	  * @version 2017年7月19日 下午3:23:36 
	  * 说明:获取地表水监测指标
	 */
	public List<Map<String, Object>> getDbsJczb();
	
	/**
	  * @author zhucy 
	  * @version 2017年7月19日 下午3:25:35 
	  * 说明:获取饮用水监测指标
	 */
	public List<Map<String, Object>> getYysJczb();
	
	/**
	  * @author zhucy 
	  * @version 2017年7月19日 下午4:15:30 
	  * 说明:获取地表水监测站点
	 */
	public List<Map<String, Object>> getDbsJczd(String ly);
	/**
	  * @author zhucy 
	  * @version 2017年7月19日 下午4:15:55 
	  * 说明:获取饮用水监测站点
	 */
	public List<Map<String, Object>> getYysJczd();
	/**
	  * @author zhucy 
	  * @version 2017年7月20日 上午10:33:50 
	  * 说明:根据监站点 指标 年份获取监测数据
	 */
	public List<Map<String, Object>> getJcsj(String jczd,String jczb,String year);
}
