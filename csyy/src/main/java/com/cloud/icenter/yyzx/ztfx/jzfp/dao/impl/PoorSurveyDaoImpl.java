package com.cloud.icenter.yyzx.ztfx.jzfp.dao.impl;

import java.util.Calendar;

import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorSurveyDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorSurveyPojo;

/**
 * @author dbchenga
 */
@Repository
public class PoorSurveyDaoImpl extends BaseDaoImpl<PoorSurveyPojo> implements
		PoorSurveyDao {

	@Override
	public PoorSurveyPojo getCurSurvey() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);

		return getSurveyByYear(curYear);
	}

	@Override
	public PoorSurveyPojo getSurveyByYear(int year) {
		try {
			// TODO Auto-generated method stub
			return super.get(PoorSurveyPojo.class, "year", year);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
