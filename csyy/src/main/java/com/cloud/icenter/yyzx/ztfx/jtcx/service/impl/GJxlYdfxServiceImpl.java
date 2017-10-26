package com.cloud.icenter.yyzx.ztfx.jtcx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GJxlYdfxDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GJxlYdfxPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.service.GJxlYdfxService;

/** 
 * @author zhucy 
 * @version 2017年7月28日 上午11:19:00 
 * 说明 
 */
@Logging
@Service
public class GJxlYdfxServiceImpl extends BaseServiceImpl<GJxlYdfxPojo> implements GJxlYdfxService{
	
	@Autowired
	private GJxlYdfxDao gJxlYdfxDao;
	
	@Override
	public String getYdsj(String name,String sxx) {
		
		return gJxlYdfxDao.getYdsj(name,sxx);
		
	}

}
