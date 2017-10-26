package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpzsJjfzGmgyDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzGmgyPojo;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyTop;

/** 
* @author zhucy 
* @version 2017年4月11日 下午1:41:24 
* 说明 
*/
@Repository
public class DpzsJjfzGmgyDaoImpl extends BaseDaoImpl<DpzsJjfzGmgyPojo> implements DpzsJjfzGmgyDao{

	@Override
	public List<DpzsJjfzGmgyPojo> getDpzsJjfzGmgyList() {
		String sql = "SELECT * FROM t_dpzs_jjfz_gmgy WHERE delete_status=0 ORDER BY `year` DESC LIMIT 5";
		try {
			Query query = createSQLQuery(sql).addEntity(DpzsJjfzGmgyPojo.class);
			List<DpzsJjfzGmgyPojo> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 省内排名信息
	 * @return
	 */
	public List<Map<String, Object>> getSnpm(){
		String sql = "SELECT * FROM t_dpzs_jjfz_snpm ORDER BY mc LIMIT 4";
		SQLQuery query = createSQLQuery(sql);//记录
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}

}
