package com.cloud.icenter.yyzx.dpzs.slp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpRkDbDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbPojo;

/**
 * @author dbchenga
 */
@Repository
public class SlpRkDbDaoImpl extends BaseDaoImpl<SlpRkDbPojo> implements
		SlpRkDbDao {

	@Override
	public List<SlpRkDbPojo> getCurDbFiveYear() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(SlpRkDbPojo.class);
			searDc.add(Restrictions.gt("year", curYear - 5));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SlpRkDbPojo getDbByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(SlpRkDbPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
