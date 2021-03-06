package com.cloud.icenter.system.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.role.dao.RoleDao;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.role.service.RoleService;

/**
 * 角色服务实现类
 * @author zhangle
 */
@Logging
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	
	@Autowired private RoleDao roleDao;
	
	@Override
	public List<Role> findRoleByUserId(String userId,Integer status) {
		return roleDao.findRoleByUserId(userId,status);
	}

	@Override
	public Role getRoleByName(String name) {
		return roleDao.getRoleByName(name);
	}

	@Override
	public void sort(Role[] roles) {
		roleDao.sort(roles);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}
}
