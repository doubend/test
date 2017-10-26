package com.cloud.icenter.yyzx.fzjc.rk.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.rk.dao.PdistributionDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Distribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Scale;
import com.cloud.icenter.yyzx.fzjc.rk.service.PdistributionServie;
/**
 * 人口分布
 * @author Administrator
 *
 */
@Logging
@Service
public class PdistributionServieImpl extends BaseServiceImpl<Distribution>  implements PdistributionServie{
	
	@Autowired
	private PdistributionDao pdistributionDao;

	
	@Override
	public List<Distribution> getPdistributionByYear(String year) {
		return pdistributionDao.getPdistributionByYear(year);
	}


	@Override
	public List<Scale> getSixNumber() {
		return pdistributionDao.getSixNumber();
	}


	@Override
	public List<Newborn> getNewBornList() {
		return pdistributionDao.getNewBornList();
	}


	@Override
	public List<Agestructure> getAgestructureList() {
		return pdistributionDao.getAgestructureList();
	}

}
