
package com.cloud.icenter.yyzx.fzjc.whly.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.TourismTimeDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketWay;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TourismTime;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:07
*/
@Repository
public class TourismTimeDaoImpl extends BaseDaoImpl<TourismTime> implements TourismTimeDao {
	/*
	 * 不同购票方式统计
	 */
	public List<TourismTime> getYkl(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR);
		try{
			String sql="SELECT * from t_whly_spl_sj where rq=(SELECT Max(rq) FROM `t_whly_spl_sj`) ORDER BY sjdbm";
			Query query=createSQLQuery(sql).addEntity(TourismTime.class);
			List<TourismTime>  result=query.list();
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}