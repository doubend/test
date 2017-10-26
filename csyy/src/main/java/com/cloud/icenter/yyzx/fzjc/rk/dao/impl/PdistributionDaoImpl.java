package com.cloud.icenter.yyzx.fzjc.rk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.rk.dao.PdistributionDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Distribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Scale;

/**
 * 
 * @author Administrator
 *
 */
@Repository
public class PdistributionDaoImpl extends BaseDaoImpl<Distribution> implements PdistributionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Distribution> getPdistributionByYear(String year) {
		String sql = "SELECT * FROM t_renk_rkfb_rkfb WHERE tyear=" + year + " GROUP BY city";
		try {
			Query query = createSQLQuery(sql).addEntity(Distribution.class);
			List<Distribution> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Scale> getSixNumber() {
		String sql = "SELECT * FROM t_renk_ldrk_fuyb WHERE delete_state=0 ORDER BY tyear DESC";
		try {
			Query query = createSQLQuery(sql).addEntity(Scale.class);
			query.setMaxResults(6);
			List<Scale> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Newborn> getNewBornList() {
		String sql = "SELECT * FROM t_renk_ldrk_xsyr WHERE delete_state=0";
		try {
			Query query = createSQLQuery(sql).addEntity(Newborn.class);
			query.setMaxResults(9);
			List<Newborn> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Agestructure> getAgestructureList() {
		String sql = "SELECT * FROM t_renk_rkfb_nljg WHERE delete_state=0  ORDER BY segment_min ASC";
		try {
			Query query = createSQLQuery(sql).addEntity(Agestructure.class);
			List<Agestructure> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
