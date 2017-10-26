package com.cloud.icenter.system.onlineuser.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;

/**
 * 在线用户服务实现类
 * @author zhangle
 */
@Logging
@Service
public class OnlineUserServiceImpl implements OnlineUserService {

	private HashMap<String, OnlineUser> onlineUserMap=new HashMap<String, OnlineUser>(50);
	
	@Override
	public void add(OnlineUser onlineUser) {
		onlineUserMap.put(onlineUser.getSession().getId(), onlineUser);
		onlineUser.getSession().setAttribute(Constants.LOGIN_USER_SESSION_KEY, onlineUser);
	}

	@Override
	public void delete(String sessionId) {
		OnlineUser user=onlineUserMap.get(sessionId);
		if(user==null) return;
		onlineUserMap.remove(sessionId);
		try {
			user.getSession().invalidate();
		} catch(Exception e) {}
	}

	@Override
	public OnlineUser get(String sessionId) {
		return onlineUserMap.get(sessionId);
	}

	@Override
	public List<OnlineUser> getOnlineUsers() {
		Collection<OnlineUser> users=onlineUserMap.values();
		List<OnlineUser> onlineUserList=new ArrayList<OnlineUser>(users);
		Collections.sort(onlineUserList);
		return onlineUserList;
	}

	@Override
	public OnlineUser getLoginUser(HttpServletRequest request) {
		if(request.getSession()==null) return null;
		return get(request.getSession().getId());
	}
}
