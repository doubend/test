package com.cloud.icenter.yyzx.dpzs.slp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxRdmapPojo;

public interface SlpJtcxRdDao extends BaseDao<SlpJtcxRdmapPojo> {
	/**
	 * @三联屏-人口-低保数据
	 * @param name
	 * @return
	 */
	public List<SlpJtcxRdmapPojo> getYesterdayRd();

}
