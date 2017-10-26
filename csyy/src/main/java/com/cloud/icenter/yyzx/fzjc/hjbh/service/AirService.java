package com.cloud.icenter.yyzx.fzjc.hjbh.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirPollution;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityCity;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.DateStr;
/**
 * 
 * @author Administrator
 *
 */
@Service
public interface AirService extends BaseService<AirPollution>{
	
	public List<AirPollution> getAirPollutionList(int num);
	
	/**
	 * 如果时间为空的情况下，默认取当前向前七天数据
	 * @param sttime 开始时间
	 * @param edtime 结束时间
	 * @return list
	 */
	public List<AirQualityCity> getAirQualityCityForSeven(Timestamp sttime,Timestamp edtime);
	
	/**
	 * 获取一天的数据
	 * @param date 当天日期
	 * @return list
	 */
	public List<AirQualityArea> getAirQualityAreaByDate(String date);
	
	
	/**
	 * 获取所有的日期字符串
	 * @return
	 */
	public List<AirQualityArea> getAllDateList();
	
	/**
	  * @author zhucy 
	  * @version 2017年6月20日 上午10:30:36 
	  * 说明
	 */
	public List<Map<String, Object>> getDataForSeven(String jczd, String jcsj);
	
	/**
	  * @author zhucy 
	  * @version 2017年8月4日 上午10:03:03 
	  * 说明:天水实时空气质量
	 */
	public List<Map<String, Object>> getSskqzl();
	/**
	 * 获取监测站点基本信息
	 * @return
	 */
	public List<Map<String, Object>> showQualitySite();
	
	/**
	  * @author zhucy 
	  * @version 2017年8月2日 下午2:52:44 
	  * 说明:写入阿里云获取的监测数据
	 */
	public void insertJcsj(String jsonResult);
	/**
	  * @author zhucy 
	  * @version 2017年8月4日 上午10:13:41 
	  * 说明:获取最新数据时间
	 */
	public List<Map<String, Object>> getZxsj();
	
	/**
	  * @author zhucy 
	  * @version 2017年8月4日 上午11:28:11 
	  * 说明:天水市空气质量日报
	 */
	public List<Map<String, Object>> getKqzlRb();
	
	/**
	  * @author zhucy 
	  * @version 2017年8月4日 下午2:26:18 
	  * 说明:页面左上角天水市当天最新时间数据
	 */
	public List<Map<String, Object>> getTsSszbSj();
	
	/**
	  * @author zhucy 
	  * @version 2017年8月4日 下午3:05:48 
	  * 说明:天水市近一年优良天数统计
	 */
	public Map<String, Object> getJynTsYltsTj();
}
