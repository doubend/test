package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpFrzbDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrzbPojo;

/**
 * @author dbchenga
 */
@Repository
public class DpFrzbDaoImpl extends BaseDaoImpl<DpFrFrzbPojo> implements DpFrzbDao {

	@Override
	public List<DpFrFrzbPojo> getCurFrzb(int year, String qyhy, String qyxz) {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(DpFrFrzbPojo.class);
			searDc.add(Restrictions.eq("year", year));
			if (qyhy != null) {
				searDc.add(Restrictions.eq("qyhy", qyhy));
			}
			if (qyxz != null) {
				searDc.add(Restrictions.eq("qyxz", qyxz));
			}
			return super.find(searDc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
