package com.cloud.icenter.system.sync.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.system.sync.dto.OrganMsg;
import com.cloud.icenter.system.sync.dto.RoleMsg;
import com.cloud.icenter.system.sync.dto.UserMsg;
import com.cloud.icenter.system.sync.pojo.Synclog;

public interface SyncService{

	void syncAllUser(UserMsg[] userlist);

	void syncAllOrg(OrganMsg[] orglist);

	void syncAllRole(RoleMsg[] rolelist);

	void deleteUser(String syncId);

	void deleteOrgan(String syncId);

	void deleteRole(String syncId);

	void syncUser(UserMsg userMsg);

	void syncOrgan(OrganMsg organMsg);

	void syncRole(RoleMsg roleMsg);

}
