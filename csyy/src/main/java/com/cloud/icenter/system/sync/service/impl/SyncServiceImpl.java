package com.cloud.icenter.system.sync.service.impl;


import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.service.OrganService;
import com.cloud.icenter.system.organ.service.OrganUserService;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.role.service.RoleService;
import com.cloud.icenter.system.sync.dao.SyncDao;
import com.cloud.icenter.system.sync.dto.OrganMsg;
import com.cloud.icenter.system.sync.dto.RoleMsg;
import com.cloud.icenter.system.sync.dto.UserMsg;
import com.cloud.icenter.system.sync.service.SyncService;
import com.cloud.icenter.system.sync.service.SynclogService;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.service.UserService;

@Logging
@Service
@Transactional
public class SyncServiceImpl implements SyncService{
	@Autowired SyncDao syncDao;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrganService organService;
	@Autowired
	private SynclogService synclogService;
	@Autowired
	private OrganUserService organUserService;

	@Override
	public void syncAllUser(UserMsg[] userlist) {
		//用户信息同步处理
		for(UserMsg usermap:userlist){
			String syncId = usermap.getUsername();
			User user = userService.getUserByName(syncId);
			if(user!=null){
			//修改
				user.setNickname(usermap.getNickname());
				user.setPassword(usermap.getPassword());
				user.setDescription(usermap.getDescription());
				user.setSalt(usermap.getSalt());
				user.setStatus(usermap.getStatus());
				user.setIdcard(usermap.getIdcard());
				syncDao.update(user);
				synclogService.saveSynclog(user, "update");
			}else{
			//新增
				user = new User();
				user.setUsername(usermap.getUsername());
				user.setNickname(usermap.getNickname());
				user.setPassword(usermap.getPassword());
				user.setDescription(usermap.getDescription());
				user.setSalt(usermap.getSalt());
				user.setStatus(usermap.getStatus());
				user.setIdcard(usermap.getIdcard());
				syncDao.add(user);
				synclogService.saveSynclog(user, "add");
				//保存完成后重新获取一次，下面要用
				user = userService.getUserByName(syncId);
			}
			
			//用户同步时需同步与角色的关联关系
			String roleNames = usermap.getRoleNames() != null ? usermap.getRoleNames() : "";
			syncDao.saveUserRole(user.getUserId(),roleNames);
			
			//用户同步时需同步与组织的关联关系
			String orgIds = usermap.getOrgIds() != null ? usermap.getOrgIds() : "";
			organUserService.deleteFromUserId(user.getUserId());
			if(orgIds==null || orgIds.equals("")){
				//默认将人员添加进其它组织机构
				organUserService.addUserToOther(user.getUserId());
			}else{
				syncDao.saveOrganUser(user.getUserId(),orgIds);
			}
		}
	}

	@Override
	public void syncAllOrg(OrganMsg[] orglist) {
		//用户信息同步处理
		if(!ArrayUtils.isEmpty(orglist)){
			String[] delOrgIds = new String[orglist.length];
			Organ[] orgs = new Organ[orglist.length];
			Organ organ = null;
			for(int i = 0;i < orglist.length;i++){
				OrganMsg orgmap = orglist[i];
				delOrgIds[i] = orgmap.getOrgId();
				organ = new Organ();
				organ.setOrgId(orgmap.getOrgId());
				organ.setEmpNo(orgmap.getEmpNo());
				organ.setName(orgmap.getName());
				organ.setShortName(orgmap.getShortName());
				organ.setOfficePhone(orgmap.getOfficePhone());
				organ.setAddress(orgmap.getAddress());
				organ.setMail(orgmap.getMail());
				organ.setParentId(orgmap.getParentId());
				organ.setDescription(orgmap.getDescription());
				organ.setSeqNum(orgmap.getSeqNum());
				organ.setStatus(orgmap.getStatus());
				organ.setType(orgmap.getType());
				organ.setCode(orgmap.getCode());
				organ.setPath(orgmap.getPath());
				organ.setSysCode(orgmap.getSyscode());
				orgs[i] = organ;
			}
			syncDao.deleteByIds(delOrgIds);
			syncDao.saveBatch(orgs);
		}
	}

	@Override
	public void syncAllRole(RoleMsg[] rolelist) {
		//用户信息同步处理
		for(RoleMsg rolemap:rolelist){
			String syncId = rolemap.getRoleName();
			Role role = roleService.getRoleByName(syncId);
			if(role!=null){
			//修改
				role.setDescription(rolemap.getDescription());
				role.setStatus(rolemap.getStatus());
				syncDao.update(role);
				synclogService.saveSynclog(role, "update");
			}else{
			//新增
				role = new Role();
				role.setRoleName(rolemap.getRoleName());
				role.setDescription(rolemap.getDescription());
				role.setStatus(rolemap.getStatus());
				syncDao.add(role);
				synclogService.saveSynclog(role, "add");
			}
		}
	}

	@Override
	public void deleteUser(String syncId) {
		User user = userService.getUserByName(syncId);
		if(user != null ){
			userService.delete(user.getUserId());
			synclogService.saveSynclog(user, "delete");
		}
	}

	@Override
	public void deleteOrgan(String syncId) {
		Organ organ = organService.get(syncId);
		if(organ != null ){
			organService.delete(organ.getOrgId());
			synclogService.saveSynclog(organ, "delete");
		}
	}

	@Override
	public void deleteRole(String syncId) {
		Role role = roleService.getRoleByName(syncId);
		if(role != null ){
			roleService.delete(role.getRoleId());
			synclogService.saveSynclog(role, "delete");
		}
	}

	@Override
	public void syncUser(UserMsg userMsg) {
		User user = userService.getUserByName(userMsg.getUsername());
		if(user!=null){
		//修改
			user.setNickname(userMsg.getNickname());
			user.setPassword(userMsg.getPassword());
			user.setDescription(userMsg.getDescription());
			user.setSalt(userMsg.getSalt());
			user.setStatus(userMsg.getStatus());
			syncDao.update(user);
			synclogService.saveSynclog(user, "update");
		}else{
		//新增
			user = new User();
			user.setUsername(userMsg.getUsername());
			user.setNickname(userMsg.getNickname());
			user.setPassword(userMsg.getPassword());
			user.setDescription(userMsg.getDescription());
			user.setSalt(userMsg.getSalt());
			user.setStatus(userMsg.getStatus());
			syncDao.add(user);
			synclogService.saveSynclog(user, "add");
			//保存完成后重新获取一次，下面要用
			user = userService.getUserByName(userMsg.getUsername());
		}
		
		//用户同步时需同步与角色的关联关系
		String roleNames = userMsg.getRoleNames();
		syncDao.saveUserRole(user.getUserId(),roleNames);
		
		//用户同步时需同步与组织的关联关系
		String orgIds = userMsg.getOrgIds();
		organUserService.deleteFromUserId(user.getUserId());
		if(orgIds==null || orgIds.equals("")){
			//默认将人员添加进其它组织机构
			organUserService.addUserToOther(user.getUserId());
		}else{
			syncDao.saveOrganUser(user.getUserId(),orgIds);
		}
	}

	@Override
	public void syncOrgan(OrganMsg organMsg) {
		Organ organ = organService.get(organMsg.getOrgId());
		if(organ!=null){
		//修改
			organ.setEmpNo(organMsg.getEmpNo());
			organ.setName(organMsg.getName());
			organ.setShortName(organMsg.getShortName());
			organ.setOfficePhone(organMsg.getOfficePhone());
			organ.setAddress(organMsg.getAddress());
			organ.setMail(organMsg.getMail());
			organ.setParentId(organMsg.getParentId());
			organ.setDescription(organMsg.getDescription());
			organ.setSeqNum(organMsg.getSeqNum());
			organ.setStatus(organMsg.getStatus());
			organ.setType(organMsg.getType());
			organ.setCode(organMsg.getCode());
			organ.setPath(organMsg.getPath());
			syncDao.update(organ);
			synclogService.saveSynclog(organ, "update");
		}else{
		//新增
			organ = new Organ();
			organ.setOrgId(organMsg.getOrgId());
			organ.setEmpNo(organMsg.getEmpNo());
			organ.setName(organMsg.getName());
			organ.setShortName(organMsg.getShortName());
			organ.setOfficePhone(organMsg.getOfficePhone());
			organ.setAddress(organMsg.getAddress());
			organ.setMail(organMsg.getMail());
			organ.setParentId(organMsg.getParentId());
			organ.setDescription(organMsg.getDescription());
			organ.setSeqNum(organMsg.getSeqNum());
			organ.setStatus(organMsg.getStatus());
			organ.setType(organMsg.getType());
			organ.setCode(organMsg.getCode());			
			organ.setPath(organMsg.getPath());
			syncDao.add(organ);
			synclogService.saveSynclog(organ, "add");
		}
	}

	@Override
	public void syncRole(RoleMsg roleMsg) {
		Role role = roleService.getRoleByName(roleMsg.getRoleName());
		if(role!=null){
		//修改
			role.setDescription(roleMsg.getDescription());
			role.setStatus(roleMsg.getStatus());
			syncDao.update(role);
			synclogService.saveSynclog(role, "update");
		}else{
		//新增
			role = new Role();
			role.setRoleName(roleMsg.getRoleName());
			role.setDescription(roleMsg.getDescription());
			role.setStatus(roleMsg.getStatus());			
			syncDao.add(role);
			synclogService.saveSynclog(role, "add");
		}
	}
	
	
}
