package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpFrQyjyzqDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrQyjyzqPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpFrQyjyzqDaoImpl extends BaseDaoImpl<DpFrQyjyzqPojo> implements
		DpFrQyjyzqDao {

	@Override
	public List<DpFrQyjyzqPojo> getCurQyjyzq() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			DetachedCriteria dc = DetachedCriteria
					.forClass(DpFrQyjyzqPojo.class);
			dc.add(Restrictions.eq("year", curYear));
			dc.addOrder(Order.asc("clnf"));
			Criteria cri = dc.getExecutableCriteria(getSession());
			cri.setMaxResults(5);
			return cri.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DpFrQyjyzqPojo> getQyjyzqByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpFrQyjyzqPojo.class);
			searDc.add(Restrictions.gt("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
