package com.cloud.icenter.yyzx.ztfx.jzfp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jzfp.dao.PoorPopulationDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPopulationPojo;

/**
 * @author dbchenga
 */
@Repository
public class PoorPopulationDaoImpl extends BaseDaoImpl<PoorPopulationPojo>
		implements PoorPopulationDao {

	@Override
	public List<PoorPopulationPojo> getCurPopulationFiveYear() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			// TODO Auto-generated method stub
			DetachedCriteria searDc = DetachedCriteria
					.forClass(PoorPopulationPojo.class);
			searDc.add(Restrictions.gt("year", curYear - 6));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
