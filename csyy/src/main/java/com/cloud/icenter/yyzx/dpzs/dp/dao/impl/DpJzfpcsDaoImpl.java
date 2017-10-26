package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfpcsDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpcsPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpJzfpcsDaoImpl extends BaseDaoImpl<DpJzfpcsPojo> implements
		DpJzfpcsDao {

	@Override
	public List<DpJzfpcsPojo> getCurFpcs() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		return getFpcsByYear(curYear);
	}

	@Override
	public List<DpJzfpcsPojo> getFpcsByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpJzfpcsPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
