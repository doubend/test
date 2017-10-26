
package com.cloud.icenter.yyzx.fzjc.whly.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.HolidayTouristDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:40:00
*/
@Repository
public class HolidayTouristDaoImpl extends BaseDaoImpl<HolidayTourist> implements HolidayTouristDao {

	/*
	 * 节假日游客量统计
	 */
	public List<HolidayTourist> getYkl(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR);
		try{
			DetachedCriteria  criteria=DetachedCriteria.forClass(HolidayTourist.class);
			criteria.add(Restrictions.eq("nf",year));
			criteria.addOrder(Order.asc("jjrbm"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}