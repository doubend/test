package com.cloud.icenter.system.logs.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.logs.dao.LogsDao;
import com.cloud.icenter.system.logs.pojo.Logs;

@Repository
public class LogsDaoImpl extends BaseDaoImpl<Logs> implements LogsDao {

	@Override
	public void deleteBefore(Date date) {
		executeUpdate("delete Logs where createdAt<?", date);
	}

	@Override
	public void deleteBetween(String type, Date fromDate, Date toDate) {
		if(StringUtil.isEmpty(type)){
			executeUpdate("delete Logs where createdAt between ? and ?", fromDate,toDate);
		}
		else{
		executeUpdate("delete Logs where type = ? and createdAt between ? and ?",type, fromDate,toDate);
		}
	}

	
}
