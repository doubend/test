package com.cloud.icenter.yyzx.dpzs.slp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpJtcxTenDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTenPojo;

/**
 * @author dbchenga
 */
@Repository
public class SlpJtcxTenDaoImpl extends BaseDaoImpl<SlpJtcxTenPojo> implements SlpJtcxTenDao {

	@Override
	public List<SlpJtcxTenPojo> getTenHotspot() {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(SlpJtcxTenPojo.class);
			// searDc.add(Restrictions.eq("rq", str));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
