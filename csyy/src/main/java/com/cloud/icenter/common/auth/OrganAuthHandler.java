package com.cloud.icenter.common.auth;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cloud.icenter.system.auth.dao.AuthDao;
import com.cloud.icenter.system.function.pojo.Function;
import com.cloud.icenter.system.menu.pojo.Menu;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;

/**
 * 基于组织机构的权限验证处理类
 * @author zhangle
 */
@Component
public class OrganAuthHandler extends AuthHandler {

	@Resource(name="organAuthDaoImpl") private AuthDao authDao;
	
	@Override
	public boolean handleUrl(OnlineUser loginUser, String url) {
		if(authDao.checkUrl(loginUser, url)) return true;
		return getNextHandler().handleUrl(loginUser, url);
	}

	@Override
	public boolean handleCode(OnlineUser loginUser, String functionCode) {
		if(authDao.checkCode(loginUser, functionCode)) return true;
		return getNextHandler().handleCode(loginUser, functionCode);
	}

	@Override
	public List<Menu> handleMenu(OnlineUser loginUser, String parentId) {
		List<Menu> menus=authDao.checkMenu(loginUser, parentId);
		List<Menu> otherMenus=getNextHandler().handleMenu(loginUser, parentId);
		for (Menu m :otherMenus) {
			if(!menus.contains(m))
			{
				menus.add(m);
			}
		}
		//menus.addAll(otherMenus);
		Collections.sort(menus);
		return menus;
	}

	@Override
	public void refreshCache() {
		authDao.refreshCache();
		getNextHandler().refreshCache();
	}

	@Override
	public List<Function> handleFunction(OnlineUser loginUser, String parentId) {
		List<Function> menus=authDao.checkFunction(loginUser, parentId);
		List<Function> otherMenus=getNextHandler().handleFunction(loginUser, parentId);
		menus.addAll(otherMenus);
		Collections.sort(menus);
		return menus;
	}

}
