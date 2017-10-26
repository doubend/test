package com.cloud.icenter.yyzx.cszc.tjfx.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.cszc.tjfx.dao.CszcJyfzfxDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxDqPoJo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxDsjPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxNfPoJo;

/** 
* @author zhucy 
* @version 2017年4月20日 下午5:44:00 
* 说明 
*/
@Repository
public class CszcJyfzfxDaoImpl extends BaseDaoImpl<CszcJyfzfxNfPoJo> implements CszcJyfzfxDao{

	@Override
	public List<CszcJyfzfxNfPoJo> getJcjyfz() {
		String sql = "SELECT * FROM t_cszc_jyfzfx_nf a WHERE delete_status = 0 GROUP BY a.nian ORDER BY a.nian DESC LIMIT 5";
		try {
			Query query = createSQLQuery(sql).addEntity(CszcJyfzfxNfPoJo.class);
			List<CszcJyfzfxNfPoJo> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CszcJyfzfxNfPoJo> getZyjyfz() {
		String sql = "SELECT * FROM t_cszc_jyfzfx_nf a WHERE delete_status = 0 GROUP BY a.nian ORDER BY a.nian DESC LIMIT 5";
		try {
			Query query = createSQLQuery(sql).addEntity(CszcJyfzfxNfPoJo.class);
			List<CszcJyfzfxNfPoJo> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CszcJyfzfxDqPoJo> getJcjyfb() {
		String sql = "SELECT * FROM t_cszc_jyfzfx_dq a WHERE a.delete_status = 0 ";
		try {
			Query query = createSQLQuery(sql).addEntity(CszcJyfzfxDqPoJo.class);
			List<CszcJyfzfxDqPoJo> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CszcJyfzfxNfPoJo> getJyfzxq() {
		String sql = "SELECT *  FROM t_cszc_jyfzfx_nf a WHERE delete_status = 0 GROUP BY a.nian ORDER BY a.nian DESC LIMIT 5";
		try {
			Query query = createSQLQuery(sql).addEntity(CszcJyfzfxNfPoJo.class);
			List<CszcJyfzfxNfPoJo> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CszcJyfzfxDsjPojo> getDsjTopSix() {
		String sql = "SELECT * FROM t_cszc_jyfzfx_dsj WHERE delete_status = 0 ORDER BY create_time DESC LIMIT 6";
		try {
			Query query = createSQLQuery(sql).addEntity(CszcJyfzfxDsjPojo.class);
			List<CszcJyfzfxDsjPojo> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CszcJyfzfxDsjPojo> getDsjList() {
		String sql = "SELECT * FROM t_cszc_jyfzfx_dsj WHERE delete_status = 0 ORDER BY create_time DESC";
		try {
			Query query = createSQLQuery(sql).addEntity(CszcJyfzfxDsjPojo.class);
			List<CszcJyfzfxDsjPojo> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
