package com.cloud.icenter.yyzx.fzjc.hgjj.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.hgjj.dao.GmgyDao;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyCzgc;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyTop;
/**
 * 规模工业
 * @author Administrator
 *
 */
@Repository
public class GmgyDaoImpl extends BaseDaoImpl<GmgyLnsh> implements GmgyDao{

	@Override
	public List<GmgyLnsh> getGmgyLnshList() {
		String sql = "SELECT * FROM t_jjfz_gmgy_lnsj WHERE delete_state=0 ORDER BY nian DESC LIMIT 5";
		try {
			Query query = createSQLQuery(sql).addEntity(GmgyLnsh.class);
			List<GmgyLnsh> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<GmgyTop> getGmgyTopList() {
		String sql = "SELECT * FROM t_jjfz_gmgy_top WHERE delete_state=0 ORDER BY nian DESC LIMIT 5";
		try {
			Query query = createSQLQuery(sql).addEntity(GmgyTop.class);
			List<GmgyTop> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<GmgyCzgc> getGmgyCzgcList() {
		Calendar a=Calendar.getInstance();
		int year = a.get(Calendar.YEAR) - 1;
		String sql = "SELECT * FROM t_jjfz_gmgy_czgc WHERE nian="+year+" AND delete_state=0 ORDER BY id ASC";
		try {
			Query query = createSQLQuery(sql).addEntity(GmgyCzgc.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
