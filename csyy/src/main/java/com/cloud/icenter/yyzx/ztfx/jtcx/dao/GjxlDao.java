package com.cloud.icenter.yyzx.ztfx.jtcx.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjxlPojo;

public interface GjxlDao extends BaseDao<GjxlPojo> {
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<GjxlPojo> getAll();

}
