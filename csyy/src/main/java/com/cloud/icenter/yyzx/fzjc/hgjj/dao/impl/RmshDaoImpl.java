package com.cloud.icenter.yyzx.fzjc.hgjj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.hgjj.dao.RmshDao;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshGksj;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshShru;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshXfjg;
/**
 * 人民生活
 * @author Administrator
 *
 */
@Repository
public class RmshDaoImpl extends BaseDaoImpl<RmshGksj> implements RmshDao {

	@Override
	public RmshGksj getRmshGksj() {
		String sql = "SELECT * FROM t_rmsh_gksj WHERE delete_state=0 AND nian = (SELECT MAX(nian) FROM t_rmsh_gksj) LIMIT 1";
		try {
			Query query = createSQLQuery(sql).addEntity(RmshGksj.class);
			List<RmshGksj> list = query.list();
			if (null != list && list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RmshLnsh> getRmshLnshList() {
		String sql = "SELECT * FROM t_rmsh_lnsh WHERE delete_state=0 ORDER BY nian DESC LIMIT 5";
		try {
			Query query = createSQLQuery(sql).addEntity(RmshLnsh.class);
			List<RmshLnsh> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RmshXfjg> getRmshXfjgList() {
		String sql = "SELECT * FROM t_rmsh_xfjg WHERE nian=(SELECT MAX(nian) FROM t_rmsh_xfjg) AND delete_state=0 ORDER BY yuef ASC";
		try {
			Query query = createSQLQuery(sql).addEntity(RmshXfjg.class);
			List<RmshXfjg> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RmshShru getRmshShruList() {
		String sql = "SELECT * FROM t_rmsh_shru WHERE delete_state=0";
		try {
			Query query = createSQLQuery(sql).addEntity(RmshShru.class);
			if(query.list()==null){
				return null;
			}
			return (RmshShru) query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
