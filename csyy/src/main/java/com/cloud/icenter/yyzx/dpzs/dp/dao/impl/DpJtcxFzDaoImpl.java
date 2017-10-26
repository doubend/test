package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJtcxFzDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxFzPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpJtcxFzDaoImpl extends BaseDaoImpl<DpJtcxFzPojo> implements
		DpJtcxFzDao {

	@Override
	public List<DpJtcxFzPojo> getCurFiveYear() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);

		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(DpJtcxFzPojo.class);
			searDc.add(Restrictions.gt("year", curYear - 7));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
