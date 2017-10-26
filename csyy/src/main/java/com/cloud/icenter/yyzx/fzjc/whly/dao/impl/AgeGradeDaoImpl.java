
package com.cloud.icenter.yyzx.fzjc.whly.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.AgeGradeDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.AgeGrade;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.CardType;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:51:43
*/
@Repository
public class AgeGradeDaoImpl extends BaseDaoImpl<AgeGrade> implements AgeGradeDao {
	public List<AgeGrade> getAgeGrade(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR);
		try{
			DetachedCriteria  criteria=DetachedCriteria.forClass(AgeGrade.class);
			criteria.add(Restrictions.eq("year",year-1));
			criteria.addOrder(Order.asc("nldbh"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}