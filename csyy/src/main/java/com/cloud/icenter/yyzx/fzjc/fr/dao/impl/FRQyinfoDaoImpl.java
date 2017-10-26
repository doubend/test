package com.cloud.icenter.yyzx.fzjc.fr.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRQyinfoDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyinfoPojo;

/**
 * @author dbchenga
 */
@Repository
public class FRQyinfoDaoImpl extends BaseDaoImpl<FRQyinfoPojo> implements
		FRQyinfoDao {

	@Override
	public List<FRQyinfoPojo> getCurQyinfo() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			return getQyinfoByYear(curYear);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FRQyinfoPojo> getQyinfoByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(FRQyinfoPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
