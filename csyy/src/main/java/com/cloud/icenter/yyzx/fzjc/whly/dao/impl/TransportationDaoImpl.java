package com.cloud.icenter.yyzx.fzjc.whly.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.TransportationDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.Transportation;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:42:49
*/
@Repository
public class TransportationDaoImpl extends BaseDaoImpl<Transportation> implements TransportationDao {

	public List<Transportation> getTrans(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR);
		try{
			DetachedCriteria  criteria=DetachedCriteria.forClass(Transportation.class);
			criteria.add(Restrictions.eq("year",year));
			criteria.addOrder(Order.desc("tansCode"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}