package com.cloud.icenter.yyzx.cszc.zygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cszc.zygl.dao.BjmbDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.BjmbPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.BjmbService;

/** 
* @author zhucy 
* @version 2017年3月24日 下午2:07:06 
* 城市资源>部件码表
*/
@Logging
@Service
public class BjmbServiceImpl extends BaseServiceImpl<BjmbPojo> implements BjmbService{
	@Autowired
	private BjmbDao bjmbDao;

	@Override
	public List<BjmbPojo> getChildren(String parentId, String status) {
		return bjmbDao.getChildren(parentId, status);
	}
	
	@Override
	public boolean checkDm(String dm) {
		return bjmbDao.checkDm(dm);
	}

	@Override
	public void move(String targetId, String sourceId, String point) {
		bjmbDao.move(targetId, sourceId, point);
	}

	@Override
	public void delete(String id) {
		this.bjmbDao.delete(id);
	}
	
	
}
