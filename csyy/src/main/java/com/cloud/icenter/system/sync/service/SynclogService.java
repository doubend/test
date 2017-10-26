package com.cloud.icenter.system.sync.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.system.sync.pojo.Synclog;


public interface SynclogService extends BaseService<Synclog>{
	void saveSynclog(Object pojo,String type);
}
