package com.cloud.icenter.yyzx.fzjc.fr.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrfbPojo;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRZxwDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRZxwPojo;

/**
 * @author dbchenga
 */
@Repository
public class FRZxwDaoImpl extends BaseDaoImpl<FRZxwPojo> implements FRZxwDao {
	@Override
	public List<FRZxwPojo> getFiveYearZxw() {
		try {
			List<Integer> years = new ArrayList<Integer>();
			years.add(2013);
			years.add(2014);
			years.add(2015);
			years.add(2016);
			years.add(2017);
			DetachedCriteria searDc = DetachedCriteria
					.forClass(FRZxwPojo.class);
			searDc.add(Restrictions.in("year", years));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FRZxwPojo getZxwByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(FRZxwPojo.class);
			searDc.add(Restrictions.gt("year", year));
			return super.find(searDc).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FRZxwPojo> getSevenYear() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);

		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(FRZxwPojo.class);
			searDc.add(Restrictions.gt("year", curYear - 5));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
