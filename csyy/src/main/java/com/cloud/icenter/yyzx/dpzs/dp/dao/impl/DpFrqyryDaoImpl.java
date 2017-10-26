package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpFrqyryDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrqyryPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpFrqyryDaoImpl extends BaseDaoImpl<DpFrFrqyryPojo> implements
		DpFrqyryDao {

	@Override
	public List<DpFrFrqyryPojo> getCurQyry() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		return getQyryByYear(curYear - 1);
	}

	@Override
	public List<DpFrFrqyryPojo> getQyryByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpFrFrqyryPojo.class);
			searDc.add(Restrictions.gt("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
