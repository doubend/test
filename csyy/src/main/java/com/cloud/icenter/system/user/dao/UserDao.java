package com.cloud.icenter.system.user.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.system.user.pojo.User;

/**
 * 用户数据访问接口
 * @author zhangle
 */
public interface UserDao extends BaseDao<User>{
	
	/**
	 * 根据用户名查找用户对象
	 * @param name
	 * @return
	 */
	public User getUserByName(String username);
	
	/**
	 * 更新用户密码
	 * @param userId
	 * @param password
	 */
	public void updatePassword(String userId,String password);
	
	/**
	 * 更新所有用户密码
	 * @param password
	 */
	public void updateAllPassword(String password);
	
	/**
	 * 修改登录参数(登录时间与登录次数)
	 * @param user
	 */
	public void updateLoginParams(User user);
	
	public void findUsersByOrgId(final Pagination<User> pagin ,final String[] orgIds , final String params);
	
	/**
	 * 根据组织机构ID，查找不在该组织机构下的人员
	 * @param pagin
	 * @param orgId
	 * @param params
	 */
	public void findNotInOrg(final Pagination<User> pagin , final String orgId , final String params);
	public boolean isChinese(String strName);
}
