
package com.cloud.icenter.yyzx.fzjc.nync.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.nync.dao.SpecialProductDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;

/**
* @author: yaoli
* Date: 2017-03-02 18:32:42
*/
@Repository
public class SpecialProductDaoImpl extends BaseDaoImpl<SpecialProduct> implements SpecialProductDao {

	public List<SpecialProduct> getSpecialSummary(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR)-1;
		try{
			DetachedCriteria criteria=DetachedCriteria.forClass(SpecialProduct.class);			
			criteria.addOrder(Order.desc("year"));
			criteria.addOrder(Order.asc("lb"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public List<SpecialProduct> getSpecialInvestment(int specialType){
		try{
			DetachedCriteria criteria=DetachedCriteria.forClass(SpecialProduct.class);			
			criteria.add(Restrictions.eq("lb", specialType));
			criteria.addOrder(Order.asc("year"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}