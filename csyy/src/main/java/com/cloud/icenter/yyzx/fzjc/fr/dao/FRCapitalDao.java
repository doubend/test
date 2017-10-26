package com.cloud.icenter.yyzx.fzjc.fr.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRCapitalPojo;

public interface FRCapitalDao extends BaseDao<FRCapitalPojo>{
	/**
	 * 获取当前年份的贫困概况
	 * @param name
	 * @return
	 */
	public List<FRCapitalPojo> getCurCapital();
	public List<FRCapitalPojo> getCapitalByYear(int year);
	
}
