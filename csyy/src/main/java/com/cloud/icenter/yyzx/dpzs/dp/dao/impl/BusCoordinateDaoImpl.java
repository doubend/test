package com.cloud.icenter.yyzx.dpzs.dp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.BusCoordinateDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.BusCoordinate;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalHusbandry;
import com.google.common.base.Strings;

/**
* Created with gender.
* @author: liyao
* Date: 2017-05-27 10:59:02
*/
@Repository
public class BusCoordinateDaoImpl extends BaseDaoImpl<BusCoordinate> implements BusCoordinateDao {	
	//查询实时公交位置信息	
	public JSONObject getBusCoordinates(){
		String sql="SELECT MAX(t.create_date),t.onboard_id,t.gprs_id,t.lng_du,t.lng_fen,t.lat_du,t.lat_fen "
				+" FROM bus.t_bus_coordinate  t where DATE(t.create_date)=DATE(NOW()) GROUP BY t.onboard_id";
		JSONObject stationsJsonObject=new JSONObject();
		Map<String, ?> map=commonQuery(sql);
		stationsJsonObject.put(Integer.toString(0), map);
		return stationsJsonObject;	
	}
	//查询实时出租车位置信息
	public JSONObject getTaxiCoordinates(){
		String sql="SELECT * FROM  bus.t_traffic_bus_station  ORDER BY id";
		JSONObject stationsJsonObject=new JSONObject();
		Map<String, ?> map=commonQuery(sql);
		stationsJsonObject.put(Integer.toString(0), map);
		return stationsJsonObject;		
	}
	//根据公交线路名称，运营方向，查询该线路所有站点信息
	public JSONObject getBusStations(String linename,String dir){		
		String sql="SELECT	* FROM	bus.t_traffic_bus_station WHERE	lineid = (SELECT t.lineid FROM bus.t_traffic_bus_line t"
				+ "	WHERE	t. NAME ='"+linename+"') AND dir = "+dir+" ORDER BY	orderno";
		JSONObject stationsJsonObject=new JSONObject();
		Map<String, ?> map=commonQuery(sql);
		stationsJsonObject.put(Integer.toString(0), map);
		return stationsJsonObject;	
	}
	//查询公交线路列表
	public JSONObject getBusLines() {
		String sql="SELECT * FROM bus.t_traffic_bus_line GROUP BY lineid";
		JSONObject stationsJsonObject=new JSONObject();
		Map<String, ?> map=commonQuery(sql);
		stationsJsonObject.put(Integer.toString(0), map);
		return stationsJsonObject;
	}
	//按线路查询正在运行的公交车
	public JSONObject queryBusByLine(String linename,String dir){
		String sql="SELECT * from (SELECT t.onboard_id,t.gprs_id,t.status_streamflg,t.speed,t.lng_du,t.lng_fen,t.lat_du,t.lat_fen "
				+" FROM bus.t_bus_coordinate  t where DATE(t.create_date)=DATE(NOW()) GROUP BY t.onboard_id) t1 where "
				+" t1.gprs_id=(SELECT t2.gprsid from bus.t_traffic_bus_line t2 WHERE t2.name='"+linename+"') and t1.status_streamflg="+dir;		
		JSONObject stationsJsonObject=new JSONObject();
		Map<String, ?> map=commonQuery(sql);
		stationsJsonObject.put(Integer.toString(0), map);
		return stationsJsonObject;
	}
	//拼装线路及其对应的起始站数据
	public JSONObject lineStartEnd(){
		String sql="SELECT	* FROM	(SELECT	t5.`NAME` AS linename,t5.lineid AS lineid,t6. NAME AS station,t6.orderno AS orderno,t6.dir AS dir "
				+" FROM(SELECT	t4. NAME,	t4.lineid,MIN(t4.orderno) AS orderno	FROM	(SELECT	*	FROM(SELECT	t1. NAME,t1.lineid,t2. NAME AS stations,"
				+"t2.dir,t2.orderno	FROM	bus.t_traffic_bus_line t1	RIGHT JOIN bus.t_traffic_bus_station t2 ON t1.lineid = t2.lineid "
				+"ORDER BY	t1.lineid) t3	WHERE	t3.dir = 0) AS t4	GROUP BY	t4. NAME) t5	LEFT JOIN bus.t_traffic_bus_station t6 ON t6.lineid = t5.lineid "
				+"AND t6.orderno = t5.orderno		AND t6.dir = 0	UNION ALL (SELECT	t5.`NAME` AS linename,t5.lineid AS lineid,t6. NAME AS station,t6.orderno AS orderno,"
				+"t6.dir AS dir	FROM(SELECT t4. NAME,t4.lineid,MAX(t4.orderno) AS orderno	FROM(SELECT	* FROM(SELECT	t1. NAME,t1.lineid,t2. NAME AS stations,"
				+"t2.dir,t2.orderno	FROM	bus.t_traffic_bus_line t1	RIGHT JOIN bus.t_traffic_bus_station t2 ON t1.lineid = t2.lineid "
				+"ORDER BY	t1.lineid) t3	WHERE	t3.dir = 0) AS t4	GROUP BY t4. NAME) t5	LEFT JOIN bus.t_traffic_bus_station t6 ON t6.lineid = t5.lineid	AND "
				+"t6.orderno = t5.orderno	AND t6.dir = 0)) t7 ORDER BY	t7.linename,t7.orderno";
		JSONObject stationsJsonObject=new JSONObject();
		Map<String, ?> map=commonQuery(sql);
		stationsJsonObject.put(Integer.toString(0), map);
		return stationsJsonObject;
	}
	//根据sql语句查询数据
	public Map<String,?> commonQuery(String sql){		
		try{		
			
			List<Object> obj = new ArrayList<Object>();
			
			SQLQuery query = createSQLQuery(sql);//记录
			SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
			
			Map<String,Object> map = new HashMap<String,Object>();
			int size = querySize.list().size();//总记录数
			if(size>0){
				map.put("total", querySize.list().get(0));
				map.put("rows",query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list());
			}else{
				map.put("total",0);
				map.put("rows","");
			}
			return map;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}