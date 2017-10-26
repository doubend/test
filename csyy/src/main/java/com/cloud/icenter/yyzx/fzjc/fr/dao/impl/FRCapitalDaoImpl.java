package com.cloud.icenter.yyzx.fzjc.fr.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRCapitalDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRCapitalPojo;

/**
 * @author dbchenga
 */
@Repository
public class FRCapitalDaoImpl extends BaseDaoImpl<FRCapitalPojo> implements FRCapitalDao {

	@Override
	public List<FRCapitalPojo> getCurCapital() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			return getCapitalByYear(curYear - 1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FRCapitalPojo> getCapitalByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(FRCapitalPojo.class);
			searDc.add(Restrictions.gt("year", year));
			searDc.addOrder(Order.desc("num"));
			Criteria cri = searDc.getExecutableCriteria(getSession());
			cri.setMaxResults(8);
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
