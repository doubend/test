package com.cloud.icenter.system.sync.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.system.sync.pojo.Synclog;


public interface SynclogDao extends BaseDao<Synclog>{

	List<Synclog> getSynclog(String starttime, String endtime);

	void saveSynclog(Object pojo,String type);
}
