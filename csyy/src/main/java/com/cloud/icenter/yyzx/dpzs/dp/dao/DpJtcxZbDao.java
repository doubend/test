package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxZbPojo;

public interface DpJtcxZbDao extends BaseDao<DpJtcxZbPojo> {
	/**
	 * @大屏-交通出行-出租车
	 * @param name
	 * @return
	 */

	public List<DpJtcxZbPojo> getCurZb();

}
