package com.cloud.icenter.yyzx.ztfx.jtcx.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.util.Dzppzb;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjzbDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzbPojo;

/**
 * @author dbchenga
 */
@SuppressWarnings("all")
@Repository
public class GjzbDaoImpl extends BaseDaoImpl<GjzbPojo> implements GjzbDao {


	
	@Override
	public List<GjzbPojo> getCurGjzb() {
		try {
			Calendar now = Calendar.getInstance();
			int curYear = now.get(Calendar.YEAR);
			// TODO Auto-generated method stub
			DetachedCriteria searDc = DetachedCriteria.forClass(GjzbPojo.class);
			searDc.add(Restrictions.gt("year", curYear - 5));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<GjzbPojo> getGjzbByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(GjzbPojo.class);
			searDc.add(Restrictions.gt("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 公交停车时间
	 */
	@Override
	public List<?> getStopTimeList(String name, String dir) {
		String zt = getCurrentDayOfAgoOne();
		String sql = "SELECT ttbs. NAME,t.sj FROM t_traffic_bus_line ttbl "
				+ "LEFT JOIN t_traffic_bus_station ttbs ON ttbl.lineid = ttbs.lineid LEFT JOIN "
				+ "(SELECT FLOOR(AVG((tbd.date_time - tbd.arrival_time)))AS sj,gprs_id,site_index FROM t_bus_departure tbd"
				+ " WHERE DATE_FORMAT(tbd.arrival_time,'%Y-%m-%d') = '"+zt+"'AND DATE_FORMAT(tbd.date_time, '%Y-%m-%d') = '"+zt+"' GROUP BY tbd.site_index ORDER BY FLOOR(AVG((tbd.date_time - tbd.arrival_time))) DESC ) t "
				+ "ON t.gprs_id = ttbl.gprsid WHERE ttbl. NAME = '"+name+"' AND ttbs.dir = '"+dir+"' AND ttbs.orderno = t.site_index ORDER BY t.sj DESC limit 5;";
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<?> result =query.list();
		return result;
	}
	
	/** 
	 * 公交线路覆盖情况
	 */
	@Override
	public List<Map<String,Object>> getGjxlList(String name, String dir) {
		String sql111 = "select * from t_traffic_bus_line where name='"+name+"'";
		Query queryline = createSQLQuery(sql111);
		List<Map<String,Object>> list = queryline.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		Object obj = list.get(0).get("lineid");
		
		String sql = "SELECT a.name,(SELECT COUNT(*) FROM t_traffic_bus_line b "
				+ "WHERE b.lineid IN (SELECT c.lineid FROM t_traffic_bus_station c WHERE c.name = a.name)) AS count,"
				+ "(SELECT GROUP_CONCAT(b.`name`) FROM t_traffic_bus_line b WHERE b.lineid IN (SELECT c.lineid FROM t_traffic_bus_station c WHERE c.`name` = a.`name`)) AS xl "
				+ "FROM t_traffic_bus_station a WHERE a.dir = '"+dir+"' AND a.lineid = '"+obj+"' GROUP BY a.`name` ORDER BY count DESC LIMIT 5";
		//{1A9702B3-9FF5-4257-9893-E4A8E496DF1D}
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> result =query.list();
		return result;
	}
	/**
	 * 时间工具类
	 * @return
	 */
	public String getCurrentDayOfAgoOne(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); //得到前一天
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date).toString();
		//return "2017-07-25";
	}

	/**
	 * 出租车空载率
	 */
	public List<Map<String, Object>> getKzlList() {
		String sql = "SELECT xq,(case "
				+ "WHEN DATE_FORMAT(date_time,'%H') BETWEEN 0 AND 6 THEN '0-6' "
				+ "WHEN DATE_FORMAT(date_time,'%H') BETWEEN 7 AND 9 THEN '7-9' "
				+ "WHEN DATE_FORMAT(date_time,'%H') BETWEEN 10 AND 12 THEN '10-12' "
				+ "WHEN DATE_FORMAT(date_time,'%H') BETWEEN 13 AND 16 THEN '13-16' "
				+ "WHEN DATE_FORMAT(date_time,'%H') BETWEEN 17 AND 20 THEN '17-20' "
				+ "WHEN DATE_FORMAT(date_time,'%H') BETWEEN 21 AND 24 THEN '21-24'"
				+ "ELSE NULL END) as time,ROUND(avg(kzl)) zb "
				+ "from t_taxi_kzl GROUP BY xq,time";
		Query query = createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> result = query.list();
		return result;
	}
	/**
	 * 出租车营收情况
	 */
	@Override
	public List<Object> getYsList() {
		String sql = "select ROUND(avg(income)) as ys from t_taxi_yings where DATE_FORMAT(date_time,'%Y-%m-%d')='2017-08-12' group by HOUR(date_time)";
		Query query  =createSQLQuery(sql);
		List<Object> list = query.list();
		return list;
	}
	/**
	 * 出租车工作日平均速度
	 */
	@Override
	public List<Object> getWorkSpeedList() {
		String sql = "select ROUND(avg(speed)) from t_taxi_coordinate where DATE_FORMAT(date_time,'%Y-%m-%d')='2017-08-07' group by HOUR(date_time)";
		Query query  =createSQLQuery(sql);
		List<Object> list = query.list();
		return list;
	}
	/**
	 * 出租车周末平均速度
	 */
	@Override
	public List<Object> getWeekSpeedList() {
		String sql = "select ROUND(avg(speed)) from t_taxi_coordinate where DATE_FORMAT(date_time,'%Y-%m-%d') BETWEEN '2017-08-05' and '2017-08-06' group by HOUR(date_time)";
		Query query  =createSQLQuery(sql);
		List<Object> list = query.list();
		return list;
	}
	/**
	 * 出租车实时待客和载客情况
	 */
	@Override
	public List<Map<String, Object>> getZkDkList(String hour) {
		String sql = "select zk,dk from t_taxi_zkdk where DATE_FORMAT(date_time,'%H')<='"+hour+"' order by date_time";
		Query query  =createSQLQuery(sql);
		List<Map<String, Object>> list = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return list;
	}
	/**
	 * 出租车实时待客和载客情况当前时间
	 */
	@Override
	public List<Map<String, Object>> getSsZkDkList(String hour) {
		String sql = "select zk,dk from t_taxi_zkdk where DATE_FORMAT(date_time,'%H') ='"+hour+"' order by date_time";
		Query query  =createSQLQuery(sql);
		List<Map<String, Object>> list = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return list;
	}
	/**
	 * 出租车上客点排名
	 */
	@Override
	public List<Object> getTaxiSkdList(String type) {
		String sql;
		if(type.equals("工作日")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') BETWEEN '2017-08-14' AND '2017-08-18' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("假日")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') BETWEEN '2017-08-19' AND '2017-08-20' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("元旦")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-01-01' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("春节")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-01-28' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("元宵节")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-02-11' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("情人节")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-02-14' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("清明节")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-04-04' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("劳动节")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-05-01' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("端午节")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-05-30' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("中秋节")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-10-04' group by skd order by count(skd) desc limit 5;";
		}
		else if(type.equals("国庆节")){
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-10-01' group by skd order by count(skd) desc limit 5;";
		}else{
			sql = "select skd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-12-25' group by skd order by count(skd) desc limit 5;";
		}
		Query query  =createSQLQuery(sql);
		List<Object> list = query.list();
		return list;
	}
	/**
	 * 出租车下客点排名
	 */
	@Override
	public List<Object> getTaxiXkdList(String type) {
		String sql;
		if(type.equals("工作日")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') BETWEEN '2017-08-14' AND '2017-08-18' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("假日")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') BETWEEN '2017-08-19' AND '2017-08-20' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("元旦")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-01-01' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("春节")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-01-28' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("元宵节")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-02-11' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("情人节")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-02-14' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("清明节")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-04-04' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("劳动节")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-05-01' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("端午节")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-05-30' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("中秋节")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-10-04' group by xkd order by count(xkd) desc limit 5;";
		}
		else if(type.equals("国庆节")){
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-10-01' group by xkd order by count(xkd) desc limit 5;";
		}else{
			sql = "select xkd from t_taxi_od WHERE DATE_FORMAT(date_time, '%Y-%m-%d') ='2017-12-25' group by xkd order by count(xkd) desc limit 5;";
		}
		Query query  =createSQLQuery(sql);
		List<Object> list = query.list();
		return list;
	}

	

	

}
