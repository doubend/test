package com.cloud.icenter.yyzx.fzjc.hjbh.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.hjbh.dao.WaterDao;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterPollution;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterQualityCity;
import com.cloud.icenter.yyzx.fzjc.hjbh.service.WaterService;

/**
 * 
 * @author Administrator
 *
 */
@Service
public class WaterServiceImpl extends BaseServiceImpl<WaterPollution> implements WaterService{
	
	@Autowired
	private WaterDao waterDao;

	@Override
	public List<WaterPollution> getWaterPollutionList(int num) {
		return waterDao.getWaterPollutionList(num);
	}

	@Override
	public List<WaterQualityCity> getWaterQualityCityForSeven(Timestamp sttime,
			Timestamp edtime) {
		return waterDao.getWaterQualityCityForSeven(sttime, edtime);
	}

	@Override
	public List<WaterQualityArea> getWaterQualityAreaByDate(String date) {
		return waterDao.getWaterQualityAreaByDate(date);
	}

	@Override
	public List<String> getHlfz() {
		return waterDao.getHlfz();
		
	}

	@Override
	public List<Map<String, Object>> getDbsJczb() {
		
		return waterDao.getDbsJczb();
		
	}

	@Override
	public List<Map<String, Object>> getYysJczb() {
		
		return waterDao.getYysJczb();
		
	}

	@Override
	public List<Map<String, Object>> getDbsJczd(String ly) {
		
		return waterDao.getDbsJczd(ly);
		
	}

	@Override
	public List<Map<String, Object>> getYysJczd() {
		
		return waterDao.getYysJczd();
		
	}

	@Override
	public List<Map<String, Object>> getJcsj(String jczd, String jczb,
			String year) {
		
		return waterDao.getJcsj(jczd, jczb, year);
		
	}

}
