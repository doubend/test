package com.cloud.icenter.system.logs.service;

import java.util.Date;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.system.logs.pojo.Logs;

public interface LogsService extends BaseService<Logs> {

	public void deleteBefore(Date date);
	
	public void deleteBetween(String type,Date fromDate, Date toDate);
}
