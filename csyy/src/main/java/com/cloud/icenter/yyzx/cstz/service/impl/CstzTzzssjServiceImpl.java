package com.cloud.icenter.yyzx.cstz.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cstz.dao.CstzTzzssjDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzzssjPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzzssjService;

/** 
* @author zhucy 
* @version 2017年4月18日 上午11:03:45 
* 说明 
*/
@Logging
@Service
public class CstzTzzssjServiceImpl extends BaseServiceImpl<CstzTzzssjPojo> implements CstzTzzssjService{
	
	@Autowired
	private CstzTzzssjDao cstzTzzssjDao;
	
	@Override
	public Map<String, ?> getPageObjectBySql(String ywzbmc, PagingUtil pagingUtil) {
		// TODO Auto-generated method stub
		return this.cstzTzzssjDao.getPageObjectBySql(ywzbmc, pagingUtil);
	}

	@Override
	public void upCal() {
		// TODO Auto-generated method stub
		this.cstzTzzssjDao.upCal();
	}

	@Override
//	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void add(CstzTzzssjPojo obj) {
		// TODO Auto-generated method stub
		super.add(obj);
	}

	@Override
//	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void update(CstzTzzssjPojo obj) {
		// TODO Auto-generated method stub
		super.update(obj);
	}

	@Override
	public void calThree() {
		this.cstzTzzssjDao.calThree();
	}

	@Override
	public void calTwo() {
		this.cstzTzzssjDao.calTwo();
	}

	@Override
	public void calOne() {
		this.cstzTzzssjDao.calOne();
	}
	
	
	
	
}
