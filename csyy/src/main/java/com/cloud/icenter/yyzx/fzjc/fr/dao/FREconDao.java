package com.cloud.icenter.yyzx.fzjc.fr.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconNsPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconPojo;

public interface FREconDao extends BaseDao<FREconPojo>{
	/**
	 * 获取当前年份的贫困概况
	 * @param name
	 * @return
	 */
	public List<FREconPojo> getCurEcon();
	public List<FREconPojo> getEconByYear(int year);
	public List<FREconNsPojo> getCurEconNs();
	public List<FREconNsPojo> getEconNsByYear(int year);
	
}
