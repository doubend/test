package com.cloud.icenter.system.datasync.service;

/**
 * 数据同步
 */
public interface DataSyncService {

	public void syncUsers(String json);
	
	public String sync();
	
	public void syncOrgan(String json);
	
	public void syncAllOrganData(String json);
}
