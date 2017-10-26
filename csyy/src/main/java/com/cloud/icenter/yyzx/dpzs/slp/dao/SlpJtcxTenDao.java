package com.cloud.icenter.yyzx.dpzs.slp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTenPojo;

public interface SlpJtcxTenDao extends BaseDao<SlpJtcxTenPojo> {
	/**
	 * @三联屏-交通出行-十大热点
	 * @param name
	 * @return
	 */
	public List<SlpJtcxTenPojo> getTenHotspot();

}
