package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpPkcDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpPkcPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpJzfpPkcDaoImpl extends BaseDaoImpl<DpJzfpPkcPojo> implements
		DpJzfpPkcDao {

	@Override
	public List<DpJzfpPkcPojo> getCurPkc(int type) {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpJzfpPkcPojo.class);
			searDc.add(Restrictions.eq("year", curYear));
			searDc.add(Restrictions.eq("pkcd", type));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DpJzfpPkcPojo> gePkcByYear(int type, int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpJzfpPkcPojo.class);
			searDc.add(Restrictions.eq("year", year));
			searDc.add(Restrictions.eq("pkcd", type));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
