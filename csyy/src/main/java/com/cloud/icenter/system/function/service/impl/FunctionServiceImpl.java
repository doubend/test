package com.cloud.icenter.system.function.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.function.dao.FunctionDao;
import com.cloud.icenter.system.function.pojo.Function;
import com.cloud.icenter.system.function.service.FunctionService;
import com.cloud.icenter.system.logs.pojo.Logging;

/**
 * 功能服务实现类
 * @author zhangle
 */
@Logging
@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements FunctionService{
	
	@Autowired FunctionDao functionDao;
	
	@Override
	public List<Function> getChildren(String parentId,Integer status) {
		return functionDao.getChildren(parentId,status);
	}
	
	@Override
	public List<Function> getChildrenForRole(String roleId, String parentId, Integer status) {
		return functionDao.getChildrenForRole(roleId, parentId, status);
	}
	
	@Override
	public List<Function> getChildrenForOrgan(String organId, String parentId,Integer status) {
		return functionDao.getChildrenForOrgan(organId, parentId, status);
	}

	@Override
	public void move(String targetId, String sourceId, String point) {
		functionDao.move(targetId, sourceId, point);
	}

	@Override
	public List<Function> getChildrenForMenu(String menuId, String parentId,
			Integer status) {
		return functionDao.getChildrenForMenu(menuId, parentId, status);
	}

	@Override
	public boolean checkCode(String code) {
		return functionDao.checkCode(code);
	}


}
