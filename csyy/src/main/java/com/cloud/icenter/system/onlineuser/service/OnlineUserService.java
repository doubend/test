package com.cloud.icenter.system.onlineuser.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;

/**
 * 在线用户服务接口
 * @author zhangle
 */
public interface OnlineUserService {

	/**
	 * 添加在线用户
	 * @param onlineUser
	 */
	public void add(OnlineUser onlineUser);
	
	/**
	 * 根据session id,删除在线用户
	 * @param sessionId
	 */
	public void delete(String sessionId);
	
	/**
	 * 根据session id,获取在线用户
	 * @param sessionId
	 * @return
	 */
	public OnlineUser get(String sessionId);
	
	/**
	 * 获取在线用户列表,根据登录时间降序排序
	 * @return
	 */
	public List<OnlineUser> getOnlineUsers();
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public OnlineUser getLoginUser(HttpServletRequest request);
}
