package com.cloud.icenter.yyzx.fzjc.hjbh.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javassist.convert.Transformer;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.fzjc.hjbh.dao.WaterDao;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityCity;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterPollution;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterQualityCity;
/**
 * 
 * @author Administrator
 *
 */
@Repository
public class WaterDaoImpl extends BaseDaoImpl<WaterPollution> implements WaterDao{

	@Override
	public List<WaterPollution> getWaterPollutionList(int num) {
		try {
			String sql = "select * from t_hjbh_szfx_qypw where delete_state=0 "
					+ " order by ranking asc";
			Query query = createSQLQuery(sql).addEntity(WaterPollution.class);
			query.setMaxResults(num);
			List<WaterPollution> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public List<WaterQualityCity> getWaterQualityCityForSeven(Timestamp sttime,
			Timestamp edtime) {
		String sql = "select * from t_hjbh_szfx_jiac where 1=1";
		if(sttime != null && edtime != null){
			sql += " and create_time between '"+sttime+"' and '"+edtime+"'";
		}else{
			//sql += " and DATE_SUB(CURDATE(), INTERVAL 7 DAY) < date(create_time)";
			sql += " and DATE_SUB('2017-03-03', INTERVAL 7 DAY) < date(create_time)";
		}
		sql += " and delete_state=0 order by create_time desc";
		try {
			Query query = createSQLQuery(sql).addEntity(WaterQualityCity.class);
			List<WaterQualityCity> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<WaterQualityArea> getWaterQualityAreaByDate(String date) {
		try {
			String sql = "SELECT * FROM t_hjbh_szfx_stzl WHERE delete_state=0 GROUP BY county_name order by water_quality_val asc ";
			if(date != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
				Timestamp datest = new Timestamp(sdf.parse(date + " 00:00:00").getTime());
				Timestamp dateed = new Timestamp(sdf.parse(date + " 23:59:59").getTime());
				sql = "SELECT * FROM t_hjbh_szfx_stzl WHERE create_time between '"+datest+"' and '"+dateed+"'"
						+ " and delete_state=0 GROUP BY county_name order by water_quality_val asc ";
			}
			Query query = createSQLQuery(sql).addEntity(WaterQualityArea.class);
			List<WaterQualityArea> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> getHlfz(){
		String sql = "SELECT sshl FROM t_hjbh_szfx_jczd WHERE zd_type = 1 GROUP BY sshl ORDER BY create_time ASC";
		Query query = createSQLQuery(sql);
		List<String> hlfzs = query.list();
		if (!CollectionUtils.isEmpty(hlfzs)) {
			return hlfzs;
		}
		return null;
	}
	
	public List<Map<String, Object>> getDbsJczb(){
		String sql = "SELECT * FROM t_hjbh_szfx_jczb WHERE delete_status = 0 AND zd_type = 1;";
		Query query = createSQLQuery(sql);
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	public List<Map<String, Object>> getYysJczb(){
		String sql = "SELECT * FROM t_hjbh_szfx_jczb WHERE delete_status = 0 AND zd_type = 2;";
		Query query = createSQLQuery(sql);
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	public List<Map<String, Object>> getDbsJczd(String ly){
		String sql = "";
		if (StringUtil.isEmpty(ly)) {
			sql = "SELECT * FROM t_hjbh_szfx_jczd WHERE zd_type = 1;";
		}else{
			if ("all".equals(ly)) {
				sql = "SELECT * FROM t_hjbh_szfx_jczd WHERE zd_type = 1;";
			}else{
				sql = "SELECT * FROM t_hjbh_szfx_jczd WHERE zd_type = 1 and sshl = '" +ly+"'" ;
			}
			
		}
		
		Query query = createSQLQuery(sql);
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	public List<Map<String, Object>> getYysJczd(){
		String sql = "SELECT * FROM t_hjbh_szfx_jczd WHERE zd_type = 2;";
		Query query = createSQLQuery(sql);
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	public List<Map<String, Object>> getJcsj(String jczd,String jczb,String year){
		String sql = "SELECT a.zbz,CASE a.jidu WHEN 1 THEN '第一季度' WHEN 2 THEN '第二季度' WHEN 3 THEN '第三季度' ELSE '第四季度' END AS jd "
				+ " FROM t_hjbh_szfx_jcsj a LEFT JOIN t_hjbh_szfx_jczd b ON a.jczd_id = b.id "
				+ " WHERE b.jczd = '"+jczd+"' AND a.jczb_id = '"+jczb+"' AND year="+year+" limit 4";
		Query query = createSQLQuery(sql);
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}

}
