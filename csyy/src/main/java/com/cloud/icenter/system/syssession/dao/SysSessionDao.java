package com.cloud.icenter.system.syssession.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.system.syssession.pojo.SysSession;

/**
 * Dao接口
 * 
 * @author yht 2015-07-10
 */
public interface SysSessionDao extends BaseDao<SysSession> {
	/**
	 * 查询session信息
	 * @return 返回查询结果
	 * @param session 查询条件
	 */
	public SysSession getSysSessionBySession(String session);
}
