package com.cloud.icenter.yyzx.dpzs.slp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpRkDbrqDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbrqPojo;

/**
 * @三联屏-人口-低保人群
 */
@Repository
public class SlpRkDbrqDaoImpl extends BaseDaoImpl<SlpRkDbrqPojo> implements
		SlpRkDbrqDao {

	@Override
	public List<SlpRkDbrqPojo> getCurDbrq() {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		try {
			DetachedCriteria searDc = DetachedCriteria
					.forClass(SlpRkDbrqPojo.class);
			searDc.add(Restrictions.eq("year", curYear));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
