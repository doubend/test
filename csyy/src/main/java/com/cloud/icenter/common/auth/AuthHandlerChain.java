package com.cloud.icenter.common.auth;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloud.icenter.system.function.pojo.Function;
import com.cloud.icenter.system.menu.pojo.Menu;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;

/**
 * 权限验证职责链的默认头节点,负责配置整个职责链
 * @author zhangle
 */
@Component
public class AuthHandlerChain extends AuthHandler {

	@Autowired private RoleAuthHandler roleAuthHandler;
	@Autowired private OrganAuthHandler organAuthHandler;
	
	@PostConstruct
	public void init() {
		this.setNextHandler(roleAuthHandler);
		roleAuthHandler.setNextHandler(organAuthHandler);
		organAuthHandler.setNextHandler(new DefaultAuthHandler());
	}
	
	@Override
	public boolean handleUrl(OnlineUser loginUser, String url) {
		return getNextHandler().handleUrl(loginUser, url);
	}

	@Override
	public boolean handleCode(OnlineUser loginUser, String functionCode) {
		return getNextHandler().handleCode(loginUser, functionCode);
	}

	@Override
	public List<Menu> handleMenu(OnlineUser loginUser, String parentId) {
		return getNextHandler().handleMenu(loginUser, parentId);
	}

	@Override
	public void refreshCache() {
		getNextHandler().refreshCache();
	}
	
	/**
	 * 默认的权限处理器
	 * @author zhangle
	 */
	public static class DefaultAuthHandler extends AuthHandler {

		@Override
		public boolean handleUrl(OnlineUser loginUser, String url) {
			return false;
		}

		@Override
		public boolean handleCode(OnlineUser loginUser, String functionCode) {
			return false;
		}

		@Override
		public List<Menu> handleMenu(OnlineUser loginUser, String parentId) {
			return Collections.emptyList();
		}
		
		@Override
		public void refreshCache() {}

		@Override
		public List<Function> handleFunction(OnlineUser loginUser,
				String parentId) {
			
			return Collections.emptyList();
		}
	}

	@Override
	public List<Function> handleFunction(OnlineUser loginUser, String parentId) {
		
		return getNextHandler().handleFunction(loginUser, parentId);
	}
}
