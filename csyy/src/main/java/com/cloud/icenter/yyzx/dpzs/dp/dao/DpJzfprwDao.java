package com.cloud.icenter.yyzx.dpzs.dp.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfprwPojo;

public interface DpJzfprwDao extends BaseDao<DpJzfprwPojo> {
	/**
	 * @param name
	 * @return
	 */
	public DpJzfprwPojo getCurFprw();

	public DpJzfprwPojo getFprwByYear(int year);

}
