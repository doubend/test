package com.cloud.icenter.system.logs.dao;

import java.util.Date;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.system.logs.pojo.Logs;

/**
 * 日志数据访问接口
 * @author zhangle
 */
public interface LogsDao extends BaseDao<Logs> {

	public void deleteBefore(Date date);
	
	public void deleteBetween(String type,Date fromDate, Date toDate);
}
