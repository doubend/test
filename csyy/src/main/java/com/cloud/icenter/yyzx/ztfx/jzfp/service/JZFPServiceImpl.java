package com.cloud.icenter.yyzx.ztfx.jzfp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpPkcDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpPkcPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorPlanDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorPopulationDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorStatisDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorStrategyDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorSurveyDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPlanPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPopulationPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStatisPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStrategyPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorSurveyPojo;

/**
 * @author dbchenga
 */
@Logging
@Service
public class JZFPServiceImpl extends BaseServiceImpl<PoorSurveyPojo> implements
		JZFPService {

	@Autowired
	private PoorSurveyDao poorSurveyDao;
	@Autowired
	private PoorStrategyDao poorStrategyDao;

	@Autowired
	private PoorStatisDao poorStatisDao;

	@Autowired
	private PoorPopulationDao poorPopulationDao;

	@Autowired
	private PoorPlanDao poorPlanDao;

	@Autowired
	private DpJzfpPkcDao dpJzfpPkcDao;

	@Override
	public PoorSurveyPojo getCurSurvey() {

		return poorSurveyDao.getCurSurvey();
	}

	@Override
	public PoorSurveyPojo getSurveyByYear(int year) {
		// TODO Auto-generated method stub
		return poorSurveyDao.getSurveyByYear(year);
	}

	@Override
	public List<PoorStrategyPojo> getCurStrategy() {
		// TODO Auto-generated method stub
		return poorStrategyDao.getCurStrategy();
	}

	@Override
	public List<PoorStrategyPojo> getStrategyByYear(int year) {
		// TODO Auto-generated method stub
		return poorStrategyDao.getStrategyByYear(year);
	}

	@Override
	public List<PoorStatisPojo> getCurStatis() {
		// TODO Auto-generated method stub
		return poorStatisDao.getCurStatis();
	}

	@Override
	public List<PoorStatisPojo> getCurStatis(int type) {
		// TODO Auto-generated method stub
		return poorStatisDao.getCurStatis(type);
	}

	@Override
	public List<PoorStatisPojo> getStatisByYear(int year) {
		// TODO Auto-generated method stub
		return poorStatisDao.getStatisByYear(year);
	}

	@Override
	public List<PoorStatisPojo> getStatisByYear(int year, int type) {
		// TODO Auto-generated method stub
		return poorStatisDao.getStatisByYear(year, type);
	}

	@Override
	public List<PoorPopulationPojo> getCurPopulationFiveYear() {
		// TODO Auto-generated method stub
		return poorPopulationDao.getCurPopulationFiveYear();
	}

	@Override
	public List<PoorPlanPojo> getSSWPlan() {
		// TODO Auto-generated method stub
		return poorPlanDao.getSSWPlan();
	}

	@Override
	public PoorPlanPojo getPlanByYear(int year) {
		// TODO Auto-generated method stub
		return poorPlanDao.getPlanByYear(year);
	}

	@Override
	public List<DpJzfpPkcPojo> gePkcByYear(int type, int year) {
		// TODO Auto-generated method stub
		return dpJzfpPkcDao.gePkcByYear(type, year);
	}
}
