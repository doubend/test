package com.cloud.icenter.system.syssession.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.system.syssession.pojo.SysSession;

public interface SysSessionService extends BaseService<SysSession> {

	/**
	 * 查询session信息
	 * @return 返回查询结果
	 * @param session 查询条件
	 */
	public SysSession getSysSessionBySession(String session);
}
