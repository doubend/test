package com.cloud.icenter.system.user.service.impl;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.organ.service.OrganUserService;
import com.cloud.icenter.system.user.dao.UserDao;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.service.UserService;

/**
 * 用户服务实现类
 * @author zhangle
 */
@Logging
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired private UserDao userDao;
	
	@Autowired
	private OrganUserService organUserService;
	
	@Override
	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}

	@Override
	public void updatePassword(String userId, String password) {
		userDao.updatePassword(userId, password);
	}

	@Override
	public void updateAllPassword(String password) {
		userDao.updateAllPassword(password);
	}

	@Override
	public void updateLoginParams(User user) {
		userDao.updateLoginParams(user);
	}

	@Override
	public void findByOrgId(Pagination<User> pagin, String[] orgIds, String params) {
		if(pagin != null && !ArrayUtils.isEmpty(orgIds)){
			userDao.findUsersByOrgId(pagin, orgIds, params);
		}
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.user.service.UserService#findNotInOrg(com.cloud.icenter.common.utils.Pagination, java.lang.String, java.lang.String)
	 *
	 */
	@Override
	public void findNotInOrg(Pagination<User> pagin, String orgId, String params) {
		if(pagin != null && !StringUtils.isEmpty(orgId)){
			userDao.findNotInOrg(pagin, orgId, params);
		}
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.user.service.UserService#addUser(com.cloud.icenter.system.user.pojo.User)
	 *
	 */
	@Override
	public void addUser(User user) {
		if(user != null){
			this.add(user);
			//默认将人员添加进其它组织机构
			organUserService.addUserToOther(user.getUserId());
		}
	}
	
	@Override
	public void delete(String id) {
		if(!StringUtils.isEmpty(id)){
			organUserService.deleteFromUserId(id);
			super.delete(id);
			return;
		}
		throw new RuntimeException("缺少必要参数!");
	}
	
	public boolean isChinese(String strName){
		return userDao.isChinese(strName);
	}
}
