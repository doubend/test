
package com.cloud.icenter.yyzx.fzjc.nync.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.PlantingDistributionDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingDistribution;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;

/**
* @author: yaoli
* Date: 2017-03-02 18:03:47
*/
@Repository
public class PlantingDistributionDaoImpl extends BaseDaoImpl<PlantingDistribution> implements PlantingDistributionDao {
	public List<PlantingDistribution> getDistribution(){
		Calendar today=Calendar.getInstance();
		int year=today.get(Calendar.YEAR);
		try{
			DetachedCriteria criteria=DetachedCriteria.forClass(PlantingDistribution.class);			
			criteria.add(Restrictions.eq("year", year-1));
			criteria.addOrder(Order.asc("qydm"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}