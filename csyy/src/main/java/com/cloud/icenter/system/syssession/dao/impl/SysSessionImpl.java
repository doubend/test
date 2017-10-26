package com.cloud.icenter.system.syssession.dao.impl;

import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.system.syssession.dao.SysSessionDao;
import com.cloud.icenter.system.syssession.pojo.SysSession;

/**
 * Impl
 * 
 * @author yht 2015-07-10
 */
@Repository
public class SysSessionImpl extends BaseDaoImpl<SysSession> implements
		SysSessionDao {

	@Override
	public SysSession getSysSessionBySession(String session) {
		return super.get(SysSession.class, "sessionKey", session);
	}

}
