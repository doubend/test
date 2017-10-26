package com.cloud.icenter.yyzx.ztfx.jzfp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorStrategyDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStrategyPojo;

/**
 * @author dbchenga
 */
@Repository
public class PoorStrategyDaoImpl extends BaseDaoImpl<PoorStrategyPojo>
		implements PoorStrategyDao {

	@Override
	public List<PoorStrategyPojo> getCurStrategy() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);

		return getStrategyByYear(curYear);
	}

	@Override
	public List<PoorStrategyPojo> getStrategyByYear(int year) {
		try {
			// TODO Auto-generated method stub
			DetachedCriteria searDc = DetachedCriteria
					.forClass(PoorStrategyPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<PoorStrategyPojo> getCurStrategyTop4() {
		try {
			// TODO Auto-generated method stub
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);

			DetachedCriteria dc = DetachedCriteria
					.forClass(PoorStrategyPojo.class);
			dc.add(Restrictions.eq("year", curYear));

			Criteria cri = dc.getExecutableCriteria(getSession());

			cri.setMaxResults(4);
			return super.find(dc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
