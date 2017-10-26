package com.cloud.icenter.yyzx.ztfx.jtcx.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GJxlYdfxPojo;

/** 
 * @author zhucy 
 * @version 2017年7月28日 上午11:18:25 
 * 说明 
 */
public interface GJxlYdfxService extends BaseService<GJxlYdfxPojo>{

	public String getYdsj(String name,String sxx);
	
}
