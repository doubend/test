package com.cloud.icenter.yyzx.cstz.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.yyzx.cstz.dao.CstzYwtzDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwtzPojo;

/** 
* @author zhucy 
* @version 2017年4月5日 下午6:13:15 
* 说明 
*/
@Repository
public class CstzYwtzDaoImpl extends BaseDaoImpl<CstzYwtzPojo> implements CstzYwtzDao{

	@Override
	public List<CstzYwtzPojo> getListByYwzbId(String ywzbId) {
		List<CstzYwtzPojo> list = getCriteria().add(
				Restrictions.eq("ywzbId", ywzbId)).list();
		return list;
	}

	public Map<String, ?> getYwtzList(PagingUtil pagingUtil, String signId, String ywzbmc) {
//		final StringBuilder hql = new StringBuilder("SELECT new com.cloud.icenter.yyzx.cstz.pojo.CstzYwtzPojo(a.id, a.ywzbId, b.ywzbmc AS ywzbmc, a.code, a.yz, a.ylzcfw, a.zyzbs,a.jsgs,a.tbdz,a.createTime) ");
//		hql.append(" FROM CstzYwtzPojo a , CstzYwzbPojo b WHERE a.ywzbId = b.id AND a.deleteStatus = :deleteStatus ");
		String sql = "SELECT a.id,a.ywzb_id as ywzbId,b.ywzbmc AS ywzbmc,a.code,a.yz,a.ylzcfw,a.zyzbs,a.jsgs,a.tbdz,a.create_time as createTime"
				+ " FROM t_cstz_ywtz a LEFT JOIN t_cstz_ywzb b ON a.ywzb_id = b.id WHERE 1=1 AND a.delete_status = 0";
		if (!StringUtil.isEmpty(signId)) {//体征编码
			sql += " AND a.code like :code ";
		}
		if (!StringUtil.isEmpty(ywzbmc)) {//指标名称
			sql += " AND b.ywzbmc like :ywzbmc ";
		}
		sql = sql + " ORDER BY a.create_time DESC ";
		Query query = this.createSQLQuery(sql);
		Query countQuery = this.createSQLQuery(sql);
		if(!StringUtils.isEmpty(signId)){
			query.setParameter("code", "%"+signId+"%");
			countQuery.setParameter("code", "%"+signId+"%");
		}
		if (!StringUtil.isEmpty(ywzbmc)) {
			query.setParameter("ywzbmc", "%"+ywzbmc+"%");
			countQuery.setParameter("ywzbmc", "%"+ywzbmc+"%");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		int size = countQuery.list().size();//总记录数
		if(size>0){
			map.put("total", size);
			query.setFirstResult(pagingUtil.getPageStart());
			query.setMaxResults(pagingUtil.getRows());
			//查询结果是map对象，省去创建pojo;
			map.put("rows",query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list());
			List<Map<String,Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		}else{
			map.put("total",0);
			map.put("rows","");
		}
		return map;
	}

	@Override
	public CstzYwtzPojo getCstzYwtzPojoByYwzbId(String ywzbId) {
		return super.get(CstzYwtzPojo.class, "ywzbId", ywzbId);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
