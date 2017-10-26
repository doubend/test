package com.cloud.icenter.yyzx.dpzs.lz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.lz.dao.LzJtcxDao;
import com.cloud.icenter.yyzx.dpzs.lz.dao.LzMinshengDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzJtcxPojo;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzMinshengPojo;

/**
 * @author dbchenga
 */
@Logging
@Service
public class LzServiceImpl extends BaseServiceImpl<LzMinshengPojo> implements
		LzService {

	@Autowired
	private LzMinshengDao lzMinshengDao;
	@Autowired
	private LzJtcxDao lzJtcxDao;

	@Override
	public List<LzMinshengPojo> getCurMinsheng() {
		// TODO Auto-generated method stub
		return lzMinshengDao.getCurMinsheng();
	}

	@Override
	public List<LzMinshengPojo> getMinshengByYear(int year) {
		// TODO Auto-generated method stub
		return lzMinshengDao.getMinshengByYear(year);
	}

	@Override
	public List<LzMinshengPojo> getCurMinsheng(int type) {
		// TODO Auto-generated method stub
		return lzMinshengDao.getCurMinsheng(type);
	}

	@Override
	public LzJtcxPojo getCurJtcx() {
		// TODO Auto-generated method stub
		return lzJtcxDao.getCurJtcx();
	}

	@Override
	public LzJtcxPojo getJtcxByYear(int year) {
		// TODO Auto-generated method stub
		return lzJtcxDao.getJtcxByYear(year);
	}

}
