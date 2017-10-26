package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpzsJjfzDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzPojo;

/** 
* @author zhucy 
* @version 2017年3月28日 上午11:06:48 
* 大屏展示经济发展
*/
@Repository
public class DpzsJjfzDaoImpl extends BaseDaoImpl<DpzsJjfzPojo> implements DpzsJjfzDao{

	@Override
	public List<DpzsJjfzPojo> getList() {
		String sql = "SELECT * FROM t_dpzs_jjfz WHERE delete_status=0 ORDER BY nian DESC LIMIT 1";
		try {
			Query query = createSQLQuery(sql).addEntity(DpzsJjfzPojo.class);
			List<DpzsJjfzPojo> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
