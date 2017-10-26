package com.cloud.icenter.yyzx.fzjc.fr.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRQyhyDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyhyPojo;

/**
 * @author dbchenga
 */
@Repository
public class FRQyhyDaoImpl extends BaseDaoImpl<FRQyhyPojo> implements FRQyhyDao {

	@Override
	public List<FRQyhyPojo> getCurQyhy() {
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		return getQyhyByYear(curYear);
	}

	@Override
	public List<FRQyhyPojo> getQyhyByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(FRQyhyPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
