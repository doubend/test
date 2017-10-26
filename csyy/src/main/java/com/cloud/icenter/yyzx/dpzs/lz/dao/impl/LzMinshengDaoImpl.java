package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.lz.dao.LzMinshengDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzMinshengPojo;

/**
 * @author dbchenga
 */
@Repository
public class LzMinshengDaoImpl extends BaseDaoImpl<LzMinshengPojo> implements
		LzMinshengDao {

	@Override
	public List<LzMinshengPojo> getCurMinsheng() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			return getMinshengByYear(curYear);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LzMinshengPojo> getMinshengByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(LzMinshengPojo.class);
			searDc.add(Restrictions.gt("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LzMinshengPojo> getCurMinsheng(int type) {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			DetachedCriteria searDc = DetachedCriteria
					.forClass(LzMinshengPojo.class);
			searDc.add(Restrictions.eq("year", curYear));
			searDc.add(Restrictions.eq("type", type));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
