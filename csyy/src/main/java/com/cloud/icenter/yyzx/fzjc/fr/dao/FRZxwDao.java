package com.cloud.icenter.yyzx.fzjc.fr.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRZxwPojo;

public interface FRZxwDao extends BaseDao<FRZxwPojo> {
	/**
	 * 获取当前年份的贫困概况
	 * 
	 * @param name
	 * @return
	 */
	public List<FRZxwPojo> getFiveYearZxw();

	public FRZxwPojo getZxwByYear(int year);

	
	public List<FRZxwPojo> getSevenYear();
}
