package com.cloud.icenter.yyzx.fzjc.fr.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRTop5Dao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop5Pojo;

/**
 * @author dbchenga
 */
@Repository
public class FRTop5DaoImpl extends BaseDaoImpl<FRTop5Pojo> implements FRTop5Dao {

	@Override
	public List<FRTop5Pojo> getCurFiveYear() {
		try {
			// TODO Auto-generated method stub
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			List<Integer> years = new ArrayList<Integer>();
			years.add(curYear);
			years.add(curYear - 1);
			years.add(curYear - 2);
			years.add(curYear - 3);
			years.add(curYear - 4);
			DetachedCriteria searDc = DetachedCriteria
					.forClass(FRTop5Pojo.class);
			searDc.add(Restrictions.in("year", years));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
