package com.cloud.icenter.yyzx.dpzs.slp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpJtcxRdDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxRdmapPojo;

/**
 * @author dbchenga
 */
@Repository
public class SlpJtcxRdDaoImpl extends BaseDaoImpl<SlpJtcxRdmapPojo> implements
		SlpJtcxRdDao {

	@Override
	public List<SlpJtcxRdmapPojo> getYesterdayRd() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH) - 1;

		String str = curYear + "-";

		if (month < 10) {
			str += "0" + month + "-";
		} else {
			str += month + "-";
		}

		if (day < 10) {
			str += "0" + day;
		} else {
			str += day;
		}
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(SlpJtcxRdmapPojo.class);
//			searDc.add(Restrictions.eq("rq", str));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
