package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrQyjyzqPojo;

public interface DpFrQyjyzqDao extends BaseDao<DpFrQyjyzqPojo> {
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<DpFrQyjyzqPojo> getCurQyjyzq();

	public List<DpFrQyjyzqPojo> getQyjyzqByYear(int year);


}
