package com.cloud.icenter.yyzx.ztfx.jtcx.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjcDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjxlDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjzbDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjzdDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjxlPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzbPojo;

/**
 * @author dbchenga
 */
@Logging
@Service
public class JtcxServiceImpl extends BaseServiceImpl<GjzbPojo> implements
		JtcxService {

	@Autowired
	private GjzbDao gjzbDao;
	@Autowired
	private GjcDao gjcDao;
	@Autowired
	private GjxlDao gjxlDao;
	@Autowired
	private GjzdDao gjzdDao;

	@Override
	public List<GjcPojo> getSixYear() {
		// TODO Auto-generated method stub
		return gjcDao.getSixYear();
	}

	@Override
	public GjcPojo getGjcByYear(int year) {
		// TODO Auto-generated method stub
		return gjcDao.getGjcByYear(year);
	}

	@Override
	public List<GjzbPojo> getCurGjzb() {
		// TODO Auto-generated method stub
		return gjzbDao.getCurGjzb();
	}

	@Override
	public List<GjzbPojo> getGjzbByYear(int year) {
		// TODO Auto-generated method stub
		return gjzbDao.getGjzbByYear(year);
	}

	@Override
	public List<GjxlPojo> getAll() {
		// TODO Auto-generated method stub
		List<GjxlPojo> list = gjxlDao.getAll();

		for (GjxlPojo pojo : list) {
			pojo.setZhandian(gjzdDao.getGjzdByGjcno(pojo.getNo()));
		}

		return list;
	}
	/**
	 * 公交车停车时间
	 */
	@Override
	public List<?> getStopTimeList(String name,String dir) {
		
		return gjzbDao.getStopTimeList(name,dir);
	}
	/**
	 * 公交线路
	 */
	@Override
	public List<Map<String,Object>> getGjxlList(String name,String dir) {
		// TODO Auto-generated method stub
		return gjzbDao.getGjxlList(name,dir);
	}
	/**
	 * 出租车空载率
	 */
	@Override
	public List<Map<String, Object>> getKzlList() {
		
		return gjzbDao.getKzlList();
	}
	/**
	 * 出租车每个时段平均营收
	 */
	@Override
	public List<Object> getYsList() {
		return gjzbDao.getYsList();
	}
	/**
	 * 出租车工作日平均速度
	 */
	@Override
	public List<Object> getWorkSpeedList() {
		return gjzbDao.getWorkSpeedList();
	}
	/**
	 * 出租车周末平均速度
	 */
	@Override
	public List<Object> getWeekSpeedList() {
		return gjzbDao.getWeekSpeedList();
	}
	/**
	 * 出租车实时载客和待客
	 */
	@Override
	public List<Map<String, Object>> getZkDkList(String hour) {
		return gjzbDao.getZkDkList(hour);
	}
	/**
	 * 出租车实时载客和待客当前时间
	 */
	@Override
	public List<Map<String, Object>> getSsZkDkList(String hour) {
		return gjzbDao.getSsZkDkList(hour);
	}
	/**
	 * 出租车上客点排名
	 */
	@Override
	public List<Object> getTaxiSkdList(String type) {
		return gjzbDao.getTaxiSkdList(type);
	}
	/**
	 * 出租车下客点排名
	 */
	@Override
	public List<Object> getTaxiXkdList(String type) {
		return gjzbDao.getTaxiXkdList(type);
	}

	

}
