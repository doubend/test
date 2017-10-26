package com.cloud.icenter.yyzx.fzjc.hjbh.dao.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.fzjc.hjbh.dao.AirDao;
import com.cloud.icenter.yyzx.fzjc.hjbh.dao.KqzlJcsjDao;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirPollution;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityCity;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.KqzlJcsjPoJo;
import com.mysql.fabric.xmlrpc.base.Array;
/**
 * 
 * @author Administrator
 *
 */
@Repository
public class AirDaoImpl extends BaseDaoImpl<AirPollution> implements AirDao{
	
	@Autowired
	private KqzlJcsjDao kqzlJcsjDao;

	@Override
	public List<AirPollution> getAirPollutionList(int num) {
		try {
			String sql = "select * from t_hjbh_kqzl_qypw where delete_state=0 "
					+ " order by ranking asc";
			Query query = createSQLQuery(sql).addEntity(AirPollution.class);
			query.setMaxResults(num);
			List<AirPollution> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	
	/**
	 * 如果时间为空的情况下，默认取当前向前七天数据
	 * @param sttime 开始时间
	 * @param edtime 结束时间
	 * @return list
	 */
	@Override
	public List<AirQualityCity> getAirQualityCityForSeven(Timestamp sttime,
			Timestamp edtime) {
		String sql = "select * from t_hjbh_kqzl_jiac where 1=1";
		if(sttime != null && edtime != null){
			sql += " and create_time between '"+sttime+"' and '"+edtime+"'";
		}else{
			//sql += " and DATE_SUB(CURDATE(), INTERVAL 7 DAY) < date(create_time)";
			sql += " and DATE_SUB('2017-03-02', INTERVAL 7 DAY) < date(create_time)";
		}
		sql += " and delete_state=0 order by create_time desc";
		try {
			Query query = createSQLQuery(sql).addEntity(AirQualityCity.class);
			List<AirQualityCity> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


	/**
	 * 根据时间获取一天内一个区域的环境数据
	 */
	@Override
	public List<AirQualityArea> getAirQualityAreaByDate(String date) {
		try {
			String sql = "SELECT * FROM t_hjbh_kqzl_kqpm WHERE delete_state=0 GROUP BY county_name order by ai_quality_val asc";
			if(date != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
				Timestamp datest = new Timestamp(sdf.parse(date + " 00:00:00").getTime());
				Timestamp dateed = new Timestamp(sdf.parse(date + " 23:59:59").getTime());
				sql = "SELECT * FROM t_hjbh_kqzl_kqpm WHERE create_time between '"+datest+"' and '"+dateed+"'"
						+ " and delete_state=0 GROUP BY county_name order by ai_quality_val asc";
			}
			Query query = createSQLQuery(sql).addEntity(AirQualityArea.class);
			List<AirQualityArea> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<AirQualityArea> getAllDateList() {
		String sql = "SELECT DATE_FORMAT(create_time,'%Y-%m-%d') create_time FROM t_hjbh_kqzl_kqpm "
				+ " GROUP BY DATE_FORMAT(create_time,'%Y-%m-%d')"
				+ " ORDER BY DATE_FORMAT(create_time,'%Y-%m-%d') DESC";
		Query query = createSQLQuery(sql).addEntity(AirQualityArea.class);
		if(query == null){
			return null;
		}
		return query.list();
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		Timestamp t = new Timestamp(sdf.parse("17/03/03 23:59:59").getTime());
		System.out.println(t);
		
	}


	@Override
	public List<Map<String, Object>> getDataForSeven(String jczd, String jcsj) {
		//默认取监测站点99的七天数据:天水市数据
		String sql = "SELECT ROUND(AVG(SO2)) SO2,ROUND(AVG(O3_1h)) O3_1h,ROUND(AVG(PM2P5)) PM2P5,ROUND(AVG(CO),2) CO,ROUND(AVG(NO2)) NO2,"
				+ " ROUND(AVG(PM10)) PM10,ROUND(AVG(O3_8h)) O3_8h,ROUND(AVG(aqi)) aqi,data_time "
				+ " FROM t_hjbh_kqzl_jcsj WHERE jczd_id = 99 GROUP BY DATE_FORMAT(data_time,'%Y-%m-%d') ORDER BY data_time DESC LIMIT 7";
		if (!StringUtil.isEmpty(jczd)) {
			sql = "SELECT ROUND(AVG(SO2)) SO2,ROUND(AVG(O3_1h)) O3_1h,ROUND(AVG(PM2P5)) PM2P5,ROUND(AVG(CO),2) CO,"
					+ "ROUND(AVG(NO2)) NO2,ROUND(AVG(PM10)) PM10,ROUND(AVG(O3_8h)) O3_8h,ROUND(AVG(aqi)) aqi,data_time"
					+ " FROM t_hjbh_kqzl_jcsj "
					+ "WHERE jczd_id = '"+jczd+"' GROUP BY DATE_FORMAT(data_time,'%Y-%m-%d') ORDER BY data_time DESC LIMIT 7";
		}
		Query query = createSQLQuery(sql);
		List<Map<String,Object>> list = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return list;
		
	}
	public List<Map<String, Object>> getZxsj(){
		String sql = "SELECT * FROM t_hjbh_kqzl_jcsj WHERE jczd_id = 99 ORDER BY data_time DESC LIMIT 1";
		Query query=createSQLQuery(sql);
		List<Map<String,Object>> list=query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return list;
	}
	public List<Map<String, Object>> getTsSszbSj(){
		String sql = "SELECT * FROM t_hjbh_kqzl_jcsj WHERE jczd_id = 99 ORDER BY data_time DESC LIMIT 1;";
		Query query=createSQLQuery(sql);
		List<Map<String,Object>> list=query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return list;
	}
	public List<Map<String, Object>> getSskqzl(){
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		String sql="SELECT * FROM t_hjbh_kqzl_jczd order by id  LIMIT 3";
		Query query=createSQLQuery(sql);
		List<Map<String,Object>> list=query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		for (Map<String, Object> map : list) {//GROUP BY DATE_FORMAT(data_time,'%Y-%m-%d')
			String sql1 = "SELECT PM2P5,PM10,aqi,primary_pollutant"
					+ " FROM t_hjbh_kqzl_jcsj WHERE jczd_id = '"+map.get("id")+"' ORDER BY data_time DESC LIMIT 1";
			Query query1=createSQLQuery(sql1);
			List<Map<String,Object>> zdsj=query1.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			if(null != zdsj && zdsj.size() > 0 ){
				Map<String,Object> zdsjMap = zdsj.get(0);
				zdsjMap.put("zdmc", map.get("name"));
				if (null != zdsjMap.get("aqi")) {
					int aqi = Integer.parseInt(zdsjMap.get("aqi").toString());
					String dj = "";
					if (0 <= aqi && aqi <= 50) {
						dj = "优";
					}
					if (51 <= aqi && aqi <= 100) {
						dj = "良";
					}
					if (101 <= aqi && aqi <= 150) {
						dj = "轻度污染";			
					}
					if (151 <= aqi && aqi <= 200) {
						dj = "中度污染";
					}
					if (201 <= aqi && aqi <= 300) {
						dj = "重度污染";
					}
					if (300 < aqi ) {
						dj = "严重污染";
					}
					zdsjMap.put("dj", dj);
					result.add(zdsjMap);
				}
			}
		}
		return result;
	}
	
	public List<Map<String, Object>> getKqzlRb(){
		String sql = "SELECT aqi,CONCAT(HOUR(data_time),'时') h"
					+" FROM t_hjbh_kqzl_jcsj "
					+"WHERE jczd_id = 99 "
					+"AND CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) "
					+ " = CONCAT(YEAR(CURDATE()),MONTH(CURDATE()),DAY(CURDATE())) "
					+"ORDER BY data_time ";
		Query query=createSQLQuery(sql);
		List<Map<String,Object>> list=query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return list;
	}
	
	public Map<String, Object> getJynTsYltsTj(){
		Map<String, Integer> tstj = new HashMap<String, Integer>();
		int type1 = 0;//优
		int type2  = 0;//良
		int type3 = 0;//轻度
		int type4 = 0;//中度
		int type5 = 0;//重度
		int type6 = 0;//严重
		String sql = "SELECT CONCAT(YEAR (data_time),'年',MONTH (data_time),'月') ym,CONCAT(YEAR (data_time),MONTH (data_time)) tj"
				+ " FROM t_hjbh_kqzl_jcsj WHERE jczd_id = 99 "
				+ " GROUP BY CONCAT(YEAR (data_time),MONTH (data_time)) ORDER BY data_time DESC LIMIT 12;";
		Query query=createSQLQuery(sql);
		List<Map<String,Object>> list=query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		if (null != list && list.size() > 0) {
			List<Map<String, Object>> ynYltj = new ArrayList<Map<String,Object>>();
			for (Map<String, Object> map : list) {//月份
				Map<String, Object> result = new HashMap<String, Object>();
				String sql1 = "SELECT ROUND(AVG(aqi)) aqi FROM t_hjbh_kqzl_jcsj "
						+ " WHERE jczd_id = 99 AND CONCAT(YEAR (data_time),MONTH (data_time)) = '"+map.get("tj")+"' "
						+ " GROUP BY CONCAT(YEAR (data_time),MONTH (data_time),DAY(data_time));";
				Query query1=createSQLQuery(sql1);
				List<Map<String,Object>> aqiList=query1.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				int ecY = 0;
				int ecL = 0;
				for (Map<String, Object> map2 : aqiList) {//每月的每天
					int aqi = Integer.parseInt(map2.get("aqi").toString());
					if (0 <= aqi && aqi <= 50) {
						type1++;
						ecY++;
					}
					if (51 <= aqi && aqi <= 100) {
						type2++;
						ecL++;
					}
					if (101 <= aqi && aqi <= 150) {
						type3++;		
					}
					if (151 <= aqi && aqi <= 200) {
						type4++;
					}
					if (201 <= aqi && aqi <= 300) {
						type5++;
					}
					if (300 < aqi ) {
						type6++;
					}
				}
				result.put("yf", map.get("ym").toString());
				result.put("ecY", ecY);
				result.put("ecL", ecL);
				ynYltj.add(result);
			}
			tstj.put("type1", type1);
			tstj.put("type2", type2);
			tstj.put("type3", type3);
			tstj.put("type4", type4);
			tstj.put("type5", type5);
			tstj.put("type6", type6);
			Map<String, Object> jg = new HashMap<String, Object>();
			jg.put("tstj", tstj);
			jg.put("ecList", ynYltj);
			return jg;
		}
		return null;
	}
	
	//获取监测站点基本信息
	public List<Map<String,Object>> showQualitySite(){
		
		String sql="SELECT * FROM t_hjbh_kqzl_jczd order by id limit 3";
		Query query=createSQLQuery(sql);
		List<Map<String,Object>> list=query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return list;
	}
	
	public void insertJcsj(String jsonResult){
		if (!StringUtil.isEmpty(jsonResult)) {
			JSONObject object = new JSONObject();
	    	object = JSONObject.parseObject(jsonResult);
	    	Object showapi_res_body = object.get("showapi_res_body");
	    	Object pm = JSONObject.parseObject(showapi_res_body.toString()).get("pm");
	    	//天水市实时空气质量数据
	    	JSONObject objectPm = new JSONObject();
	    	objectPm = JSONObject.parseObject(pm.toString());
	    	KqzlJcsjPoJo jcsjPoJo = new KqzlJcsjPoJo();
	    	jcsjPoJo.setJczd_id("99");
	    	Object obj = objectPm.get("so2");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setSO2(objectPm.getBigDecimal("so2")== null ? BigDecimal.ZERO : objectPm.getBigDecimal("so2"));
			}
	    	obj = objectPm.get("o3");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setO3_1h(objectPm.getBigDecimal("o3")== null ? BigDecimal.ZERO : objectPm.getBigDecimal("o3"));
			}
	    	obj = objectPm.get("pm2_5");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setPM2P5(objectPm.getBigDecimal("pm2_5")== null ? BigDecimal.ZERO : objectPm.getBigDecimal("pm2_5"));
			}
	    	jcsjPoJo.setDataTime(objectPm.getDate("ct"));
	    	obj = objectPm.get("primary_pollutant");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setPrimary_pollutant(objectPm.getString("primary_pollutant"));
			}else{
				jcsjPoJo.setPrimary_pollutant("");
			}
	    	
	    	obj = objectPm.get("num");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setNum(objectPm.getIntValue("num"));
			}
	    	obj = objectPm.get("co");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setCO(objectPm.getBigDecimal("co") == null ? BigDecimal.ZERO : objectPm.getBigDecimal("co"));
			}
	    	obj = objectPm.get("no2");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setNO2(objectPm.getBigDecimal("no2") == null ? BigDecimal.ZERO : objectPm.getBigDecimal("no2"));
			}
	    	obj = objectPm.get("aqi");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setAqi(objectPm.getIntValue("aqi"));
			}
	    	jcsjPoJo.setQuality(objectPm.getString("quality"));
	    	obj = objectPm.get("pm10");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setPM10(objectPm.getBigDecimal("pm10") == null ? BigDecimal.ZERO : objectPm.getBigDecimal("pm10"));
			}
	    	obj = objectPm.get("o3_8h");
	    	if (null != obj && !obj.equals("_")) {
	    		jcsjPoJo.setO3_8h(objectPm.getBigDecimal("o3_8h") == null ? BigDecimal.ZERO : objectPm.getBigDecimal("o3_8h"));
			}
	    	jcsjPoJo.setCreateTime(new Date());
	    	this.kqzlJcsjDao.save(jcsjPoJo);
	    	Object siteList = JSONObject.parseObject(showapi_res_body.toString()).get("siteList");
	    	//天水市所属监测站点实时空气质量数据
	    	JSONArray array = new JSONArray();
	    	array = JSONArray.parseArray(siteList.toString());
	    	for (Object object2 : array) {
				JSONObject jsonObject = new JSONObject();
				jsonObject = JSONObject.parseObject(object2.toString());
				String siteName = jsonObject.get("site_name").toString();
				String jczdId = "";
				if (siteName.equals("仙人崖")) {
					jczdId = "1";
				}
				if (siteName.equals("进步巷")) {
					jczdId = "2";
				}
				if (siteName.equals("文化馆")) {
					jczdId = "3";
				}
				KqzlJcsjPoJo poJo = new KqzlJcsjPoJo();
				poJo.setJczd_id(jczdId);
				
				Object obj1 = jsonObject.get("so2");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setSO2(jsonObject.getBigDecimal("so2")== null ? BigDecimal.ZERO : jsonObject.getBigDecimal("so2"));
				}
		    	obj1 = jsonObject.get("o3");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setO3_1h(jsonObject.getBigDecimal("o3")== null ? BigDecimal.ZERO : jsonObject.getBigDecimal("o3"));
				}
		    	obj1 = jsonObject.get("pm2_5");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setPM2P5(jsonObject.getBigDecimal("pm2_5")== null ? BigDecimal.ZERO : jsonObject.getBigDecimal("pm2_5"));
				}
		    	obj1 = jsonObject.get("co");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setCO(jsonObject.getBigDecimal("co")== null ? BigDecimal.ZERO : jsonObject.getBigDecimal("co"));
				}
		    	obj1 = jsonObject.get("no2");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setNO2(jsonObject.getBigDecimal("no2")== null ? BigDecimal.ZERO : jsonObject.getBigDecimal("no2"));
				}
		    	obj1 = jsonObject.get("aqi");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setAqi(jsonObject.getIntValue("aqi"));
				}
		    	poJo.setQuality(jsonObject.getString("quality"));
		    	obj1 = jsonObject.get("pm10");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setPM10(jsonObject.getBigDecimal("pm10")== null ? BigDecimal.ZERO : jsonObject.getBigDecimal("pm10"));
				}
		    	obj1 = jsonObject.get("o3_8h");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setO3_8h(jsonObject.getBigDecimal("o3_8h")== null ? BigDecimal.ZERO : jsonObject.getBigDecimal("o3_8h"));
				}
				poJo.setDataTime(jsonObject.getDate("ct"));
				obj1 = jsonObject.get("primary_pollutant");
		    	if (null != obj1 && !obj1.equals("_")) {
		    		poJo.setPrimary_pollutant(jsonObject.getString("primary_pollutant"));
				}else{
					poJo.setPrimary_pollutant("");
				}
				poJo.setCreateTime(new Date());
				this.kqzlJcsjDao.save(poJo);
			}
		}
	}
}
