package com.cloud.icenter.yyzx.ztfx.jzfp.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorSurveyPojo;

public interface PoorSurveyDao extends BaseDao<PoorSurveyPojo>{
	/**
	 * 获取当前年份的贫困概况
	 * @param name
	 * @return
	 */
	public PoorSurveyPojo getCurSurvey();
	public PoorSurveyPojo getSurveyByYear(int year);
	
}
