package com.cloud.icenter.yyzx.ztfx.jzfp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorPlanDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPlanPojo;

/**
 * @author dbchenga
 */
@Repository
public class PoorPlanDaoImpl extends BaseDaoImpl<PoorPlanPojo> implements
		PoorPlanDao {

	@Override
	public List<PoorPlanPojo> getSSWPlan() {
		try {
			// TODO Auto-generated method stub
			
			List<Integer> years = new ArrayList<Integer>();
			years.add(2016);
			years.add(2017);
			years.add(2018);
			years.add(2019);
			years.add(2020);
			DetachedCriteria searDc = DetachedCriteria
					.forClass(PoorPlanPojo.class);
			searDc.add(Restrictions.in("year", years));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PoorPlanPojo getPlanByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(PoorPlanPojo.class);
			searDc.add(Restrictions.gt("year", year));
			return super.find(searDc).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
