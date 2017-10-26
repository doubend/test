package com.cloud.icenter.yyzx.dpzs.slp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpRkDbDao;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpRkDbrqDao;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpRkfbDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbrqPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkNljgPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkfbPojo;
import com.cloud.icenter.yyzx.fzjc.rk.dao.PdistributionDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;

/**
 * @author dbchenga
 */
@Logging
@Service
public class SlpRkServiceImpl extends BaseServiceImpl<SlpRkDbPojo> implements SlpRkService {

	@Autowired
	private SlpRkDbDao slpRkDbDao;
	@Autowired
	private SlpRkDbrqDao slpRkDbrqDao;
	@Autowired
	private PdistributionDao pdistributionDao;
	@Autowired
	private SlpRkfbDao slpRkfbDao;

	@Override
	public List<SlpRkDbPojo> getCurDbFiveYear() {
		// TODO Auto-generated method stub
		return slpRkDbDao.getCurDbFiveYear();
	}

	@Override
	public SlpRkDbPojo getDbByYear(int year) {
		// TODO Auto-generated method stub
		return slpRkDbDao.getDbByYear(year);
	}

	@Override
	public List<SlpRkDbrqPojo> getCurDbrq() {
		// TODO Auto-generated method stub
		return slpRkDbrqDao.getCurDbrq();
	}

	@Override
	public List<Newborn> getNewBornList() {
		// TODO Auto-generated method stub
		return pdistributionDao.getNewBornList();
	}

	@Override
	public List<SlpRkNljgPojo> getRkNljgList() {
		// TODO Auto-generated method stub
		return slpRkfbDao.getRkNljgList();
	}

	@Override
	public List<SlpRkfbPojo> getRkfbByYear(int year) {
		// TODO Auto-generated method stub
		return slpRkfbDao.getRkfbByYear(year);
	}

}
