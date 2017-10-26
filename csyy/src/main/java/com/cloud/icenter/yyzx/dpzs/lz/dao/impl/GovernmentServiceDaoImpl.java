package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.AnimalClCl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.PrimaryIndustry;
import com.cloud.icenter.yyzx.dpzs.lz.dao.GovernmentServiceDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovernmentService;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
@Repository
public class GovernmentServiceDaoImpl extends BaseDaoImpl<GovernmentService> implements GovernmentServiceDao {

	/*
	 * 统计当日 
	 * 1:已预受理；2：正在受理；3：已受理；4：已办结；
	 */
	public List<Tourism> getDayData(){
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		int day=now.get(Calendar.DAY_OF_MONTH);
		try{			

			String sql="SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where rq=CURDATE() and  blztdm=1"
					+" union all(SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where rq=CURDATE()  and  blztdm=2)"
					+" union all(SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where rq=CURDATE()  and blztdm=3)"
					+" union all(SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where rq=CURDATE()  and  blztdm=4)"
					+"ORDER BY blztdm";			
			/*String sql="SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where rq=CURDATE() and  blztdm=1"
					+"union (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where rq=CURDATE()  and  blztdm=2)"
					+"union (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where rq=CURDATE()  and blztdm=3)"
					+"union (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where rq=CURDATE()  and  blztdm=4)"
					+"ORDER BY blztdm";*/
			
			Query query=createSQLQuery(sql);
			List<Tourism> result=query.list();
			return result;
			
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	/*
	 * 统计当月政务事项情况
	 */
	public List<Tourism> getMonthData(){
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		int day=now.get(Calendar.DAY_OF_MONTH);
		try{
			String sql="SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where month(rq)="+month +"  and  blztdm=1"
					+" union all (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where month(rq)="+month +"  and  blztdm=2)"
					+" union all (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where month(rq)="+month +"  and blztdm=3)"
					+" union all (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where month(rq)="+month +"  and  blztdm=4)"
					+" ORDER BY blztdm";
			Query query=createSQLQuery(sql);
			List<Tourism> result=query.list();
			return result;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 统计当年政务事项情况
	 */
	public List<Tourism> getYearData(){
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		int day=now.get(Calendar.DAY_OF_MONTH);
		try{
			String sql="SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where year(rq)="+year +"  and  blztdm=1"
					+"  union all (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where year(rq)="+year +"  and  blztdm=2)"
					+" union  all (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where year(rq)="+year +"  and blztdm=3)"
					+" union all (SELECT count(*) as account,blztdm FROM `t_zwfw_sx_detail` where year(rq)="+year +"  and  blztdm=4)"
					+" ORDER BY blztdm";
			Query query=createSQLQuery(sql);
			List<Tourism> result=query.list();
			return result;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}