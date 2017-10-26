package com.cloud.icenter.yyzx.fzjc.fr.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FREconDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconNsPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconPojo;

/**
 * @author dbchenga
 */
@Repository
public class FREconDaoImpl extends BaseDaoImpl<FREconPojo> implements FREconDao {

	@Override
	public List<FREconPojo> getCurEcon() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			return getEconByYear(curYear - 1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FREconPojo> getEconByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(FREconPojo.class);
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

	@Override
	public List<FREconNsPojo> getCurEconNs() {
		// TODO Auto-generated method stub
		List<FREconPojo> list = getCurEcon();
		List<FREconNsPojo> nslist = new ArrayList<FREconNsPojo>();
		for (FREconPojo pojo : list) {
			FREconNsPojo ns = new FREconNsPojo();
			ns.setType(pojo.getType());
			ns.setNsnum(pojo.getNsnum());
			nslist.add(ns);
		}
		return nslist;
	}

	@Override
	public List<FREconNsPojo> getEconNsByYear(int year) {
		// TODO Auto-generated method stub
		List<FREconPojo> list = getEconByYear(year);
		List<FREconNsPojo> nslist = new ArrayList<FREconNsPojo>();
		for (FREconPojo pojo : list) {
			FREconNsPojo ns = new FREconNsPojo();
			ns.setType(pojo.getType());
			ns.setNsnum(pojo.getNsnum());
			nslist.add(ns);
		}
		return nslist;
	}

}
