
package com.cloud.icenter.yyzx.fzjc.whly.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.TicketTypeDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketType;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketWay;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:40:50
*/
@Repository
public class TicketTypeDaoImpl extends BaseDaoImpl<TicketType> implements TicketTypeDao {
	/*
	 * 不同票种售票量
	 */
	public List<TicketType> getYkl(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR);
		try{
			DetachedCriteria  criteria=DetachedCriteria.forClass(TicketType.class);
			criteria.add(Restrictions.eq("nf",year));
			criteria.addOrder(Order.desc("pzlxbm"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}