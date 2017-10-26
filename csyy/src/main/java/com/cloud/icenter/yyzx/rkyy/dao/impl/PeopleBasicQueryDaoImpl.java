package com.cloud.icenter.yyzx.rkyy.dao.impl;

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
import com.cloud.icenter.yyzx.rkyy.dao.PeopleBasicQueryDao;
import com.cloud.icenter.yyzx.rkyy.pojo.Dictionary;
import com.cloud.icenter.yyzx.rkyy.pojo.HunYinInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.JiaTingInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.PeopleBasicQuery;
import com.cloud.icenter.yyzx.rkyy.pojo.PeopleBasicQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.SheBaoInfoQueryQM;

/** 
* @author zhucy 
* @version 2017年4月26日 上午10:07:49 
* 说明 
*/
@Repository
public class PeopleBasicQueryDaoImpl extends BaseDaoImpl<PeopleBasicQuery> implements PeopleBasicQueryDao{
	/**
	 * 查询人口数据
	 */
	@Override
	public Map<String, ?> getPageObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil) {
		List<Object> obj = new ArrayList<Object>();
		String sql = "select * from (select b.zwxm,b.sfz,s.name as xb,n.name as mz,date_format(b.csrq, '%Y-%m-%d') as csrq,"
				+ "b.hjszd,b.zzbh as zzbh,replace(b.sfz,SUBSTR(b.sfz,6,10),'****') as r_sfz,b.lxfs,b.hjszdssx,b.xjzd as xzz,"
				+ "b.csrq as csrqs from  T_PBID_POP_BASIC_INF b left join t_dic_sex s on b.xb = s.code left join t_dic_nation n"
				+ " on b.mz = cast(n.code as UNSIGNED INT)) as a where 1=1";
		if (!StringUtil.isEmpty(qm.getZwxm())) {//姓名
			sql += " AND zwxm like :zwxm";
		}
		if (!StringUtil.isEmpty(qm.getSfz())) {//身份证
			sql += " AND sfz = :sfz";
		}
		if (!StringUtil.isEmpty(qm.getXb()) && !"请选择".equals(qm.getXb())) {//性别
			sql += " AND xb = :xb";
		}
		if (!StringUtil.isEmpty(qm.getLxfs())) {//电话号码
			sql += " AND lxfs like :lxfs";
		}
		if (null != qm.getKssj()) {//开始时间
			sql += " AND csrqs >= :kssj";
		}
		if (null != qm.getJssj()) {//结束时间
			sql += " AND csrqs <= :jssj";
		}
		if (!StringUtil.isEmpty(qm.getHjszdssx()) && !"请选择".equals(qm.getHjszdssx())) {//行政区划
			sql += " AND hjszdssx = :hjszdssx";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
		if (!StringUtil.isEmpty(qm.getZwxm())) {
			query.setString("zwxm", "%" +  qm.getZwxm() + "%");
    		querySize.setString("zwxm", "%" +  qm.getZwxm() + "%");
		}
		if (!StringUtil.isEmpty(qm.getSfz())) {//身份证
			query.setString("sfz", qm.getSfz());
			querySize.setString("sfz", qm.getSfz());
		}
		if (!StringUtil.isEmpty(qm.getXb()) && !"请选择".equals(qm.getXb())) {//性别
			query.setString("xb", qm.getXb());
			querySize.setString("xb", qm.getXb());
		}
		if (!StringUtil.isEmpty(qm.getLxfs())) {//电话号码
			query.setString("lxfs", "%" +  qm.getLxfs() + "%");
    		querySize.setString("lxfs", "%" +  qm.getLxfs() + "%");
		}
		if (null != qm.getKssj()) {//开始时间
			query.setDate("kssj", qm.getKssj());
			querySize.setDate("kssj", qm.getKssj());
		}
		if (null != qm.getJssj()) {//结束时间
			query.setDate("jssj", qm.getKssj());
			querySize.setDate("jssj", qm.getKssj());
		}
		if (!StringUtil.isEmpty(qm.getHjszdssx()) && !"请选择".equals(qm.getHjszdssx())) {//行政区划
			query.setString("hjszdssx", qm.getHjszdssx());
			querySize.setString("hjszdssx", qm.getHjszdssx());
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
	 * 查询社保列表数据
	 */
	public Map<String, ?> getPageSbxxObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil) {
		List<Object> obj = new ArrayList<Object>();
		String sql = "select tt.* ,replace(tt.sfzhm, SUBSTR(tt.sfzhm, 6, 10), '****') sfzh from  T_PBID_SOCIAL_INSU_PAY tt"
				+ " where 1=1 ";
		if (!StringUtil.isEmpty(qm.getSfzhm())) {
			sql += " AND tt.sfzhm = :sfzhm";
		}
		sql += " order by cast(tt.jfyf as UNSIGNED INT) desc";
		SQLQuery query = createSQLQuery(sql);//记录
		SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
		if (!StringUtil.isEmpty(qm.getSfzhm())) {
			query.setString("sfzhm", qm.getSfzhm());
			querySize.setString("sfzhm", qm.getSfzhm());
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
	 * 查询公积金列表数据
	 */
	public Map<String, ?> getPageGjjxxObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil) {
		List<Object> obj = new ArrayList<Object>();
		String sql = " select i.xm ,replace(i.sfzhm, SUBSTR(i.sfzhm, 6, 10), '****') sfzh,i.sfzhm,t.zggjjzh , t.dwdm,t.gjjyjce,t.gjjye,t.zjjhjny "
				+ "from   t_pbid_accumu_info i "
				+ "left join  T_PBID_ACCUMU_PAY  t on i.zggjjzh=t.zggjjzh where 1=1 ";
		if (!StringUtil.isEmpty(qm.getSfz())) {
			sql += " AND i.sfzhm = :sfzhm";
		}
		sql += " order by t.zjjhjny desc";
		SQLQuery query = createSQLQuery(sql);//记录
		SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
		if (!StringUtil.isEmpty(qm.getSfz())) {
			query.setString("sfzhm", qm.getSfz());
			querySize.setString("sfzhm", qm.getSfz());
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
	 * 行政区划
	 * @return
	 */
	public List<Map<String, Object>> getAreaCombox(){
		String sql = "select t.xzqdm as code,t.xzqmc name from t_kj_xzqh_xq t";
		SQLQuery query = createSQLQuery(sql);//记录
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 个人信息
	 * @return
	 */
	public Map<String, Object> findBaseBySfz(String sfz){
		String sql = "select b.zwxm,b.sfz,s.name as xb,n.name as mz,b.csrq,c.name as gj,a.name as jg,"
				+ "b.hjszd,b.lxfs,b.zzbh,b.ywxm,p.name as zzmm,m.name as hyzk,eb.name as whcd,"
				+ "replace(b.sfz,SUBSTR(b.sfz,6,10),'****') as r_sfz,f.name as zjxy,ms.name as byzk,"
				+ "i.name as xxjb,b.zzbh as hjszdssx,case when d.sfz is null then '否' else '是' end as disabled,b.xjzd as xzz "
				+ "from  T_PBID_POP_BASIC_INF b left join t_dic_sex s on b.xb=s.code "
				+ "left join t_dic_nation n on b.mz = cast(n.code as UNSIGNED INT)"
				+ "left join t_dic_country c on b.gj = c.code "
				+ "left join T_dic_area a on b.jg = a.code "
				+ "left join t_dic_political_status p on b.zzmm = p.code "
				+ "left join t_dic_marry_status m on m.code=b.hyzk "
				+ "left join t_dic_edu_background eb on b.whcd = eb.code "
				+ "left join t_dic_faith f on b.zjxy = f.code "
				+ "left join t_dic_military_service ms on b.byzk = ms.code "
				+ "left join t_dic_pop_infolevel i on b.xxjb = i.code "
				+ "left join  T_PBID_DISABLED d on b.sfz = d.sfz where 1=1 ";
		if (!StringUtil.isEmpty(sfz)) {
			sql += " AND b.sfz = :sfz";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(sfz)) {
			query.setString("sfz", sfz);
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		if (null != result && result.size() > 0 ) {
			 return result.get(0);
		}
		return null;
	}
	
	
	/**
	 * 个人信息相关字典
	 * @return
	 */
	public List<Dictionary> getDictionary(Dictionary dqm){
		String sql = "SELECT id ,dic_name dicName,dic_code dicCode,dic_state dicState,dic_type dicType FROM t_gasp_sys_data_dic where 1=1 ";
		if (!StringUtil.isEmpty(dqm.getDicType())) {
			sql += " AND dic_type = :dic_type";
		}
		if (!StringUtil.isEmpty(dqm.getDicState())) {
			sql += " AND dic_state = :dic_state";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(dqm.getDicType())) {
			query.setString("dic_type", dqm.getDicType());
		}
		if (!StringUtil.isEmpty(dqm.getDicState())) {
			query.setString("dic_state", dqm.getDicState());
		}
		query.setResultTransformer(Transformers.aliasToBean(Dictionary.class));
		List<Dictionary> list = query.list();
		return list;
	}
	
	/**
	 * 家庭基本信息
	 * @return
	 */
	public Map<String, Object> getJtJbxx(JiaTingInfoQueryQM qm){
		String sql = "select t.jtbh,replace(t.hzsfz,substr(t.hzsfz,6,10),'****') hzsfz,s.peonum,t.hzsfz as sfz,"
				+ "case when cast(t.sfdbh as UNSIGNED INT)=2 then '是' else '否' end as sfdbh,"
				+ "case when cast(t.sflnjt as UNSIGNED INT)=1 then '是' else '否' end as sflnjt,"
				+ "case when cast(t.sfclnrjt as UNSIGNED INT)=1 then '是' else '否' end as sfclnrjt,t.jtnzsr,"
				+ "t.lxfs,c.name||t.hjszdxz as jtxxdz from T_PBID_FAMILY_BASIC_INFO t "
				+ " left join    t_dic_address c on c.code=t.hjszdssx "
				+ " left join (select count(*) peonum,a.jtbh from T_PBID_FAMILY_RELATE a group by a.jtbh) s on t.jtbh=s.jtbh where 1=1";
		if (!StringUtil.isEmpty(qm.getHzsfz())) {
			sql += " AND t.hzsfz = :hzsfz";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getHzsfz())) {
			query.setString("hzsfz", qm.getHzsfz());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		if (null != result && result.size() > 0 ) {
			 return result.get(0);
		}
		return null;
	}
	
	/**
	 * 家庭关系
	 * @return
	 */
	public List<Map<String, Object>> getJtgx(JiaTingInfoQueryQM qm){
		String sql = " select replace(r.sfz,SUBSTR(r.sfz,6,10),'****') sfz,f.name as ybbgx,"
				+ "replace(r.gxrsfz,SUBSTR(r.gxrsfz,6,10),'****') gxrsfz,r.gxrlxdh,f.code "
				+ " from  t_pbid_family_relate r "
				+ " left join T_DIC_FAMILY_RELATION f on r.ybbgx = f.code where 1=1 ";
		if (!StringUtil.isEmpty(qm.getHzsfz())) {
			sql += " AND r.sfz = :hzsfz";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getHzsfz())) {
			query.setString("hzsfz", qm.getHzsfz());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 社保信息
	 * @return
	 */
	public List<Map<String, Object>> getSbxx(SheBaoInfoQueryQM qm){
		String sql = "select tt.* ,replace(tt.sfzhm, SUBSTR(tt.sfzhm, 6, 10), '****') sfzh "
				+ " from  T_PBID_SOCIAL_INSU_PAY tt where 1=1 ";
		if (!StringUtil.isEmpty(qm.getSfzhm())) {
			sql += " AND tt.sfzhm = :sfzhm";
		}
		sql += " order by cast(tt.jfyf as UNSIGNED INT) desc";
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getSfzhm())) {
			query.setString("sfzhm", qm.getSfzhm());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 婚姻情况
	 * @return
	 */
	public List<Map<String, Object>> getHyxx(HunYinInfoQueryQM qm){
		String sql = "select i0.zwxm as mxm, replace(m.mnfsfzhm,SUBSTR(m.mnfsfzhm,6,10),'****') mnfsfzhm , "
				+ "replace(m.fnfsfzhm,SUBSTR(m.fnfsfzhm,6,10),'****') fnfsfzhm,i1.zwxm as fxm,t.name as ywlxdm,m.blhydjzhm,"
				+ "m.djrq,case when m.fhbs = 0 then '否' else '是' end as fhbs,"
				+ "case when m.bbjhbs = 0 then '否' else '是' end as bbjhbs,"
				+ "m.lhyydm,m.blyydm,m.hydjgljgmc,m.hydjgljgdwdm,m.hydjgljgtyshxydm "
				+ " from  t_pbid_marry_regist m  left join    T_DIC_MARRY_BUSI_TYPE t on m.ywlxdm = t.code "
				+ " left join  t_pbid_pop_basic_inf i0 on m.mnfsfzhm = i0.sfz "
				+ " left join  t_pbid_pop_basic_inf i1 on m.fnfsfzhm = i1.sfz "
				+ " where 1=1 ";
		if (!StringUtil.isEmpty(qm.getSfz())) {
			sql += " AND m.mnfsfzhm = :mnfsfzhm or m.fnfsfzhm =:fnfsfzhm";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getSfz())) {
			query.setString("mnfsfzhm", qm.getSfz());
			query.setString("fnfsfzhm", qm.getSfz());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 公积金信息
	 * @return
	 */
	public List<Map<String, Object>> getGjjxx(PeopleBasicQueryQM qm){
		String sql = "select i.xm ,replace(i.sfzhm, SUBSTR(i.sfzhm, 6, 10), '****') sfzh,i.sfzhm,t.zggjjzh , "
				+ "t.dwdm,t.gjjyjce,t.gjjye,t.zjjhjny from   t_pbid_accumu_info i left join  T_PBID_ACCUMU_PAY  t "
				+ " on i.zggjjzh=t.zggjjzh where 1=1 ";
		if (!StringUtil.isEmpty(qm.getSfz())) {
			sql += " AND i.sfzhm = :sfzhm";
		}
		sql += " order by t.zjjhjny desc";
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getSfz())) {
			query.setString("sfzhm", qm.getSfz());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	/**
	 * 家庭关系拓展图
	 * @param qm
	 * @return
	 */
	public List<Map<String, Object>> getJtgxtzt(JiaTingInfoQueryQM qm){
		String sql = "select r.sfz,f.name as ybbgx,r.gxrsfz,r.gxrlxdh,f.code,"
				+ "i.xb,floor(TIMESTAMPDIFF(MONTH,sysdate(),i.csrq)/12) as age,i.zwxm "
				+ " from  t_pbid_family_relate r left join T_DIC_FAMILY_RELATION f on r.ybbgx = f.code "
				+ " left join T_PBID_POP_BASIC_INF i on i.sfz=r.gxrsfz where 1=1 ";
		if (!StringUtil.isEmpty(qm.getHzsfz())) {
			sql += " AND r.sfz = :sfz";
		}
		SQLQuery query = createSQLQuery(sql);//记录
		if (!StringUtil.isEmpty(qm.getHzsfz())) {
			query.setString("sfz", qm.getHzsfz());
		}
		List<Map<String, Object>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return result;
	}
	
	
}
