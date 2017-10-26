package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpFpcxDao;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpPkcDao;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpcsDao;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfprwDao;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpzjDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrQyjyzqPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpFpcxPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpPkcPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpcsPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfprwPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpzjPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorPopulationDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorStatisDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorStrategyDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorSurveyDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPopulationPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStatisPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStrategyPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorSurveyPojo;

/**
 * @author dbchenga
 */
@Logging
@Service
public class DpJzfpServiceImpl extends BaseServiceImpl<DpFrQyjyzqPojo>
		implements DpJzfpService {

	@Autowired
	private PoorSurveyDao poorSurveyDao;
	@Autowired
	private PoorStatisDao poorStatisDao;
	@Autowired
	private PoorPopulationDao poorPopulationDao;

	@Autowired
	private DpJzfpzjDao dpJzfpzjDao;
	@Autowired
	private DpJzfpFpcxDao dpJzfpFpcxDao;

	@Autowired
	private DpJzfpcsDao dpJzfpcsDao;
	@Autowired
	private DpJzfprwDao dpJzfprwDao;
	@Autowired
	private PoorStrategyDao poorStrategyDao;

	@Autowired
	private DpJzfpPkcDao dpJzfpPkcDao;

	@Override
	public PoorSurveyPojo getCurSurvey() {
		// TODO Auto-generated method stub
		return poorSurveyDao.getCurSurvey();
	}

	@Override
	public List<PoorStatisPojo> getCurStatis(int type) {
		// TODO Auto-generated method stub
		return poorStatisDao.getCurStatis(type);
	}

	@Override
	public List<PoorPopulationPojo> getCurPopulationFiveYear() {
		// TODO Auto-generated method stub
		return poorPopulationDao.getCurPopulationFiveYear();
	}

	@Override
	public DpJzfpzjPojo getCurFpzj() {
		// TODO Auto-generated method stub
		return dpJzfpzjDao.getCurFpzj();
	}

	@Override
	public DpJzfpzjPojo getFpzjByYear(int year) {
		// TODO Auto-generated method stub
		return dpJzfpzjDao.getFpzjByYear(year);
	}

	@Override
	public DpJzfpFpcxPojo getCurFpcx() {
		// TODO Auto-generated method stub
		return dpJzfpFpcxDao.getCurFpcx();
	}

	@Override
	public DpJzfpFpcxPojo getFpcxByYear(int year) {
		// TODO Auto-generated method stub
		return dpJzfpFpcxDao.getFpcxByYear(year);
	}

	@Override
	public DpJzfprwPojo getCurFprw() {
		// TODO Auto-generated method stub
		return dpJzfprwDao.getCurFprw();
	}

	@Override
	public DpJzfprwPojo getFprwByYear(int year) {
		// TODO Auto-generated method stub
		return dpJzfprwDao.getFprwByYear(year);
	}

	@Override
	public List<DpJzfpcsPojo> getCurFpcs() {
		// TODO Auto-generated method stub
		return dpJzfpcsDao.getCurFpcs();
	}

	@Override
	public List<DpJzfpcsPojo> getFpcsByYear(int year) {
		// TODO Auto-generated method stub
		return dpJzfpcsDao.getFpcsByYear(year);
	}

	@Override
	public List<PoorStrategyPojo> getCurStrategyTop4() {
		// TODO Auto-generated method stub
		return poorStrategyDao.getCurStrategyTop4();
	}

	@Override
	public List<DpJzfpPkcPojo> getCurPkc(int type) {
		// TODO Auto-generated method stub
		return dpJzfpPkcDao.getCurPkc(type);
	}

}
