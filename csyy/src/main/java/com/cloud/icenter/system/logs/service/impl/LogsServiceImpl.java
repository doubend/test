package com.cloud.icenter.system.logs.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.dao.LogsDao;
import com.cloud.icenter.system.logs.pojo.Logs;
import com.cloud.icenter.system.logs.service.LogsService;

@Service
public class LogsServiceImpl extends BaseServiceImpl<Logs> implements LogsService {
	@Autowired private LogsDao logsDao;
	
	@Override
	public void deleteBefore(Date date) {
		logsDao.deleteBefore(date);
	}

	@Override
	public void deleteBetween(String type,Date fromDate, Date toDate) {
		logsDao.deleteBetween(type,fromDate, toDate);
		
	}

	
}
