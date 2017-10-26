package com.cloud.icenter.yyzx.dpzs.slp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbrqPojo;

public interface SlpRkDbrqDao extends BaseDao<SlpRkDbrqPojo> {
	/**
	 * @三联屏-人口-低保人群
	 * @param name
	 * @return
	 */
	public List<SlpRkDbrqPojo> getCurDbrq();

}
