package com.cloud.icenter.yyzx.ztfx.jtcx.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjxlDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjxlPojo;

/**
 * @author dbchenga
 */
@Repository
public class GjxlDaoImpl extends BaseDaoImpl<GjxlPojo> implements GjxlDao {

	@Override
	public List<GjxlPojo> getAll() {
		try {
			// TODO Auto-generated method stub
			DetachedCriteria searDc = DetachedCriteria.forClass(GjxlPojo.class);
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
