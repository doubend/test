package com.cloud.icenter.yyzx.ztfx.jzfp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorStatisDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStatisPojo;

/**
 * @author dbchenga
 */
@Repository
public class PoorStatisDaoImpl extends BaseDaoImpl<PoorStatisPojo> implements
		PoorStatisDao {

	@Override
	public List<PoorStatisPojo> getCurStatis() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);

		return getStatisByYear(curYear);
	}

	@Override
	public List<PoorStatisPojo> getStatisByYear(int year) {
		try {
			// TODO Auto-generated method stub
			DetachedCriteria searDc = DetachedCriteria
					.forClass(PoorStatisPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<PoorStatisPojo> getCurStatis(int type) {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);

		return getStatisByYear(curYear, type);
	}

	@Override
	public List<PoorStatisPojo> getStatisByYear(int year, int type) {
		try {
			// TODO Auto-generated method stub
			DetachedCriteria searDc = DetachedCriteria
					.forClass(PoorStatisPojo.class);
			searDc.add(Restrictions.eq("year", year));
			searDc.add(Restrictions.eq("type", type));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
