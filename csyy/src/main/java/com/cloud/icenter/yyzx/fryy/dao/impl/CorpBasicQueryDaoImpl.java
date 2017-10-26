package com.cloud.icenter.yyzx.fryy.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.fryy.dao.CorpBasicQueryDao;
import com.cloud.icenter.yyzx.fryy.pojo.CorpBasicQuery;
import com.cloud.icenter.yyzx.fryy.pojo.CorpBasicQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.CorpCancelQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.CorpChangeQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.EmployeeQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.SocialSecurityQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.TaxQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.TaxRegistQueryQM;

/** 
* @author zhucy 
* @version 2017年5月4日 下午2:36:02 
* 说明 
*/
@Repository
public class CorpBasicQueryDaoImpl extends BaseDaoImpl<CorpBasicQuery> implements CorpBasicQueryDao{
	/**
	 * 查询法人数据
	 */
	public Map<String, ?> getPageObjectBySql(CorpBasicQueryQM qm, PagingUtil pagingUtil) {
		List<Object> obj = new ArrayList<Object>();
		String sql = "select distinct b.zzjgdm,b.zzjgmc,c.name as zzjglx ,b.nsrsbh,b.tyshxydm,"
				+ "b.jgdz,b.xzqh,d.xzqmc as xzqmc,b.fddbrxm,e.name as fddbrzjlx,b.fddbrzjhm,f.name as hyml,"
				+ "g.name as jjlx,b.pzsljg,b.zczjbz,b.zczj,b.yzbm,b.dhhm,b.wz,b.dzyx,"
				+ "b.khyh,b.yhzh,date_format(b.clrq, '%Y-%m-%d') as clrq,b.zxrq,b.nbrq,b.jyqx,b.jyywfw,b.zongzhi,b.cyrs,b.if_ssqy,"
				+ "b.if_jlqjxk,b.if_zhtsxy,b.if_szzlj,b.if_jsmp,b.if_bzhlhxw,b.if_tzsbzzxk,"
				+ "b.if_zcsb,b.sjly_dm,b.bbrq as cjrq from T_CBID_CORP_BASE_INFO b "
				+ "left join T_DIC_ORGANIZATION_TYPE c on b.zzjglx = c.code "
				+ "left join t_kj_xzqh_xq d on b.xzqh = d.xzqdm "
				+ "left join T_DIC_IDCARD_TYPE e on b.fddbrzjlx = e.code "
				+ "left join T_DIC_ORG_INDUSTRY f on b.hyml = f.code "
				+ "left join T_DIC_ECONOMIC_TYPE g on b.jjlx = g.code where 1=1";
		if (!StringUtil.isEmpty(qm.getJgdz())) {
			sql += " AND b.jgdz = :jgdz";
		}
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND b.zzjgdm like :zzjgdm";
		}
		if (!StringUtil.isEmpty(qm.getFddbrxm())) {
			sql += " AND b.fddbrxm like :fddbrxm";
		}
		if (!StringUtil.isEmpty(qm.getZzjgmc())) {
			sql += " AND b.zzjgmc like :zzjgmc";
		}
		if (null != qm.getStartDate()) {//开始时间
			sql += " AND b.clrq >= :kssj";
		}
		if (null != qm.getEndDate()) {//结束时间
			sql += " AND b.clrq <= :jssj";
		}
		if (!StringUtil.isEmpty(qm.getXzqh()) && !"请选择".equals(qm.getXzqh())) {//行政区划
			sql += " AND b.xzqh = :xzqh";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
		if (!StringUtil.isEmpty(qm.getJgdz())) {
			query.setString("jgdz", qm.getJgdz());
    		querySize.setString("jgdz", qm.getJgdz());
		}
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", "%" +  qm.getZzjgdm() + "%");
    		querySize.setString("zzjgdm", "%" +  qm.getZzjgdm() + "%");
		}
		if (!StringUtil.isEmpty(qm.getFddbrxm())) {
			query.setString("fddbrxm", "%" +  qm.getFddbrxm() + "%");
    		querySize.setString("fddbrxm", "%" +  qm.getFddbrxm() + "%");
		}
		if (!StringUtil.isEmpty(qm.getZzjgmc())) {
			query.setString("zzjgmc", "%" +  qm.getZzjgmc() + "%");
    		querySize.setString("zzjgmc", "%" +  qm.getZzjgmc() + "%");
		}
		if (null != qm.getStartDate()) {//开始时间
			query.setDate("kssj", qm.getStartDate());
			querySize.setDate("kssj", qm.getStartDate());
		}
		if (null != qm.getEndDate()) {//结束时间
			query.setDate("jssj", qm.getEndDate());
			querySize.setDate("jssj", qm.getEndDate());
		}
		if (!StringUtil.isEmpty(qm.getXzqh()) && !"请选择".equals(qm.getXzqh())) {//行政区划
			query.setString("xzqh", qm.getXzqh());
			querySize.setString("xzqh", qm.getXzqh());
		}
		Map<String,Object> map = new HashMap<String,Object>();
		int size = querySize.list().size();//总记录数
		if(size>0){
			map.put("total", querySize.list().get(0));
			query.setFirstResult(pagingUtil.getPageStart());
			query.setMaxResults(pagingUtil.getRows());
			//查询结果是map对象，省去创建pojo;
			map.put("rows",query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list());
			List<Map<String,Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		}else{
			map.put("total",0);
			map.put("rows","");
		}
		return map;
	}
	
	
	/**
	 * 法人基本信息查询
	 * @return
	 */
	public Map<String, Object> findBaseByParam(CorpBasicQueryQM qm){
		String sql = "select distinct b.zzjgdm,b.zzjgmc,c.name as zzjglx ,b.nsrsbh,b.tyshxydm,"
				+ "b.jgdz,d.name as xzqh,b.fddbrxm,e.name as fddbrzjlx,b.fddbrzjhm,f.name as hyml,"
				+ "g.name as jjlx,b.pzsljg,b.zczjbz,b.zczj,b.yzbm,b.dhhm,b.wz,b.dzyx,"
				+ "b.khyh,b.yhzh,b.clrq,b.zxrq,b.nbrq,b.jyqx,b.jyywfw,b.zongzhi,b.cyrs,b.if_ssqy,"
				+ "b.if_jlqjxk,b.if_zhtsxy,b.if_szzlj,b.if_jsmp,b.if_bzhlhxw,b.if_tzsbzzxk,"
				+ "b.if_zcsb,b.sjly_dm,b.bbrq as cjrq from T_CBID_CORP_BASE_INFO b "
				+ " left join T_DIC_ORGANIZATION_TYPE c on b.zzjglx = c.code "
				+ " left join T_DIC_AREA d on b.xzqh = d.code "
				+ " left join T_DIC_IDCARD_TYPE e on b.fddbrzjlx = e.code"
				+ " left join T_DIC_ORG_INDUSTRY f on b.hyml = f.code"
				+ " left join T_DIC_ECONOMIC_TYPE g on b.jjlx = g.code where 1=1 ";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND b.zzjgdm = :zzjgdm";
		}
		if (!StringUtil.isEmpty(qm.getFddbrzjhm())) {
			sql += " AND b.fddbrzjhm = :fddbrzjhm";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", qm.getZzjgdm());
		}
		if (!StringUtil.isEmpty(qm.getFddbrzjhm())) {
			query.setString("fddbrzjhm", qm.getFddbrzjhm());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		if (null != result && result.size() > 0 ) {
			 return result.get(0);
		}
		return null;
	}
	
	/**
	 * 社保基本信息查询
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(SocialSecurityQueryQM qm){
		String sql = "select b.ZZJGDM,b.ZZJGMC,count(b.YLIAODWJNE) as YLIAODWJNE_c,sum(b.YLIAODWJNE) as YLIAODWJNE,"
				+ "count(b.YLAODWJNE) as YLAODWJNE_C,sum(b.YLAODWJNE) as YLAODWJNE, count(b.GSDWJNE) as GSDWJNE_C,"
				+ "sum(b.GSDWJNE) as GSDWJNE, count(b.SYEDWJNE) as SYEDWJNE_C,sum(b.SYEDWJNE) as SYEDWJNE,"
				+ "count(b.SYUDWJNE) as SYUDWJNE_C,sum(b.SYUDWJNE) as SYUDWJNE,b.JFYF "
				+ " from T_CBID_PERSON_SS b where 1=1";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND b.zzjgdm = :zzjgdm";
		}
		sql += " group by b.ZZJGDM,b.ZZJGMC,b.JFYF";
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", qm.getZzjgdm());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 税务基本信息查询
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(TaxRegistQueryQM qm){
		String sql = "select b.zzjgdm, b.zzjgmc,b.nsrsbh,cbi.zzjgmc as gsdjjgmc,b.djrq,"
				+ "b.hsfs_dm,cbi.jyywfw as zy,f.name as hy_dm,b.nsr_swjg_dm,b.swjg_mc,"
				+ "d.name as djzclx_dm,e.name as nsrzt_dm,c.name as lsgx_dm,cbi.fddbrxm as fddbrmc,"
				+ "cbi.dhhm as dhhm,cbi.jgdz as zcdz,cbi.jgdz as scjydz,cbi.ZCZJ as zczb from t_cbid_tax_regist b "
				+ " join t_cbid_corp_base_info cbi on b.zzjgdm=cbi.zzjgdm "
				+ " left join T_DIC_UNIT_SUB_RELA c on b.lsgx_dm = c.code  "
				+ " left join t_dic_regist_type d on b.djzclx_dm = d.code "
				+ " left join T_DIC_TAXPAYER_STATUS e on b.nsrzt_dm = e.code  "
				+ " left join T_DIC_INDUSTRY f on b.hy_dm = f.type2 and f.type3 is null and f.type4 is null where 1=1";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND b.zzjgdm = :zzjgdm";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", qm.getZzjgdm());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 税收
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(TaxQueryQM qm){
		String sql = "select * from ( select b.ZZJGDM,b.ZZJGMC,b.TYSHXYDM,b.NSRSBH,c.name as ZSXM_DM,"
				+ "b.SFSS_Q,b.SFSS_Z,b.CKMDTXSE,b.YSXSSR,b.YNSE,b.SBRQ from T_CBID_NTAX_DELIVER b "
				+ " left join T_DIC_COLLECT_ITEM c on b.ZSXM_DM = c.code order by b.sbrq ) t where 1=1";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND zzjgdm = :zzjgdm";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", qm.getZzjgdm());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 法人注销登记页面
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(CorpCancelQueryQM qm){
		String sql ="select b.zzjgdm,b.zch,b.zzjgmc as dwmc,c.name as zzjglx,b.jgdz,"
				+ "b.fddbr,b.lxdh,b.pzzxjg,b.zxrq,b.zxyy,b.sjly_dm  from T_CBID_CORP_CANCEL b  "
				+ " left join T_DIC_ORGANIZATION_TYPE c on b.zzjglx = c.code where 1=1";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND zzjgdm = :zzjgdm";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", qm.getZzjgdm());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 法人登记变更页面
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(CorpChangeQueryQM qm){
		String sql ="select b.ZZJGDM,b.ZCH,b.ZZJGMC,b.FDDBR,b.ZS,cast(b.KBZJ as decimal(12,2)) AS KBZJ,"
				+ "b.DEMC,b.DSMC,b.QTMC,b.JBDW,b.SLRQ,'' as DHHM "
				+ " from T_CBID_INSTITU_CORP_ESTAB b where 1=1 ";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND b.zzjgdm = :zzjgdm";
		}		
		sql += " union all "
		+ " select c.zzjgdm,c.zch,c.ZZJGMC,c.FDDBR,c.dz as ZS,c.zczbj as KBZJ,"
		+ " '' as DEMC, '' as DSMC,'' as QTMC,c.pzsljg as JBDW,c.slrq as SLRQ,c.lxdh as DHHM "
		+ "from T_CBID_CORP_ESTAB c  where 1=1 ";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND c.zzjgdm = :zzjgdm1";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", qm.getZzjgdm());
		}
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm1", qm.getZzjgdm());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 企业公积金最后缴存月份
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(CorpBasicQueryQM qm){
		String sql ="select distinct b.ZZJGDM,b.ZCH,b.ZZJGMC,b.TYSHXYDM,b.SJZGS,b.SJJE,b.JCSJ,b.JCLX "
				+ " from t_cbid_unit_accum_fund b where 1=1 ";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND b.zzjgdm = :zzjgdm";
		}		
		sql += " and b.jcsj=(select max(c.jcsj) from t_cbid_unit_accum_fund c  where 1=1 ";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND c.zzjgdm = :zzjgdm1";
		}
		sql += ")";
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", qm.getZzjgdm());
		}
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm1", qm.getZzjgdm());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 查询法人员工
	 */
	public Map<String, ?> getPageObjectBySql(EmployeeQueryQM qm, PagingUtil pagingUtil) {
		List<Object> obj = new ArrayList<Object>();
		String sql = "SELECT  t.XM ,t.SFZ,replace(t.SFZ, SUBSTR(t.SFZ, 6, 10), '****') SFZHM,t.JGDM zzjgdm,t.SNNAME zzjgmc ,"
				+ "date_format(a.CSRQ, '%Y-%m-%d') CSRQ,d.name xb from T_CBID_UNIT_STAFF_INF t "
				+ " LEFT JOIN T_PBID_POP_BASIC_INF a on a.SFZ=t.SFZ "
				+ " LEFT JOIN T_DIC_SEX d on d.CODE=a.XB where 1=1";
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			sql += " AND t.jgdm = :zzjgdm";
		}
//		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
//			sql += " AND b.zzjgdm like :zzjgdm";
//		}
//		if (!StringUtil.isEmpty(qm.getFddbrxm())) {
//			sql += " AND b.fddbrxm like :fddbrxm";
//		}
//		if (!StringUtil.isEmpty(qm.getZzjgmc())) {
//			sql += " AND b.zzjgmc like :zzjgmc";
//		}
//		if (null != qm.getStartDate()) {//开始时间
//			sql += " AND b.clrq >= :kssj";
//		}
//		if (null != qm.getEndDate()) {//结束时间
//			sql += " AND b.clrq <= :jssj";
//		}
//		if (!StringUtil.isEmpty(qm.getXzqh()) && !"请选择".equals(qm.getXzqh())) {//行政区划
//			sql += " AND b.xzqh = :xzqh";
//		}
		SQLQuery query = createSQLQuery(sql);//记录
		SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
			query.setString("zzjgdm", qm.getZzjgdm());
    		querySize.setString("zzjgdm", qm.getZzjgdm());
		}
//		if (!StringUtil.isEmpty(qm.getZzjgdm())) {
//			query.setString("zzjgdm", "%" +  qm.getZzjgdm() + "%");
//    		querySize.setString("zzjgdm", "%" +  qm.getZzjgdm() + "%");
//		}
//		if (!StringUtil.isEmpty(qm.getFddbrxm())) {
//			query.setString("fddbrxm", "%" +  qm.getFddbrxm() + "%");
//    		querySize.setString("fddbrxm", "%" +  qm.getFddbrxm() + "%");
//		}
//		if (!StringUtil.isEmpty(qm.getZzjgmc())) {
//			query.setString("zzjgmc", "%" +  qm.getZzjgmc() + "%");
//    		querySize.setString("zzjgmc", "%" +  qm.getZzjgmc() + "%");
//		}
//		if (null != qm.getStartDate()) {//开始时间
//			query.setDate("kssj", qm.getStartDate());
//			querySize.setDate("kssj", qm.getStartDate());
//		}
//		if (null != qm.getEndDate()) {//结束时间
//			query.setDate("jssj", qm.getEndDate());
//			querySize.setDate("jssj", qm.getEndDate());
//		}
//		if (!StringUtil.isEmpty(qm.getXzqh()) && !"请选择".equals(qm.getXzqh())) {//行政区划
//			query.setString("xzqh", qm.getXzqh());
//			querySize.setString("xzqh", qm.getXzqh());
//		}
		Map<String,Object> map = new HashMap<String,Object>();
		int size = querySize.list().size();//总记录数
		if(size>0){
			map.put("total", querySize.list().get(0));
			query.setFirstResult(pagingUtil.getPageStart());
			query.setMaxResults(pagingUtil.getRows());
			//查询结果是map对象，省去创建pojo;
			map.put("rows",query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list());
			List<Map<String,Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		}else{
			map.put("total",0);
			map.put("rows","");
		}
		return map;
	}
	
}
