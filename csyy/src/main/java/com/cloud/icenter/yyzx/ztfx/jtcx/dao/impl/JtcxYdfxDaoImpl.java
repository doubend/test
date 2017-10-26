package com.cloud.icenter.yyzx.ztfx.jtcx.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GJxlYdfxDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.JtcxYdfxDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GJxlYdfxPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzdPojo;

/** 
 * @author zhucy 
 * @version 2017年7月26日 下午5:01:40 
 * 说明 
 */
@Repository
public class JtcxYdfxDaoImpl extends BaseDaoImpl<GjzdPojo> implements JtcxYdfxDao{
	
	@Autowired
	private GJxlYdfxDao gJxlYdfxDao;

	@Override
	public Map<String, Object> getGfsdYdph() {
		String zgfSql = "SELECT b.name,ROUND(AVG(speed),0) AS pjss"
				+ " FROM t_bus_coordinate a  "
				+ " RIGHT JOIN t_traffic_bus_line b ON a.gprs_id = b.gprsid "
				+ " WHERE date_time BETWEEN '"+getCurrentDayOfAgoOne()+" 07:00:00"+"'"
				+ " AND '"+getCurrentDayOfAgoOne()+" 09:00:00"+"'"
				+ " GROUP BY a.gprs_id ORDER BY AVG(speed) DESC LIMIT 5;";
		String wgfSql = "SELECT b.name,ROUND(AVG(speed),0) AS pjss"
				+ " FROM t_bus_coordinate a  "
				+ " RIGHT JOIN t_traffic_bus_line b ON a.gprs_id = b.gprsid "
				+ " WHERE date_time BETWEEN '"+getCurrentDayOfAgoOne()+" 19:00:00"+"'"
				+ " AND '"+getCurrentDayOfAgoOne()+" 21:00:00"+"'"
				+ " GROUP BY a.gprs_id ORDER BY AVG(speed) DESC LIMIT 5;";
		Query zgfQuery = createSQLQuery(zgfSql);
		List<Map<String, Object>> zgfList = zgfQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		JSONArray zgfArray = new JSONArray();
		for (Map<String, Object> map : zgfList) {
			JSONArray array = new JSONArray();
			int pjss = Integer.parseInt(map.get("pjss").toString());
			if (pjss > 20) {
				map.put("ydjb", 1);
			}
			if (pjss <= 20 && pjss > 15) {
				map.put("ydjb", 2);
			}
			if (pjss <= 15 && pjss > 10) {
				map.put("ydjb", 3);
			}
			if (pjss <= 10 && pjss > 5) {
				map.put("ydjb", 4);
			}
			if (pjss <= 5 && pjss >= 0) {
				map.put("ydjb", 5);
			}
			array.add(handleXlmc(map.get("name").toString()));
			array.add(map.get("pjss"));
			array.add(map.get("ydjb"));
			zgfArray.add(array);
		}
		Query wgfQuery = createSQLQuery(wgfSql);
		List<Map<String, Object>> wgfList = wgfQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		JSONArray wgfArray = new JSONArray();
		for (Map<String, Object> map : wgfList) {
			JSONArray array = new JSONArray();
			int pjss = Integer.parseInt(map.get("pjss").toString());
			if (pjss > 20) {
				map.put("ydjb", 1);
			}
			if (pjss <= 20 && pjss > 15) {
				map.put("ydjb", 2);
			}
			if (pjss <= 15 && pjss > 10) {
				map.put("ydjb", 3);
			}
			if (pjss <= 10 && pjss > 5) {
				map.put("ydjb", 4);
			}
			if (pjss <= 5 && pjss >= 0) {
				map.put("ydjb", 5);
			}
			array.add(handleXlmc(map.get("name").toString()));
			array.add(map.get("pjss"));
			array.add(map.get("ydjb"));
			wgfArray.add(array);
		}
		Map<String, Object> result  = new HashMap<String, Object>();
		result.put("zgf", zgfArray);
		result.put("wgf", wgfArray);
		return result;
		
	}
	
	public String getCurrentDayOfAgoOne(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); //得到前一天
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date).toString();
//		return "2017-07-25";
	}
	
	public String handleXlmc(String name){
		return name.replace("路", "").replace("-", "").replace("东", "").replace("西", "");
	}
	
	public List<Map<String, Object>> getXl(){
		//查询线路
		String xlSql = "SELECT * FROM t_traffic_bus_line GROUP BY name ORDER BY REPLACE(name,'路','')+0 ASC;";
		Query xlQuery = createSQLQuery(xlSql);
		List<Map<String, Object>> xlList = xlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return xlList;
	}
	
	//计算上行拥堵数据
	public void dataHandleSx(Map<String, Object> map){
		//昨天的年月日时间
		String zt = getCurrentDayOfAgoOne();
		//时间段
		String[] timeGroup = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		//查询线路
		String xlSql = "SELECT * FROM t_traffic_bus_line GROUP BY name ORDER BY REPLACE(name,'路','')+0 ASC;";
		Query xlQuery = createSQLQuery(xlSql);
		List<Map<String, Object>> xlList = xlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		//存放计算出的拥堵数据
		List<GJxlYdfxPojo> ydsjList = new ArrayList<GJxlYdfxPojo>();
//		for (Map<String, Object> map : xlList) {
			System.out.println("上行：当前线路--"+map.get("name").toString());
			//获取线路上行站点
			String sxzdSql = "SELECT * FROM t_traffic_bus_station WHERE lineid = '"+map.get("lineid")+"' AND dir = 0 ORDER BY orderno;";
			Query sxzdQuery = createSQLQuery(sxzdSql);
			List<Map<String, Object>> sxzdList = sxzdQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			//站点分段 假如有10个站点 站点段为10-1=9
			if (null != sxzdList && sxzdList.size() > 0 ) {
				JSONArray totalArray = new JSONArray();//存放各时间段各站点之间的拥堵数据
				for (String string : timeGroup) {
					System.out.println("当前计算时间段："+string);
					JSONArray sjwd = new JSONArray();//时间维度，24个
					for(int i = 1 ; i <= sxzdList.size()-1;i++){
						//出站的站点序号为当前循环i，进入下站的站点序号为i+1
						int cz = i;//出站
						int jz = i+1;//进站
						System.out.println("当前计算站点段：出站点-"+cz+"  进站点-"+jz);
						//获取出站数据
						String czsjSql = "SELECT * FROM t_bus_departure WHERE gprs_id = '"+map.get("gprsid")+"' "
								+ " AND DATE_FORMAT(date_time, '%Y-%m-%d') = '"+zt+"'"
								+ " AND HOUR(date_time) = '"+string+"' "
								+ " AND site_index = "+cz+" "
								+ " AND status_streamflg = 0 ORDER BY date_time ASC;";
						Query czsjQuery = createSQLQuery(czsjSql);
						List<Map<String, Object>> czsjList = czsjQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
						if (null != czsjList && czsjList.size() > 0) {
							//获取最早出站时间
							Object zzczsj = czsjList.get(0).get("date_time");
							//出站数据车辆
							List<Object> czsjCl = new ArrayList<Object>();
							for (Map<String, Object> map2 : czsjList) {
								czsjCl.add(map2.get("onboard_id"));
							}
							//获取进站数据
							String jzsjSql = "SELECT * FROM t_bus_arrival WHERE gprs_id = '"+map.get("gprsid")+"'"
									+ " AND DATE_FORMAT(date_time, '%Y-%m-%d') = '"+zt+"'"
									+ " AND HOUR(date_time) = '"+string+"' "
									+ " AND site_index = '"+jz+"' "
									+ " AND status_streamflg = 0 ORDER BY date_time DESC;";
							Query jzsjQuery = createSQLQuery(jzsjSql);
							List<Map<String, Object>> jzsjList = jzsjQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
							if (null != jzsjList && jzsjList.size() > 0) {
								//获取最晚进站时间
								Object zwjzsj = jzsjList.get(0).get("date_time");
								//进站数据车辆
								List<Object> jzsjCl = new ArrayList<Object>();
								for (Map<String, Object> map2 : jzsjList) {
									jzsjCl.add(map2.get("onboard_id"));
								}
								List<Object> cljh = new ArrayList<Object>();
								cljh.addAll(czsjCl);
								cljh.addAll(jzsjCl);
								//获取当前时间，当前站点之间的平均速度
								String avgSdSql = "SELECT ROUND(AVG(speed),0) AS pjsd "
										+ " FROM t_bus_coordinate WHERE gprs_id = '"+map.get("gprsid")+"' "
										+ " AND date_time BETWEEN '"+zzczsj+"' "
										+ " AND '"+zwjzsj+"' "
										+ " AND onboard_id IN :clsj "
										+ " AND status_streamflg = 0;";
								Query avgSdQuery = createSQLQuery(avgSdSql);
								avgSdQuery.setParameterList("clsj", cljh);
								List<Map<String, Object>> avgSdList = avgSdQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
								if (null != avgSdList && avgSdList.size() > 0) {
									//添加pjsd非空验证
									if(null != avgSdList.get(0).get("pjsd")){
										int avgsd = Integer.parseInt(avgSdList.get(0).get("pjsd").toString());
										//平均速度转换为拥堵级别
										int ydjb = 6;
										if (avgsd > 20) {
											ydjb = 1;
										}
										if (avgsd <= 20 && avgsd > 15) {
											ydjb = 2;
										}
										if (avgsd <= 15 && avgsd > 10) {
											ydjb = 3;
										}
										if (avgsd <= 10 && avgsd > 5) {
											ydjb = 4;
										}
										if (avgsd <= 5 && avgsd >= 0) {
											ydjb = 5;
										}
										sjwd.add(ydjb);
									}else{
										sjwd.add(6);
									}
									
								}else{
									sjwd.add(6);
								}
							}else{
								sjwd.add(6);
							}
						}else{
							sjwd.add(6);
						}
						
					}
					if (sxzdList.size()-1 != sjwd.size()) {
						int j = (sxzdList.size()-1)-sjwd.size();
						if (j > 0) {
							for (int i = 0; i < j; i++) {
								sjwd.add(6);
							}
						}
					}
					totalArray.add(sjwd);
				}
				System.out.println(totalArray.toString());
				GJxlYdfxPojo gJxlYdfxPojo = new GJxlYdfxPojo();
				gJxlYdfxPojo.setName(map.get("name").toString());
				gJxlYdfxPojo.setLineid(map.get("lineid").toString());
				gJxlYdfxPojo.setGprsid(map.get("gprsid").toString());
				gJxlYdfxPojo.setYdsj(totalArray.toString());
				gJxlYdfxPojo.setSxl("0");
				gJxlYdfxPojo.setDateTime(DateUtil.stringToDate(zt,"yyyy-MM-dd"));
				gJxlYdfxPojo.setCreateTime(new Date());
				ydsjList.add(gJxlYdfxPojo);
			}
			
//		}
		if (null != ydsjList && ydsjList.size() > 0 ) {
			this.gJxlYdfxDao.bachSaveObject(ydsjList);
		}
	}
	//计算下行拥堵数据
	public void dataHandleXx(Map<String, Object> map){
		//昨天的年月日时间
		String zt = getCurrentDayOfAgoOne();
		//时间段
		String[] timeGroup = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		//查询线路
		String xlSql = "SELECT * FROM t_traffic_bus_line GROUP BY name ORDER BY REPLACE(name,'路','')+0 ASC;";
		Query xlQuery = createSQLQuery(xlSql);
		List<Map<String, Object>> xlList = xlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		//存放计算出的拥堵数据
		List<GJxlYdfxPojo> ydsjList = new ArrayList<GJxlYdfxPojo>();
//		for (Map<String, Object> map : xlList) {
			System.out.println("下行：当前线路--"+map.get("name").toString());
			//获取线路下行站点
			String sxzdSql = "SELECT * FROM t_traffic_bus_station WHERE lineid = '"+map.get("lineid")+"' AND dir = 1 ORDER BY orderno;";
			Query sxzdQuery = createSQLQuery(sxzdSql);
			List<Map<String, Object>> sxzdList = sxzdQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			//站点分段 假如有10个站点 站点段为10-1=9
			if (null != sxzdList && sxzdList.size() > 0 ) {
				JSONArray totalArray = new JSONArray();//存放各时间段各站点之间的拥堵数据
				for (String string : timeGroup) {
					System.out.println("当前计算时间段："+string);
					JSONArray sjwd = new JSONArray();//时间维度，24个
					for(int i = 1 ; i <= sxzdList.size()-1;i++){
						//出站的站点序号为当前循环i，进入下站的站点序号为i+1
						int cz = i;//出站
						int jz = i+1;//进站
						System.out.println("当前计算站点段：出站点-"+cz+"  进站点-"+jz);
						//获取出站数据
						String czsjSql = "SELECT * FROM t_bus_departure WHERE gprs_id = '"+map.get("gprsid")+"' "
								+ " AND DATE_FORMAT(date_time, '%Y-%m-%d') = '"+zt+"'"
								+ " AND HOUR(date_time) = '"+string+"' "
								+ " AND site_index = "+cz+" "
								+ " AND status_streamflg = 1 ORDER BY date_time ASC;";
						Query czsjQuery = createSQLQuery(czsjSql);
						List<Map<String, Object>> czsjList = czsjQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
						if (null != czsjList && czsjList.size() > 0) {
							//获取最早出站时间
							Object zzczsj = czsjList.get(0).get("date_time");
							//出站数据车辆
							List<Object> czsjCl = new ArrayList<Object>();
							for (Map<String, Object> map2 : czsjList) {
								czsjCl.add(map2.get("onboard_id"));
							}
							//获取进站数据
							String jzsjSql = "SELECT * FROM t_bus_arrival WHERE gprs_id = '"+map.get("gprsid")+"'"
									+ " AND DATE_FORMAT(date_time, '%Y-%m-%d') = '"+zt+"'"
									+ " AND HOUR(date_time) = '"+string+"' "
									+ " AND site_index = '"+jz+"' "
									+ " AND status_streamflg = 1 ORDER BY date_time DESC;";
							Query jzsjQuery = createSQLQuery(jzsjSql);
							List<Map<String, Object>> jzsjList = jzsjQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
							if (null != jzsjList && jzsjList.size() > 0) {
								//获取最晚进站时间
								Object zwjzsj = jzsjList.get(0).get("date_time");
								//进站数据车辆
								List<Object> jzsjCl = new ArrayList<Object>();
								for (Map<String, Object> map2 : jzsjList) {
									jzsjCl.add(map2.get("onboard_id"));
								}
								List<Object> cljh = new ArrayList<Object>();
								cljh.addAll(czsjCl);
								cljh.addAll(jzsjCl);
								//获取当前时间，当前站点之间的平均速度
								String avgSdSql = "SELECT ROUND(AVG(speed),0) AS pjsd "
										+ " FROM t_bus_coordinate WHERE gprs_id = '"+map.get("gprsid")+"' "
										+ " AND date_time BETWEEN '"+zzczsj+"' "
										+ " AND '"+zwjzsj+"' "
										+ " AND onboard_id IN :clsj "
										+ " AND status_streamflg = 1;";
								Query avgSdQuery = createSQLQuery(avgSdSql);
								avgSdQuery.setParameterList("clsj", cljh);
								List<Map<String, Object>> avgSdList = avgSdQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
								if (null != avgSdList && avgSdList.size() > 0) {
									//添加pjsd非空验证
									if(null != avgSdList.get(0).get("pjsd")){
										int avgsd = Integer.parseInt(avgSdList.get(0).get("pjsd").toString());
										//平均速度转换为拥堵级别
										int ydjb = 6;
										if (avgsd > 20) {
											ydjb = 1;
										}
										if (avgsd <= 20 && avgsd > 15) {
											ydjb = 2;
										}
										if (avgsd <= 15 && avgsd > 10) {
											ydjb = 3;
										}
										if (avgsd <= 10 && avgsd > 5) {
											ydjb = 4;
										}
										if (avgsd <= 5 && avgsd >= 0) {
											ydjb = 5;
										}
										sjwd.add(ydjb);
									}else{
										sjwd.add(6);
									}
									
								}else{
									sjwd.add(6);
								}
							}else{
								sjwd.add(6);
							}
						}else{
							sjwd.add(6);
						}
						
					}
					if (sxzdList.size()-1 != sjwd.size()) {
						int j = (sxzdList.size()-1)-sjwd.size();
						if (j > 0) {
							for (int i = 0; i < j; i++) {
								sjwd.add(6);
							}
						}
					}
					totalArray.add(sjwd);
				}
				System.out.println(totalArray.toString());
				GJxlYdfxPojo gJxlYdfxPojo = new GJxlYdfxPojo();
				gJxlYdfxPojo.setName(map.get("name").toString());
				gJxlYdfxPojo.setLineid(map.get("lineid").toString());
				gJxlYdfxPojo.setGprsid(map.get("gprsid").toString());
				gJxlYdfxPojo.setYdsj(totalArray.toString());
				gJxlYdfxPojo.setSxl("1");
				gJxlYdfxPojo.setDateTime(DateUtil.stringToDate(zt,"yyyy-MM-dd"));
				gJxlYdfxPojo.setCreateTime(new Date());
				ydsjList.add(gJxlYdfxPojo);
			}
			
//		}
		if (null != ydsjList && ydsjList.size() > 0 ) {
			this.gJxlYdfxDao.bachSaveObject(ydsjList);
		}
	}
}
