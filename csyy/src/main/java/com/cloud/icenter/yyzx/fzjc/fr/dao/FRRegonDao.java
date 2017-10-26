package com.cloud.icenter.yyzx.fzjc.fr.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRRegonPojo;

public interface FRRegonDao extends BaseDao<FRRegonPojo> {
	/**
	 * 获取当前年份的贫困概况
	 * 
	 * @param name
	 * @return
	 */
	public List<FRRegonPojo> getCurRegon();

	public List<FRRegonPojo> getRegonByYear(int year);

	public List<FRRegonPojo> getRegonByNameSevevYear(String regonName);

}
