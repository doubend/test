package com.cloud.icenter.yyzx.cstz.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cstz.dao.CstzTzmxDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzmxPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzmxService;

/** 
* @author zhucy 
* @version 2017年4月12日 上午9:22:41 
* 说明 
*/
@Logging
@Service
public class CstzTzmxServiceImpl extends BaseServiceImpl<CstzTzmxPojo> implements CstzTzmxService{
	@Autowired
	private CstzTzmxDao cstzTzmxDao;

	@Override
	public List<CstzTzmxPojo> getChildren(String parentId, String status) {
		// TODO Auto-generated method stub
		return cstzTzmxDao.getChildren(parentId, status);
	}

	@Override
	public void move(String targetId, String sourceId, String point) {
		// TODO Auto-generated method stub
		cstzTzmxDao.move(targetId, sourceId, point);
	}

	@Override
	public boolean checkTzmc(String tzmc) {
		// TODO Auto-generated method stub
		return cstzTzmxDao.checkTzmc(tzmc);
	}

	@Override
	public boolean checkYwtzId(String ywtzId) {
		// TODO Auto-generated method stub
		return cstzTzmxDao.checkYwtzId(ywtzId);
	}

	@Override
	public void bachSaveOrUpdateObject(Collection<CstzTzmxPojo> coll) {
		// TODO Auto-generated method stub
		cstzTzmxDao.bachSaveOrUpdateObject(coll);
	}

	@Override
	public int getMaxXssx() {
		// TODO Auto-generated method stub
		return cstzTzmxDao.getMaxXssx();
	}
}
