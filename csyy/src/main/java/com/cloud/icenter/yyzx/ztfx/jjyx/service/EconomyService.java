package com.cloud.icenter.yyzx.ztfx.jjyx.service;

import java.util.List;

import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Economy;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Equipment;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Industrytotal;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Situation;

public interface EconomyService {
	
	public List<Economy> getEconomyLizt();
	
	public List<Industrytotal> getIndustrytotalListByYear(String year);
	
	public List<Equipment> getEquipmentListByYear(String year);
	
	public Situation getMaxSituation();

}
