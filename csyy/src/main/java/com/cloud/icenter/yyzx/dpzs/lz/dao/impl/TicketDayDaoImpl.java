package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.TicketDayDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.SourceDay;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketDay;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:43:34
*/
@Repository
public class TicketDayDaoImpl extends BaseDaoImpl<TicketDay> implements TicketDayDao {

	/**
	 * 近一周票务量统计
	 * 总票务量、入园量、接待量、入园车辆、日均入园量
	 * @return
	 */
	public List<Tourism> getDayTicket(){
		try{
			String sql="SELECT SUM(zpwl)as zpwl,SUM(ryl)as ryl,SUM(jdl),SUM(rycl),CEIL(ryl/7)as rjryl FROM `t_whly_pwl_day` where"
					+ " rq>DATE_SUB(NOW(),INTERVAL 7 day);";
			/*String sql="SELECT SUM(zpwl)as zpwl,SUM(ryl)as ryl,SUM(jdl)as jdl,SUM(rycl)as rycl,CEIL(ryl/7)as rjryl FROM `t_whly_pwl_day` where"
					+ " rq>DATE_SUB('2017-04-01',INTERVAL 7 day);";*/
			Query query=createSQLQuery(sql);	
			List<Tourism> result=query.list();
			return result;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 近一年票务量
	 * 总票务量、入园量、接待量、入园车辆、日均入园量、日均入园车辆
	 */
	public List<Tourism> getYearTicket(){
		try{
			String sql="SELECT SUM(zpwl)as zpwl,SUM(ryl)as ryl,SUM(jdl)as jdl,SUM(rycl)as rycl,CEIL(ryl/365)as rjryl,CEIL(rycl/365)as rjrycl FROM `t_whly_pwl_day` where"
					+ " rq>DATE_SUB(NOW(),INTERVAL 1 year);";
			Query query=createSQLQuery(sql);
			List<Tourism> result=query.list();
			return result;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 某一年票务量
	 * 总票务量、入园量、接待量、入园车辆、日均入园量、日均入园车辆
	 */
	public List<Tourism> getOneYearTicket(int year){
		int queryYear=year;
		int queryLastYear=year-1;
		try{
			String sql="select CEIL(a.jdl/10000) as jdl,CEIL(((a.jdl-b.jdl)/a.jdl)*100) as increase from (SELECT SUM(jdl)as jdl FROM `t_whly_pwl_day` where  YEAR(rq)="+queryYear+")a,"
					+"(SELECT SUM(jdl)as jdl FROM `t_whly_pwl_day` where  YEAR(rq)="+queryLastYear+")b";
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