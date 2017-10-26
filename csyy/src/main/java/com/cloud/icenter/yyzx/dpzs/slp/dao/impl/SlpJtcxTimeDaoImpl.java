package com.cloud.icenter.yyzx.dpzs.slp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpJtcxTimeDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTimePojo;

/**
 * @author dbchenga
 */
@Repository
public class SlpJtcxTimeDaoImpl extends BaseDaoImpl<SlpJtcxTimePojo> implements SlpJtcxTimeDao {

	@Override
	public List<SlpJtcxTimePojo> getTimeHotspot() {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(SlpJtcxTimePojo.class);
			// searDc.add(Restrictions.eq("rq", str));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
