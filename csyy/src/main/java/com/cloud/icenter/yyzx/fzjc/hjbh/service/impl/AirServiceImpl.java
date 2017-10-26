package com.cloud.icenter.yyzx.fzjc.hjbh.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.hjbh.dao.AirDao;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirPollution;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityCity;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.DateStr;
import com.cloud.icenter.yyzx.fzjc.hjbh.service.AirService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class AirServiceImpl extends BaseServiceImpl<AirPollution> implements AirService{
	
	@Autowired
	private AirDao airDao;

	/**
	 * 大气污染源企业排污总量排名
	 * num 返回几条
	 */
	@Override
	public List<AirPollution> getAirPollutionList(int num) {
		return airDao.getAirPollutionList(num);
	}

	@Override
	public List<AirQualityCity> getAirQualityCityForSeven(Timestamp sttime,
			Timestamp edtime) {
		return airDao.getAirQualityCityForSeven(sttime, edtime);
	}

	@Override
	public List<AirQualityArea> getAirQualityAreaByDate(String date) {
		return airDao.getAirQualityAreaByDate(date);
	}

	@Override
	public List<AirQualityArea> getAllDateList() {
		return airDao.getAllDateList();
	}

	@Override
	public List<Map<String, Object>> getDataForSeven(String jczd, String jcsj) {
		
		return airDao.getDataForSeven(jczd, jcsj);
		
	}
	public List<Map<String, Object>> showQualitySite(){
		return airDao.showQualitySite();
	}
	
	/**
	  * @author zhucy 
	  * @version 2017年8月2日 下午2:52:44 
	  * 说明:写入阿里云获取的监测数据
	 */
	public void insertJcsj(String jsonResult){
		airDao.insertJcsj(jsonResult);
	}

	@Override
	public List<Map<String, Object>> getSskqzl() {
		
		return airDao.getSskqzl();
		
	}

	@Override
	public List<Map<String, Object>> getZxsj() {
		
		return airDao.getZxsj();
		
	}

	@Override
	public List<Map<String, Object>> getKqzlRb() {
		
		return airDao.getKqzlRb();
		
	}

	@Override
	public List<Map<String, Object>> getTsSszbSj() {
		
		return airDao.getTsSszbSj();
		
	}

	@Override
	public Map<String, Object> getJynTsYltsTj() {
		
		return airDao.getJynTsYltsTj();
		
	}

}
