package com.cloud.icenter.yyzx.fzjc.fr.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyhyPojo;

public interface FRQyhyDao extends BaseDao<FRQyhyPojo>{
	/**
	 * 获取当前年份的贫困概况
	 * @param name
	 * @return
	 */
	public List<FRQyhyPojo> getCurQyhy();
	public List<FRQyhyPojo> getQyhyByYear(int year);
	
	
}
