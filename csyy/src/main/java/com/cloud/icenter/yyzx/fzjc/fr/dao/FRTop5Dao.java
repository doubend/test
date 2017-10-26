package com.cloud.icenter.yyzx.fzjc.fr.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop5Pojo;

public interface FRTop5Dao extends BaseDao<FRTop5Pojo> {
	/**
	 * 获取当前年份的贫困概况
	 * 
	 * @param name
	 * @return
	 */
	public List<FRTop5Pojo> getCurFiveYear();
	

}
