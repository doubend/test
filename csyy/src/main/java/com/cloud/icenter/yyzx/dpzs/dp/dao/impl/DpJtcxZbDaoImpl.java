package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpJtcxZbDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxZbPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpJtcxZbDaoImpl extends BaseDaoImpl<DpJtcxZbPojo> implements
		DpJtcxZbDao {

	@Override
	public List<DpJtcxZbPojo> getCurZb() {
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
					.forClass(DpJtcxZbPojo.class);

			searDc.addOrder(Order.asc("wz"));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
