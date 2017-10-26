package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrzbPojo;

public interface DpFrzbDao extends BaseDao<DpFrFrzbPojo> {
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<DpFrFrzbPojo> getCurFrzb(int year, String qyhy, String qyxz);

}
