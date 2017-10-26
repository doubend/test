package com.cloud.icenter.yyzx.ztfx.jtcx.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjzdDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzdPojo;

/**
 * @author dbchenga
 */
@Repository
public class GjzdDaoImpl extends BaseDaoImpl<GjzdPojo> implements GjzdDao {

	@Override
	public List<GjzdPojo> getGjzdByGjcno(int gjc_no) {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(GjzdPojo.class);
			searDc.add(Restrictions.eq("gjc_no", gjc_no));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
