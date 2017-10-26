package com.cloud.icenter.system.syssession.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.syssession.dao.SysSessionDao;
import com.cloud.icenter.system.syssession.pojo.SysSession;
import com.cloud.icenter.system.syssession.service.SysSessionService;

/**
 * serviceImpl
 * 
 * @author yht 2015-07-10
 */
@Logging
@Service
public class SysSessionServiceImpl extends BaseServiceImpl<SysSession>
		implements SysSessionService {
	@Autowired
	private SysSessionDao sysSessionDao;

	@Override
	public SysSession getSysSessionBySession(String session) {
		// TODO Auto-generated method stub
		return sysSessionDao.getSysSessionBySession(session);
	}
	
}
