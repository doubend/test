package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.Calendar;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.lz.dao.LzJtcxDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzJtcxPojo;

/**
 * @author dbchenga
 */
@Repository
public class LzJtcxDaoImpl extends BaseDaoImpl<LzJtcxPojo> implements LzJtcxDao {

	@Override
	public LzJtcxPojo getCurJtcx() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			return getJtcxByYear(curYear);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LzJtcxPojo getJtcxByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(LzJtcxPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
