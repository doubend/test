package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrQyjyzqPojo;
import com.cloud.icenter.yyzx.fzjc.rk.dao.PdistributionDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;

/**
 * @author dbchenga
 */
@Logging
@Service
public class DpRkServiceImpl extends BaseServiceImpl<DpFrQyjyzqPojo> implements
		DpRkService {

	@Autowired
	private PdistributionDao pdistributionDao;

	@Override
	public List<Agestructure> getAgestructureList() {
		// TODO Auto-generated method stub
		return pdistributionDao.getAgestructureList();
	}

	@Override
	public List<Newborn> getNewBornList() {
		// TODO Auto-generated method stub
		return pdistributionDao.getNewBornList();
	}

}
