package com.cloud.icenter.system.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.menu.dao.MenuDao;
import com.cloud.icenter.system.menu.pojo.Menu;
import com.cloud.icenter.system.menu.service.MenuService;

/**
 * 菜单服务实现类
 * @author zhangle
 */
@Logging
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

	@Autowired private MenuDao menuDao;

	@Override
	public List<Menu> getChildren(String parentId,Integer status) {
		return menuDao.getChildren(parentId,status);
	}

	@Override
	public void move(String targetId, String sourceId, String point) {
		menuDao.move(targetId, sourceId, point);
	}

	@Override
	public List<?> findName(String name) {
		return menuDao.findName(name);
	}
	
}
