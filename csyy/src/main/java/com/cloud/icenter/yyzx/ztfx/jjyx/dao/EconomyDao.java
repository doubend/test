package com.cloud.icenter.yyzx.ztfx.jjyx.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Economy;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Equipment;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Industrytotal;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Situation;
/**
 * 工业经济总体表
 * @author Administrator
 *
 */
public interface EconomyDao extends BaseDao<Economy>{
	
	
	public List<Economy>  getEconomyLizt();
	
	public List<Industrytotal> getIndustrytotalListByYear(String year);
	
	public List<Equipment> getEquipmentListByYear(String year);
	
	public Situation getMaxSituation();

}
