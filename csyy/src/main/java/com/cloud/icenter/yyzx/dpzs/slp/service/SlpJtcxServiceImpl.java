package com.cloud.icenter.yyzx.dpzs.slp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpJtcxRdDao;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpJtcxTenDao;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpJtcxTimeDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxRdmapPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTenPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTimePojo;

/**
 * @author dbchenga
 */
@Logging
@Service
public class SlpJtcxServiceImpl extends BaseServiceImpl<SlpJtcxRdmapPojo> implements SlpJtcxService {

	@Autowired
	private SlpJtcxRdDao slpJtcxRdDao;

	@Autowired
	private SlpJtcxTenDao slpJtcxTenDao;

	@Autowired
	private SlpJtcxTimeDao slpJtcxTimeDao;

	@Override
	public List<SlpJtcxRdmapPojo> getYesterdayRd() {
		// TODO Auto-generated method stub
		return slpJtcxRdDao.getYesterdayRd();
	}

	@Override
	public List<SlpJtcxTenPojo> getTenHotspot() {
		// TODO Auto-generated method stub
		return slpJtcxTenDao.getTenHotspot();
	}

	@Override
	public List<SlpJtcxTimePojo> getTimeHotspot() {
		// TODO Auto-generated method stub
		return slpJtcxTimeDao.getTimeHotspot();
	}

}
