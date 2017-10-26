package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpFpcxPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpPkcPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpcsPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfprwPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpzjPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPopulationPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStatisPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStrategyPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorSurveyPojo;

public interface DpJzfpService {
	public PoorSurveyPojo getCurSurvey();

	public List<PoorStatisPojo> getCurStatis(int type);

	public List<PoorPopulationPojo> getCurPopulationFiveYear();

	public DpJzfpzjPojo getCurFpzj();

	public DpJzfpzjPojo getFpzjByYear(int year);

	public DpJzfpFpcxPojo getCurFpcx();

	public DpJzfpFpcxPojo getFpcxByYear(int year);

	public DpJzfprwPojo getCurFprw();

	public DpJzfprwPojo getFprwByYear(int year);

	public List<DpJzfpcsPojo> getCurFpcs();

	public List<DpJzfpcsPojo> getFpcsByYear(int year);

	public List<PoorStrategyPojo> getCurStrategyTop4();

	public List<DpJzfpPkcPojo> getCurPkc(int type);
}
