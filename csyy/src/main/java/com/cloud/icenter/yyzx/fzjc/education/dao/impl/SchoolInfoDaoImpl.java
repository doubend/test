
package com.cloud.icenter.yyzx.fzjc.education.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.fzjc.education.dao.SchoolInfoDao;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolInfo;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolQueryParam;

/**
* Created with gender.
* @author: whcai
* Date: 2017-07-04 17:37:40
*/
@Repository
public class SchoolInfoDaoImpl extends BaseDaoImpl<SchoolInfo> implements SchoolInfoDao {

	/**
	 * 根据条件查询学校信息
	 * @param xxlx : 1幼儿园； 2小学； 3初中； 4高中 等
	 * @return
	 */
	public List<JSONObject> getSchoolByXxlx(SchoolQueryParam param){
		try{
			List<JSONObject> lstRes = new ArrayList<JSONObject>();
			//学校类型
			String xxType = "2";  //默认小学
			int startYear = 2013,endYear = 2014;
			String grade = "一年级";  //年级
			Calendar now = Calendar.getInstance();
			int curYear = now.get(now.YEAR);
			if("幼儿园".equals(param.getXxlx())){
				xxType = "1";
				grade = "小班";
				startYear = curYear - 4;  //幼儿园的适龄学童为3到4岁
				endYear = curYear - 3;
			}else if("小学".equals(param.getXxlx())){
				xxType = "2";
				grade = "一年级";
				startYear = curYear - 8;  //小学的适龄学童为6到8岁
				endYear = curYear - 6;
			}else if("初中".equals(param.getXxlx())) {
				xxType = "3";
				grade = "初一";
				startYear = curYear - 14;  //初中的适龄学童为12到14岁
				endYear = curYear - 12;
			} else {
				xxType = "2";
				grade = "一年级";
				startYear = curYear - 8;  
				endYear = curYear - 6;
			}
			
			//年份
			int nf = StringUtil.isEmpty(String.valueOf(param.getNf()))?2017:param.getNf();	
			//排序类型
			String sortType = "";
			if("招生名额".equals(param.getSortType())){
				sortType = "zsme";
			} else if("适龄学童".equals(param.getSortType())){
				sortType = "slxt";
			} else if("名额不足".equals(param.getSortType())){
				sortType = "mebz";
			} else {
				sortType = "";
			}
			
			String sql = "select a.xxjbxxwybsm,a.xxjc,a.szdxzqhbm,a.xxlx,a.dizhi,a.x,a.y,IFNULL(b.njzrs,0) as zsme,IFNULL(c.slxt,0) as slxt,(IFNULL(c.slxt,0) - IFNULL(b.njzrs,0)) as mebz from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join "
					   + "(select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm "
					   + "where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + "  GROUP BY x.xxjbxxwybsm) c on b.xxwybsm=c.xxjbxxwybsm "
					   + "where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + nf;
			
			if(!StringUtil.isEmpty(param.getXzqdm())){
				sql += " and a.szdxzqhbm='" + param.getXzqdm() + "'";
			}
			if(!StringUtil.isEmpty(sortType)){
				sql += " order by " + sortType + " desc";
			}
			
			Query query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			if(result != null){
				for(int i = 0; i < result.size(); i++){
					Map map = (Map)result.get(i);
					
					JSONObject obj = new JSONObject();
					obj.put("xxjc", String.valueOf(map.get("xxjc")));
					obj.put("DiZhi", String.valueOf(map.get("dizhi")));
					obj.put("xxlx", StringUtil.isEmpty(param.getXxlx())?"小学":param.getXxlx());
					obj.put("zsme", Integer.valueOf(String.valueOf(map.get("zsme"))));
					obj.put("slxt", Integer.valueOf(String.valueOf(map.get("slxt"))));
					obj.put("mebz", Integer.valueOf(String.valueOf(map.get("mebz"))));
					obj.put("x", String.valueOf(map.get("x")));
					obj.put("y", String.valueOf(map.get("y")));
					
					lstRes.add(obj);
				}
			}
			
			return lstRes;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取学区信息
	 * @param xxlx ： 学校类型
	 * @param name ： 学校名称
	 * @return
	 */
	public List<JSONObject> getXqInfoByName(String xxlx, String name, int nf){
		try{
			List<JSONObject> lstRes = new ArrayList<JSONObject>();
			String xxType = "2";  //默认小学
			int startYear = 2013,endYear = 2014;
			String grade = "一年级";  //年级
			Calendar now = Calendar.getInstance();
			int curYear = now.get(now.YEAR);
			if("幼儿园".equals(xxlx)){
				xxType = "1";
				grade = "小班";
				startYear = curYear - 4;  //幼儿园的适龄学童为3到4岁
				endYear = curYear - 3;
			}else if("小学".equals(xxlx)){
				xxType = "2";
				grade = "一年级";
				startYear = curYear - 8;  //小学的适龄学童为6到8岁
				endYear = curYear - 6;
			}else if("初中".equals(xxlx)) {
				xxType = "3";
				grade = "初一";
				startYear = curYear - 14;  //初中的适龄学童为12到14岁
				endYear = curYear - 12;
			} else {
				xxType = "2";
				grade = "一年级";
				startYear = curYear - 8;  
				endYear = curYear - 6;
			}
			
			String sql = "select a.xxjc,a.dizhi,a.x as xxX,a.y as xxY,c.xiaoqu,d.x as xqX,d.y as xqY,d.jiedao,count(e.xingming) as slxt,b.zsme from t_jy_xxjbxx a left join "
					   + "(select xxwybsm,IFNULL(njzrs,0) as zsme from t_jy_xnzsnl where YEAR(jxnf)=" + nf + " and nianji='" + grade + "') b on a.xxjbxxwybsm=b.xxwybsm left join "
					   + "t_jy_xqhpxx c on b.xxwybsm=c.xxbs left join t_renk_rhdc d on c.szlphbs=d.lphwybsm left join t_renk_base_jbxx e on d.lphwybsm=e.lphbsm "
					   + "where a.xxjc='" + name + "' and Year(e.csrq)>=" + startYear + " and Year(e.csrq)<=" + endYear + " GROUP BY c.xiaoqu";
			Query query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			if(result != null){
				for(int i = 0; i < result.size(); i++){
					Map map = (Map)result.get(i);
					
					JSONObject obj = new JSONObject();
					obj.put("xxjc", String.valueOf(map.get("xxjc")));
					obj.put("DiZhi", String.valueOf(map.get("dizhi")));
					obj.put("xxX", String.valueOf(map.get("xxX")));
					obj.put("xxY", String.valueOf(map.get("xxY")));
					obj.put("XiaoQu", String.valueOf(map.get("xiaoqu")));
					obj.put("JieDao", String.valueOf(map.get("jiedao")));
					obj.put("xqX", String.valueOf(map.get("xqX")));
					obj.put("xqY", String.valueOf(map.get("xqY")));
					obj.put("slxt", Integer.valueOf(String.valueOf(map.get("slxt"))));
					obj.put("zsme", Integer.valueOf(String.valueOf(map.get("zsme"))));
					
					lstRes.add(obj);
				}
			}
			
			return lstRes;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取历年(2010-2017)招生名额和适龄学童
	 * @return
	 */
	public Map<String, Object> getZsmeAndSlxt(String xxlx, String xzqdm){
		try{
			Map<String, Object> resMap = new HashMap<String, Object>();
			Calendar now = Calendar.getInstance();
			int curYear = now.get(now.YEAR);
			String xxType = "2";  //默认小学
			int startYear = 2013,endYear = 2014;
			String grade = "一年级";  //年级
			if("幼儿园".equals(xxlx)){
				xxType = "1";
				grade = "小班";
				startYear = curYear - 4;  //幼儿园的适龄学童为3到4岁
				endYear = curYear - 3;
			}else if("小学".equals(xxlx)){
				xxType = "2";
				grade = "一年级";
				startYear = curYear - 8;  //小学的适龄学童为6到8岁
				endYear = curYear - 6;
			}else if("初中".equals(xxlx)) {
				xxType = "3";
				grade = "初一";
				startYear = curYear - 14;  //初中的适龄学童为12到14岁
				endYear = curYear - 12;
			} else {
				xxType = "2";
				grade = "一年级";
				startYear = curYear - 8;  
				endYear = curYear - 6;
			}
			
			String sqlWhere = "";
			if(!StringUtil.isEmpty(xzqdm)){
				sqlWhere = " and a.szdxzqhbm='" + xzqdm + "'";
			}
			
			//历年招生名额和适龄学童
			String sql = "select " + (curYear-6) + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-6) + sqlWhere +
					     " UNION ALL " +
					     "select " + (curYear-5) + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-5) + sqlWhere +
					     " UNION ALL " +
					     "select " + (curYear-4) + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-4) + sqlWhere +
					     " UNION ALL " +
					     "select " + (curYear-3) + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-3) + sqlWhere +
					     " UNION ALL " +
					     "select " + (curYear-2) + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-2) + sqlWhere +
					     " UNION ALL " +
					     "select " + (curYear-1) + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-1) + sqlWhere +
					     " UNION ALL " +
					     "select " + curYear + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + curYear + sqlWhere;
			
			List<JSONObject> lstReal = new ArrayList<JSONObject>();
			List<JSONObject> lstForecast = new ArrayList<JSONObject>();
			Query query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			if(result != null){
				for(int i = 0; i < result.size(); i++){
					Map map = (Map)result.get(i);
					
					JSONObject objReal = new JSONObject();
					objReal.put("nf", Integer.valueOf(String.valueOf(map.get("nf"))));
					objReal.put("zsme", (map.get("zsme") == null)?0:Integer.valueOf(String.valueOf(map.get("zsme"))));
					objReal.put("slxt", (map.get("slxt") == null)?0:Integer.valueOf(String.valueOf(map.get("slxt"))));
					
					lstReal.add(objReal);
					lstForecast.add(objReal);
				}
			}
			resMap.put("real", lstReal);
			
			//招生名额和适龄学童预测
			sql = "select " + (curYear+1) + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + (startYear+1) + " and YEAR(z.csrq)<=" + (endYear+1) + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + curYear + sqlWhere +
				  " UNION ALL " +
				  "select " + (curYear+2)+ " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + (startYear+2) + " and YEAR(z.csrq)<=" + (endYear+2) + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + curYear + sqlWhere +
				  " UNION ALL " +
				  "select " + (curYear+3) + " as nf,a.xxlx,sum(b.njzrs) as zsme,c.slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxlx,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxlx='" + xxType + "' and YEAR(z.csrq)>=" + (startYear+3) + " and YEAR(z.csrq)<=" + (endYear+3) + ") c on a.xxlx=c.xxlx where a.xxlx='" + xxType + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + curYear + sqlWhere;
			
			query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result1 = query.list();
			if(result1 != null){
				for(int j = 0; j < result1.size(); j++){
					Map map = (Map)result1.get(j);
					
					JSONObject objForecast = new JSONObject();
					objForecast.put("nf", Integer.valueOf(String.valueOf(map.get("nf"))));
					objForecast.put("zsme", (map.get("zsme") == null)?0:Integer.valueOf(String.valueOf(map.get("zsme"))));
					objForecast.put("slxt", (map.get("slxt") == null)?0:Integer.valueOf(String.valueOf(map.get("slxt"))));
					
					lstForecast.add(objForecast);
				}
			}
			resMap.put("forecast", lstForecast);
			
			return resMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
    /**
     * 获取学校历年(2010-2017)招生名额和适龄学童
     * @param xxlx  学校类型
     * @param name  学校名称
     * @return
     */
	public Map<String, Object> getZsmeAndSlxtByName(String xxlx, String name){
		try{
			Map<String, Object> resMap = new HashMap<String, Object>();
			Calendar now = Calendar.getInstance();
			int curYear = now.get(now.YEAR);
			String xxType = "2";   //默认小学
			int startYear = 2013,endYear = 2014;
			String grade = "一年级";  //年级
			if("幼儿园".equals(xxlx)){
				xxType = "1";
				grade = "小班";
				startYear = curYear - 4;  //幼儿园的适龄学童为3到4岁
				endYear = curYear - 3;
			}else if("小学".equals(xxlx)){
				xxType = "2";
				grade = "一年级";
				startYear = curYear - 8;  //小学的适龄学童为6到8岁
				endYear = curYear - 6;
			}else if("初中".equals(xxlx)) {
				xxType = "3";
				grade = "初一";
				startYear = curYear - 14;  //初中的适龄学童为12到14岁
				endYear = curYear - 12;
			} else {
				xxType = "2";
				grade = "一年级";
				startYear = curYear - 8;  
				endYear = curYear - 6;
			}
			
			//历年招生名额和适龄学童
			String sql = "select " + (curYear-6) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-6) + 
			             " UNION ALL " +
			             "select " + (curYear-5) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-5) + 
			             " UNION ALL " +
			             "select " + (curYear-4) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-4) + 
			             " UNION ALL " +
			             "select " + (curYear-3) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-3) + 
			             " UNION ALL " +
			             "select " + (curYear-2) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-2) + 
			             " UNION ALL " +
			             "select " + (curYear-1) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + (curYear-1) + 
			             " UNION ALL " +
			             "select " + curYear + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + startYear + " and YEAR(z.csrq)<=" + endYear + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + curYear;
			
			List<JSONObject> lstReal = new ArrayList<JSONObject>();
			List<JSONObject> lstForecast = new ArrayList<JSONObject>();
			Query query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			if(result != null){
				for(int i = 0; i < result.size(); i++){
					Map map = (Map)result.get(i);
					
					JSONObject objReal = new JSONObject();
					objReal.put("nf", Integer.valueOf(String.valueOf(map.get("nf"))));
					objReal.put("zsme", (map.get("zsme") == null)?0:Integer.valueOf(String.valueOf(map.get("zsme"))));
					objReal.put("slxt", (map.get("zsme") == null)?0:Integer.valueOf(String.valueOf(map.get("slxt"))));
					
					lstReal.add(objReal);
					lstForecast.add(objReal);
				}
			}
			resMap.put("real", lstReal);
			
			//招生名额和适龄学童预测
			sql = "select " + (curYear+1) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + (startYear+1) + " and YEAR(z.csrq)<=" + (endYear+1) + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + curYear + 
		          " UNION ALL " +
		          "select " + (curYear+2) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + (startYear+2) + " and YEAR(z.csrq)<=" + (endYear+2) + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + curYear + 
		          " UNION ALL " +
		          "select " + (curYear+3) + " as nf,a.xxjc,sum(b.njzrs) as zsme,IFNULL(c.slxt,0) as slxt from t_jy_xxjbxx a left join t_jy_xnzsnl b on a.xxjbxxwybsm=b.xxwybsm left join (select x.xxjbxxwybsm,count(z.xingming) as slxt from t_jy_xxjbxx x left join t_jy_xqhpxx y on x.xxjbxxwybsm=y.xxbs left join t_renk_base_jbxx z on y.szlphbs=z.lphbsm where x.xxjc='" + name + "' and YEAR(z.csrq)>=" + (startYear+3) + " and YEAR(z.csrq)<=" + (endYear+3) + ") c on b.xxwybsm=c.xxjbxxwybsm where a.xxjc='" + name + "' and b.nianji='" + grade + "' and YEAR(b.jxnf)=" + curYear;
			
			query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result1 = query.list();
			if(result1 != null){
				for(int j = 0; j < result1.size(); j++){
					Map map = (Map)result1.get(j);
					
					JSONObject objForecast = new JSONObject();
					objForecast.put("nf", Integer.valueOf(String.valueOf(map.get("nf"))));
					objForecast.put("zsme", (map.get("zsme") == null)?0:Integer.valueOf(String.valueOf(map.get("zsme"))));
					objForecast.put("slxt", (map.get("slxt") == null)?0:Integer.valueOf(String.valueOf(map.get("slxt"))));
					
					lstForecast.add(objForecast);
				}
			}
			resMap.put("forecast", lstForecast);
			
			return resMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}