package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrqyryPojo;

public interface DpFrqyryDao extends BaseDao<DpFrFrqyryPojo> {
	/**
	 * @大屏-法人-近年主要行业企业数与从业人员变化
	 * @param name
	 * @return
	 */
	public List<DpFrFrqyryPojo> getCurQyry();

	public List<DpFrFrqyryPojo> getQyryByYear(int year);


}
