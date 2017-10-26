package com.cloud.icenter.yyzx.cszc.tjfx.dao.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.dtzs.pojo.CszcDetailsPojo;
import com.cloud.icenter.yyzx.cszc.dtzs.pojo.CszcInfoPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.dao.BaseInfoDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.BaseInfo;

/**
* Created with gender.
* @author: liyao,whcai
* Date: 2017-04-23 17:57:20
*/
@Repository
public class BaseInfoDaoImpl extends BaseDaoImpl<BaseInfo> implements BaseInfoDao {
	//获取近五年年份列表
	public List<String> getYears(){
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		List<String> yearList=new ArrayList<String>();
		yearList.add(Integer.toString(year-4));
		yearList.add(Integer.toString(year-3));
		yearList.add(Integer.toString(year-2));
		yearList.add(Integer.toString(year-1));
		yearList.add(Integer.toString(year));
		return yearList;
	}
	/*
	 * 按区域获取路灯数量
	 */
	public List<CategorySum> getRegionCount(String year){
		int nf=Integer.valueOf(year).intValue()-1;
		try{
			String sql="SELECT ssqy,count(*)as year1 from (SELECT * FROM `t_cszc_jbxx`  where ssyjflbh='01' and ssejflbh='07'"  
+"  AND YEAR(disabled_time)>"+nf+" or disabled_time is null)as a GROUP BY ssqy ORDER BY qydm";

		 Query query=createSQLQuery(sql);
		 List<CategorySum>  result=query.list();
		 return result;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
    /*
	 * 按类型获取不同年份数量
	 */
	public List<CategorySum> getYearCount(String ejflbh){
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		try{
			String sql="SELECT count(*)as count FROM t_cszc_jbxx  where ssyjflbh='01' and ssejflbh='"+ejflbh+"'  AND YEAR(disabled_time)>="+(year-5)+" AND YEAR(start_time)<="+(year-5)+" or disabled_time is null"
					+" UNION ALL SELECT count(*)as count FROM t_cszc_jbxx  where ssyjflbh='01' and ssejflbh='"+ejflbh+"'  AND YEAR(disabled_time)>="+(year-4)+" AND YEAR(start_time)<="+(year-4)+" or disabled_time is null"
					+" UNION ALL SELECT count(*)as count FROM t_cszc_jbxx  where ssyjflbh='01' and ssejflbh='"+ejflbh+"'  AND YEAR(disabled_time)>="+(year-3)+" AND YEAR(start_time)<="+(year-3)+" or disabled_time is null"
					+" UNION ALL SELECT count(*)as count FROM t_cszc_jbxx  where ssyjflbh='01' and ssejflbh='"+ejflbh+"'  AND YEAR(disabled_time)>="+(year-2)+" AND YEAR(start_time)<="+(year-2)+" or disabled_time is null"
					+" UNION ALL SELECT count(*)as count FROM t_cszc_jbxx  where ssyjflbh='01' and ssejflbh='"+ejflbh+"'  AND YEAR(disabled_time)>="+(year-1)+" AND YEAR(start_time)<="+(year-1)+" or disabled_time is null"
					+" UNION ALL SELECT count(*)as count FROM t_cszc_jbxx  where ssyjflbh='01' and ssejflbh='"+ejflbh+"'  AND YEAR(disabled_time)>="+year+" AND YEAR(start_time)<="+year+" or disabled_time is null";
		 Query query=createSQLQuery(sql);
		 List<CategorySum>  result=query.list();
		 return result;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	/*
	 * 按养护原因获取养护次数
	 */
	public List<CategorySum> getRepairTimeByReason(){
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR)-1;
		try{
		 String sql="SELECT t1.bxyy,count(*) FROM `t_cszc_xsjl` t1 where t1.bxyy is not null GROUP BY t1.bxyy ";
		 Query query=createSQLQuery(sql);
		 List<CategorySum>  result=query.list();
		 return result;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 按地区获取养护次数
	 */
	public List<CategorySum> getRepairTimeByRegion(){
		try{
			String sql="SELECT t3.ssqy,count(*) from (SELECT t1.id,t2.qydm,t2.ssqy FROM `t_cszc_xsjl` t1 "
					+ "left join t_cszc_jbxx t2 on t1.jbxx_id=t2.id )t3 "
					+ "where t3.ssqy is not null GROUP BY t3.qydm order by t3.qydm ";
		 Query query=createSQLQuery(sql);
		 List<CategorySum>  result=query.list();
		 return result;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过部件名称查询城市资产
	 * @param zcmc
	 * @return
	 */
	public List<CszcInfoPojo> queryCszcByName(String zcmc){
		try{
			String sql = String.format("select @rownum\\:=@rownum+1 as xh,a.id as objID,a.zymc,a.ssqy,a.ztmc,a.zblx,a.zbz,b.mc as zcmc from (SELECT @rownum\\:=0) t_cszc_jbxx,t_cszc_jbxx a left join t_cszc_bjmb b on a.ssyjflbh=substring(b.dm, 7, 2) and a.ssejflbh=substring(b.dm, 9, 2) where a.ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='%s') and a.ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='%s') and a.delete_status='0'", zcmc, zcmc);
			
			Query query = createSQLQuery(sql);
			//query.setResultTransformer(Transformers.aliasToBean(CszcInfoPojo.class));
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<CszcInfoPojo> outLst = new ArrayList<CszcInfoPojo>();
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					CszcInfoPojo obj = new CszcInfoPojo();
					obj.setXh(Double.valueOf(String.valueOf(map.get("xh"))).intValue());
					obj.setObjID(String.valueOf(map.get("objID")));
					obj.setZymc(String.valueOf(map.get("zymc")));
					obj.setSsqy(String.valueOf(map.get("ssqy")));
					obj.setZtmc(String.valueOf(map.get("ztmc")));
					//obj.setX(BigDecimal.valueOf(Double.valueOf(String.valueOf(map.get("x")))));
					//obj.setY(BigDecimal.valueOf(Double.valueOf(String.valueOf(map.get("y")))));
					obj.setZblx(String.valueOf(map.get("zblx")));
					obj.setZbz(String.valueOf(map.get("zbz")));	
					obj.setZcmc(String.valueOf(map.get("zcmc")));
					
					outLst.add(obj);
				}
			}
			
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询城市资产
	 * @param zcmc   资产名称
	 * @param xzqmc  行政区名称
	 * @param ztmc   状态名称
	 */
	public List<CszcInfoPojo> queryCszcByZcmcAndQxAndZt(String zcmc, String xzqmc, String ztmc){
		try{
			String sql = "select a.id as objID,a.zymc,a.ssqy,a.ztmc,a.zblx,a.zbz,b.mc as zcmc from t_cszc_jbxx a " +
		                 "left join t_cszc_bjmb b on a.ssyjflbh=substring(b.dm, 7, 2) and a.ssejflbh=substring(b.dm, 9, 2) " + 
					     "where a.ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='"+ zcmc + "') and a.ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "') " + 
		                 "and a.delete_status='0' and a.ssqy='" + xzqmc + "'";
			if(!"总数".equals(ztmc)){
				sql += " and a.ztmc='" + ztmc + "'";
			}
			
			Query query = createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(CszcInfoPojo.class));
			List<CszcInfoPojo> dataList = query.list();
			if(dataList != null){
				for(int i = 0; i < dataList.size(); i++){
					CszcInfoPojo obj = dataList.get(i);
					obj.setXh(i+1);
				}
			}
			
			return dataList;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据资产名称和资产状态按区查询资产数量
	 * @param zcmc
	 * @param zczt 资产状态代码[1,2,3,4] ；0表示全部；-1表示待养护资产
	 * @return
	 */
	public List<Integer> getCountByZcmcAndZczt(String zcmc, int zczt){
		try{
			String ztStr;
			if(zczt == 0){
				ztStr = "";
			}else if(zczt == -1){
				ztStr = " and ztdm is not null and ztdm!=1 ";
			}else{
				ztStr = " and ztdm=" + zczt;
			}
			
			String sql = String.format("SELECT ssqy as name,count(*) as count from (SELECT * FROM t_cszc_jbxx where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='%s') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='%s') %s)as a where a.delete_status='0' GROUP BY ssqy ORDER BY qydm asc", zcmc, zcmc, ztStr);
			//String sql = String.format("SELECT new map(ssqy as name,count(*) as sum) from (SELECT * FROM t_cszc_jbxx where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='%s') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='%s') %s)as a GROUP BY ssqy ORDER BY qydm asc", zcmc, zcmc, ztStr);
			Query query=createSQLQuery(sql);
			//query.setResultTransformer(Transformers.aliasToBean(CszcSumPojo.class));
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xzqmc = String.valueOf(map.get("name"));
					Integer nCount = Integer.parseInt(String.valueOf(map.get("count")));

					switch(xzqmc){
						case "秦州区":
							outLst.set(0, nCount);
							break;
						case "麦积区":
							outLst.set(1, nCount);
							break;
						case "清水县":
							outLst.set(2, nCount);
							break;
						case "秦安县":
							outLst.set(3, nCount);
							break;
						case "甘谷县":
							outLst.set(4, nCount);
							break;
						case "武山县":
							outLst.set(5, nCount);
							break;
						case "张家川":
							outLst.set(6, nCount);
							break;
						default:
							break;	
					}
				}
			}
			 
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据资产名称查询资产近年发展情况
	 * @param zcmc
	 * @return
	 */
	public List<Integer> getCountByZcmcAndYear(String zcmc){
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		try{
			String sql="SELECT count(*) as count FROM t_cszc_jbxx where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "') AND delete_status='0' AND YEAR(disabled_time)>="+(year-4)+" AND YEAR(start_time)<="+(year-4)+" or disabled_time is null"
					+" UNION ALL SELECT count(*) as count FROM t_cszc_jbxx  where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "') AND delete_status='0' AND YEAR(disabled_time)>="+(year-3)+" AND YEAR(start_time)<="+(year-3)+" or disabled_time is null"
					+" UNION ALL SELECT count(*) as count FROM t_cszc_jbxx  where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "') AND delete_status='0' AND YEAR(disabled_time)>="+(year-2)+" AND YEAR(start_time)<="+(year-2)+" or disabled_time is null"
					+" UNION ALL SELECT count(*) as count FROM t_cszc_jbxx  where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "') AND delete_status='0' AND YEAR(disabled_time)>="+(year-1)+" AND YEAR(start_time)<="+(year-1)+" or disabled_time is null"
					+" UNION ALL SELECT count(*) as count FROM t_cszc_jbxx  where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "') AND delete_status='0' AND YEAR(disabled_time)>="+year+" AND YEAR(start_time)<="+year+" or disabled_time is null";
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					outLst.add(Integer.parseInt(String.valueOf(map.get("count"))));
				}
			}
			
			return outLst;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据资产名称查询资产各状态数量
	 * @param zcmc
	 * @return
	 */
	public List<Integer> getCszcZtfb(String zcmc){
		try{
			String sql = "SELECT count(*) as count FROM t_cszc_jbxx  where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "') AND ztdm=1 AND delete_status='0' " + 
					 "UNION ALL SELECT count(*) as count FROM t_cszc_jbxx  where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "')  AND ztdm=2 AND delete_status='0' " +
					 "UNION ALL SELECT count(*) as count FROM t_cszc_jbxx  where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "')  AND ztdm=3 AND delete_status='0' " +
					 "UNION ALL SELECT count(*) as count FROM t_cszc_jbxx  where ssyjflbh=(select substring(dm, 7, 2) from t_cszc_bjmb where mc='" + zcmc + "') and ssejflbh=(select substring(dm, 9, 2) from t_cszc_bjmb where mc='" + zcmc + "')  AND ztdm=4 AND delete_status='0'";
			
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					outLst.add(Integer.parseInt(String.valueOf(map.get("count"))));
				}
			}
			
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据资产名称获取资产详情
	 * @param zcmc 资产名称
	 * @param zymc 资源名称
	 * @param zczt 资产状态
	 * @param xzqmc行政区划名称
	 * @return
	 */
	public List<CszcDetailsPojo> getCszcDetailsInfo(String zcmc, String zymc, String zczt, String xzqmc){
		try{
			String sql = "select @rownum\\:=@rownum+1 as xh, a.id as zybm,a.zymc,b.mc as zylb,b.dm as lbdm,a.start_time as trsysj,ifnull(a.qsdw,'') as ssdw,ifnull(a.dz,'') as dz,ifnull(a.ztmc,'') as zt,ifnull(a.bz,'') as bz from (SELECT @rownum\\:=0) t_cszc_jbxx, " +
					     "t_cszc_jbxx a left join t_cszc_bjmb b on a.ssyjflbh=substring(b.dm, 7, 2) and a.ssejflbh=substring(b.dm, 9, 2) " +
					     "where b.mc='" + zcmc + "' and a.delete_status='0'";
			
			if(zymc != null && !zymc.isEmpty()){
				sql += " and a.zymc like '%" + zymc + "%'";   //支持模糊查询
			}
			if(zczt != null && !zczt.isEmpty()){
				sql += " and a.ztmc='" + zczt + "'";
			}
			if(xzqmc != null && !xzqmc.isEmpty()){
				sql += " and a.ssqy='" + xzqmc + "'";
			}
			
			Query query=createSQLQuery(sql);
			//query.setResultTransformer(Transformers.aliasToBean(CszcDetailsPojo.class));
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<CszcDetailsPojo> outLst = new ArrayList<CszcDetailsPojo>();
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					CszcDetailsPojo obj = new CszcDetailsPojo();
					obj.setXh(Double.valueOf(String.valueOf(map.get("xh"))).intValue());
					//obj.setZybm(String.valueOf(map.get("zybm")));
					obj.setZymc(String.valueOf(map.get("zymc")));
					obj.setZylb(String.valueOf(map.get("zylb")));
					obj.setLbdm(String.valueOf(map.get("lbdm")));
					obj.setTrsysj(Date.valueOf(String.valueOf(map.get("trsysj"))));
					obj.setSsdw(String.valueOf(map.get("ssdw")));
					obj.setDz(String.valueOf(map.get("dz")));
					obj.setZt(String.valueOf(map.get("zt")));
					obj.setBz(String.valueOf(map.get("bz")));
					
					outLst.add(obj);
				}
			}
			
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取各类城市资产数量
	 * @return
	 */
	public List<Integer> getAllCszcCount(){
		try{
			String sql = "select a.mc,count(*) as count from t_cszc_bjmb a left join t_cszc_jbxx b on substring(a.dm, 7, 2)=b.ssyjflbh and  " +
					     "substring(a.dm, 9, 2)=b.ssejflbh where a.type=2 group by a.mc order by a.dm asc";
			
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					outLst.add(Double.valueOf(String.valueOf(map.get("count"))).intValue());
				}
			}
			
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取各类型学校数量
	 * @return
	 */
	public List<Integer> getXxlxCount(){
		try{
			String sql = "select b.xxlx,count(*) as count from t_cszc_jbxx a left join t_cszc_xxlsxx b on a.id=b.bjbsm " +
						 "where a.ssyjflbh='05' and a.ssejflbh='01' and a.delete_status='0' group by b.xxlx";
			
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			Integer nTotal = 0;
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xxlx = String.valueOf(map.get("xxlx"));
					Integer nCount = Double.valueOf(String.valueOf(map.get("count"))).intValue();
					nTotal += nCount;
					
					switch(xxlx){
						case "高校":
							outLst.set(0, nCount);
							break;
						case "技校/职高":
							outLst.set(1, nCount);
							break;
						case "中学":
							outLst.set(2, nCount);
							break;
						case "小学":
							outLst.set(3, nCount);
							break;
						case "幼儿园":
							outLst.set(4, nCount);
							break;
						default:
							break;
					}
				}
			}
			outLst.add(nTotal);
			
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	 
	/**
	 * 根据学校类型获取各区县学校数量
	 * @param xxlx
	 * @return
	 */
	public List<Integer> getSchoolCountByXxlx(String xxlx){
		try{
			String sql = "select a.ssqy,count(*) as count from t_cszc_jbxx a left join t_cszc_xxlsxx b on a.id=b.bjbsm " +
					     "where a.ssyjflbh='05' and a.ssejflbh='01' and b.xxlx='" + xxlx + "' and a.delete_status='0' group by a.ssqy order by a.qydm asc";
		
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xzqmc = String.valueOf(map.get("ssqy"));
					Integer nCount = Double.valueOf(String.valueOf(map.get("count"))).intValue();

					switch(xzqmc){
						case "秦州区":
							outLst.set(0, nCount);
							break;
						case "麦积区":
							outLst.set(1, nCount);
							break;
						case "清水县":
							outLst.set(2, nCount);
							break;
						case "秦安县":
							outLst.set(3, nCount);
							break;
						case "甘谷县":
							outLst.set(4, nCount);
							break;
						case "武山县":
							outLst.set(5, nCount);
							break;
						case "张家川":
							outLst.set(6, nCount);
							break;
						default:
							break;	
					}
				}
			}
			 
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取城市资产各一级分类各区县数量
	 * @param zclx
	 * @return
	 */
	public List<Integer> getCszcCountQyfb(String zclx){
		try{
			String sql = "select a.ssqy,count(*) as count from t_cszc_jbxx a left join t_cszc_bjmb b on a.ssyjflbh=substring(b.dm, 7, 2) " +
					     "where b.mc='" + zclx + "' and a.delete_status='0' group by a.ssqy order by a.qydm asc";
			
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xzqmc = String.valueOf(map.get("ssqy"));
					Integer nCount = Double.valueOf(String.valueOf(map.get("count"))).intValue();

					switch(xzqmc){
						case "秦州区":
							outLst.set(0, nCount);
							break;
						case "麦积区":
							outLst.set(1, nCount);
							break;
						case "清水县":
							outLst.set(2, nCount);
							break;
						case "秦安县":
							outLst.set(3, nCount);
							break;
						case "甘谷县":
							outLst.set(4, nCount);
							break;
						case "武山县":
							outLst.set(5, nCount);
							break;
						case "张家川":
							outLst.set(6, nCount);
							break;
						default:
							break;	
					}
				}
			}
			 
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取各类型学校数量统计
	 * @return
	 */
	public List<Integer> getSchoolCount(){
		try{
			String sql = "select xxlx,count(*) as count from t_cszc_xxlsxx group by xxlx order by xxlx asc";
		
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xxlx = String.valueOf(map.get("xxlx"));
					Integer nCount = Double.valueOf(String.valueOf(map.get("count"))).intValue();

					switch(xxlx){
						case "幼儿园":
							outLst.set(0, nCount);
							break;
						case "小学":
							outLst.set(1, nCount);
							break;
						case "中学":
							outLst.set(2, nCount);
							break;
						case "技校":
							outLst.set(3, nCount);
							break;
						case "高校":
							outLst.set(4, nCount);
							break;
						default:
							break;	
					}
				}
			}
			 
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取教育资金分布情况
	 * @return
	 */
	public List<Map<String, Object>> getJyzjFbqk(){
		try{
			String sql = "select xxlx,SUM(jssl) as jssl,sum(jyzjtr) as trzj from t_cszc_xxlsxx where xxlx!='幼儿园' group by xxlx order by xxlx asc";
			
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			  
			List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>(); 
			dataList.add(new HashMap<String, Object>());
			dataList.add(new HashMap<String, Object>());
			dataList.add(new HashMap<String, Object>());
			dataList.add(new HashMap<String, Object>());
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xxlx = String.valueOf(map.get("xxlx"));
					DecimalFormat df = new DecimalFormat("#");
					BigDecimal bg = new BigDecimal(String.valueOf(map.get("trzj")));

					Map<String, Object> rowMap = new HashMap<String, Object>();
					rowMap.put("xxlx", xxlx);
					rowMap.put("jssl", Double.valueOf(String.valueOf(map.get("jssl"))).intValue());
					rowMap.put("trzj", Double.valueOf(bg.toPlainString()).intValue());
					
					if("小学".equalsIgnoreCase(xxlx)){
						dataList.set(0, rowMap);
					}else if("中学".equalsIgnoreCase(xxlx)){
						dataList.set(1, rowMap);
					}else if("技校".equalsIgnoreCase(xxlx)){
						dataList.set(2, rowMap);
					}else if("高校".equalsIgnoreCase(xxlx)){
						dataList.set(3, rowMap);
					}
				}
			}
			
			return dataList;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取学校生源分布情况
	 * @return
	 */
	public List<Map<String, Object>> getXxsyFbqk(){
		try{
			String sql = "select IFNULL(b.ssqy,''),round(sum(a.bdsys)/100) as bdsy,round(sum(a.wdsys)/100) as wdsy from t_cszc_xxlsxx a left join t_cszc_jbxx b on a.bjbsm=b.id group by b.ssqy order by b.qydm asc";
			
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>(); 
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xzqmc = String.valueOf(map.get("ssqy"));
					if("".equals(xzqmc) || "null".equals(xzqmc)){
						continue;
					}
					
					DecimalFormat df = new DecimalFormat("#");
					BigDecimal bg = new BigDecimal(String.valueOf(map.get("bdsy")));

					Map<String, Object> rowMap = new HashMap<String, Object>();
					rowMap.put("xzqmc", xzqmc);
					rowMap.put("bdsy", Integer.valueOf(bg.toPlainString()));
					rowMap.put("wdsy", Integer.valueOf(String.valueOf(map.get("wdsy"))));
					
					dataList.add(rowMap);
				}
			}
			
			return dataList;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取小学招生人数分布情况
	 * @return
	 */
	public List<Integer> getZsrsFbqk(){
		try{
			String sql = "select b.ssqy,round(sum(a.zsrs)/100) as zsrs from t_cszc_xxlsxx a left join t_cszc_jbxx b on a.bjbsm=b.id where a.xxlx='小学' group by b.ssqy order by b.qydm asc";
			
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xzqmc = String.valueOf(map.get("ssqy"));
					Integer nCount = Double.valueOf(String.valueOf(map.get("zsrs"))).intValue();

					switch(xzqmc){
						case "秦州区":
							outLst.set(0, nCount);
							break;
						case "麦积区":
							outLst.set(1, nCount);
							break;
						case "清水县":
							outLst.set(2, nCount);
							break;
						case "秦安县":
							outLst.set(3, nCount);
							break;
						case "甘谷县":
							outLst.set(4, nCount);
							break;
						case "武山县":
							outLst.set(5, nCount);
							break;
						case "张家川":
							outLst.set(6, nCount);
							break;
						default:
							break;	
					}
				}
			}
			 
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取义务教育适龄人口分布情况
	 * @return
	 */
	public List<Integer> getSlrkFbqk(){
		try{
			String sql = "select city,age_group_one as slrk from t_renk_rkfb_rkfb where tyear=2016 group by city";
			
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			
			List<Integer> outLst = new ArrayList<Integer>();
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			outLst.add(0);
			if(result != null){
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					String xzqmc = String.valueOf(map.get("city"));
					Integer nCount = Double.valueOf(String.valueOf(map.get("slrk"))).intValue();

					switch(xzqmc){
						case "秦州区":
							outLst.set(0, nCount);
							break;
						case "麦积区":
							outLst.set(1, nCount);
							break;
						case "清水县":
							outLst.set(2, nCount);
							break;
						case "秦安县":
							outLst.set(3, nCount);
							break;
						case "甘谷县":
							outLst.set(4, nCount);
							break;
						case "武山县":
							outLst.set(5, nCount);
							break;
						case "张家川":
							outLst.set(6, nCount);
							break;
						default:
							break;	
					}
				}
			}
			 
			return outLst;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 */
	public List<CategorySum> supplyResult(List inRes){
		List<CategorySum> resLst = getXzqh();
		try{		
	    	for(CategorySum obj : resLst){
	    		String xzqmc = obj.getCategory();
	    		for(int i = 0;i < inRes.size(); i++){
	    			//Object[] objects = (Object[])inRes.get(i);
	    			Map map = (Map)inRes.get(i);
	    			if(String.valueOf(map.get("name")).equalsIgnoreCase(xzqmc)){
	    				obj.setSum(Integer.parseInt(String.valueOf(map.get("count"))));
	    				break;
	    			}
	    		}
	    	}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
			
    	return resLst;
	}
	
//****************************************************************************************************//
	
	/**
     * 获取各行政区划初始数据
     * @return
     */
    private List<CategorySum> getXzqh(){
    	List<CategorySum> xzqhLst = new ArrayList<CategorySum>();
    	CategorySum obj = new CategorySum();
    	obj.setCategory("秦州区");
    	obj.setSum(0);
    	xzqhLst.add(obj);
    	
    	obj = new CategorySum();
    	obj.setCategory("麦积区");
    	obj.setSum(0);
    	xzqhLst.add(obj);
    	
    	obj = new CategorySum();
    	obj.setCategory("清水县");
    	obj.setSum(0);
    	xzqhLst.add(obj);
    	
    	obj = new CategorySum();
    	obj.setCategory("秦安县");
    	obj.setSum(0);
    	xzqhLst.add(obj);
    	
    	obj = new CategorySum();
    	obj.setCategory("甘谷县");
    	obj.setSum(0);
    	xzqhLst.add(obj);
    	
    	obj = new CategorySum();
    	obj.setCategory("武山县");
    	obj.setSum(0);
    	xzqhLst.add(obj);
    	
    	obj = new CategorySum();
    	obj.setCategory("张家川");
    	obj.setSum(0);
    	xzqhLst.add(obj);
    	
    	return xzqhLst;
    }
    /*
     * 根据二级分类代码，获取近五年各资源类型坐标
     * 拼接json
     */
	public JSONObject getAllData(String ejflbh){
		List<String> yearlist=getYears();	
		JSONObject jcsslxjsonobj=new JSONObject();	
		for(int i=0;i<yearlist.size();i++){   
		       String year = yearlist.get(i); 
		       Map<String,?> map=getXY(ejflbh,year);
			   jcsslxjsonobj.put(year,map);
		   } 
		return jcsslxjsonobj;		
	}

	public Map<String,?> getXY(String ejflbh,String year){
		
		try{
			String sql="SELECT x,y FROM t_cszc_jbxx  where ssyjflbh='01' and ssejflbh='"+ejflbh+"'  AND  "
 +" YEAR(disabled_time)>="+year+" AND YEAR(start_time)<="+year+" or disabled_time is null";
			
			List<Object> obj = new ArrayList<Object>();
			
			SQLQuery query = createSQLQuery(sql);//记录
			SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
			
			Map<String,Object> map = new HashMap<String,Object>();
			int size = querySize.list().size();//总记录数
			if(size>0){
				map.put("total", querySize.list().get(0));
				map.put("rows",query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list());
				List<Map<String,Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
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
	
	/**
	 * 获取城市资产树结构模型数据
	 * @return
	 */
	public JSONArray queryCszcModelData(){
		try{
			JSONArray arrRes = new JSONArray();
			
			String sql = "select mc,substring(dm, 7, 2) as dm from  t_cszc_bjmb where type=1 and delete_status='0'";
			Query query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			if(result != null){
				int nCount = 1;
				for(int i = 0;i < result.size(); i++){
					Map map = (Map)result.get(i);
					
					//资产名称
					String mc = String.valueOf(map.get("mc"));
					//一级分类代码
					String dm = String.valueOf(map.get("dm"));
					
					int num = nCount;
					JSONObject obj = new JSONObject();
					obj.put("code", num);
					obj.put("parentCode", 0);
					obj.put("name", mc);
					
					JSONArray arrChildren = new JSONArray();
					sql = "select mc from t_cszc_bjmb where substring(dm, 7, 2)='" + dm + "' and type=2 and delete_status='0'";
					query=createSQLQuery(sql);
					query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
					List resultChildren = query.list();
					if(resultChildren != null){
						for(int j = 0;j < resultChildren.size(); j++){
							map = (Map)resultChildren.get(j);
							
							String childrenMc = String.valueOf(map.get("mc"));
							JSONObject objChildren = new JSONObject();
							objChildren.put("code", nCount++);
							objChildren.put("parentCode", num);
							objChildren.put("name", childrenMc);
							
							arrChildren.add(objChildren);
						}
					}
					
					obj.put("children", arrChildren);
					arrRes.add(obj);
				}
			}
			
			return arrRes;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

}