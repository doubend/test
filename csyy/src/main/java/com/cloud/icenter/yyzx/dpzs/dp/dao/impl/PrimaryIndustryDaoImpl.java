package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.PrimaryIndustryDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.PrimaryIndustry;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalHusbandry;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:41:24
*/
@Repository
public class PrimaryIndustryDaoImpl extends BaseDaoImpl<PrimaryIndustry> implements PrimaryIndustryDao {
	
	public List<PrimaryIndustry> getPrimaryIndustry(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR);
		try{
			DetachedCriteria criteria=DetachedCriteria.forClass(PrimaryIndustry.class);			
			criteria.add(Restrictions.eq("nf", year));
			criteria.addOrder(Order.asc("cylxbm"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	
	}

}