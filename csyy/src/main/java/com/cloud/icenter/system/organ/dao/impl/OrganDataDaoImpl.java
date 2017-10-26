package com.cloud.icenter.system.organ.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.organ.dao.OrganDataDao;
import com.cloud.icenter.system.organ.pojo.OrganData;

@Repository
public class OrganDataDaoImpl extends BaseDaoImpl<OrganData> implements OrganDataDao{

	@Override
	public void add(OrganData obj) {
		obj.setSeqNum(getNextSeqNum());
		obj.setCreatedAt(new Date());
		super.add(obj);
	}
	
	@Override
	public List<OrganData> getDataByOrganId(String organId){
		Criteria criteria=getCriteria();
		criteria.add(Restrictions.eq("orgId", organId));
		criteria.addOrder(Order.asc("seqNum"));
		return criteria.list();
	}
	
	@Override
	public void add(String organId,OrganData[] organDatas) {
		
		if(organDatas==null) return;
		for(OrganData data:organDatas) {
			if(StringUtil.isEmpty(data.getId())) {
				data.setOrgId(organId);
				add(data);
			} else{
				update(data);
			}
		}
		
		//清除无效的脏数据
		if(organDatas.length==0) {
			executeUpdate("delete OrganData where orgId=?", organId);
		} else {
			Query query=createQuery("delete OrganData where orgId=:orgId and id not in(:dataId)");
			query.setString("organId", organId);
			query.setParameterList("dataId", toIdArray(organDatas));
			query.executeUpdate();
		}
	}
	
	private String[] toIdArray(OrganData[] datas) {
		String[] id=new String[datas.length];
		for(int i=0;i<datas.length;i++) {
			id[i]=datas[i].getId();
		}
		return id;
	}
}
