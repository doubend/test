package com.cloud.icenter.yyzx.ztfx.jtcx.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GJxlYdfxPojo;

/** 
 * @author zhucy 
 * @version 2017年7月28日 上午11:19:54 
 * 说明 
 */
public interface GJxlYdfxDao extends BaseDao<GJxlYdfxPojo>{
	
	public String getYdsj(String name,String sxx);

}
