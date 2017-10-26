package com.cloud.icenter.yyzx.ztfx.jtcx.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GjcsdDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GJxlYdfxPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;
@Repository
public class GjcsdDaoImpl extends BaseDaoImpl<GjcsdPojo> implements GjcsdDao{
	

	
	public String getCurrentDayOfAgoOne(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); //得到前一天
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date).toString();
//		return "2017-07-25";
	}
	/**
	 * 上行平均速度
	 */
	@Override
	public void writeSxData() {
		//昨天的年月日时间
		
			String zt = getCurrentDayOfAgoOne();
			//时间段
			//String[] timeGroup = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
			//查询线路
			String xlSql = "SELECT * FROM t_traffic_bus_line GROUP BY name ORDER BY REPLACE(name,'路','')+0 ASC;";
			Query xlQuery = createSQLQuery(xlSql);
			List<Map<String, Object>> xlList = xlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			//存放计算出的拥堵数据
			List<GjcsdPojo> ydsjList = new ArrayList<GjcsdPojo>();
			for (Map<String, Object> map : xlList) {
				System.out.println("获取平均速度"+"----------"+map.get("name").toString());
				//获取线路上行站点
				String sxzdSql = "SELECT * FROM t_traffic_bus_station WHERE lineid = '"+map.get("lineid")+"' AND dir = 0 ORDER BY orderno;";
				Query sxzdQuery = createSQLQuery(sxzdSql);
				List<Map<String, Object>> sxzdList = sxzdQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				//站点分段 假如有10个站点 站点段为10-1=9
				if (null != sxzdList && sxzdList.size() > 0 ) {
					JSONArray totalArray = new JSONArray();//存放各时间段各站点之间的拥堵数据
					//for (String string : timeGroup) {
						//System.out.println("当前计算时间段："+string);
						JSONArray sjwd = new JSONArray();//时间维度，24个
						sjwd.add(0);
						for(int i = 1 ; i <= sxzdList.size()-1;i++){
							//出站的站点序号为当前循环i，进入下站的站点序号为i+1
							int cz = i;//出站
							int jz = i+1;//进站
							System.out.println("当前计算站点段：出站点-"+cz+"  进站点-"+jz);
							//获取出站数据
							String czsjSql = "SELECT * FROM t_bus_departure WHERE gprs_id = '"+map.get("gprsid")+"' "
									+ " AND DATE_FORMAT(date_time, '%Y-%m-%d') = '"+zt+"'"
									//+ " AND HOUR(date_time) = '"+string+"' "
									+ " AND site_index = "+cz+" "
									+ " AND status_streamflg = 0 ORDER BY date_time ASC;";
							Query czsjQuery = createSQLQuery(czsjSql);
							List<Map<String, Object>> czsjList = czsjQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
							if (null != czsjList && czsjList.size() > 0) {
								//获取最早出站时间
								Object zzczsj = czsjList.get(0).get("date_time");
//								//出站数据车辆
//								List<Object> czsjCl = new ArrayList<Object>();
//								for (Map<String, Object> map2 : czsjList) {
//									czsjCl.add(map2.get("onboard_id"));
//								}
								//获取进站数据
								String jzsjSql = "SELECT * FROM t_bus_arrival WHERE gprs_id = '"+map.get("gprsid")+"'"
										+ " AND DATE_FORMAT(date_time, '%Y-%m-%d') = '"+zt+"'"
										//+ " AND HOUR(date_time) = '"+string+"' "
										+ " AND site_index = '"+jz+"' "
										+ " AND status_streamflg = 0 ORDER BY date_time DESC;";
								Query jzsjQuery = createSQLQuery(jzsjSql);
								List<Map<String, Object>> jzsjList = jzsjQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
								if (null != jzsjList && jzsjList.size() > 0) {
									//获取最晚进站时间
									Object zwjzsj = jzsjList.get(0).get("date_time");
//									//进站数据车辆
//									List<Object> jzsjCl = new ArrayList<Object>();
//									for (Map<String, Object> map2 : jzsjList) {
//										jzsjCl.add(map2.get("onboard_id"));
//									}
//									List<Object> cljh = new ArrayList<Object>();
//									cljh.addAll(czsjCl);
//									cljh.addAll(jzsjCl);
									//获取当前时间，当前站点之间的平均速度
									String avgSdSql = "SELECT ROUND(AVG(speed),0) AS pjsd "
											+ " FROM t_bus_coordinate WHERE gprs_id = '"+map.get("gprsid")+"' "
											+ " AND date_time BETWEEN '"+zzczsj+"' "
											+ " AND '"+zwjzsj+"' "
											//+ " AND onboard_id IN :clsj "
											+ " AND status_streamflg = 0;";
									Query avgSdQuery = createSQLQuery(avgSdSql);
								//	avgSdQuery.setParameterList("clsj", cljh);
									List<Map<String, Object>> avgSdList = avgSdQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
									if (null != avgSdList && avgSdList.size() > 0) {
										if(null != avgSdList.get(0).get("pjsd")){
										int avgsd = Integer.parseInt(avgSdList.get(0).get("pjsd").toString());
										sjwd.add(avgsd);
										}else{
											sjwd.add(0);
										}
									}else{
										sjwd.add(0);
									}
								}else{
									sjwd.add(0);
								}
							}else{
								sjwd.add(0);
							}
							
						}
						//sjwd;
						System.out.println(sjwd.toString());
						GjcsdPojo gJxlYdfxPojo = new GjcsdPojo();
						gJxlYdfxPojo.setXl(map.get("name").toString());
						gJxlYdfxPojo.setLineid(map.get("lineid").toString());
						gJxlYdfxPojo.setGprs_id(map.get("gprsid").toString());
						gJxlYdfxPojo.setPjsd(sjwd.toString());
						gJxlYdfxPojo.setSxx("0");
						gJxlYdfxPojo.setCreate_time(new Date());
						gJxlYdfxPojo.setDate_time(DateUtil.stringToDate(zt,"yyyy-MM-dd"));
						
						ydsjList.add(gJxlYdfxPojo);
					}
					
				}
			
			if (null != ydsjList && ydsjList.size() > 0 ) {
				this.bachSaveObject(ydsjList);
			   }
			//return null;
		
	}
	/**
	 * 下行平均速度
	 */
	@Override
	public void writeXxData() {
		//昨天的年月日时间
		
			String zt = getCurrentDayOfAgoOne();
			//时间段
			//String[] timeGroup = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
			//查询线路
			String xlSql = "SELECT * FROM t_traffic_bus_line GROUP BY name ORDER BY REPLACE(name,'路','')+0 ASC;";
			Query xlQuery = createSQLQuery(xlSql);
			List<Map<String, Object>> xlList = xlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			//存放计算出的拥堵数据
			List<GjcsdPojo> ydsjList = new ArrayList<GjcsdPojo>();
			for (Map<String, Object> map : xlList) {
				System.out.println("获取平均速度"+"----------"+map.get("name").toString());
				//获取线路上行站点
				String sxzdSql = "SELECT * FROM t_traffic_bus_station WHERE lineid = '"+map.get("lineid")+"' AND dir = 1 ORDER BY orderno;";
				Query sxzdQuery = createSQLQuery(sxzdSql);
				List<Map<String, Object>> sxzdList = sxzdQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				//站点分段 假如有10个站点 站点段为10-1=9
				if (null != sxzdList && sxzdList.size() > 0 ) {
					JSONArray totalArray = new JSONArray();//存放各时间段各站点之间的拥堵数据
				
						JSONArray sjwd = new JSONArray();//时间维度，24个
						sjwd.add(0);
						for(int i = 1 ; i <= sxzdList.size()-1;i++){
							//出站的站点序号为当前循环i，进入下站的站点序号为i+1
							int cz = i;//出站
							int jz = i+1;//进站
							System.out.println("当前计算站点段：出站点-"+cz+"  进站点-"+jz);
							//获取出站数据
							String czsjSql = "SELECT * FROM t_bus_departure WHERE gprs_id = '"+map.get("gprsid")+"' "
									+ " AND DATE_FORMAT(date_time, '%Y-%m-%d') = '"+zt+"'"
									//+ " AND HOUR(date_time) = '"+string+"' "
									+ " AND site_index = "+cz+" "
									+ " AND status_streamflg = 1 ORDER BY date_time ASC;";
							Query czsjQuery = createSQLQuery(czsjSql);
							List<Map<String, Object>> czsjList = czsjQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
							if (null != czsjList && czsjList.size() > 0) {
								//获取最早出站时间
								Object zzczsj = czsjList.get(0).get("date_time");

								//获取进站数据
								String jzsjSql = "SELECT * FROM t_bus_arrival WHERE gprs_id = '"+map.get("gprsid")+"'"
										+ " AND DATE_FORMAT(date_time, '%Y-%m-%d') = '"+zt+"'"
										//+ " AND HOUR(date_time) = '"+string+"' "
										+ " AND site_index = '"+jz+"' "
										+ " AND status_streamflg = 1 ORDER BY date_time DESC;";
								Query jzsjQuery = createSQLQuery(jzsjSql);
								List<Map<String, Object>> jzsjList = jzsjQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
								if (null != jzsjList && jzsjList.size() > 0) {
									//获取最晚进站时间
									Object zwjzsj = jzsjList.get(0).get("date_time");

									//获取当前时间，当前站点之间的平均速度
									String avgSdSql = "SELECT ROUND(AVG(speed),0) AS pjsd "
											+ " FROM t_bus_coordinate WHERE gprs_id = '"+map.get("gprsid")+"' "
											+ " AND date_time BETWEEN '"+zzczsj+"' "
											+ " AND '"+zwjzsj+"' "
											//+ " AND onboard_id IN :clsj "
											+ " AND status_streamflg = 1;";
									Query avgSdQuery = createSQLQuery(avgSdSql);
								//	avgSdQuery.setParameterList("clsj", cljh);
									List<Map<String, Object>> avgSdList = avgSdQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
									if (null != avgSdList && avgSdList.size() > 0) {
										if(null != avgSdList.get(0).get("pjsd")){
										int avgsd = Integer.parseInt(avgSdList.get(0).get("pjsd").toString());
										sjwd.add(avgsd);
										}else{
											sjwd.add(0);
										}
									}else{
										sjwd.add(0);
									}
								}else{
									sjwd.add(0);
								}
							}else{
								sjwd.add(0);
							}
							
						}
						//sjwd;
						System.out.println(sjwd.toString());
						GjcsdPojo gJxlYdfxPojo = new GjcsdPojo();
						gJxlYdfxPojo.setXl(map.get("name").toString());
						gJxlYdfxPojo.setLineid(map.get("lineid").toString());
						gJxlYdfxPojo.setGprs_id(map.get("gprsid").toString());
						gJxlYdfxPojo.setPjsd(sjwd.toString());
						gJxlYdfxPojo.setSxx("1");
						gJxlYdfxPojo.setCreate_time(new Date());
						gJxlYdfxPojo.setDate_time(DateUtil.stringToDate(zt,"yyyy-MM-dd"));
						
						ydsjList.add(gJxlYdfxPojo);
					}
					
				}
			
			if (null != ydsjList && ydsjList.size() > 0 ) {
				this.bachSaveObject(ydsjList);
			   }
			//return null;
		
	}
	@Override
	public String getPjsdList(String name,String dir) {
		String sql = "select * from t_bus_sd where xl= '"+name+"' and sxx = '"+dir+"' ORDER BY date_time DESC LIMIT 1";
		Query query  = createSQLQuery(sql).addEntity(GjcsdPojo.class);
		List<GjcsdPojo> list = query.list();
		if (null != list && list.size() > 0 ) {
			 return list.get(0).getPjsd();
		}
		return null;
		
	}
	@Override
	public List<Map<String,Object>> getZmList(String name,String dir) {
		String sql = "SELECT ts.name from t_traffic_bus_station ts "
				+ "LEFT JOIN t_traffic_bus_line tl on ts.lineid = tl.lineid "
				+ "where tl.name='"+name+"' and ts.dir = '"+dir+"' order by ts.orderno";
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> result =query.list();
		return result;
	}
	

}
