package com.cloud.icenter.yyzx.cstz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cstz.dao.CstzYwzbDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzYwzbService;

/** 
* @author zhucy 
* @version 2017年4月5日 下午2:44:18 
* 说明 
*/
@Logging
@Service
public class CstzYwzbServiceImpl extends BaseServiceImpl<CstzYwzbPojo> implements CstzYwzbService{

	@Autowired
	private CstzYwzbDao cstzYwzbDao;
	
	@Override
	public void zbCal() {
		// TODO Auto-generated method stub
		this.cstzYwzbDao.zbCal();
	}

	@Override
	public void initData() {
		this.cstzYwzbDao.initData();
	}

	@Override
	public void zbCalDs() {
		this.cstzYwzbDao.zbCalDs();
	}
}
