package com.cloud.icenter.yyzx.ztfx.jjyx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.ztfx.jjyx.dao.EconomyDao;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Economy;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Equipment;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Industrytotal;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Situation;
import com.cloud.icenter.yyzx.ztfx.jjyx.service.EconomyService;
/**
 * 
 * @author Administrator
 *
 */
@Logging
@Service
public class EconomyServiceImpl extends BaseServiceImpl<Economy> implements EconomyService{

	@Autowired
	private EconomyDao economyDao;

	@Override
	public List<Economy> getEconomyLizt() {
		return economyDao.getEconomyLizt();
	}

	@Override
	public List<Industrytotal> getIndustrytotalListByYear(String year) {
		return economyDao.getIndustrytotalListByYear(year);
	}

	@Override
	public List<Equipment> getEquipmentListByYear(String year) {
		return economyDao.getEquipmentListByYear(year);
	}

	@Override
	public Situation getMaxSituation() {
		return economyDao.getMaxSituation();
	}

}
