package com.cloud.icenter.system.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.common.auth.AuthHandler;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.auth.service.AuthService;
import com.cloud.icenter.system.function.pojo.Function;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.menu.pojo.Menu;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;

/**
 * 权限验证服务实现类
 * @author zhangle
 */
@Service
@Transactional(readOnly=true)
public class AuthServiceImpl implements AuthService,ApplicationListener<ContextRefreshedEvent> {

	private static final Log logger = LogFactory.getLog(AuthServiceImpl.class);
	
	@Resource(name="authHandlerChain")
	private AuthHandler authHandler;
	
	@Override
	public boolean checkUrl(OnlineUser loginUser, String url) {
		return authHandler.handleUrl(loginUser, url);
	}

	@Override
	public boolean checkCode(OnlineUser loginUser, String functionCode) {
		return authHandler.handleCode(loginUser, functionCode);
	}

	@Override
	public List<Menu> checkMenu(OnlineUser loginUser, String parentId) {
		return authHandler.handleMenu(loginUser, parentId);
	}

	@Override
	@Logging
	@Transactional(readOnly=false)
	public void refreshCache() {
		logger.info("正在刷新权限缓存,请稍等...");
		authHandler.refreshCache();
	}

	/**
	 * 当Spring的ApplicationContext初始化或刷新时发送的事件
	 * 当spring加载完毕后,刷新菜单缓存
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//系统启动时,是否刷新与权限有关的缓存
		String refreshCache=SystemConfig.getProperty("system.cache.refresh_on_startup");
		if("true".equalsIgnoreCase(refreshCache)) {
			refreshCache();
		}
	}

	@Override
	public List<Function> checkFunction(OnlineUser loginUser, String parentId) {
		return authHandler.handleFunction(loginUser, parentId);
	}
}
