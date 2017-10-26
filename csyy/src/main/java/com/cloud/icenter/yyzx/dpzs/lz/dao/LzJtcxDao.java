package com.cloud.icenter.yyzx.dpzs.lz.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzJtcxPojo;

public interface LzJtcxDao extends BaseDao<LzJtcxPojo> {
	/**
	 * 获取当前年份的贫困概况
	 * 
	 * @param name
	 * @return
	 */
	public LzJtcxPojo getCurJtcx();

	public LzJtcxPojo getJtcxByYear(int year);

}
