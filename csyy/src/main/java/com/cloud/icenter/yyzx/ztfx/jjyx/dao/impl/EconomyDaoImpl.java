package com.cloud.icenter.yyzx.ztfx.jjyx.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.ztfx.jjyx.dao.EconomyDao;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Economy;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Equipment;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Industrytotal;
import com.cloud.icenter.yyzx.ztfx.jjyx.pojo.Situation;
/**
 * 工业经济总体表
 * @author Administrator
 *
 */
@Repository
public class EconomyDaoImpl extends BaseDaoImpl<Economy> implements EconomyDao{

	@Override
	public List<Economy> getEconomyLizt() {
		String sql = "SELECT * FROM t_jjfz_jjyx_gail WHERE delete_state=0 ORDER BY tyear DESC LIMIT 5";
		try {
			Query query = createSQLQuery(sql).addEntity(Economy.class);
			List<Economy> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Industrytotal> getIndustrytotalListByYear(String year) {
		String sql = "SELECT * FROM t_jjfz_jjyx_ghyz WHERE tyear=(SELECT MAX(tyear) FROM t_jjfz_jjyx_ghyz) AND delete_state=0";
		try {
			Query query = createSQLQuery(sql).addEntity(Industrytotal.class);
			List<Industrytotal> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Equipment> getEquipmentListByYear(String year) {
		String sql = "SELECT * FROM t_jjfz_jjyx_zdzb WHERE tyear=(SELECT MAX(tyear) FROM t_jjfz_jjyx_zdzb) AND delete_state=0";
		try {
			Query query = createSQLQuery(sql).addEntity(Equipment.class);
			List<Equipment> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Situation getMaxSituation() {
		String sql = "SELECT * FROM t_jjfz_jjyx_jjgk WHERE delete_state=0 ORDER BY tyear DESC LIMIT 1";
		try {
			Query query = createSQLQuery(sql).addEntity(Situation.class);
			List<Situation> list = query.list();
			if (null != list && list.size() > 0 ) {
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}


}
