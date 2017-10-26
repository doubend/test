package com.cloud.icenter.yyzx.dpzs.slp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTimePojo;

public interface SlpJtcxTimeDao extends BaseDao<SlpJtcxTimePojo> {
	/**
	 * @三联屏-交通出行-十大热点
	 * @param name
	 * @return
	 */
	public List<SlpJtcxTimePojo> getTimeHotspot();

}
