package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpcsPojo;

public interface DpJzfpcsDao extends BaseDao<DpJzfpcsPojo> {
	/**
	 * @param name
	 * @return
	 */
	public List<DpJzfpcsPojo> getCurFpcs();

	public List<DpJzfpcsPojo> getFpcsByYear(int year);

}
