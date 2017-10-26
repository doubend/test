package com.cloud.icenter.system.user.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.system.user.pojo.User;

/**
 * 用户服务接口
 * @author zhangle
 */
public interface UserService extends BaseService<User>{
	
	/**
	 * 根据用户名查找用户对象
	 * @param name
	 * @return
	 */
	public User getUserByName(String username);
	
	/**
	 * 更新用户密码
	 * @param userId		用户ID
	 * @param password		密码原文
	 */
	public void updatePassword(String userId,String password);
	
	/**
	 * 更新所有用户密码
	 * @param password		密码原文
	 */
	public void updateAllPassword(String password);

	/**
	 * 修改登录参数(登录时间与登录次数)
	 * @param user
	 */
	public void updateLoginParams(User user);
	
	/**
	 * 查找某个组织机构下的人
	 * @param pagin
	 * @param orgId
	 * @param params
	 */
	public void findByOrgId(Pagination<User> pagin , String[] orgIds , String params);
	
	/**
	 * 根据组织机构查找未在该组织机构中的人
	 * @param pagin
	 * @param orgId
	 * @param params
	 */
	public void findNotInOrg(Pagination<User> pagin , String orgId , String params);
	
	public void addUser(User user);
	public boolean isChinese(String strName);
}
