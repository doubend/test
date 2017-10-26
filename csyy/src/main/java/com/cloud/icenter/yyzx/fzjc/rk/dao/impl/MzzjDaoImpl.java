package com.cloud.icenter.yyzx.fzjc.rk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.rk.dao.MzzjDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Distribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjAreaResult;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjResult;
/**
 * 民族宗教
 * @date 2017年9月27日
 * @author dxliug
 */
@Repository
public class MzzjDaoImpl extends BaseDaoImpl<MzzjResult> implements MzzjDao {
    
	@Override
	public List<MzzjResult> getRenkMzzj(String year) {
		String sql = "SELECT * FROM t_renk_rkfb_mzzj where tyear = " + year;
		try {
			Query query = createSQLQuery(sql).addEntity(MzzjResult.class);
			List<MzzjResult> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MzzjAreaResult> getRenkMzzjArea(String year) {
		String sql = "SELECT * FROM t_renk_rkfb_mzzj_area where tyear = " + year;
		try {
			Query query = createSQLQuery(sql).addEntity(MzzjAreaResult.class);
			List<MzzjAreaResult> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Agestructure> getRenkMzzjAge(String year) {
		String sql = "SELECT * FROM t_renk_rkfb_mzzj_age where delete_state = 0  ORDER BY segment_min ASC";
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
