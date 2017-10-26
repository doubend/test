package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpzjDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpzjPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpJzfpzjDaoImpl extends BaseDaoImpl<DpJzfpzjPojo> implements
		DpJzfpzjDao {

	@Override
	public DpJzfpzjPojo getCurFpzj() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		return getFpzjByYear(curYear);
	}

	@Override
	public DpJzfpzjPojo getFpzjByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpJzfpzjPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
