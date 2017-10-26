package com.cloud.icenter.yyzx.fzjc.rk.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.rk.dao.PmigrantDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Eduincome;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Jobdistribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migrant;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migration;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Outflowsource;

/**
 * 人口流动
 * 
 * @author Administrator
 *
 */
@Repository
public class PmigrantDaoImpl extends BaseDaoImpl<Migrant> implements PmigrantDao {

	@Override
	public List<Migrant> getMigrantList() {
		String sql = "SELECT * FROM t_renk_ldrk_rkbh WHERE delete_state=0 ORDER BY tyear DESC";
		try {
			Query query = createSQLQuery(sql).addEntity(Migrant.class);
			query.setMaxResults(6);
			List<Migrant> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Eduincome> getEduincomeList() {
		String sql = "SELECT * FROM t_renk_ldrk_xlsr WHERE delete_state=0 ORDER BY eorder ASC";
		try {
			Query query = createSQLQuery(sql).addEntity(Eduincome.class);
			List<Eduincome> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 流出(入)人口职业分布(单位：万人)
	 * 
	 * @param type
	 *            1流出人口，2流入人口
	 */
	@Override
	public List<Jobdistribution> getJobdistributionByType(String type) {
		String sql = "SELECT * FROM t_renk_ldrk_zyfb WHERE type=" + type + " AND delete_state = 0";
		try {
			Query query = createSQLQuery(sql).addEntity(Jobdistribution.class);
			// query.setString("type", type);
			List<Jobdistribution> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Outflowsource> getOutflowsourceListByYear(String year) {
		String sql = "SELECT * FROM t_renk_ldrk_rkly WHERE tyear=" + year + " AND delete_state=0 GROUP BY city";
		try {
			Query query = createSQLQuery(sql).addEntity(Outflowsource.class);
			List<Outflowsource> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Migration> getMigrationList() {
		String sql = "SELECT * FROM t_renk_ldrk_dtsj WHERE delete_state=1";
		try {
			Query query = createSQLQuery(sql).addEntity(Migration.class);
			List<Migration> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * type 1 流出 0流入
	 */
	@Override
	public List<Migration> getDtsj(String type) {
		String sql;
		if ("1".equals(type)) {
			sql = "SELECT * FROM t_renk_ldrk_dtsj WHERE outmigrate='天水' and delete_state=0 order by number desc";
		} else {
			sql = "SELECT * FROM t_renk_ldrk_dtsj WHERE immigration='天水' and delete_state=0 order by number desc";
		}
		try {
			Query query = createSQLQuery(sql).addEntity(Migration.class);
			List<Migration> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取总流出人数和流入人数
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getLcAndLr() {
		String sql = "SELECT SUM(outflow) outsum,SUM(intoflow) intosum FROM t_renk_ldrk_rkbh WHERE delete_state = '0' and tyear='2017'";
		SQLQuery query = createSQLQuery(sql);// 记录
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}

}
