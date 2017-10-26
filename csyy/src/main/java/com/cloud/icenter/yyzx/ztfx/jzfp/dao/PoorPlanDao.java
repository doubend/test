package com.cloud.icenter.yyzx.ztfx.jzfp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPlanPojo;

public interface PoorPlanDao extends BaseDao<PoorPlanPojo> {
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<PoorPlanPojo> getSSWPlan();

	public PoorPlanPojo getPlanByYear(int year);

}
