package com.cloud.icenter.yyzx.fzjc.fr.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRRegonDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRRegonPojo;

/**
 * @author dbchenga
 */
@Repository
public class FRRegonDaoImpl extends BaseDaoImpl<FRRegonPojo> implements
		FRRegonDao {

	@Override
	public List<FRRegonPojo> getCurRegon() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			return getRegonByYear(curYear - 1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FRRegonPojo> getRegonByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(FRRegonPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FRRegonPojo> getRegonByNameSevevYear(String regonName) {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			DetachedCriteria searDc = DetachedCriteria
					.forClass(FRRegonPojo.class);
			searDc.add(Restrictions.gt("year", curYear - 6));
			searDc.add(Restrictions.eq("regon", regonName));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
