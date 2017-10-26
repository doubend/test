
package com.cloud.icenter.yyzx.cstz.dao.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.common.util.DBConfigure;
import com.cloud.icenter.common.util.MySqlBean;
import com.cloud.icenter.common.util.ValueCompareAsc;
import com.cloud.icenter.common.util.ValueCompareDesc;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.yyzx.cstz.dao.SignModelDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzAllBusPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzCommonPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzmxPojo;
import com.cloud.icenter.yyzx.cstz.pojo.SignData;
import com.cloud.icenter.yyzx.cstz.pojo.SignModel;
import com.cloud.icenter.yyzx.cstz.pojo.ZbphPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzmxService;

/**
* Created with gender.
* @author: whcai
* Date: 2017-03-20 15:49:08
*/
@Repository
public class SignModelDaoImpl extends BaseDaoImpl<SignModel> implements SignModelDao {

	//数据库配置
	private DBConfigure dbConfig = getDBConfigure(); 
	
	@Autowired
	private CstzTzmxService cstzTzmxService;
	
	/**
	 * 获取最新的体征数据
	 */
	public List<CstzCommonPojo> getTheNewestSign(){
//		String sql = "select t.tz_id as tzID, IFNULL(ROUND(t.tzz,1), 0) tzz, t.tzzk, t.tzmc, t.xssx from (select a.tz_id,a.tzz,a.tzzk,b.tzmc,b.xssx from t_cstz_tzzssj a left join t_cstz_tzmx b on a.tz_id=b.id WHERE b.tzlx != 3 order by a.data_time desc) t group by tz_id order by xssx asc";
//		每项体征都是获取最新日期的数据，直接取值
		String sql = "SELECT ( SELECT ROUND(c.tzz,2) tzz FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) tzz,"
				+ "(SELECT c.tzzk FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) tzzk,a.tzmc "
				+ "FROM t_cstz_tzmx a WHERE a.tzlx != 3 ORDER BY a.xssx ASC";
//		//通过计算下级体征之和获取的上级，体征模型页面上下级能对应上
//		String sql = "SELECT ROUND( IF(a.tzlx != 2,"
//				+ " ( SELECT SUM(b.qz*(SELECT d.tzz FROM t_cstz_tzzssj d WHERE d.tz_id = b.id ORDER BY d.data_time DESC LIMIT 1)) tzz "
//				+ " FROM t_cstz_tzmx b WHERE b.parent_id = a.id),(SELECT SUM(b.qz*(SELECT d.tzz FROM t_cstz_tzzssj d "
//				+ " WHERE d.tz_id = b.ywtz_id ORDER BY d.data_time DESC LIMIT 1)) tzz "
//				+ " FROM t_cstz_tzmx b WHERE b.parent_id = a.id)),2) tzz,a.tzmc"
//				+ " FROM t_cstz_tzmx a  WHERE a.tzlx  != 3  ORDER BY a.xssx ASC";
		try {
			Query query = createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			List<CstzCommonPojo> list = query.list();
//			List<Map<String,Object>> list = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			if(list == null){
				return null;
			}
//			for (Map<String, Object> map : list) {
//				if (!StringUtil.isEmpty(map.get("tzz").toString())) {
//					BigDecimal tzz = new BigDecimal( map.get("tzz").toString());
//					String tzzk = getYlzc(tzz);
//					map.put("tzzk", tzzk);
//				}
//			}
			return list;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<CstzCommonPojo> getZcTzsjById(String id) {
		String sql = "SELECT (SELECT ROUND(c.tzz, 2) tzz FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) tzz,"
				+ " (SELECT c.tzzk FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) tzzk, a.tzmc FROM t_cstz_tzmx a WHERE "
				+ " a.parent_id = '"+id+"' ORDER BY ( SELECT ROUND(c.tzz, 2) tzz FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) ASC";
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
		List<CstzCommonPojo> list = query.list();
		if(list == null){
			return null;
		}
		return list;
	}
	
	public List<CstzCommonPojo> getZcTzsjByName(String name){
		String sql = "SELECT (SELECT ROUND(c.tzz, 2) tzz FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) tzz,"
				+ " (SELECT c.tzzk FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) tzzk, a.tzmc FROM t_cstz_tzmx a WHERE "
				+ " a.parent_id = (SELECT t.id FROM t_cstz_tzmx t WHERE t.tzmc = '"+name+"') ORDER BY ( SELECT ROUND(c.tzz, 2) tzz FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) ASC";
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
		List<CstzCommonPojo> list = query.list();
		if(list == null){
			return null;
		}
		return list;
	}
	
	public String getYlzc(BigDecimal tzz){
		BigDecimal ylzc1 = new BigDecimal(0);//0 N
		BigDecimal ylzc2 = new BigDecimal(2);//2 M
		BigDecimal ylzc3 = new BigDecimal(5);//5 L
		BigDecimal ylzc4 = new BigDecimal(8);//8 K
		BigDecimal ylzc5 = new BigDecimal(10);//10 J
		String ylzc = "";
		if ((tzz.compareTo(ylzc1) == 0
				|| tzz.compareTo(ylzc1) == 1)
				&& tzz.compareTo(ylzc2) == -1) {// 0 <= tzz < 2
			ylzc = "差";
		}else if((tzz.compareTo(ylzc2) == 0
				|| tzz.compareTo(ylzc2) == 1)
				&& tzz.compareTo(ylzc3) == -1){// 2 <= tzz < 5
			ylzc = "中";
		}else if((tzz.compareTo(ylzc3) == 0
				|| tzz.compareTo(ylzc3) == 1)
				&& tzz.compareTo(ylzc4) == -1){// 5 <= tzz < 8
			ylzc = "良";
		}else if((tzz.compareTo(ylzc4) == 0
				|| tzz.compareTo(ylzc4) == 1)
				&& (tzz.compareTo(ylzc5) == -1
				|| tzz.compareTo(ylzc5) == 0)){// 8 <= tzz <=10
			ylzc = "优";
		}
		return ylzc;
	}
	
	/**
	 * 获取综合体征最新日期
	 */
	public Map<String, Integer> getTheNewestDate(){
		String sql ="select * from t_cstz_tzzssj where tz_id=(select id from t_cstz_tzmx where tzlx='0') order by data_time desc limit 1";
		Map<String, Integer> rowMap = new HashMap<String, Integer>();
		try {
			Query query = createSQLQuery(sql).addEntity(SignData.class);
			List<SignData> list = query.list();
			if(null != list && list.size() > 0 ){
				Date dt = list.get(0).getDataTime();  
				Calendar cal =Calendar.getInstance(); 
				cal.setTime(dt);
				rowMap.put("year", cal.get(Calendar.YEAR));
				rowMap.put("month", cal.get(Calendar.MONTH) + 1);
				rowMap.put("day", cal.get(Calendar.DAY_OF_MONTH));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rowMap;
	}
	
	/**
	 * 获取最新该体征和它下级体征数据
	 */
	public List<CstzCommonPojo> getJuniorSignData(String tzmc){	
//		String sql = String.format("select a.id as tzID,a.tzmc,IFNULL(b.tzz,0) tzz,b.tzzk,IFNULL(a.qz,0) qz from t_cstz_tzmx a,(select * from t_cstz_tzzssj order by data_time desc) b where a.id=b.tz_id and(a.tzmc='%s' or a.parent_id=(select id from t_cstz_tzmx where tzmc='%s')) group by a.id order by a.xssx asc", tzmc, tzmc);
		String sql = "SELECT a.id as tzID, ( SELECT ROUND(c.tzz,2) tzz FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) tzz,"
				+ "(SELECT c.tzzk FROM t_cstz_tzzssj c WHERE c.tz_id = a.id ORDER BY c.data_time DESC LIMIT 1 ) tzzk,a.tzmc "
				+ "FROM t_cstz_tzmx a WHERE a.tzlx != 3 and(a.tzmc='"+tzmc+"' or a.parent_id=(select id from t_cstz_tzmx where tzmc='"+tzmc+"')) ORDER BY a.xssx ASC";
		try {
			Query query = createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			List<CstzCommonPojo> dataList = query.list();
			if(dataList == null){
				return null;
			}
			return dataList;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取最新该体征和它下级体征数据
	 */
	public List<CstzCommonPojo> getJuniorSignDataByID(String tzID){	
		/** zhucy 20170603 修改 */
		String sql = String.format("select a.id as tzID,a.tzmc,a.qz,IFNULL(b.tzz,0) tzz,b.tzzk "
				+ " from t_cstz_tzmx a "
				+ " LEFT JOIN t_cstz_tzzssj b ON a.ywtz_id = b.tz_id OR a.id = b.tz_id"
				+ " where (a.id='%s' or a.parent_id='%s') group by a.id order by a.xssx asc ,b.data_time DESC", tzID, tzID);
		/** zhucy 20170603 注释 */
		//String sql = String.format("select a.id as tzID,a.tzmc,a.qz,IFNULL(b.tzz,0) tzz,b.tzzk from t_cstz_tzmx a,(select * from t_cstz_tzzssj order by data_time desc) b where a.id=b.tz_id and (a.id='%s' or a.parent_id='%s') group by a.id order by a.xssx asc", tzID, tzID);
		try {
			Query query = createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			List<CstzCommonPojo> dataList = query.list();
			if(dataList == null){
				return null;
			}
			return dataList;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * 获取最新该体征和它下级体征数据(该方法已废弃！)
	 */
	public List<Map<String,Object>> getJuniorSign(List<Integer> lstSignID){	
		String sql;
		ResultSet rs = null;
		MySqlBean mysqlBean = null;
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>(); 
		try{
			//执行sql语句 
			mysqlBean = new MySqlBean(dbConfig);
			
			for(int i = 0; i < lstSignID.size(); i++){
				int id = lstSignID.get(i);
				sql ="select a.id,a.tzmc,IFNULL(a.qz,0) qz,FORMAT(b.tzz,1) as tzz,b.tzzk,b.data_time from t_cstz_tzmx a left join t_cstz_tzzssj b on a.id=b.tzzb_id where b.tzzb_id=" + id + " order by b.data_time desc limit 1";
				rs = mysqlBean.ExcuteQuery(sql);
				Map<String, Object> rowMap = new HashMap<String, Object>();
				while (rs.next()) {
					rowMap.put("sign_id", rs.getInt("id"));
					rowMap.put("tzz", rs.getFloat("tzz"));
					rowMap.put("tzzk", rs.getString("tzzk"));
					rowMap.put("tzmc", rs.getString("tzmc"));
					rowMap.put("qz", rs.getFloat("qz"));
					
					dataList.add(rowMap);
				}
			}
		}catch (Exception ex) {
			return null;
 		}finally{
		try {
				if(mysqlBean != null)
					mysqlBean.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
		
		return dataList;
	}
	
	/**
	 * 获取最差指标Top5
	 * @return
	 */
	public List<CstzCommonPojo> getWorstTop(List<CstzCommonPojo> lstSign, int topNum){
		//获取最差TOP5体征ID
//		Map<String,Float> mapSignTop = getWorstSign(mapSign);
//        if(mapSignTop == null || mapSignTop.size() <= 0){
//        	return null;
//        }
		
        return getTop(lstSign, topNum, 1);
	}
	
	/**
	 * 获取最优指标Top5
	 * @return
	 */
	public List<CstzCommonPojo> getOptimalTop(List<CstzCommonPojo> lstSign, int topNum){
		//获取最优TOP5体征ID
//		List<CstzCommonPojo> mapSignTop = getOptimalSign(lstSign, topNum);
//        if(mapSignTop == null || mapSignTop.size() <= 0){
//        	return null;
//        } 
        
        return getTop(lstSign, topNum, 2); 
	}
	
	/**
	 * 获取全部指标
	 * @param mapQz
	 * @return
	 */
	public List<CstzAllBusPojo> getAllBusIndex(List<CstzCommonPojo> lstQz, int topNum){
	
		return getAllBus(lstQz, topNum); 
	}
	
	/**
	 * 根据体征ID和年份查询历史体征值
	 * @param signID
	 * @param nf
	 * @return
	 */
	/** zhucy 20170613 改变历史体征，原有方法注释**/
	/*public List<Double> getLstzByIdAndYear(String tzID, int nf){
		String sql = String.format("select IFNULL(tzz,0) tzz from t_cstz_tzzsydsj where tz_id= '%s' and nian=%d group by yf order by yf asc", tzID, nf);
		try {
			Query query = createSQLQuery(sql);
			query .setResultTransformer(Transformers.aliasToBean(CstzValue.class));
			List<CstzValue> dataList = query.list();
			if(dataList == null){
				return null;
			}
			
			List<Double> lstRes = new ArrayList<Double>();
			for(int i = 0; i < dataList.size(); i++){
				CstzValue obj = dataList.get(i);
				lstRes.add(obj.getTzz());
			}
			
			return lstRes;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		try{
			String sql;
			List<Double> lstRes = new ArrayList<Double>();
			for(int yf = 1; yf < 13; yf++){ //12个月
				CstzTzmxPojo cstzTzmxPojo = new CstzTzmxPojo();
				cstzTzmxPojo = this.cstzTzmxService.get(tzID);
				if (("3").equals(cstzTzmxPojo.getTzlx())) {
					sql = "select IFNULL(AVG(tzz),0) as tzz from t_cstz_tzzssj where tz_id=(SELECT ywtz_id FROM t_cstz_tzmx WHERE id = '"+tzID+"' LIMIT 1) and YEAR(data_time)=" + nf + " and MONTH(data_time)=" + yf;
				}else{
					sql = "select IFNULL(AVG(tzz),0) as tzz from t_cstz_tzzssj where tz_id= '"+tzID+"' and YEAR(data_time)=" + nf + " and MONTH(data_time)=" + yf;
				}
				Query query=createSQLQuery(sql);
				query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
				List result = query.list();
				if(result != null){
					Map map = (Map)result.get(0);
					lstRes.add(Double.valueOf(String.valueOf(map.get("tzz"))));
				}
			}
			
			return lstRes;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}*/
	
	/** zhucy 20170613 改变历史体征，新增方法**/
	public Map<String, Object> getLstzByIdAndYear(String tzID, int nf){
		Map<String, Object> result = new HashMap<String, Object>();
		String sql = "";
		List<String> timeStr = new ArrayList<String>();
		List<String> lstSignValue = new ArrayList<String>();
		List<Double> lstRes = new ArrayList<Double>();
		CstzTzmxPojo cstzTzmxPojo = new CstzTzmxPojo();
		cstzTzmxPojo = this.cstzTzmxService.get(tzID);
		if (("3").equals(cstzTzmxPojo.getTzlx())) {
			sql = "select IFNULL(FORMAT(AVG(IFNULL(tzz,0)),2),0) tzz,YEAR(data_time) x from t_cstz_tzzssj where tz_id=(SELECT ywtz_id FROM t_cstz_tzmx WHERE id = '"+tzID+"' LIMIT 1) GROUP BY YEAR (data_time) ORDER BY data_time DESC LIMIT 5 ";
		}else{
			sql = "select IFNULL(FORMAT(AVG(IFNULL(tzz,0)),2),0) tzz,YEAR(data_time) x from t_cstz_tzzssj where tz_id= '"+tzID+"' GROUP BY YEAR (data_time) ORDER BY data_time DESC LIMIT 5 ";
		}
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> list =query.list();
		if (null != list && list.size() > 0 ) {//组装图表数据
			for (int i = list.size() - 1; i >= 0; i--) {
				Map<String, Object> map = list.get(i);
				if (null != map.get("x")) {
					String x = map.get("x").toString();
					if (!StringUtil.isEmpty(x)) {
						timeStr.add(x);
						String tzz = "0";
						if (null != map.get("tzz")) {
							tzz = map.get("tzz").toString();
						}
						lstSignValue.add(tzz);
					}
				}
			}
		}
		result.put("lstSignValue", lstSignValue);
		result.put("x", timeStr);
		return result;
	}
	/**
	 * 根据体征名称和年份查询历史体征值
	 * @param signID
	 * @param nf
	 * @return
	 */
	/** zhucy 20170613改变历史体征,原有方法注释 **/
	/*public List<Double> getLstzByNameAndYear(String tzmc, int nf){
		String sql =String.format("select IFNULL(b.tzz,0) tzz from t_cstz_tzmx a left join t_cstz_tzzsydsj b on a.id=b.tz_id where a.tzmc='%s' and b.nian=%d group by b.yf order by b.yf asc", tzmc, nf);
		try {
			Query query = createSQLQuery(sql);
			query .setResultTransformer(Transformers.aliasToBean(CstzValue.class));
			List<CstzValue> dataList = query.list();
			if(dataList == null){
				return null;
			}
			
			List<Double> lstRes = new ArrayList<Double>();
			for(int i = 0; i < dataList.size(); i++){
				CstzValue obj = dataList.get(i);
				lstRes.add(obj.getTzz());
			}
			
			return lstRes;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
		try{
			String sql;
			List<Double> lstRes = new ArrayList<Double>();
			for(int yf = 1; yf < 13; yf++){ //12个月
				sql = "select IFNULL(AVG(b.tzz),0) as tzz from t_cstz_tzmx a left join t_cstz_tzzssj b on a.id=b.tz_id where a.tzmc='" + tzmc + "' and YEAR(b.data_time)=" + nf + " and MONTH(b.data_time)=" + yf;
				
				Query query=createSQLQuery(sql);
				query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
				List result = query.list();
				if(result != null){
					Map map = (Map)result.get(0);
					lstRes.add(Double.valueOf(String.valueOf(map.get("tzz"))));
				}
			}
			
			return lstRes;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}*/
	/** zhucy 20170613 改变历史体征，新增方法 **/
	public Map<String, Object> getLstzByNameAndYear(String tzmc, int nf){
		Map<String, Object> result = new HashMap<String, Object>();
		String sql = "";
		List<String> timeStr = new ArrayList<String>();
		List<String> lstSignValue = new ArrayList<String>();
		List<Double> lstRes = new ArrayList<Double>();
		sql = "select IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) as tzz,YEAR (b.data_time) x from t_cstz_tzmx a left join t_cstz_tzzssj b on a.id=b.tz_id where a.tzmc='" + tzmc + "' GROUP BY YEAR (b.data_time) ORDER BY b.data_time DESC LIMIT 5";
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> list =query.list();
		if (null != list && list.size() > 0 ) {//组装图表数据
			for (int i = list.size() - 1; i >= 0; i--) {
				Map<String, Object> map = list.get(i);
				if (null != map.get("x")) {
					String x = map.get("x").toString();
					if (!StringUtil.isEmpty(x)) {
						timeStr.add(x);
						String tzz = "0";
						if (null != map.get("tzz")) {
							tzz = map.get("tzz").toString();
						}
						lstSignValue.add(tzz);
					}
				}
			}
		}
		result.put("lstSignValue", lstSignValue);
		result.put("x", timeStr);
		return result;
	}

	/**
	 * 根据二级体征名称获取该体征最下级业务体征的ID集合(该方法已废弃！)
	 * @return
	 */
	public List<Integer> getJuniorBusID(String tzmc){
		String sql = String.format("select * from t_cstz_tzmx where parent_id in (select id from t_cstz_tzmx where parent_id in (select id from t_cstz_tzmx where tzmc='%s'))", tzmc);
		MySqlBean mysqlBean = null;
		List<Integer> lstSignID = new ArrayList<Integer>();
		try{
			mysqlBean = new MySqlBean(dbConfig);
			ResultSet rs = mysqlBean.ExcuteQuery(sql);
			while (rs.next()) {
				lstSignID.add(rs.getInt("id"));
			}			
		}catch (Exception ex) {
			return null;
 		}finally{
		try {
				if(mysqlBean != null)
					mysqlBean.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
		
		return lstSignID;
	}
	
	/**
	 * 获取四级体征占综合体征复合权重(该方法已废弃！)
	 * @return
	 */
	public Map<String, Float> getFourthComplexQz(List<Integer> lstID){
		Map<String, Float> mapSignQz = new HashMap<String, Float>();	
		for(int i = 0; i < lstID.size(); i++){
			int id = lstID.get(i);
			//业务指标占综合体征复合权重
			float complexQz = getComplexWeight(id);	
			mapSignQz.put(String.valueOf(id), (float)(Math.round(complexQz * 1000))/1000);
		}		
		
		return mapSignQz;
	}
	
	/**
	 * 获取四级体征占综合体征复合权重
	 * @return
	 */
	public List<CstzCommonPojo> getBusSignComplexQz(){
		String sql = "select a.id as tzID, a.ywtz_id as ywtzID, (IFNULL(a.qz,0) * (select IFNULL(b.qz,0) * (select IFNULL(c.qz,0) from t_cstz_tzmx c where c.id = b.parent_id) from t_cstz_tzmx b where b.id = a.parent_id)) as qz from t_cstz_tzmx a where tzlx='3' order by xssx asc";
		try {
			Query query = createSQLQuery(sql);
			//query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List dataList = query.list();
			
			List<CstzCommonPojo> resLst = new ArrayList<CstzCommonPojo>();
			if(dataList != null){
				for(int i = 0; i < dataList.size(); i++){
					Map map = (Map)dataList.get(i);
					CstzCommonPojo obj = new CstzCommonPojo();
					obj.setTzID(String.valueOf(map.get("tzID")));
					obj.setYwtzID(String.valueOf(map.get("ywtzID")));
					obj.setQz(BigDecimal.valueOf(Double.valueOf(String.valueOf(map.get("qz")))));
					obj.setGx(0.0);
					
					resLst.add(obj);
				}
			}
			
			return resLst;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取第四级体征占第二级体征复合权重
	 * @param tzmc
	 * @return
	 */
	public List<CstzCommonPojo> getComplexQzByTzmc(String tzmc){
		try{
			String sql = "select a.id as tzID,a.ywtz_id as ywtzID, (IFNULL(a.qz,0) * (select IFNULL(b.qz,0) from t_cstz_tzmx b where b.id = a.parent_id)) as qz from t_cstz_tzmx a where id in " +
						 "(select id from t_cstz_tzmx where parent_id in (select id from t_cstz_tzmx where parent_id=(select id from t_cstz_tzmx where tzmc='" + tzmc + "'))) order by xssx asc";
			
			Query query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List dataList = query.list();
			
			List<CstzCommonPojo> resLst = new ArrayList<CstzCommonPojo>();
			if(dataList != null){
				for(int i = 0; i < dataList.size(); i++){
					Map map = (Map)dataList.get(i);
					CstzCommonPojo obj = new CstzCommonPojo();
					obj.setTzID(String.valueOf(map.get("tzID")));
					obj.setYwtzID(String.valueOf(map.get("ywtzID")));
					obj.setQz(BigDecimal.valueOf(Double.valueOf(String.valueOf(map.get("qz")))));
					obj.setGx(0.0);
					
					resLst.add(obj);
				}
			}
			
			return resLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取第四级体征根据体征贡献值排序后的集合
	 * @return
	 */
	public List<CstzCommonPojo> getSignContributionSort(List<CstzCommonPojo> lstComplexQz){
		List<CstzCommonPojo> lstObj = getFourthContribution(lstComplexQz);
		if(lstObj == null){
			return null;
		}

		//按体征贡献值排序(升序)
		Collections.sort(lstObj);
        return lstObj;
	}
	
	/**
	 * 获取某二级体征下的所有第四级体征根据体征贡献值排序后的集合
	 * @param tzmc
	 * @return
	 */
	public List<CstzCommonPojo> getSignContributionByTzmc(List<CstzCommonPojo> lstQz, String tzmc){
		try{
			String sql = "select t.tz_id as tzID,IFNULL(t.tzz,0) tzz,t.xssx from (select a.tz_id,a.tzz,b.xssx from t_cstz_tzzssj a left join t_cstz_tzmx b on "
					+ "a.tz_id=b.id where a.tz_id in (select id from t_cstz_tzmx where parent_id in "
					+ "(select id from t_cstz_tzmx where parent_id=(select id from t_cstz_tzmx where tzmc='" + tzmc + "'))) order by a.data_time desc) t "
					+ "group by tzID order by xssx asc";
			
			Query query = createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			List<CstzCommonPojo> list = query.list();
			if(list == null){
				return null;
			}
			
			for(int i = 0; i < list.size(); i++){
				CstzCommonPojo objTzz = list.get(i);
				CstzCommonPojo objQz = lstQz.get(i);
				objTzz.setQz(BigDecimal.valueOf(objQz.getQz()));
				objTzz.setGx((double)(Math.round((objTzz.getTzz() * objQz.getQz()) * 1000))/1000);
			}
			
			//按体征贡献值排序(升序)
			Collections.sort(list);
	        return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取该体征和它的下级体征ID集合(该方法已废弃！)
	 * @return
	 */
	public List<Integer> getJuniorSignID(String tzmc){
		String sql = String.format("select * from t_cstz_tzmx where tzmc='%s' or parent_id in(select id from t_cstz_tzmx where tzmc='%s') order by id asc", tzmc, tzmc);
		MySqlBean mysqlBean = null;
		List<Integer> lstSignID = new ArrayList<Integer>();
		try{
			mysqlBean = new MySqlBean(dbConfig);
			ResultSet rs = mysqlBean.ExcuteQuery(sql);
			while (rs.next()) {
				lstSignID.add(rs.getInt("id"));
			}			
		}catch (Exception ex) {
			return null;
 		}finally{
		try {
				if(mysqlBean != null)
					mysqlBean.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
		
		return lstSignID;
	}
	
	/**
	 * 获取专题体征一级页面指标排行数据
	 * @param tzmc
	 * @return
	 */
	public List<CstzCommonPojo> getZttzOneIndexRank(String tzID){
		String sql = String.format("select a.id as tzID,a.tzmc,IFNULL(a.qz,0) qz,IFNULL(b.tzz,0) tzz,IFNULL(b.tzzk,'') tzzk,IFNULL(c.yz,'') yz,c.zyzbs,e.ywzbsj from t_cstz_tzmx a left join (select * from t_cstz_tzzssj order by data_time desc) b on a.ywtz_id=b.tz_id left join t_cstz_ywtz c on a.ywtz_id=c.id left join t_cstz_ywzb d on c.ywzb_id=d.id left join t_cstz_ywzbsj e on d.id=e.ywzb_id where a.parent_id='%s' group by a.id order by b.data_time desc", tzID);
		try {
			Query query = createSQLQuery(sql);
			query .setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			List<CstzCommonPojo> dataList = query.list();
			if(dataList == null){
				return null;
			}
			
			for(int i = 0; i < dataList.size(); i++){
				CstzCommonPojo obj = dataList.get(i);
				if("".equals(obj.getYz()))
					continue;
				
				obj.setGx((double)(Math.round((obj.getTzz() * obj.getQz()) * 1000))/1000);
				obj.setZbyz(getIndexThreshold(obj.getYz(), obj.getZyzbs()));
				obj.setLstz((List<String>) getLstzByIdAndYear(obj.getTzID(), 2016).get("lstSignValue"));
				obj.setX((List<String>) getLstzByIdAndYear(obj.getTzID(), 2016).get("x"));
			}
			
			return dataList;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取专题体征二级页面数据
	 * @param signID
	 * @return
	 */
	public List<CstzCommonPojo> getZttzTwoData(String tzID){
		//
		String sql = String.format("select a.id as tzID,a.tzmc,IFNULL(a.qz,0) qz,IFNULL(b.tzz,0) tzz,IFNULL(b.tzzk,'') tzzk,IFNULL(c.yz,'') yz,c.zyzbs,e.ywzbsj,d.sjdw,d.sjly,d.sjpl from t_cstz_tzmx a left join (select * from t_cstz_tzzssj) b on a.ywtz_id=b.tz_id left join t_cstz_ywtz c on b.tz_id = c.id left join t_cstz_ywzb d on c.ywzb_id=d.id left join t_cstz_ywzbsj e on d.id=e.ywzb_id AND e.data_time = b.data_time  where a.id='%s' ORDER BY b.data_time DESC LIMIT 1", tzID);
		try {
			Query query = createSQLQuery(sql);
			query .setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			List<CstzCommonPojo> dataList = query.list();
			if(dataList == null){
				return null;
			}
//			if (StringUtil.isEmpty(dataList.get(0).getYwzbsj()) || dataList.get(0).getYwzbsj().equals("0")) {
//				double b=(Math.random()*1000);//产生0-1000的整数随机数
//				dataList.get(0).setYwzbsj(String.valueOf(new BigDecimal(b).setScale(0, BigDecimal.ROUND_HALF_UP)));
//			}
			for(int i = 0; i < dataList.size(); i++){
				CstzCommonPojo obj = dataList.get(i);
				if("".equals(obj.getYz()))
					continue;
				
				obj.setZbyz(getIndexThreshold(obj.getYz(), obj.getZyzbs()));
				obj.setLstz((List<String>) getLstzByIdAndYear(obj.getTzID(), 2016).get("lstSignValue"));
				obj.setX((List<String>) getLstzByIdAndYear(obj.getTzID(), 2016).get("x"));
			}
			
			return dataList;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据体征ID获取最新体征数据（历史体征页面）
	 * @param signID
	 * @return
	 */
	public List<CstzCommonPojo> getNewestZhtzData(String tzmc){
		String sql = String.format("select a.id as tzID,a.tzmc,IFNULL(b.tzz,0) tzz,b.tzzk from t_cstz_tzmx a left join (select * from t_cstz_tzzssj ) b on a.id=b.tz_id where a.tzmc='%s' order by b.data_time desc limit 1", tzmc);
		try {
			Query query = createSQLQuery(sql);
			query .setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			List<CstzCommonPojo> dataList = query.list();
			if(dataList == null){
				return null;
			}
			
			return dataList;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//********************************** 以下为私有函数 ***************************************//
	
	/**
	 * 获取数据库配置
	 * @return
	 */
	private DBConfigure getDBConfigure(){
		//数据库配置
		DBConfigure dbConfig = null;
		dbConfig = new DBConfigure(Constants.DB_MYSQL);
	
		dbConfig.setDatabaseURL(SystemConfig.getProperty("dbUrl"));
		dbConfig.setDatabaseUser(SystemConfig.getProperty("dbUser"));
		dbConfig.setDatebasePassword(SystemConfig.getProperty("dbPwd"));
		
		return dbConfig;
	}
	
	/**
	 * 获取指标阈值
	 * @param yz  指标阈值
	 * @param i 最优标识位
	 * @return
	 */
	private List<String> getIndexThreshold(String yz, int i){
		String[] yzs = yz.split(",");
		List<String> lstYz = new ArrayList<String>();
		for (String string : yzs) {
			lstYz.add(string);
		}
//		if(i == 0){
//			for(int m = 0; m < yzs.length; m++){
//				lstYz.add(yzs[m]);
//			}
//		}else if(i == 3){
//			for(int n = yzs.length - 1; n >=0; n--){
//				lstYz.add(yzs[n]);
//			}
//		}
		
		return lstYz;
	}
	
	/**
	 * 获取最新四级体征占综合体征贡献值
	 * @return
	 */
	private List<CstzCommonPojo> getFourthContribution(List<CstzCommonPojo> lstQz){
		String sql = "select t.tz_id as tzID,IFNULL(t.tzz,0) tzz,t.xssx from (select a.tz_id,a.tzz,b.xssx from t_cstz_tzzssj a left join t_cstz_tzmx b on a.tz_id=b.ywtz_id where b.tzlx='3' order by a.data_time desc) t group by tzID order by xssx asc";
		try {
			Query query = createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
			List<CstzCommonPojo> list = query.list();
			if(list == null){
				return null;
			}
			
			for(int i = 0; i < list.size(); i++){
				CstzCommonPojo objTzz = list.get(i);
				CstzCommonPojo objQz = lstQz.get(i);
				objTzz.setQz(BigDecimal.valueOf(objQz.getQz()));
				objTzz.setGx((double)(Math.round((objTzz.getTzz() * objQz.getQz()) * 1000))/1000);
			}
			
			return list;  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	/**
	 * 获取最差指标TOP5(对应的四级体征ID)——该方法已经废弃！
	 * @return
	 */
	private Map<String,Float> getWorstSign(Map<String, Float> mapSign){
		int num = 0;
		Map<String, Float> mapWorstSign = new HashMap<String, Float>(); 
		Iterator iter = mapSign.entrySet().iterator();  
        while(iter.hasNext()){  
            if(num == 5){
		    	break;
		    }
  
            Map.Entry ent = (Map.Entry)iter.next();  
            String key = ent.getKey().toString();  
            String value = ent.getValue().toString(); 
		    mapWorstSign.put(key, Float.parseFloat(value));
		    num++;
        }  
        
        //排序(升序)
        ValueCompareAsc bvc =  new ValueCompareAsc(mapWorstSign);  
        TreeMap<String,Float> sorted_map = new TreeMap<String,Float>(bvc);
        sorted_map.putAll(mapWorstSign); 
		
		return sorted_map;
	}
	
	/**
	 * 获取最优指标TOP5(对应的四级体征ID)——该方法已经废弃！
	 * @return
	 */
	private Map<String, Float> getOptimalSign(Map<String, Float> mapSign, int topNum){	
		int num = 0;
		int count = mapSign.size();
		Map<String, Float> mapOptimalSign = new HashMap<String, Float>();  
		Iterator iter = mapSign.entrySet().iterator();  
        while(iter.hasNext()){  
            num++;
            Map.Entry ent = (Map.Entry)iter.next(); 
			if(num >= (count - topNum + 1)){    
	             String key = ent.getKey().toString();  
	             String value = ent.getValue().toString();
			     mapOptimalSign.put(key, Float.parseFloat(value));
		    }
        } 
        
        //排序(降序)
        ValueCompareDesc bvc =  new ValueCompareDesc(mapOptimalSign);  
        TreeMap<String,Float> sorted_map = new TreeMap<String,Float>(bvc);
        sorted_map.putAll(mapOptimalSign); 
	
		return sorted_map;
	}
	
	/**
	 * 获取业务指标占综合体征的复合权重(该方法已经废弃！)
	 * @param signID
	 * @return
	 */
	private Float getComplexWeight(int signID){
		float complexQz = 1.0f;
		MySqlBean mysqlBean = null;
		String sql ="select parent_id,IFNULL(qz,0) qz from t_cstz_tzmx where id=" + signID;
		try{
			mysqlBean = new MySqlBean(dbConfig);
			ResultSet rs = mysqlBean.ExcuteQuery(sql);
			while (rs.next()) {
				String parentID = String.valueOf(rs.getInt("parent_id"));
				complexQz = rs.getFloat("qz");
				if(!"null".equals(parentID) && !"0".equals(parentID)){
					complexQz = complexQz * getComplexWeight(Integer.parseInt(parentID));
				}
			}			
		}catch (Exception ex) {
			return null;
 		}finally{
		try {
				if(mysqlBean != null)
					mysqlBean.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
		
		return complexQz;
	}
	
	/**
	 * 获取指标排行Top5
	 * @param lstID
	 * @param order : 1 表示从按顺序遍历，2表示按倒序遍历
	 * @return
	 */
	private List<CstzCommonPojo> getTop(List<CstzCommonPojo> lstSign, int topNum, int order){
		String sql;
		List<CstzCommonPojo> lstRes = new ArrayList<CstzCommonPojo>();
		try {
			int num = 0;
			if(order == 1){
				for(int i = 0; i < lstSign.size(); i++){
					if(++num > topNum){
		        		break;
		        	}
					
					CstzCommonPojo obj = lstSign.get(i);
					sql = String.format("select a.id as tzID,a.tzmc,IFNULL(b.tzz,0) tzz,b.tzzk,c.yz,c.zyzbs,e.ywzbsj from t_cstz_tzmx a left join t_cstz_tzzssj b on a.ywtz_id=b.tz_id left join t_cstz_ywtz c on a.ywtz_id=c.id left join t_cstz_ywzb d on c.ywzb_id=d.id left join t_cstz_ywzbsj e on d.id= e.ywzb_id where a.ywtz_id='%s' order by b.data_time desc limit 1", obj.getTzID());
					Query query = createSQLQuery(sql);
					query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
					List<CstzCommonPojo> list = query.list();
					if(list != null){
						CstzCommonPojo resObj = list.get(0);
						resObj.setQz(new BigDecimal(obj.getQz(), MathContext.DECIMAL32));
						resObj.setGx(obj.getGx());
						resObj.setZbyz(getIndexThreshold(resObj.getYz(), resObj.getZyzbs()));
						resObj.setLstz((List<String>) getLstzByIdAndYear(resObj.getTzID(), 2016).get("lstSignValue"));
						resObj.setX((List<String>) getLstzByIdAndYear(resObj.getTzID(), 2016).get("x"));
						lstRes.add(resObj);
					}
				}
			}
			else if(order == 2){
				for(int j = (lstSign.size()-1); j >= 0; j--){
					if(++num > topNum){
		        		break;
		        	}
					
					CstzCommonPojo obj = lstSign.get(j);
					sql = String.format("select a.id as tzID,a.tzmc,IFNULL(b.tzz,0) tzz,b.tzzk,c.yz,c.zyzbs,e.ywzbsj from t_cstz_tzmx a left join t_cstz_tzzssj b on a.ywtz_id=b.tz_id left join t_cstz_ywtz c on a.ywtz_id=c.id left join t_cstz_ywzb d on c.ywzb_id=d.id left join t_cstz_ywzbsj e on d.id= e.ywzb_id where a.ywtz_id='%s' order by b.data_time desc limit 1", obj.getTzID());
					Query query = createSQLQuery(sql);
					query.setResultTransformer(Transformers.aliasToBean(CstzCommonPojo.class));
					List<CstzCommonPojo> list = query.list();
					if(list != null){
						CstzCommonPojo resObj = list.get(0);
						resObj.setQz(new BigDecimal(obj.getQz(), MathContext.DECIMAL32));
						resObj.setGx(obj.getGx());
						resObj.setZbyz(getIndexThreshold(resObj.getYz(), resObj.getZyzbs()));
						resObj.setLstz((List<String>) getLstzByIdAndYear(resObj.getTzID(), 2016).get("lstSignValue"));
						resObj.setX((List<String>) getLstzByIdAndYear(resObj.getTzID(), 2016).get("x"));
						lstRes.add(resObj);
					}
				}
			}
			
			return lstRes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		/*ResultSet rs = null;
		MySqlBean mysqlBean = null;
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>(); 
		try{
			//执行sql语句 
			mysqlBean = new MySqlBean(dbConfig);
			
			int num = 0;
			Iterator iter = mapSign.entrySet().iterator();  
	        while(iter.hasNext()){ 
	        	if(++num > topNum){
	        		break;
	        	}
	        	
	        	Map.Entry ent = (Map.Entry)iter.next();  
	            String key = ent.getKey().toString();  
	            String value = ent.getValue().toString(); 
	            int id = Integer.parseInt(key);
				float gx = Float.parseFloat(value);
				//复合权重
				float qz = (float)(Math.round(getComplexWeight(id) * 1000))/1000;
				//历史体征数据
				List<Float> lstHisValue = getLstzByIdAndYear(id, 2016);
				sql ="select a.id,a.tzmc,b.tzz,b.tzzk,b.data_time,c.ywzb_id,c.yz,c.zyzbs,d.ywzbsj from t_cstz_tzmx a left join t_cstz_tzzssj b on a.ywtz_id=b.tzzb_id left join t_cstz_ywtz c on a.ywtz_id=c.ywzb_id left join t_cstz_ywzbsj d on c.ywzb_id=d.ywzb_id where a.id=" + id + " order by data_time desc limit 1";
				rs = mysqlBean.ExcuteQuery(sql);
				Map<String, Object> rowMap = new HashMap<String, Object>();
				while (rs.next()) {
					rowMap.put("sign_id", rs.getInt("id"));
					rowMap.put("tzz", rs.getFloat("tzz"));
					rowMap.put("tzzk", rs.getString("tzzk"));
					rowMap.put("tzmc", rs.getString("tzmc"));
					rowMap.put("qz", qz);
					rowMap.put("ywzbsj", rs.getString("ywzbsj"));
					rowMap.put("gx", gx);
					List<String> zbyz = getIndexThreshold(rs.getString("yz"), rs.getInt("zyzbs"));
					rowMap.put("zbyz", zbyz);
					rowMap.put("lstz", lstHisValue);
					
					dataList.add(rowMap);
				}
	        }
		}catch (Exception ex) {
			return null;
 		}finally{
		try {
				if(mysqlBean != null)
					mysqlBean.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
		
		return dataList; */
	}
	
	/**
	 * 获取全部指标排行
	 * @param lstID
	 * @return
	 */
	private List<CstzAllBusPojo> getAllBus(List<CstzCommonPojo> lstSign, int topNum){
		String sql;
		List<CstzAllBusPojo> lstRes = new ArrayList<CstzAllBusPojo>();
		try {
			int num = 0;
			for(int i = 0; i < lstSign.size(); i++){
				CstzCommonPojo obj = lstSign.get(i);
				sql = String.format("select a.id as tzID,a.tzmc,IFNULL(b.tzz,0) tzz,IFNULL(b.tzzk,'') tzzk,IFNULL(c.yz,'') yz,c.zyzbs,e.ywzbsj from t_cstz_tzmx a left join t_cstz_tzzssj b on a.ywtz_id=b.tz_id left join t_cstz_ywtz c on a.ywtz_id=c.id left join t_cstz_ywzb d on c.ywzb_id=d.id left join t_cstz_ywzbsj e on d.id= e.ywzb_id where a.ywtz_id='%s' order by b.data_time desc limit 1", obj.getYwtzID());
				Query query = createSQLQuery(sql);
				query.setResultTransformer(Transformers.aliasToBean(CstzAllBusPojo.class));
				List<CstzAllBusPojo> list = query.list();
				if(list != null){
					CstzAllBusPojo resObj = list.get(0);
					if("".equals(resObj.getYz()))
						continue;
					
					resObj.setQz(new BigDecimal(obj.getQz(), MathContext.DECIMAL32));
					resObj.setGx((double)(Math.round((resObj.getTzz() * obj.getQz()) * 1000))/1000);
					resObj.setZbyz(getIndexThreshold(resObj.getYz(), resObj.getZyzbs()));
					resObj.setLstz((List<String>) getLstzByIdAndYear(resObj.getTzID(), 2016).get("lstSignValue"));
					resObj.setX((List<String>) getLstzByIdAndYear(resObj.getTzID(), 2016).get("x"));
					lstRes.add(resObj);
				}
			}

			//按权重值排序(降序)
			Collections.sort(lstRes);
			
			return lstRes.subList(0, topNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

	public Map<String, Object> getLstzByIndex(String tzmc, int nf, int index) {
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "";
		List<String> timeStr = new ArrayList<String>();
		List<String> lstSignValue = new ArrayList<String>();
		/*if (index == 0) {
			for(int i = 6; i>=0; i--){
				Date date = getDateAgo(i);
				Date start = getDateStart(date);
				String strStart = formater.format(start);
				Date end = getDateEnd(date);
				String strEnd = formater.format(end);
				String dateStr = getDateString(date);
			    sql =String.format("select FORMAT(b.tzz,1) as tzz FROM t_cstz_tzmx a LEFT JOIN t_cstz_tzzssj b ON a.id = b.tz_id where a.tzmc='%s' and b.data_time >='%s' AND b.data_time <='%s' ORDER BY b.data_time desc LIMIT 1", tzmc, strStart, strEnd);
			    Query query = createSQLQuery(sql);
				List<String> list = query.list();
//			    MySqlBean mysqlBean = null;
//				try{
//					mysqlBean = new MySqlBean(dbConfig);
//					ResultSet rs = mysqlBean.ExcuteQuery(sql);
					timeStr.add(dateStr);
					int size = lstSignValue.size();
					if (null != list && list.size() > 0 ) {
						lstSignValue.add(list.get(0));
					}
//					while (rs.next()) {
//						lstSignValue.add(rs.getString("tzz"));						
//					}	
					if (size == lstSignValue.size()) {//集合长度没有产生变化,证明当前查询无记录数据
						lstSignValue.add("");
					}			
//				}catch (Exception ex) {
//					return null;
//		 		}finally{
//				try {
//						if(mysqlBean != null)
//							mysqlBean.disConnect();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//		 		}
			}
		}
		if (index == 1) {
			for(int i = 30; i>=0; i--){
				Date date = getDateAgo(i);
				Date start = getDateStart(date);
				String strStart = formater.format(start);
				Date end = getDateEnd(date);
				String strEnd = formater.format(end);
				String dateStr = getDateString(date);
			    sql =String.format("select FORMAT(b.tzz,1) as tzz FROM t_cstz_tzmx a LEFT JOIN t_cstz_tzzssj b ON a.id = b.tz_id where a.tzmc='%s' and b.data_time >='%s' AND b.data_time <='%s' ORDER BY b.data_time desc LIMIT 1", tzmc, strStart, strEnd);
			    Query query = createSQLQuery(sql);
				List<String> list = query.list();
//			    MySqlBean mysqlBean = null;
//				try{
//					mysqlBean = new MySqlBean(dbConfig);
//					ResultSet rs = mysqlBean.ExcuteQuery(sql);
					timeStr.add(dateStr);
					int size = lstSignValue.size();
					if (null != list && list.size() > 0 ) {
						lstSignValue.add(list.get(0));
					}
//					while (rs.next()) {
//						lstSignValue.add(rs.getString("tzz"));						
//					}	
					if (size == lstSignValue.size()) {//集合长度没有产生变化,证明当前查询无记录数据
						lstSignValue.add("");
					}
//				}catch (Exception ex) {
//					return null;
//		 		}finally{
//				try {
//						if(mysqlBean != null)
//							mysqlBean.disConnect();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//		 		}
			}
		}*/
		if (index == 0) {//按照日维度统计查询
			sql =String.format("SELECT IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) tzz,"
					+ " CONCAT(YEAR (b.data_time),'-',"
					+ " IF(LENGTH(MONTH (b.data_time)) > 1,MONTH (b.data_time),CONCAT('0',MONTH (b.data_time)) ),"
					+ "'-',IF(LENGTH(DAY (b.data_time)) > 1,DAY (b.data_time),CONCAT('0',DAY (b.data_time)) )) x "
					+ " FROM t_cstz_tzmx a LEFT JOIN t_cstz_tzzssj b ON a.id = b.tz_id "
					+ " WHERE a.tzmc = '%s' GROUP BY CONCAT( YEAR (b.data_time), MONTH (b.data_time), DAY(b.data_time) ) "
					+ " ORDER BY b.data_time DESC LIMIT 30", tzmc);
		}else if (index == 1){//按照月维度统计查询
			sql =String.format("SELECT IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) tzz,"
					+ " CONCAT(YEAR (data_time),'-',"
					+ " IF(LENGTH(MONTH (data_time)) > 1,MONTH (data_time),CONCAT('0',MONTH (data_time)) )) x"
					+ " FROM t_cstz_tzmx a LEFT JOIN t_cstz_tzzssj b ON a.id = b.tz_id "
					+ " WHERE a.tzmc = '%s' GROUP BY CONCAT( YEAR (b.data_time), MONTH (b.data_time)) "
					+ " ORDER BY b.data_time DESC LIMIT 12", tzmc);
		}
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> list =query.list();
		if (null != list && list.size() > 0 ) {//组装图表数据
			for (int i = list.size() - 1; i >= 0; i--) {
				Map<String, Object> map = list.get(i);
				if (null != map.get("x")) {
					String x = map.get("x").toString();
					if (!StringUtil.isEmpty(x)) {
						timeStr.add(x);
						String tzz = "0";
						if (null != map.get("tzz")) {
							tzz = map.get("tzz").toString();
						}
						lstSignValue.add(tzz);
					}
				}
			}
		}
		result.put("lstSignValue", lstSignValue);
		result.put("x", timeStr);
		return result;
	}
	
	/**
	 * 获取一天的开始时间
	 * @param date
	 * @return
	 */
	public Date getDateStart(Date date){
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    Date start = calendar.getTime();
		return start;
	}
	
	/**
	 * 获取一天的结束时间
	 * @param date
	 * @return
	 */
	public Date getDateEnd(Date date){
		Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        int hour = cal.get(Calendar.HOUR_OF_DAY);  
        int minute = cal.get(Calendar.MINUTE);  
        int second = cal.get(Calendar.SECOND);  
        //时分秒（毫秒数）  
        long millisecond = hour*60*60*1000 + minute*60*1000 + second*1000;  
        //凌晨00:00:00  
        cal.setTimeInMillis(cal.getTimeInMillis()-millisecond);
        //凌晨23:59:59  
        cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
	    Date end = cal.getTime();
		return end;
	}
	
	/**
	 * 获取之前的某一天
	 * @param i
	 * @return
	 */
	public Date getDateAgo(int i){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -i);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 获取某一天时间(年/月/日)
	 * @param i
	 * @return
	 */
	public String getDateString(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DATE);
	    int month = calendar.get(Calendar.MONTH) + 1;
	    int year = calendar.get(Calendar.YEAR);
		return year+"/"+month+"/"+day;
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        int hour = cal.get(Calendar.HOUR_OF_DAY);  
        int minute = cal.get(Calendar.MINUTE);  
        int second = cal.get(Calendar.SECOND);  
        //时分秒（毫秒数）  
        long millisecond = hour*60*60*1000 + minute*60*1000 + second*1000;  
        //凌晨00:00:00  
        cal.setTimeInMillis(cal.getTimeInMillis()-millisecond);
        //凌晨23:59:59  
        cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);  
        System.out.println(cal.getTime());
	}

	@Override
	public Map<String, Object> getLstzByIndexById(String tzID, int nf, int index) {
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "";
		List<String> timeStr = new ArrayList<String>();
		List<String> lstSignValue = new ArrayList<String>();
		/*if (index == 0) {
			for(int i = 6; i>=0; i--){
				Date date = getDateAgo(i);
				Date start = getDateStart(date);
				String strStart = formater.format(start);
				Date end = getDateEnd(date);
				String strEnd = formater.format(end);
				String dateStr = getDateString(date);
			    sql =String.format("select FORMAT(b.tzz,1) as tzz FROM t_cstz_tzmx a LEFT JOIN t_cstz_tzzssj b ON a.id = b.tz_id where a.id='%s' and b.data_time >='%s' AND b.data_time <='%s' ORDER BY b.data_time desc LIMIT 1", tzID, strStart, strEnd);
			    Query query = createSQLQuery(sql);
				List<String> list = query.list();
//			    MySqlBean mysqlBean = null;
//				try{
//					mysqlBean = new MySqlBean(dbConfig);
//					ResultSet rs = mysqlBean.ExcuteQuery(sql);
					timeStr.add(dateStr);
					int size = lstSignValue.size();
					if (null != list && list.size() > 0 ) {
						lstSignValue.add(list.get(0));
					}
//					while (rs.next()) {
//						lstSignValue.add(rs.getString("tzz"));						
//					}	
					if (size == lstSignValue.size()) {//集合长度没有产生变化,证明当前查询无记录数据
						lstSignValue.add("");
					}			
//				}catch (Exception ex) {
//					return null;
//		 		}finally{
//				try {
//						if(mysqlBean != null)
//							mysqlBean.disConnect();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//		 		}
			}
		}
		if (index == 1) {
			for(int i = 30; i>=0; i--){
				Date date = getDateAgo(i);
				Date start = getDateStart(date);
				String strStart = formater.format(start);
				Date end = getDateEnd(date);
				String strEnd = formater.format(end);
				String dateStr = getDateString(date);
			    sql =String.format("select FORMAT(b.tzz,1) as tzz FROM t_cstz_tzmx a LEFT JOIN t_cstz_tzzssj b ON a.id = b.tz_id where a.id='%s' and b.data_time >='%s' AND b.data_time <='%s' ORDER BY b.data_time desc LIMIT 1", tzID, strStart, strEnd);
			    Query query = createSQLQuery(sql);
				List<String> list = query.list();
//			    MySqlBean mysqlBean = null;
//				try{
//					mysqlBean = new MySqlBean(dbConfig);
//					ResultSet rs = mysqlBean.ExcuteQuery(sql);
					timeStr.add(dateStr);
					int size = lstSignValue.size();
					if (null != list && list.size() > 0 ) {
						lstSignValue.add(list.get(0));
					}
//					while (rs.next()) {
//						lstSignValue.add(rs.getString("tzz"));						
//					}	
					if (size == lstSignValue.size()) {//集合长度没有产生变化,证明当前查询无记录数据
						lstSignValue.add("");
					}
//				}catch (Exception ex) {
//					return null;
//		 		}finally{
//				try {
//						if(mysqlBean != null)
//							mysqlBean.disConnect();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//		 		}
			}
		}*/
		/********** zhucy 20170613增加历史体征新方案 ***********/
		CstzTzmxPojo cstzTzmxPojo = new CstzTzmxPojo();
		cstzTzmxPojo = this.cstzTzmxService.get(tzID);
		if (index == 0) {//按照日维度统计查询
			if (("3").equals(cstzTzmxPojo.getTzlx())) {
				sql =   "SELECT IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) tzz,"
						+ " CONCAT(YEAR (b.data_time),'-',"
						+ " IF(LENGTH(MONTH (b.data_time)) > 1,MONTH (b.data_time),CONCAT('0',MONTH (b.data_time)) ),"
						+ "'-',IF(LENGTH(DAY (b.data_time)) > 1,DAY (b.data_time),CONCAT('0',DAY (b.data_time)) )) x "
						+ " FROM t_cstz_tzzssj b "
						+ " where b.tz_id=(SELECT ywtz_id FROM t_cstz_tzmx WHERE id = '"+tzID+"' LIMIT 1) "
						+ " GROUP BY CONCAT( YEAR (b.data_time), MONTH (b.data_time), DAY(b.data_time) ) "
						+ " ORDER BY b.data_time DESC LIMIT 30";
			}else{
				sql =   "SELECT IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) tzz,"
						+ " CONCAT(YEAR (b.data_time),'-',"
						+ " IF(LENGTH(MONTH (b.data_time)) > 1,MONTH (b.data_time),CONCAT('0',MONTH (b.data_time)) ),"
						+ "'-',IF(LENGTH(DAY (b.data_time)) > 1,DAY (b.data_time),CONCAT('0',DAY (b.data_time)) )) x "
						+ " FROM t_cstz_tzzssj b "
						+ " where b.tz_id='"+tzID+"' "
						+ " GROUP BY CONCAT( YEAR (b.data_time), MONTH (b.data_time),DAY(b.data_time) ) "
						+ " ORDER BY b.data_time DESC LIMIT 30";
			}
//			sql =String.format("SELECT IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) tzz,"
//					+ " CONCAT(YEAR (b.data_time),'-',"
//					+ " IF(LENGTH(MONTH (b.data_time)) > 1,MONTH (b.data_time),CONCAT('0',MONTH (b.data_time)) ),"
//					+ "'-',IF(LENGTH(DAY (b.data_time)) > 1,DAY (b.data_time),CONCAT('0',DAY (b.data_time)) )) x "
//					+ " FROM t_cstz_tzzssj b "
//					+ " where b.tz_id=(SELECT ywtz_id FROM t_cstz_tzmx WHERE id = '"+tzID+"' LIMIT 1) "
//					+ " GROUP BY CONCAT( YEAR (b.data_time), MONTH (b.data_time), DAY(b.data_time) ) "
//					+ " ORDER BY b.data_time DESC LIMIT 30", tzID);
		}else if (index == 1){//按照月维度统计查询
			if (("3").equals(cstzTzmxPojo.getTzlx())) {
				sql =   "SELECT IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) tzz,"
						+ " CONCAT(YEAR (b.data_time),'-',"
						+ " IF(LENGTH(MONTH (b.data_time)) > 1,MONTH (b.data_time),CONCAT('0',MONTH (b.data_time)) )) x "
						+ " FROM t_cstz_tzzssj b "
						+ " where b.tz_id=(SELECT ywtz_id FROM t_cstz_tzmx WHERE id = '"+tzID+"' LIMIT 1) "
						+ " GROUP BY CONCAT( YEAR (b.data_time), MONTH (b.data_time) ) "
						+ " ORDER BY b.data_time DESC LIMIT 12";
			}else{
				sql =   "SELECT IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) tzz,"
						+ " CONCAT(YEAR (b.data_time),'-',"
						+ " IF(LENGTH(MONTH (b.data_time)) > 1,MONTH (b.data_time),CONCAT('0',MONTH (b.data_time)) )) x "
						+ " FROM t_cstz_tzzssj b "
						+ " where b.tz_id='"+tzID+"' "
						+ " GROUP BY CONCAT( YEAR (b.data_time), MONTH (b.data_time) ) "
						+ " ORDER BY b.data_time DESC LIMIT 12";
			}
//			sql =String.format("SELECT IFNULL(FORMAT(AVG(IFNULL(b.tzz,0)),2),0) tzz,"
//					+ " CONCAT(YEAR (data_time),'-',"
//					+ " IF(LENGTH(MONTH (data_time)) > 1,MONTH (data_time),CONCAT('0',MONTH (data_time)) )) x"
//					+ " FROM t_cstz_tzmx a LEFT JOIN t_cstz_tzzssj b ON a.id = b.tz_id "
//					+ " WHERE a.id = '%s' GROUP BY CONCAT( YEAR (b.data_time), MONTH (b.data_time)) "
//					+ " ORDER BY b.data_time DESC LIMIT 12", tzID);
		}
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> list =query.list();
		if (null != list && list.size() > 0 ) {//组装图表数据
			for (int i = list.size() - 1; i >= 0; i--) {
				Map<String, Object> map = list.get(i);
				if (null != map.get("x")) {
					String x = map.get("x").toString();
					if (!StringUtil.isEmpty(x)) {
						timeStr.add(x);
						String tzz = "0";
						if (null != map.get("tzz")) {
							tzz = map.get("tzz").toString();
						}
						lstSignValue.add(tzz);
					}
				}
			}
		}
		result.put("lstSignValue", lstSignValue);
		result.put("x", timeStr);
		return result;
	}
	
	/**
	 * 查询城市体征模型数据
	 * @return
	 */
	public JSONArray queryCstzModelData(){
		try{
			JSONArray arrOne = new JSONArray();
			JSONObject objOne = new JSONObject();
			//一级体征
			String sql = "select * from t_cstz_tzmx where tzlx='0'";
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);

					String id = String.valueOf(map.get("id"));
					objOne.put("id", id);
					objOne.put("hasStatic", Boolean.FALSE);
					objOne.put("modified", Boolean.FALSE);
					objOne.put("name", String.valueOf(map.get("tzmc")) + "指数");
					objOne.put("staticKey", null);
					objOne.put("staticName", null);
					objOne.put("staticValue", 0);
					objOne.put("signLevel", 1);    //体征级别
					String qz = String.valueOf(map.get("qz"));
					if("1".equalsIgnoreCase(qz)){
						qz = "1.0";
					}
					objOne.put("value", qz);
					
					//二级体征
					JSONArray arrTwo = new JSONArray();
					sql = "select * from t_cstz_tzmx where parent_id=(select id from t_cstz_tzmx where tzlx='0')";
					query=createSQLQuery(sql);
					query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
					List result2 = query.list();
					if(result2 != null){
						int count = result2.size();
						for(int j = 0;j < result2.size(); j++){
							map = (Map)result2.get(j);
							
							JSONObject objTwo = new JSONObject();
							id = String.valueOf(map.get("id"));
							objTwo.put("id", id);
							objTwo.put("hasStatic", Boolean.FALSE);
							objTwo.put("modified", Boolean.FALSE);
							objTwo.put("name", String.valueOf(map.get("tzmc")) + "指数");
							objTwo.put("staticKey", null);
							objTwo.put("staticName", null);
							objTwo.put("staticValue", 0);
							objTwo.put("signLevel", 2);    //体征级别
							qz = String.valueOf(map.get("qz"));
							if("1".equalsIgnoreCase(qz)){
								qz = "1.0";
							}
							objTwo.put("value", qz);
							
							//三级体征
							JSONArray arrThree = new JSONArray();
							sql = "select * from t_cstz_tzmx where parent_id=(select id from t_cstz_tzmx where id='" + id + "')";
							query=createSQLQuery(sql);
							query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
							List result3 = query.list();
							if(result3 != null){
								for(int k = 0;k < result3.size(); k++){
									map = (Map)result3.get(k);
									
									JSONObject objThree = new JSONObject();
									id = String.valueOf(map.get("id"));
									objThree.put("id", id);
									objThree.put("hasStatic", Boolean.FALSE);
									objThree.put("modified", Boolean.FALSE);
									objThree.put("name", String.valueOf(map.get("tzmc")) + "指数");
									objThree.put("staticKey", null);
									objThree.put("staticName", null);
									objThree.put("staticValue", 0);
									objThree.put("signLevel", 3);    //体征级别
									qz = String.valueOf(map.get("qz"));
									if("1".equalsIgnoreCase(qz)){
										qz = "1.0";
									}
									objThree.put("value", qz);
									
									//四级体征
									JSONArray arrFour = new JSONArray();
									sql = "select a.id,a.tzmc,a.qz,c.sjdw from t_cstz_tzmx a left join t_cstz_ywtz b on a.ywtz_id=b.id left join t_cstz_ywzb c on b.ywzb_id=c.id where a.parent_id=(select id from t_cstz_tzmx where id='" + id + "')";
									query=createSQLQuery(sql);
									query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
									List result4 = query.list();
									if(result4 != null){
										for(int p = 0;p < result4.size(); p++){
											map = (Map)result4.get(p);
											
											JSONObject objFour = new JSONObject();
											objFour.put("children", null);
											id = String.valueOf(map.get("id"));
											objFour.put("id", id);
											objFour.put("hasStatic", Boolean.FALSE);
											objFour.put("modified", Boolean.FALSE);
											objFour.put("name", String.valueOf(map.get("tzmc")) + "(" + String.valueOf(map.get("sjdw")) + ")");
											objFour.put("staticKey", null);
											objFour.put("staticName", null);
											objFour.put("staticValue", 0);
											objFour.put("signLevel", 4);    //体征级别
											qz = String.valueOf(map.get("qz"));
											if("1".equalsIgnoreCase(qz)){
												qz = "1.0";
											}
											objFour.put("value", qz);
											
											arrFour.add(objFour);
										}
									}
									
									objThree.put("children", arrFour);
									arrThree.add(objThree);
								}
							}
							
							objTwo.put("children", arrThree);
							arrTwo.add(objTwo);
						}
					}
					
					objOne.put("children", arrTwo);
					arrOne.add(objOne);
				}
			}
			
			return arrOne;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	/**
	 * 阈值处理
	 * @param yz
	 * @return
	 */
	private List<String> yzHandle(String yz){
		String[] yzs = yz.split(",");
		List<String> lstYz = new ArrayList<String>();
		for (String string : yzs) {
			lstYz.add(string);
		}
		return lstYz;
	}
	
	@Override
	public List<ZbphPojo> getZhtzYjZbphData(int type) {
		//先获取基础数据，再计算贡献值和权重
		String sql = " SELECT "
					+ "	b.tz_id AS tzID,"
					+ "	a.tzmc,"
					+ "	d.ywzbsj,"
					+ "	ROUND(IFNULL(b.tzz, 0),2) tzz,"
					+ "	b.tzzk,"
					+ "	c.yz,"
					+ " a.id ywtzID "
					+ " FROM t_cstz_tzmx a "
					+ " LEFT JOIN t_cstz_tzzssj b ON a.ywtz_id = b.tz_id"
					+ " LEFT JOIN t_cstz_ywtz c ON c.id = b.tz_id"
					+ " LEFT JOIN t_cstz_ywzbsj d ON c.ywzb_id = d.ywzb_id"
					+ " WHERE a.tzlx = '3'"
					+ " GROUP BY b.tz_id ";
		List<ZbphPojo> lstRes = new ArrayList<ZbphPojo>();
		if (type == 0) {//最差排名TOP5
			sql = sql + " ORDER BY b.tzz ASC , b.data_time DESC LIMIT 5";
		}else if (type == 1){//最优排名TOP5
			sql = sql + " ORDER BY b.tzz DESC , b.data_time DESC LIMIT 5";
		}else {//全部
			sql = sql + " ORDER BY b.tzz DESC , b.data_time DESC";
		}
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(ZbphPojo.class));
		lstRes = query.list();
		for (ZbphPojo cstzCommonPojo : lstRes) {
			this.getQz(cstzCommonPojo);
			cstzCommonPojo.setZbyz(yzHandle(cstzCommonPojo.getYz()));
//			cstzCommonPojo.setLstz((List<String>) getLstzByIdAndYear(cstzCommonPojo.getYwtzID(), 2016).get("lstSignValue"));
//			cstzCommonPojo.setX((List<String>) getLstzByIdAndYear(cstzCommonPojo.getYwtzID(), 2016).get("x"));
		}
		return lstRes;
	}
	
	/**
	 * 获取最下级体征占一级体征的权重 综合体征一级
	 * @param id
	 * @return
	 */
	private void getQz(ZbphPojo pojo){
		String id = pojo.getYwtzID();
		BigDecimal qz = BigDecimal.ONE;
		for (int i = 0; i < 3; i++) {
			CstzTzmxPojo cstzTzmxPojo = this.cstzTzmxService.get(id);
			if (null != cstzTzmxPojo) {
				if (!StringUtil.isEmpty(cstzTzmxPojo.getParentId())) {
					qz = qz.multiply(cstzTzmxPojo.getQz()).setScale(4, BigDecimal.ROUND_HALF_UP);
					id = cstzTzmxPojo.getParentId();
				}
			}	
		}
		pojo.setQz(qz);
		pojo.setGx(pojo.getQz().multiply(pojo.getTzz()).setScale(4, BigDecimal.ROUND_HALF_UP));
	}
	
	
	/**
	 * 获取最下级体征占一级体征的权重 综合体征二级
	 * @param id
	 * @return
	 */
	private void getQzEj(ZbphPojo pojo){
		String id = pojo.getYwtzID();
		BigDecimal qz = BigDecimal.ONE;
		for (int i = 0; i < 3; i++) {
			CstzTzmxPojo cstzTzmxPojo = this.cstzTzmxService.get(id);
			if (null != cstzTzmxPojo) {
				if (!StringUtil.isEmpty(cstzTzmxPojo.getParentId())) {
					qz = qz.multiply(cstzTzmxPojo.getQz()).setScale(4, BigDecimal.ROUND_HALF_UP);
					id = cstzTzmxPojo.getParentId();
				}
			}	
		}
		pojo.setQz(qz);
		pojo.setGx(pojo.getQz().multiply(pojo.getTzz()).setScale(4, BigDecimal.ROUND_HALF_UP));
	}

	@Override
	public List<ZbphPojo> geteZhtzEjZbphData(String tzmc, int type) {
		String sql ="SELECT b.tz_id AS tzID,a.tzmc,d.ywzbsj,"
				+ " ROUND(IFNULL(b.tzz, 0), 2) tzz,b.tzzk,c.yz,a.id ywtzID "
				+ " FROM t_cstz_tzmx a "
				+ " LEFT JOIN t_cstz_tzzssj b ON a.ywtz_id = b.tz_id "
				+ " LEFT JOIN t_cstz_ywtz c ON c.id = b.tz_id "
				+ " LEFT JOIN t_cstz_ywzbsj d ON c.ywzb_id = d.ywzb_id "
				+ " WHERE "
				+ " a.tzlx = '3' "
				+ " AND b.tz_id IN "
				+ " ( SELECT ywtz_id FROM t_cstz_tzmx WHERE tzlx = '3' AND parent_id IN "
				+ " ( SELECT id FROM t_cstz_tzmx WHERE parent_id = "
				+ " ( SELECT id FROM t_cstz_tzmx WHERE tzmc = '"+tzmc+"' ))) "
				+ " GROUP BY b.tz_id";
		List<ZbphPojo> lstRes = new ArrayList<ZbphPojo>();
		if (type == 0) {//最差排名TOP3
			sql = sql + " ORDER BY b.tzz ASC , b.data_time DESC LIMIT 3";
		}else if (type == 1){//最优排名TOP3
			sql = sql + " ORDER BY b.tzz DESC , b.data_time DESC LIMIT 3";
		}else {//全部
			sql = sql + " ORDER BY b.tzz DESC , b.data_time DESC";
		}
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(ZbphPojo.class));
		lstRes = query.list();
		for (ZbphPojo cstzCommonPojo : lstRes) {
			this.getQzEj(cstzCommonPojo);
			cstzCommonPojo.setZbyz(yzHandle(cstzCommonPojo.getYz()));
//			cstzCommonPojo.setLstz((List<String>) getLstzByIdAndYear(cstzCommonPojo.getYwtzID(), 2016).get("lstSignValue"));
//			cstzCommonPojo.setX((List<String>) getLstzByIdAndYear(cstzCommonPojo.getYwtzID(), 2016).get("x"));
		}
		return lstRes;
	}

	@Override
	public List<ZbphPojo> getZttzOneIndexRankNew(String tzID) {
		String sql = "SELECT b.tz_id AS tzID,a.tzmc,d.ywzbsj,"
				+ "ROUND(IFNULL(b.tzz, 0), 2) tzz,b.tzzk,c.yz,"
				+ "a.id ywtzID,a.qz,ROUND(a.qz*IFNULL(b.tzz, 0),2) gx "
				+ " FROM t_cstz_tzmx a"
				+ " LEFT JOIN t_cstz_tzzssj b ON a.ywtz_id = b.tz_id"
				+ " LEFT JOIN t_cstz_ywtz c ON c.id = b.tz_id"
				+ " LEFT JOIN t_cstz_ywzbsj d ON c.ywzb_id = d.ywzb_id "
				+ " WHERE a.tzlx = '3' AND a.parent_id = '"+tzID+"' GROUP BY b.tz_id ORDER BY a.xssx ASC,b.data_time DESC LIMIT 2";
		List<ZbphPojo> lstRes = new ArrayList<ZbphPojo>();
		Query query = createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(ZbphPojo.class));
		lstRes = query.list();
		for (ZbphPojo cstzCommonPojo : lstRes) {
			cstzCommonPojo.setZbyz(yzHandle(cstzCommonPojo.getYz()));
//			cstzCommonPojo.setLstz((List<String>) getLstzByIdAndYear(cstzCommonPojo.getYwtzID(), 2016).get("lstSignValue"));
//			cstzCommonPojo.setX((List<String>) getLstzByIdAndYear(cstzCommonPojo.getYwtzID(), 2016).get("x"));
		}
		return lstRes;
	}
	
}