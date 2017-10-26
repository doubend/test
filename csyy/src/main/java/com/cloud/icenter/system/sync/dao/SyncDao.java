package com.cloud.icenter.system.sync.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.user.pojo.User;

public interface SyncDao extends BaseDao<Object>{

	void saveUserRole(String userId, String roleNames);

	void saveOrganUser(String userId, String orgIds);

	Organ getOrganById(String syncId);

	Role getRoleByName(String roleName);
	
	/**
	 * 删除所有组织机构，物理删除
	 */
	public void deleteByIds(String[] orgIds);
	
	public void saveBatch(Organ[] orgs);

}
