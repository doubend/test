
package com.cloud.icenter.yyzx.fzjc.whly.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.MonthTouristDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.MonthTourist;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:45
*/
@Repository
public class MonthTouristDaoImpl extends BaseDaoImpl<MonthTourist> implements MonthTouristDao {
	/*
	 * 游客量季节变化统计
	 */
	public List<MonthTourist> getYkl(){
		try{
			String sql="select * from t_whly_spl ORDER BY nf DESC,yf desc LIMIT 12";
		    Query query=createSQLQuery(sql).addEntity(MonthTourist.class);
		    List<MonthTourist> list=query.list();
		    return list;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}