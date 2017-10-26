package com.cloud.icenter.yyzx.ztfx.jtcx.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcPojo;

public interface GjcDao extends BaseDao<GjcPojo> {
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<GjcPojo> getSixYear();

	public GjcPojo getGjcByYear(int year);

}
