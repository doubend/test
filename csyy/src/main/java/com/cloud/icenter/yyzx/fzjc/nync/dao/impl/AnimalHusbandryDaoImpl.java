
package com.cloud.icenter.yyzx.fzjc.nync.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.AnimalHusbandryDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalHusbandry;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;
import com.cloud.icenter.yyzx.common.query.AnimalClCl;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:25
*/
@Repository
public class AnimalHusbandryDaoImpl extends BaseDaoImpl<AnimalHusbandry> implements AnimalHusbandryDao {

	/*
	 * 获取最近一个年度的各类别出栏量和产值数据
	 */
	public List<AnimalHusbandry> getCurrentSum(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR)-1;
		try{
			DetachedCriteria criteria=DetachedCriteria.forClass(AnimalHusbandry.class);			
			criteria.add(Restrictions.eq("year", year));
			criteria.addOrder(Order.asc("lb"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 近5年猪牛羊马出栏量及存栏量
	 */
	public List<AnimalHusbandry> getHistoryStock(int lb){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR)-1;
		try{
			DetachedCriteria criteria=DetachedCriteria.forClass(AnimalHusbandry.class);			
			criteria.add(Restrictions.eq("lb", lb));
			criteria.addOrder(Order.asc("year"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 *牲畜总存栏量，出栏量，出栏率
	 */
	public List<AnimalClCl> getHistoryList(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR)-1;
		try{
			String sql="SELECT id,sum(cunll) as cunll,SUM(chull) as chull,chull/cunll as cll FROM t_nync_xmy_jbxx where lb in(1,2,3,4) and nf="+(year-5)
				    +" union all (SELECT id,sum(cunll) as cunll,SUM(chull) as chull,chull/cunll as cll FROM t_nync_xmy_jbxx where lb in(1,2,3,4) and nf="+(year-4)+")"
				    +" union all (SELECT id,sum(cunll) as cunll,SUM(chull) as chull,chull/cunll as cll FROM t_nync_xmy_jbxx where lb in(1,2,3,4) and nf="+(year-3)+")"
				    +" union all (SELECT id,sum(cunll) as cunll,SUM(chull) as chull,chull/cunll as cll FROM t_nync_xmy_jbxx where lb in(1,2,3,4) and nf="+(year-2)+")"
				    +" union all (SELECT id,sum(cunll) as cunll,SUM(chull) as chull,chull/cunll as cll FROM t_nync_xmy_jbxx where lb in(1,2,3,4) and nf="+(year-1)+")";
				    
					
					Query query=createSQLQuery(sql);
					
					List<AnimalClCl> historyList= query.list();
					
					return historyList;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
				
	}
	/*
	 * 畜牧业总产值、总出栏量
	 * 牲畜总产值、总出栏量
	 */
	public List<AnimalClCl> getCurrentList(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR)-1;
		try{
			String sql="SELECT id,sum(cz) as cz,SUM(chull) as chull FROM t_nync_xmy_jbxx where  nf="+year
					+" union all(SELECT id,sum(cz) as cz,SUM(chull) as chull FROM t_nync_xmy_jbxx where lb in(1,2,3,4) and nf="+year+")"
					+" union all(SELECT id,sum(cz) as cz,SUM(chull) as chull FROM t_nync_xmy_jbxx where lb in(5,6) and nf="+year+")";
			Query query=createSQLQuery(sql);
			List<AnimalClCl> currentList= query.list();			
			return currentList;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public List<BigDecimal> getDpzbList(){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR)-1;
		try{
			String sql=" SELECT sum(cz) as cz FROM t_nync_xmy_jbxx where lb in(1,2,3,4) and nf="+year
					+" union all(SELECT SUM(chull) as chull FROM t_nync_xmy_jbxx where lb in(1,2,3,4) and nf="+year+")"
					+" union all(SELECT sum(cz) as cz FROM t_nync_xmy_jbxx where lb in(5,6) and nf="+year+")"
					+" union all(SELECT SUM(chull) as chull FROM t_nync_xmy_jbxx where lb in(5,6) and nf="+year+")";
					List<Object> obj = new ArrayList<Object>();
			
					Query query=createSQLQuery(sql);
					List<BigDecimal> stringList= query.list();			
					return stringList;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}