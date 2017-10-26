package com.cloud.icenter.yyzx.ztfx.jtcx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.JtcxYdfxDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzbPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.service.JtcxYdfxService;

/** 
 * @author zhucy 
 * @version 2017年7月26日 下午4:59:58 
 * 说明 
 */
@Logging
@Service
public class JtcxYdfxServiceImpl  extends BaseServiceImpl<GjzbPojo> implements JtcxYdfxService{
	@Autowired
	JtcxYdfxDao jtcxYdfxDao;
	
	@Override
	public Map<String, Object> getGfsdYdph() {
		
		return jtcxYdfxDao.getGfsdYdph();
		
	}

	@Override
	public void dataHandleSx(Map<String, Object> map) {
		jtcxYdfxDao.dataHandleSx(map);
	}
	
	@Override
	public void dataHandleXx(Map<String, Object> map) {
		jtcxYdfxDao.dataHandleXx(map);
	}

	@Override
	public List<Map<String, Object>> getXl() {
		
		return jtcxYdfxDao.getXl();
		
	}

}
