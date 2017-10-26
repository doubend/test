package com.cloud.icenter.yyzx.dpzs.dp.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpFpcxPojo;

public interface DpJzfpFpcxDao extends BaseDao<DpJzfpFpcxPojo> {
	/**
	 * @大屏-法人-企业法人分布
	 * @param name
	 * @return
	 */
	public DpJzfpFpcxPojo getCurFpcx();

	public DpJzfpFpcxPojo getFpcxByYear(int year);

}
