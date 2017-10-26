package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJtcxCzcDao;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJtcxFzDao;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJtcxZbDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxCzcPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxFzPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxZbPojo;

/**
 * @author dbchenga
 */
@Logging
@Service
public class DpJtcxServiceImpl extends BaseServiceImpl<DpJtcxCzcPojo> implements
		DpJtcxService {

	@Autowired
	private DpJtcxCzcDao dpJtcxCzcDao;

	@Autowired
	private DpJtcxZbDao dpJtcxZbDao;

	@Autowired
	private DpJtcxFzDao dpJtcxFzDao;

	@Override
	public List<DpJtcxCzcPojo> getCurCzc() {
		// TODO Auto-generated method stub
		return dpJtcxCzcDao.getCurCzc();
	}

	@Override
	public List<DpJtcxZbPojo> getCurZb() {
		// TODO Auto-generated method stub
		return dpJtcxZbDao.getCurZb();
	}

	@Override
	public List<DpJtcxFzPojo> getCurFiveYear() {
		// TODO Auto-generated method stub
		return dpJtcxFzDao.getCurFiveYear();
	}

}
