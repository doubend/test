
package com.cloud.icenter.yyzx.fzjc.whly.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalHusbandry;
import com.cloud.icenter.yyzx.fzjc.whly.dao.TouristSourceDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TouristSource;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-14 15:34:32
*/
@Repository
public class TouristSourceDaoImpl extends BaseDaoImpl<TouristSource> implements TouristSourceDao {

	/*
	 * all top10
	 */
	public List<Map<String,Object>> getAll(){
		try{
			List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
			Map<String,Object> zykl=new HashMap<String,Object>();
			zykl.put("zykl", getZykl());
			Map<String,Object> zjykl=new HashMap<String,Object>();
			zjykl.put("zjykl", getZjykl());
			result.add(zykl);
			result.add(zjykl);
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 获取总游客量
	 */
	public List<TouristSource> getZykl(){
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		try{
			String sql="select * from t_whly_ly where nf="+curYear+" order by ykl desc";
			Query query=createSQLQuery(sql).addEntity(TouristSource.class);
			return query.list();
		
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 获取自驾游客量
	 */
	public List<TouristSource> getZjykl(){
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		try{
			String sql="select * from t_whly_ly where nf="+curYear+" order by zjy desc";
			Query query=createSQLQuery(sql).addEntity(TouristSource.class);
			return query.list();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}