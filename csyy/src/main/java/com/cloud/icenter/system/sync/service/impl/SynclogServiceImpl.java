package com.cloud.icenter.system.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloud.icenter.system.sync.dao.SynclogDao;
import com.cloud.icenter.system.sync.pojo.Synclog;
import com.cloud.icenter.system.sync.service.SynclogService;
import com.cloud.icenter.base.service.impl.BaseServiceImpl;


@Service
public class SynclogServiceImpl extends BaseServiceImpl<Synclog> implements SynclogService{

	@Autowired private SynclogDao synclogDao;
	
	@Override
	public void saveSynclog(Object pojo, String type) {
		synclogDao.saveSynclog(pojo,type);
		
	}

}
