package com.cloud.icenter.yyzx.fzjc.fr.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop8Pojo;

public interface FRTop8Dao extends BaseDao<FRTop8Pojo> {
	/**
	 * 获取当前年份的贫困概况
	 * 
	 * @param name
	 * @return
	 */
	public List<FRTop8Pojo> getCurFourYear();

}
