package com.cloud.icenter.yyzx.dpzs.slp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbPojo;

public interface SlpRkDbDao extends BaseDao<SlpRkDbPojo> {
	/**
	 * @三联屏-人口-低保数据
	 * @param name
	 * @return
	 */
	public List<SlpRkDbPojo> getCurDbFiveYear();

	public SlpRkDbPojo getDbByYear(int year);

}
