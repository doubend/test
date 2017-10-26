package com.cloud.icenter.yyzx.dpzs.dp.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpzjPojo;

public interface DpJzfpzjDao extends BaseDao<DpJzfpzjPojo> {
	/**
	 * @大屏-法人-企业法人分布
	 * @param name
	 * @return
	 */
	public DpJzfpzjPojo getCurFpzj();

	public DpJzfpzjPojo getFpzjByYear(int year);

}
