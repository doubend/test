package com.cloud.icenter.yyzx.ztfx.jtcx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjcsdDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.service.GjcsdService;
@Logging
@Service
public class GjcsdServiceImpl extends BaseServiceImpl<GjcsdPojo> implements GjcsdService{
	@Autowired
	private GjcsdDao gjcsdDao;

	@Override
	public String getPjsdList(String name,String dir) {
		
			return gjcsdDao.getPjsdList(name,dir);
		

	}

	@Override
	public List<Map<String,Object>> getZmList(String name,String dir) {
		// TODO Auto-generated method stub
		return gjcsdDao.getZmList(name,dir);
	}

	@Override
	public void writeSxData() {
		gjcsdDao.writeSxData();	
	}

	@Override
	public void writeXxData() {
		gjcsdDao.writeXxData();
	}
	
	

}
