package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJzfprwDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfprwPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpJzfprwDaoImpl extends BaseDaoImpl<DpJzfprwPojo> implements
		DpJzfprwDao {

	@Override
	public DpJzfprwPojo getCurFprw() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		return getFprwByYear(curYear);
	}

	@Override
	public DpJzfprwPojo getFprwByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpJzfprwPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
