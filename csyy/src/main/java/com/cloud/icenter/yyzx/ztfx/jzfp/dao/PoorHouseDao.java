package com.cloud.icenter.yyzx.ztfx.jzfp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStrategyPojo;

public interface PoorHouseDao extends BaseDao<PoorStrategyPojo>{
	/**
	 * 获取当前年份的贫困概况
	 * @param name
	 * @return
	 */
	public List<PoorStrategyPojo> getCurStrategy();
	public List<PoorStrategyPojo> getStrategyByYear(int year);
	
}
