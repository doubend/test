package com.cloud.icenter.yyzx.ztfx.jtcx.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjcDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcPojo;

/**
 * @author dbchenga
 */
@Repository
public class GjcDaoImpl extends BaseDaoImpl<GjcPojo> implements GjcDao {

	@Override
	public List<GjcPojo> getSixYear() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			// TODO Auto-generated method stub
			DetachedCriteria searDc = DetachedCriteria.forClass(GjcPojo.class);
			searDc.add(Restrictions.gt("year", curYear - 6));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GjcPojo getGjcByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(GjcPojo.class);
			searDc.add(Restrictions.gt("year", year));
			return super.find(searDc).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
