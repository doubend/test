package com.cloud.icenter.yyzx.fzjc.fr.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyinfoPojo;

public interface FRQyinfoDao extends BaseDao<FRQyinfoPojo>{
	/**
	 * 获取当前年份的贫困概况
	 * @param name
	 * @return
	 */
	public List<FRQyinfoPojo> getCurQyinfo();
	public List<FRQyinfoPojo> getQyinfoByYear(int year);
	
	
}
