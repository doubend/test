package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpPkcPojo;

public interface DpJzfpPkcDao extends BaseDao<DpJzfpPkcPojo> {
	/**
	 * @param name
	 * @return
	 */
	public List<DpJzfpPkcPojo> getCurPkc(int type);

	/**
	 * @param name
	 * @return
	 */
	public List<DpJzfpPkcPojo> gePkcByYear(int type, int year);

}
