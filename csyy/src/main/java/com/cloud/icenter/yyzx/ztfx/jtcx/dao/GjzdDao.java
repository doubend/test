package com.cloud.icenter.yyzx.ztfx.jtcx.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzdPojo;

public interface GjzdDao extends BaseDao<GjzdPojo> {
	/**
	 * 
	 * @param name
	 * @return
	 */

	public List<GjzdPojo> getGjzdByGjcno(int gjc_no);

}
