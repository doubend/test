package com.cloud.icenter.yyzx.ztfx.jzfp.service;

import java.util.List;

import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpPkcPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPlanPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPopulationPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStatisPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStrategyPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorSurveyPojo;

public interface JZFPService {
	public PoorSurveyPojo getCurSurvey();

	public PoorSurveyPojo getSurveyByYear(int year);

	public List<PoorStrategyPojo> getCurStrategy();

	public List<PoorStrategyPojo> getStrategyByYear(int year);

	public List<PoorStatisPojo> getCurStatis();

	public List<PoorStatisPojo> getCurStatis(int type);

	public List<PoorStatisPojo> getStatisByYear(int year);

	public List<PoorStatisPojo> getStatisByYear(int year, int type);

	public List<PoorPopulationPojo> getCurPopulationFiveYear();

	public List<PoorPlanPojo> getSSWPlan();

	public PoorPlanPojo getPlanByYear(int year);

	public List<DpJzfpPkcPojo> gePkcByYear(int type, int year);

}
