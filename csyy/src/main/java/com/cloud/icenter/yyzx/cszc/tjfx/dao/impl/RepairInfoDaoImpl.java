package com.cloud.icenter.yyzx.cszc.tjfx.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.AnimalClCl;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cstz.pojo.CstzCommonPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.dao.RepairInfoDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.RepairInfo;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TourismTime;

/**
* Created with gender.
* @author: liyao
* Date: 2017-04-19 14:27:14
*/
@Repository
public class RepairInfoDaoImpl extends BaseDaoImpl<RepairInfo> implements RepairInfoDao {

	/*
	 * 根据部件类型代码code，统计近五年养护量
	 */
	public List<CategorySum> getCountByBjlx(String code){
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		try{
                  String sql="SELECT YEAR(start_time)as nf,count(*)as sum FROM `t_cszc_xsjl` where dm='"+code+"'  and   YEAR(start_time)="+(year-4)
					+" UNION ALL (SELECT YEAR(start_time)as nf,count(*)as sum FROM `t_cszc_xsjl` where dm='"+code+"'  and   YEAR(start_time)="+(year-3)
					+") UNION ALL (SELECT YEAR(start_time)as nf,count(*)as sum FROM `t_cszc_xsjl` where dm='"+code+"'  and   YEAR(start_time)="+(year-2)
					+") UNION ALL (SELECT YEAR(start_time)as nf,count(*)as sum FROM `t_cszc_xsjl` where dm='"+code+"'  and   YEAR(start_time)="+(year-1)
					+") UNION ALL (SELECT YEAR(start_time)as nf,count(*)as sum FROM `t_cszc_xsjl` where dm='"+code+"'  and   YEAR(start_time)="+year+")";
			
            Query query=createSQLQuery(sql);
			List<CategorySum>  result=query.list();
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 根据行政区划获取不同区域不同养护类型的养护频次
	 * 分类代码：code
	 * 状态：status
	 */
    public List<CategorySum> getYhpc(String code,String status){
    	try{
    		String sql="SELECT a.ssqy,count(a.ssqy)as sum FROM "
    				+"(SELECT t1.id,t1.jbxx_id,t1.yhlx,t1.dm,t2.qydm,t2.ssqy FROM t_cszc_xsjl t1"
    				+"	LEFT JOIN t_cszc_jbxx t2 ON t2.id = t1.jbxx_id) a   WHERE a.dm ='"+code
    				+"'  and a.yhlx='"+status+"'      AND a.qydm='620502'"
    				+" UNION ALL (SELECT a.ssqy,count(a.ssqy)as sum FROM "
    				+"(SELECT t1.id,t1.jbxx_id,t1.yhlx,t1.dm,t2.qydm,t2.ssqy FROM t_cszc_xsjl t1"
    				+"	LEFT JOIN t_cszc_jbxx t2 ON t2.id = t1.jbxx_id) a   WHERE a.dm ='"+code
    				+"'  and a.yhlx='"+status+"'      AND a.qydm='620503')"
    				+" UNION ALL (SELECT a.ssqy,count(a.ssqy)as sum FROM "
    				+"(SELECT t1.id,t1.jbxx_id,t1.yhlx,t1.dm,t2.qydm,t2.ssqy FROM t_cszc_xsjl t1"
    				+"	LEFT JOIN t_cszc_jbxx t2 ON t2.id = t1.jbxx_id) a   WHERE a.dm ='"+code
    				+"'  and a.yhlx='"+status+"'      AND a.qydm='620521')"
    				+" UNION ALL (SELECT a.ssqy,count(a.ssqy)as sum FROM "
    				+"(SELECT t1.id,t1.jbxx_id,t1.yhlx,t1.dm,t2.qydm,t2.ssqy FROM t_cszc_xsjl t1"
    				+"	LEFT JOIN t_cszc_jbxx t2 ON t2.id = t1.jbxx_id) a   WHERE a.dm ='"+code
    				+"'  and a.yhlx='"+status+"'      AND a.qydm='620522')"
    				+" UNION ALL (SELECT a.ssqy,count(a.ssqy)as sum FROM "
    				+"(SELECT t1.id,t1.jbxx_id,t1.yhlx,t1.dm,t2.qydm,t2.ssqy FROM t_cszc_xsjl t1"
    				+"	LEFT JOIN t_cszc_jbxx t2 ON t2.id = t1.jbxx_id) a   WHERE a.dm ='"+code
    				+"'  and a.yhlx='"+status+"'      AND a.qydm='620523')"
    				+" UNION ALL (SELECT a.ssqy,count(a.ssqy)as sum FROM "
    				+"(SELECT t1.id,t1.jbxx_id,t1.yhlx,t1.dm,t2.qydm,t2.ssqy FROM t_cszc_xsjl t1"
    				+"	LEFT JOIN t_cszc_jbxx t2 ON t2.id = t1.jbxx_id) a   WHERE a.dm ='"+code
    				+"'  and a.yhlx='"+status+"'      AND a.qydm='620524')"
    				+" UNION ALL (SELECT a.ssqy,count(a.ssqy)as sum FROM "
    				+"(SELECT t1.id,t1.jbxx_id,t1.yhlx,t1.dm,t2.qydm,t2.ssqy FROM t_cszc_xsjl t1"
    				+"	LEFT JOIN t_cszc_jbxx t2 ON t2.id = t1.jbxx_id) a   WHERE a.dm ='"+code
    				+"'  and a.yhlx='"+status+"'      AND a.qydm='620525')";
    		Query query=createSQLQuery(sql);			
			List<CategorySum>  result=query.list();
			return result;
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
		
	}
    /*
     * 获取实际使用寿命
     * 根据启用时间和废弃时间，算平均使用寿命
     */
    public List<CategorySum> getSjsysm(){    	
    	try{
    		String sql="SELECT round(sumage/count)as average from"
    				+ "(select count(*)as count,SUM(age)as sumage from"
    				+ "(SELECT t.zymc, TIMESTAMPDIFF(YEAR,start_time,disabled_time)as age "
    				+ "FROM `t_cszc_jbxx` t where t.ssejflbh='01')as t)as t1"
    				+" union all("
    				+"SELECT round(sumage/count)as average from"
    				+ "(select count(*)as count,SUM(age)as sumage from"
    				+ "(SELECT t.zymc, TIMESTAMPDIFF(YEAR,start_time,disabled_time)as age "
    				+ "FROM `t_cszc_jbxx` t where t.ssejflbh='02')as t)as t1"
    				+ ")"
    				+" union all("
    				+"SELECT round(sumage/count)as average from"
    				+ "(select count(*)as count,SUM(age)as sumage from"
    				+ "(SELECT t.zymc, TIMESTAMPDIFF(YEAR,start_time,disabled_time)as age "
    				+ "FROM `t_cszc_jbxx` t where t.ssejflbh='03')as t)as t1"
    				+ ")"
    				+" union all("
    				+"SELECT round(sumage/count)as average from"
    				+ "(select count(*)as count,SUM(age)as sumage from"
    				+ "(SELECT t.zymc, TIMESTAMPDIFF(YEAR,start_time,disabled_time)as age "
    				+ "FROM `t_cszc_jbxx` t where t.ssejflbh='04')as t)as t1"
    				+ ")"
    				+" union all("
    				+"SELECT round(sumage/count)as average from"
    				+ "(select count(*)as count,SUM(age)as sumage from"
    				+ "(SELECT t.zymc, TIMESTAMPDIFF(YEAR,start_time,disabled_time)as age "
    				+ "FROM `t_cszc_jbxx` t where t.ssejflbh='05')as t)as t1"
    				+ ")"
    				+" union all("
    				+"SELECT round(sumage/count)as average from"
    				+ "(select count(*)as count,SUM(age)as sumage from"
    				+ "(SELECT t.zymc, TIMESTAMPDIFF(YEAR,start_time,disabled_time)as age "
    				+ "FROM `t_cszc_jbxx` t where t.ssejflbh='06')as t)as t1"
    				+ ")"
    				+" union all("
    				+"SELECT round(sumage/count)as average from"
    				+ "(select count(*)as count,SUM(age)as sumage from"
    				+ "(SELECT t.zymc, TIMESTAMPDIFF(YEAR,start_time,disabled_time)as age "
    				+ "FROM `t_cszc_jbxx` t where t.ssejflbh='07')as t)as t1"
    				+ ")";
    		Query query=createSQLQuery(sql);			
			List<CategorySum>  result=query.list();
			return result;
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
    /*
     * 根据实际使用寿命和启用时间推测明年养护量【更换量】
     */
    public List<CategorySum> predictNextYear(){
    	Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
    	return this.predictRepairSum(year+1);
    }
    /*
     * 根据实际使用寿命和启用时间推测后年养护量【更换量】
     */
    public List<CategorySum> predictYearAfterYear(){
    	Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
    	return this.predictRepairSum(year+2);
    }
    public List<CategorySum> predictRepairSum(int year){
    	try{
    		String sql="SELECT count(*) FROM (SELECT t4.id,t4.zymc,t4.ssejflbh,t4.start_time,t3.average FROM t_cszc_jbxx t4 "
		+"LEFT JOIN (SELECT (round(sumage / count)) AS average,t2.ssejflbh FROM(SELECT count(*) AS count,SUM(age) AS sumage,t1.ssejflbh "
		+"FROM	(SELECT t.zymc,TIMESTAMPDIFF(YEAR,start_time,disabled_time) AS age,t.ssejflbh FROM	`t_cszc_jbxx` t	WHERE	t.ssejflbh = '01')"
		+ " t1) t2) t3 ON t4.ssejflbh = t3.ssejflbh) t5 WHERE YEAR (t5.start_time) = ("+year+" - t5.average)"
	    +" union all("
	    +"SELECT count(*) FROM (SELECT t4.id,t4.zymc,t4.ssejflbh,t4.start_time,t3.average FROM t_cszc_jbxx t4 "
		+"LEFT JOIN (SELECT (round(sumage / count)) AS average,t2.ssejflbh FROM(SELECT count(*) AS count,SUM(age) AS sumage,t1.ssejflbh "
		+"FROM	(SELECT t.zymc,TIMESTAMPDIFF(YEAR,start_time,disabled_time) AS age,t.ssejflbh FROM	`t_cszc_jbxx` t	WHERE	t.ssejflbh = '02')"
		+ " t1) t2) t3 ON t4.ssejflbh = t3.ssejflbh) t5 WHERE YEAR (t5.start_time) = ("+year+" - t5.average)"
	    + ")"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	    +" union all("
	    +"SELECT count(*) FROM (SELECT t4.id,t4.zymc,t4.ssejflbh,t4.start_time,t3.average FROM t_cszc_jbxx t4 "
		+"LEFT JOIN (SELECT (round(sumage / count)) AS average,t2.ssejflbh FROM(SELECT count(*) AS count,SUM(age) AS sumage,t1.ssejflbh "
		+"FROM	(SELECT t.zymc,TIMESTAMPDIFF(YEAR,start_time,disabled_time) AS age,t.ssejflbh FROM	`t_cszc_jbxx` t	WHERE	t.ssejflbh = '03')"
		+ " t1) t2) t3 ON t4.ssejflbh = t3.ssejflbh) t5 WHERE YEAR (t5.start_time) = ("+year+" - t5.average)"
	    + ")"
	    +" union all("
	    +"SELECT count(*) FROM (SELECT t4.id,t4.zymc,t4.ssejflbh,t4.start_time,t3.average FROM t_cszc_jbxx t4 "
		+"LEFT JOIN (SELECT (round(sumage / count)) AS average,t2.ssejflbh FROM(SELECT count(*) AS count,SUM(age) AS sumage,t1.ssejflbh "
		+"FROM	(SELECT t.zymc,TIMESTAMPDIFF(YEAR,start_time,disabled_time) AS age,t.ssejflbh FROM	`t_cszc_jbxx` t	WHERE	t.ssejflbh = '04')"
		+ " t1) t2) t3 ON t4.ssejflbh = t3.ssejflbh) t5 WHERE YEAR (t5.start_time) = ("+year+" - t5.average)"
	    + ")"
	    +" union all("
	    +"SELECT count(*) FROM (SELECT t4.id,t4.zymc,t4.ssejflbh,t4.start_time,t3.average FROM t_cszc_jbxx t4 "
		+"LEFT JOIN (SELECT (round(sumage / count)) AS average,t2.ssejflbh FROM(SELECT count(*) AS count,SUM(age) AS sumage,t1.ssejflbh "
		+"FROM	(SELECT t.zymc,TIMESTAMPDIFF(YEAR,start_time,disabled_time) AS age,t.ssejflbh FROM	`t_cszc_jbxx` t	WHERE	t.ssejflbh = '05')"
		+ " t1) t2) t3 ON t4.ssejflbh = t3.ssejflbh) t5 WHERE YEAR (t5.start_time) = ("+year+" - t5.average)"
	    + ")"
	    +" union all("
	    +"SELECT count(*) FROM (SELECT t4.id,t4.zymc,t4.ssejflbh,t4.start_time,t3.average FROM t_cszc_jbxx t4 "
		+"LEFT JOIN (SELECT (round(sumage / count)) AS average,t2.ssejflbh FROM(SELECT count(*) AS count,SUM(age) AS sumage,t1.ssejflbh "
		+"FROM	(SELECT t.zymc,TIMESTAMPDIFF(YEAR,start_time,disabled_time) AS age,t.ssejflbh FROM	`t_cszc_jbxx` t	WHERE	t.ssejflbh = '06')"
		+ " t1) t2) t3 ON t4.ssejflbh = t3.ssejflbh) t5 WHERE YEAR (t5.start_time) = ("+year+" - t5.average)"
	    + ")"
	    +" union all("
	    +"SELECT count(*) FROM (SELECT t4.id,t4.zymc,t4.ssejflbh,t4.start_time,t3.average FROM t_cszc_jbxx t4 "
		+"LEFT JOIN (SELECT (round(sumage / count)) AS average,t2.ssejflbh FROM(SELECT count(*) AS count,SUM(age) AS sumage,t1.ssejflbh "
		+"FROM	(SELECT t.zymc,TIMESTAMPDIFF(YEAR,start_time,disabled_time) AS age,t.ssejflbh FROM	`t_cszc_jbxx` t	WHERE	t.ssejflbh = '07')"
		+ " t1) t2) t3 ON t4.ssejflbh = t3.ssejflbh) t5 WHERE YEAR (t5.start_time) = ("+year+" - t5.average)"
	    + ")";
    		Query query=createSQLQuery(sql);			
			List<CategorySum>  result=query.list();
			return result;
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
    /**
     * 获取累计养护次数
     * @param zcmc
     * @return
     */
    public List<Integer> getLjyhcsByZcmc(String zcmc){
    	try{
    		String sql = String.format("select p.ssqy as name,count(p.ssqy)as count from(select t.ssqy,t.qydm,t.jbxx_id from (select b.ssqy,b.qydm,a.jbxx_id,a.dm,a.yhlx from t_cszc_xsjl a left join t_cszc_jbxx b on a.jbxx_id=b.id)t where t.dm=(select c.dm from t_cszc_bjmb c where c.mc='%s'))p group by p.ssqy order by p.qydm asc", zcmc);
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
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
}