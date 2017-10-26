package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpFpcxDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpFpcxPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpJzfpFpcxDaoImpl extends BaseDaoImpl<DpJzfpFpcxPojo> implements
		DpJzfpFpcxDao {

	@Override
	public DpJzfpFpcxPojo getCurFpcx() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		return getFpcxByYear(curYear);
	}

	@Override
	public DpJzfpFpcxPojo getFpcxByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpJzfpFpcxPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
