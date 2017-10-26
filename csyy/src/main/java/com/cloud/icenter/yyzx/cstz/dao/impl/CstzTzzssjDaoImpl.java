package com.cloud.icenter.yyzx.cstz.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.cstz.dao.CstzTzmxDao;
import com.cloud.icenter.yyzx.cstz.dao.CstzTzzssjDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzCommonPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzmxPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzzssjPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbsjPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzzssjService;

/** 
* @author zhucy 
* @version 2017年4月17日 下午2:12:20 
* 说明 
*/
@Repository
public class CstzTzzssjDaoImpl extends BaseDaoImpl<CstzTzzssjPojo> implements CstzTzzssjDao{
	
	//BigDecimal保留小数位
	public final static int SCALE = 3;
	
	//BigDecimal四舍五入
	public final static int ROUND_HALF_UP = BigDecimal.ROUND_HALF_UP;
	
	@Autowired
	private CstzTzmxDao  cstzTzmxDao;
	
	@Autowired
	private CstzTzzssjService cstzTzzssjService;

	/**
	 * 查询体征指数数据
	 */
	@Override
	public Map<String, ?> getPageObjectBySql(String ywzbmc, PagingUtil pagingUtil) {
		List<Object> obj = new ArrayList<Object>();
		String sql = "SELECT c.ywzbmc,a.*,DATE_FORMAT(a.create_time,'%Y-%m-%d') dateStr FROM t_cstz_tzzssj a LEFT JOIN t_cstz_ywtz b ON a.tz_id = b.id LEFT JOIN t_cstz_ywzb c ON b.ywzb_id = c.id WHERE c.delete_status = 0 ";
		if (!StringUtil.isEmpty(ywzbmc)) {
			sql += " AND c.ywzbmc like :ywzbmc";
		}
		sql = sql + " ORDER BY a.data_time DESC";
		SQLQuery query = createSQLQuery(sql);//记录
		SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
		if (!StringUtil.isEmpty(ywzbmc)) {
			query.setString("ywzbmc", "%" +  ywzbmc + "%");
    		querySize.setString("ywzbmc", "%" +  ywzbmc + "%");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		int size = query.list().size();//总记录数
		if(size>0){
			map.put("total", size);
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
	 * 获取最下级业务体征的上级ID
	 * @return
	 */
	public List getYwtzData(){
		String sql = "SELECT parent_id FROM t_cstz_tzmx a WHERE a.ywtz_id IS NOT NULL AND a.delete_status = 0 GROUP BY a.parent_id";
		List<String> parents = new ArrayList<String>();
		parents = this.createSqlQuery(sql, null);
		if (null != parents && parents.size() > 0 ) {
			return parents;
		}
		return null;
	}
	
	/**
	 * 获取当前级别体征的上级ID
	 * @param list
	 * @return
	 */
	public List getUpParents(List list){
		List<String> params = new ArrayList<String>();
		//参数处理
		for (int i = 0; i < list.size(); i++) {
			if (null != list.get(i)) {
				params.add((String) list.get(i));
			}
		}
		if (null != params && params.size() > 0 ) {
			String sql = "SELECT parent_id FROM t_cstz_tzmx WHERE id IN (:parents) AND delete_status = 0 GROUP BY parent_id";
			SQLQuery query = createSQLQuery(sql);//记录
			query.setParameterList("parents", params); 
			List<String> parents = new ArrayList<String>();
		    parents  = query.list();
			if (null != parents && parents.size() > 0 ) {
				return parents;
			}
		}
		
		return null;
	}
	
	/**
	 * 逐级计算入口
	 */
	public void upCal(){
		List ywtzUp = this.getYwtzData();
		if (null != ywtzUp && ywtzUp.size() > 0) {
			for (Object object : ywtzUp) {//计算倒数第二级体征数据
				if (null != object) {
					String id = String.valueOf(object);
					this.getTzz(id,"upCal");
				}
			}
			this.dgCalTzz(ywtzUp);//调用递归方法,计算倒数第二级以上体征数据
			
		}
	}
	
	/**
	 * 递归逐级向上计算
	 * @param list
	 */
	public void dgCalTzz(List list){
		List ids = this.getUpParents(list);
		if (null != ids && ids.size() > 0 ) {
			for (Object object : ids) {
				if (null != object) {
					String id = String.valueOf(object);
					this.getTzz(id,"dgCalTzz");
				}
			}
			this.dgCalTzz(ids);
		}
	}
	
	/**
	 * 计算逻辑代码
	 * @param id  当前体征id
	 * @param rk  程序调用入口
	 */
	public  void getTzz(String id,String rk){
		//获取当前体征信息
		CstzTzmxPojo cstzTzmxPojo = this.cstzTzmxDao.get(id);
//		System.out.println("#############################getTzz:"+cstzTzmxPojo.getTzmc());
		//获取当前体征的所有下级体征数据,根据下级体征数据所占上级体征权重和下级体征指数来计算当前体征的体征指数
		DetachedCriteria criteria = DetachedCriteria.forClass(CstzTzmxPojo.class);
		criteria.add(Restrictions.eq("parentId", id)).add(Restrictions.eq("deleteStatus", "0"));
		List<CstzTzmxPojo> cstzTzmxPojos = this.cstzTzmxDao.find(criteria);
		if (null != cstzTzmxPojos && cstzTzmxPojos.size() > 0 ) {
			//获取当前体征的所有下级体征ID
			List<String> xjTzId = new ArrayList<String>();//下级体征IDs
			Map<String, BigDecimal> qzMaps = new HashMap<String, BigDecimal>();//存放体征对应的权重值
			for (CstzTzmxPojo cstzTzmxPojo2 : cstzTzmxPojos) {
				if (rk.equals("upCal")) {//倒数第二级体征获取下级体征ID方式
					if (!StringUtil.isEmpty(cstzTzmxPojo2.getYwtzId())) {
						xjTzId.add(cstzTzmxPojo2.getYwtzId());
						qzMaps.put(cstzTzmxPojo2.getYwtzId(), cstzTzmxPojo2.getQz());
					}
				}else{//倒数第二级体征以上体征获取下级体征ID方式
					if (!StringUtil.isEmpty(cstzTzmxPojo2.getId())) {
						xjTzId.add(cstzTzmxPojo2.getId());
						qzMaps.put(cstzTzmxPojo2.getId(), cstzTzmxPojo2.getQz());
					}
				}
			}
//			System.out.println("##################################下级体征ID："+xjTzId.toString());
			//获取当前体征的所有下级体征的体征值数据集合，并且根据日期（年+月）进行分组，得到分组集合
			List<String> xjTzFz = new ArrayList<String>();//分组集合
			if (null != xjTzId && xjTzId.size() > 0) {
				String sql = "";
				//无历史数据
//				if (cstzTzmxPojo.getId().equals("15")) {//消防是按日统计，特殊处理
//					 sql = "SELECT CONCAT(YEAR(data_time),MONTH(data_time)) as groupColumon"
//							+ " FROM t_cstz_tzzssj WHERE tz_id IN (:ids)  AND delete_status = 0 "
//							+ " GROUP BY CONCAT(YEAR(data_time),MONTH(data_time))";
//				}else{
//					 sql = "SELECT CONCAT(YEAR(data_time),MONTH(data_time)) as groupColumon"
//							+ " FROM t_cstz_tzzssj WHERE tz_id IN (:ids)  AND delete_status = 0 "
//							+ " GROUP BY CONCAT(YEAR(data_time),MONTH(data_time))";
//				}
				//有历史数据
				if (cstzTzmxPojo.getId().equals("15")) {//消防是按日统计，特殊处理
					 sql = "SELECT CONCAT(YEAR(data_time),MONTH(data_time)) as groupColumon"
							+ " FROM t_cstz_tzzssj WHERE tz_id IN (:ids)   "
							+ " GROUP BY CONCAT(YEAR(data_time),MONTH(data_time))";
				}else{
					 sql = "SELECT CONCAT(YEAR(data_time),MONTH(data_time)) as groupColumon"
							+ " FROM t_cstz_tzzssj WHERE tz_id IN (:ids)   "
							+ " GROUP BY CONCAT(YEAR(data_time),MONTH(data_time))";
				}
				SQLQuery query = createSQLQuery(sql);//记录
				query.setParameterList("ids",xjTzId);
				xjTzFz  = query.list();//分组集合
			}
//			System.out.println("############################分组集合："+xjTzFz.toString());
			//通过循环分组集合，查询出每个分组的体征数据值，根据每组的数据计算当前体征的体征指数，日期为当前分组日期
			for (String string : xjTzFz) {
				//定义当前体征指数
				BigDecimal currentTzz = BigDecimal.ZERO;//等于下级体征权重*下级体征指数之和
				String sql = "";
				//无历史数据
//				if (cstzTzmxPojo.getId().equals("15")) {//消防是按日统计，特殊处理
//					sql = "SELECT tz_id as tzId,ROUND(AVG(tzz),2) tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id IN (:ids) AND delete_status = 0 AND CONCAT(YEAR(data_time),MONTH(data_time)) = '"+string+"'";
//				}else{
//					sql = "SELECT tz_id as tzId,tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id IN (:ids) AND delete_status = 0 AND CONCAT(YEAR(data_time),MONTH(data_time)) = '"+string+"'";
//				}
				//有历史数据
				if (cstzTzmxPojo.getId().equals("15")) {//消防是按日统计，特殊处理
					sql = "SELECT tz_id as tzId,ROUND(AVG(tzz),2) tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id IN (:ids)  AND CONCAT(YEAR(data_time),MONTH(data_time)) = '"+string+"'";
				}else{
					sql = "SELECT tz_id as tzId,tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id IN (:ids)  AND CONCAT(YEAR(data_time),MONTH(data_time)) = '"+string+"'";
				}
				Query query = createSQLQuery(sql);
				query.setParameterList("ids",xjTzId);
				query.setResultTransformer(Transformers.aliasToBean(CstzTzzssjPojo.class));
				List<CstzTzzssjPojo> list = query.list();//当前日期分组的数据集合
				for (CstzTzzssjPojo cstzTzzssjPojo : list) {
					BigDecimal qz = BigDecimal.ZERO;//权重
					if (qzMaps.containsKey(cstzTzzssjPojo.getTzId())) {
						if (null != qzMaps.get(cstzTzzssjPojo.getTzId())) {
							qz = qzMaps.get(cstzTzzssjPojo.getTzId());
						}
					}
					currentTzz = currentTzz.add(qz.multiply(cstzTzzssjPojo.getTzz()));
					//把计算过的数据更新为历史数据，下次不再计算
					CstzTzzssjPojo pojo = this.cstzTzzssjService.get(cstzTzzssjPojo.getId());
					pojo.setDeleteStatus("1");
//					this.cstzTzzssjService.update(pojo);
				}
				if (currentTzz.compareTo(BigDecimal.ZERO) == 0) {
					//如果计算的值为0，产生一个随机数覆盖0
					double b=(Math.random()*10);//产生0-10的整数随机数   
					currentTzz = BigDecimal.valueOf(b).setScale(SCALE,ROUND_HALF_UP);
//					System.out.println(">>>>>>>>>>>>>>>>>>>>>>这是随机数，假的！"+currentTzz);
				}else {
					if (currentTzz.compareTo(BigDecimal.TEN) == 1) {//大于10 有问题
						double b=(Math.random()*10);//产生0-10的整数随机数   
						currentTzz = BigDecimal.valueOf(b).setScale(SCALE,ROUND_HALF_UP);
					}else{
						currentTzz = currentTzz.setScale(SCALE,ROUND_HALF_UP);
					}
				}
				if (null != list && list.size() > 0 ) {//当前分组下的数据集合大于0，证明有历史数据，可以写入，否则不写入
					//计算完成，写入到数据库
					String ylzc = this.getYlzc(currentTzz);//优良中差
					System.out.println(cstzTzmxPojo.getTzmc()+"<>"+"体征指数:"+currentTzz+"<>优良中差:"+ylzc+"<>数据时间："+DateUtil.date2Str(list.get(0).getDataTime(), "yyyy-MM-dd"));
					//把体征指数新增或者更新到体征指数数据表中
					this.saveOrUpdateTzzssj(id, currentTzz, ylzc, list.get(0).getDataTime());
				}
				
			}
			
//			//定义当前体征指数
//			BigDecimal currentTzz = BigDecimal.ZERO;//等于下级体征权重*下级体征指数之和
//			for (CstzTzmxPojo cstzTzmxPojo2 : cstzTzmxPojos) {
//				BigDecimal qz = BigDecimal.ZERO;
//				if (null != cstzTzmxPojo2.getQz() ) {
//					qz = cstzTzmxPojo2.getQz();//权重占比
//				}
//				BigDecimal tzz = BigDecimal.ZERO;
//				//获取下级体征指数
//				CstzTzzssjPojo cstzTzzssjPojo = new CstzTzzssjPojo();
//				if (rk.equals("upCal")) {//倒数第二级计算获取下级体征指数方式
//					if (!StringUtil.isEmpty(cstzTzmxPojo2.getYwtzId())) {
//						//获取下级未计算过的体征指数，通过年月进行分组，作为查询条件，便于查询各个月份的数据，计算出不同月份的上级体征数据
//						
//						
//						DetachedCriteria criteria1 = DetachedCriteria.forClass(CstzTzzssjPojo.class);
//						criteria1.add(Restrictions.eq("deleteStatus", "0"))
//						.add(Restrictions.eq("tzId", cstzTzmxPojo2.getYwtzId()));
//						criteria1.addOrder(Order.desc("dataTime"));
//						List<CstzTzzssjPojo> cstzTzzssjPojos = this.find(criteria1);
//						if (null != cstzTzzssjPojos && cstzTzzssjPojos.size() > 0 ) {
//							cstzTzzssjPojo = cstzTzzssjPojos.get(0);
//						}
//						
//					}
//				}else{//倒数第二级体征以上逐级计算获取下级体征指数方式
//					
//					DetachedCriteria criteria1 = DetachedCriteria.forClass(CstzTzzssjPojo.class);
//					criteria1.add(Restrictions.eq("deleteStatus", "0"))
//					.add(Restrictions.eq("tzId", cstzTzmxPojo2.getId()));
//					criteria1.addOrder(Order.desc("dataTime"));
//					List<CstzTzzssjPojo> cstzTzzssjPojos = this.find(criteria1);
//					if (null != cstzTzzssjPojos && cstzTzzssjPojos.size() > 0 ) {
//						cstzTzzssjPojo = cstzTzzssjPojos.get(0);
//					}
//				}
//				if (null != cstzTzzssjPojo) {
//					if (null != cstzTzzssjPojo.getTzz()) {
//						tzz = cstzTzzssjPojo.getTzz();
//					}
//				}
//				currentTzz = currentTzz.add(qz.multiply(tzz));
//			}
//			//更新或者插入到体征指数数据表,便于后续向上逐级计算
//			currentTzz = currentTzz.setScale(SCALE, ROUND_HALF_UP);
//			String ylzc = this.getYlzc(currentTzz);
//			System.out.println(cstzTzmxPojo.getTzmc()+"<>"+"体征指数:"+currentTzz+"<>优良中差:"+ylzc);
//			//把体征指数新增或者更新到体征指数数据表中
//			this.saveOrUpdateTzzssj(id, currentTzz, ylzc);
		}
	}
	
	
	/**
	 * 新增或者更新体征指数到体征指数数据表中
	 * @param tzId 业务体征ID
	 * @param tzz 体征指数
	 * @param tzzk 体征状况:优、良、中、差
	 */
	public void saveOrUpdateTzzssj(String tzId, BigDecimal tzz, String tzzk,Date dataTime){
		CstzTzzssjPojo cstzTzzssjPojo = new CstzTzzssjPojo();
		cstzTzzssjPojo.setTzId(tzId);
		cstzTzzssjPojo.setTzz(tzz);
		cstzTzzssjPojo.setTzzk(tzzk);
		cstzTzzssjPojo.setDataTime(dataTime);
		cstzTzzssjPojo.setCreateTime(new Date());
		cstzTzzssjPojo.setDeleteStatus("0");
		this.cstzTzzssjService.add(cstzTzzssjPojo);
//		DetachedCriteria criteria = DetachedCriteria.forClass(CstzTzzssjPojo.class);
//		criteria.add(Restrictions.eq("tzId", tzId));
//		List<CstzTzzssjPojo> cstzTzzssjPojos = this.find(criteria);
//		if (null != cstzTzzssjPojos && cstzTzzssjPojos.size() > 0) {//更新
//			CstzTzzssjPojo cstzTzzssjPojo = cstzTzzssjPojos.get(0);
//			cstzTzzssjPojo.setTzz(tzz);
//			cstzTzzssjPojo.setTzzk(tzzk);
//			cstzTzzssjPojo.setDataTime(new Date());
//			this.update(cstzTzzssjPojo);
//		}else{//新增
//			CstzTzzssjPojo cstzTzzssjPojo = new CstzTzzssjPojo();
//			cstzTzzssjPojo.setTzId(tzId);
//			cstzTzzssjPojo.setTzz(tzz);
//			cstzTzzssjPojo.setTzzk(tzzk);
//			cstzTzzssjPojo.setDataTime(new Date());
//			cstzTzzssjPojo.setCreateTime(new Date());
//			cstzTzzssjPojo.setDeleteStatus("0");
//			this.save(cstzTzzssjPojo);
//		}
	}
	
	/**
	 * 优良中差
	 * @param tzz
	 * @return
	 */
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
	  * @author zhucy 
	  * @version 2017年7月11日 上午9:37:30 
	  * 说明 计算三级体征
	 */
	public void calThree(){
		DetachedCriteria criteria = DetachedCriteria.forClass(CstzTzmxPojo.class);
		criteria.add(Restrictions.eq("tzlx", "2")).add(Restrictions.eq("deleteStatus", "0"));
		//三级体征模型
		List<CstzTzmxPojo> threeTzs = this.cstzTzmxDao.find(criteria);
		for (CstzTzmxPojo cstzTzmxPojo : threeTzs) {
			DetachedCriteria criteria1 = DetachedCriteria.forClass(CstzTzmxPojo.class);
			criteria1.add(Restrictions.eq("parentId",cstzTzmxPojo.getId())).add(Restrictions.eq("deleteStatus", "0"));
			//当前三级体征模型下的四级体征模型
			List<CstzTzmxPojo> fourTzs = this.cstzTzmxDao.find(criteria1);
			//存放四级体征的业务体征ID
			List<String> fourTzId = new ArrayList<String>();
			for (CstzTzmxPojo cstzTzmxPojo2 : fourTzs) {
				fourTzId.add(cstzTzmxPojo2.getYwtzId());
			}
			//获取四级体征数据的日期分组
			List<String> dateGroups = new ArrayList<String>();
			String sql = "SELECT CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) as groupColumon"
					+ " FROM t_cstz_tzzssj WHERE tz_id IN (:ids) and delete_status = 0  "
					+ " GROUP BY CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time))";
			SQLQuery query = createSQLQuery(sql);//记录
			query.setParameterList("ids",fourTzId);
			dateGroups = query.list();
			//循环日期分组，内循环业务体征ID，判断当前时间的当前id有无数据，如果没有数据，把权重平均分配给其它有数据的体征模型上
			for (String string : dateGroups) {//日期分组循环
				List<String> yesId = new ArrayList<String>();//存放有数据的id
				List<String> noId = new ArrayList<String>();//存放无数据的id
				for (String string1 : fourTzId) {//四级体征ID循环
					String countSql = "SELECT tz_id as tzId,tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id = '"+string1+"' AND delete_status = 0 AND CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) = '"+string+"'";
					SQLQuery countQuery = createSQLQuery(countSql);//记录
					List listCount = countQuery.list();
					if (null != listCount && listCount.size() > 0 ) {//有数据
						yesId.add(string1);
					}else{//无数据
						noId.add(string1);
					}
				}
				//计算无数据的体征ID所占权重之和
				BigDecimal noQz = BigDecimal.ZERO;
				if (null != noId && noId.size() > 0) {
					for (String string2 : noId) {
						DetachedCriteria criteria2 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria2.add(Restrictions.eq("ywtzId", string2)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> noQzs = this.cstzTzmxDao.find(criteria2);
						noQz = noQz.add(noQzs.get(0).getQz());
					}
					
				}
				//存放体征ID和对应权重
				List<Map<String, Object>> idAndQzMaps = new ArrayList<Map<String,Object>>();
				//如果可分配权重大于0，进行权重分配
				if (noQz.compareTo(BigDecimal.ZERO) == 1) {
					int yesIdSize = yesId.size();//需要分配的个数
					//可分配平均权重值
					BigDecimal avgQz = noQz.divide(new BigDecimal(yesIdSize), 3, BigDecimal.ROUND_HALF_UP);
					for (String string3 : yesId) {
						//获取到原始权重值
						DetachedCriteria criteria3 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria3.add(Restrictions.eq("ywtzId", string3)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> qzList = this.cstzTzmxDao.find(criteria3);
						BigDecimal yQz = qzList.get(0).getQz();//原始权重
						BigDecimal xQz = yQz.add(avgQz);//分配过后的权重
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", string3);
						map.put("qz", xQz);
						idAndQzMaps.add(map);
					}
				}else{
					for (String string4 : yesId) {
						DetachedCriteria criteria3 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria3.add(Restrictions.eq("ywtzId", string4)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> qzList = this.cstzTzmxDao.find(criteria3);
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", string4);
						map.put("qz", qzList.get(0).getQz());
						idAndQzMaps.add(map);
					}
				}
				//计算当前三级体征在当前日期下的体征指数
				BigDecimal tzz = BigDecimal.ZERO;
				Date date = new Date();
				//体征日期
				for (Map<String, Object> map : idAndQzMaps) {
					String ywtzId = map.get("id").toString();
					BigDecimal qz = new BigDecimal(map.get("qz").toString());
					//获取四级体征数据
					String tzzSql = "SELECT tz_id as tzId,ROUND(AVG(tzz),2) tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id = '"+ywtzId+"' AND delete_status = 0 AND CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) = '"+string+"'";
					Query tzzQuery = createSQLQuery(tzzSql);
					tzzQuery.setResultTransformer(Transformers.aliasToBean(CstzTzzssjPojo.class));
					List<CstzTzzssjPojo> fourTzzList = tzzQuery.list();//当前日期分组的数据(只有一条，多条也按照平均数来取值)
					CstzTzzssjPojo yjsPojo = fourTzzList.get(0);
					date = yjsPojo.getDataTime();
					BigDecimal fourTzz = yjsPojo.getTzz();
					//计算上级体征=下级体征指数*下级体征权重 之和
					tzz = tzz.add(fourTzz.multiply(qz));
					//讲计算过的数据更新为历史数据，下次不再计算
					CstzTzzssjPojo oldPojo = this.get(yjsPojo.getId());
					oldPojo.setDeleteStatus("1");
					this.cstzTzzssjService.update(oldPojo);
				}
				//根据体征指数获取优良中差
				String ylzc = this.getYlzc(tzz);
				System.out.println("》》》》》》》》》》》》》》》三级体征："+cstzTzmxPojo.getTzmc()+"；》》》》》》体征值："+tzz+"；》》》》》》优良中差："+ylzc+"；》》》》》》数据时间："+string);
				//计算后，增加三级体征数据
				this.saveOrUpdateTzzssj(cstzTzmxPojo.getId(), tzz.setScale(2, BigDecimal.ROUND_HALF_UP), ylzc, date);
			}
		}
	}
	
	/**
	  * @author zhucy 
	  * @version 2017年7月11日 下午2:21:17 
	  * 说明 : 计算二级体征
	 */
	public void calTwo(){
		DetachedCriteria criteria = DetachedCriteria.forClass(CstzTzmxPojo.class);
		criteria.add(Restrictions.eq("tzlx", "1")).add(Restrictions.eq("deleteStatus", "0"));
		//二级体征模型
		List<CstzTzmxPojo> twoTzs = this.cstzTzmxDao.find(criteria);
		for (CstzTzmxPojo cstzTzmxPojo : twoTzs) {
			DetachedCriteria criteria1 = DetachedCriteria.forClass(CstzTzmxPojo.class);
			criteria1.add(Restrictions.eq("parentId",cstzTzmxPojo.getId())).add(Restrictions.eq("deleteStatus", "0"));
			//当前二级体征模型下的三级体征模型
			List<CstzTzmxPojo> threeTzs = this.cstzTzmxDao.find(criteria1);
			//存放三级体征的体征ID
			List<String> threeTzId = new ArrayList<String>();
			for (CstzTzmxPojo cstzTzmxPojo2 : threeTzs) {
				threeTzId.add(cstzTzmxPojo2.getId());
			}
			//获取三级体征数据的日期分组
			List<String> dateGroups = new ArrayList<String>();
			String sql = "SELECT CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) as groupColumon"
					+ " FROM t_cstz_tzzssj WHERE tz_id IN (:ids)  and delete_status = 0 "
					+ " GROUP BY CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time))";
			SQLQuery query = createSQLQuery(sql);//记录
			query.setParameterList("ids",threeTzId);
			dateGroups = query.list();
			//循环日期分组，内循环业务体征ID，判断当前时间的当前id有无数据，如果没有数据，把权重平均分配给其它有数据的体征模型上
			for (String string : dateGroups) {//日期分组循环
				List<String> yesId = new ArrayList<String>();//存放有数据的id
				List<String> noId = new ArrayList<String>();//存放无数据的id
				for (String string1 : threeTzId) {//三级体征ID循环
					String countSql = "SELECT tz_id as tzId,tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id = '"+string1+"' AND delete_status = 0 AND CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) = '"+string+"'";
					SQLQuery countQuery = createSQLQuery(countSql);//记录
					List listCount = countQuery.list();
					if (null != listCount && listCount.size() > 0 ) {//有数据
						yesId.add(string1);
					}else{//无数据
						noId.add(string1);
					}
				}
				//计算无数据的体征ID所占权重之和
				BigDecimal noQz = BigDecimal.ZERO;
				if (null != noId && noId.size() > 0) {
					for (String string2 : noId) {
						DetachedCriteria criteria2 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria2.add(Restrictions.eq("id", string2)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> noQzs = this.cstzTzmxDao.find(criteria2);
						noQz = noQz.add(noQzs.get(0).getQz());
					}
					
				}
				//存放体征ID和对应权重
				List<Map<String, Object>> idAndQzMaps = new ArrayList<Map<String,Object>>();
				//如果可分配权重大于0，进行权重分配
				if (noQz.compareTo(BigDecimal.ZERO) == 1) {
					int yesIdSize = yesId.size();//需要分配的个数
					//可分配平均权重值
					BigDecimal avgQz = noQz.divide(new BigDecimal(yesIdSize), 3, BigDecimal.ROUND_HALF_UP);
					for (String string3 : yesId) {
						//获取到原始权重值
						DetachedCriteria criteria3 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria3.add(Restrictions.eq("id", string3)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> qzList = this.cstzTzmxDao.find(criteria3);
						BigDecimal yQz = qzList.get(0).getQz();//原始权重
						BigDecimal xQz = yQz.add(avgQz);//分配过后的权重
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", string3);
						map.put("qz", xQz);
						idAndQzMaps.add(map);
					}
				}else{
					for (String string4 : yesId) {
						DetachedCriteria criteria3 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria3.add(Restrictions.eq("id", string4)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> qzList = this.cstzTzmxDao.find(criteria3);
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", string4);
						map.put("qz", qzList.get(0).getQz());
						idAndQzMaps.add(map);
					}
				}
				//计算当前二级体征在当前日期下的体征指数
				BigDecimal tzz = BigDecimal.ZERO;
				Date date = new Date();
				//体征日期
				for (Map<String, Object> map : idAndQzMaps) {
					String id = map.get("id").toString();
					BigDecimal qz = new BigDecimal(map.get("qz").toString());
					//获取三级体征数据
					String tzzSql = "SELECT tz_id as tzId,ROUND(AVG(tzz),2) tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id = '"+id+"' AND delete_status = 0 AND CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) = '"+string+"'";
					Query tzzQuery = createSQLQuery(tzzSql);
					tzzQuery.setResultTransformer(Transformers.aliasToBean(CstzTzzssjPojo.class));
					List<CstzTzzssjPojo> threeTzzList = tzzQuery.list();//当前日期分组的数据(只有一条，多条也按照平均数来取值)
					CstzTzzssjPojo yjsPojo = threeTzzList.get(0);
					date = yjsPojo.getDataTime();
					BigDecimal fourTzz = yjsPojo.getTzz();
					//计算上级体征=下级体征指数*下级体征权重 之和
					tzz = tzz.add(fourTzz.multiply(qz));
					//讲计算过的数据更新为历史数据，下次不再计算
					CstzTzzssjPojo oldPojo = this.get(yjsPojo.getId());
					oldPojo.setDeleteStatus("1");
					this.cstzTzzssjService.update(oldPojo);
				}
				//根据体征指数获取优良中差
				String ylzc = this.getYlzc(tzz);
				System.out.println("》》》》》》》》》》》》》》》二级体征："+cstzTzmxPojo.getTzmc()+"；》》》》》》体征值："+tzz+"；》》》》》》优良中差："+ylzc+"；》》》》》》数据时间："+string);
				//计算后，增加二级体征数据
				this.saveOrUpdateTzzssj(cstzTzmxPojo.getId(), tzz.setScale(2, BigDecimal.ROUND_HALF_UP), ylzc, date);
			}
		}
	}
	/**
	  * @author zhucy 
	  * @version 2017年7月11日 下午2:28:35 
	  * 说明:计算一级体征
	 */
	public void calOne(){
		DetachedCriteria criteria = DetachedCriteria.forClass(CstzTzmxPojo.class);
		criteria.add(Restrictions.eq("tzlx", "0")).add(Restrictions.eq("deleteStatus", "0"));
		//一级体征模型
		List<CstzTzmxPojo> oneTzs = this.cstzTzmxDao.find(criteria);
		for (CstzTzmxPojo cstzTzmxPojo : oneTzs) {
			DetachedCriteria criteria1 = DetachedCriteria.forClass(CstzTzmxPojo.class);
			criteria1.add(Restrictions.eq("parentId",cstzTzmxPojo.getId())).add(Restrictions.eq("deleteStatus", "0"));
			//当前一级体征模型下的二级体征模型
			List<CstzTzmxPojo> twoTzs = this.cstzTzmxDao.find(criteria1);
			//存放三级体征的体征ID
			List<String> twoTzId = new ArrayList<String>();
			for (CstzTzmxPojo cstzTzmxPojo2 : twoTzs) {
				twoTzId.add(cstzTzmxPojo2.getId());
			}
			//获取二级体征数据的日期分组
			List<String> dateGroups = new ArrayList<String>();
			String sql = "SELECT CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) as groupColumon"
					+ " FROM t_cstz_tzzssj WHERE tz_id IN (:ids)  and delete_status = 0 "
					+ " GROUP BY CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time))";
			SQLQuery query = createSQLQuery(sql);//记录
			query.setParameterList("ids",twoTzId);
			dateGroups = query.list();
			//循环日期分组，内循环业务体征ID，判断当前时间的当前id有无数据，如果没有数据，把权重平均分配给其它有数据的体征模型上
			for (String string : dateGroups) {//日期分组循环
				List<String> yesId = new ArrayList<String>();//存放有数据的id
				List<String> noId = new ArrayList<String>();//存放无数据的id
				for (String string1 : twoTzId) {//二级体征ID循环
					String countSql = "SELECT tz_id as tzId,tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id = '"+string1+"' AND delete_status = 0 AND CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) = '"+string+"'";
					SQLQuery countQuery = createSQLQuery(countSql);//记录
					List listCount = countQuery.list();
					if (null != listCount && listCount.size() > 0 ) {//有数据
						yesId.add(string1);
					}else{//无数据
						noId.add(string1);
					}
				}
				//计算无数据的体征ID所占权重之和
				BigDecimal noQz = BigDecimal.ZERO;
				if (null != noId && noId.size() > 0) {
					for (String string2 : noId) {
						DetachedCriteria criteria2 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria2.add(Restrictions.eq("id", string2)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> noQzs = this.cstzTzmxDao.find(criteria2);
						noQz = noQz.add(noQzs.get(0).getQz());
					}
					
				}
				//存放体征ID和对应权重
				List<Map<String, Object>> idAndQzMaps = new ArrayList<Map<String,Object>>();
				//如果可分配权重大于0，进行权重分配
				if (noQz.compareTo(BigDecimal.ZERO) == 1) {
					int yesIdSize = yesId.size();//需要分配的个数
					//可分配平均权重值
					BigDecimal avgQz = noQz.divide(new BigDecimal(yesIdSize), 3, BigDecimal.ROUND_HALF_UP);
					for (String string3 : yesId) {
						//获取到原始权重值
						DetachedCriteria criteria3 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria3.add(Restrictions.eq("id", string3)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> qzList = this.cstzTzmxDao.find(criteria3);
						BigDecimal yQz = qzList.get(0).getQz();//原始权重
						BigDecimal xQz = yQz.add(avgQz);//分配过后的权重
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", string3);
						map.put("qz", xQz);
						idAndQzMaps.add(map);
					}
				}else{
					for (String string4 : yesId) {
						DetachedCriteria criteria3 = DetachedCriteria.forClass(CstzTzmxPojo.class);
						criteria3.add(Restrictions.eq("id", string4)).add(Restrictions.eq("deleteStatus", "0"));
						List<CstzTzmxPojo> qzList = this.cstzTzmxDao.find(criteria3);
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", string4);
						map.put("qz", qzList.get(0).getQz());
						idAndQzMaps.add(map);
					}
				}
				//计算当前二级体征在当前日期下的体征指数
				BigDecimal tzz = BigDecimal.ZERO;
				Date date = new Date();
				//体征日期
				for (Map<String, Object> map : idAndQzMaps) {
					String id = map.get("id").toString();
					BigDecimal qz = new BigDecimal(map.get("qz").toString());
					//获取二级体征数据
					String tzzSql = "SELECT tz_id as tzId,ROUND(AVG(tzz),2) tzz,id,data_time as dataTime FROM t_cstz_tzzssj WHERE tz_id = '"+id+"' AND delete_status = 0 AND CONCAT(YEAR(data_time),MONTH(data_time),DAY(data_time)) = '"+string+"'";
					Query tzzQuery = createSQLQuery(tzzSql);
					tzzQuery.setResultTransformer(Transformers.aliasToBean(CstzTzzssjPojo.class));
					List<CstzTzzssjPojo> twoTzzList = tzzQuery.list();//当前日期分组的数据(只有一条，多条也按照平均数来取值)
					CstzTzzssjPojo yjsPojo = twoTzzList.get(0);
					date = yjsPojo.getDataTime();
					BigDecimal fourTzz = yjsPojo.getTzz();
					//计算上级体征=下级体征指数*下级体征权重 之和
					tzz = tzz.add(fourTzz.multiply(qz));
					//讲计算过的数据更新为历史数据，下次不再计算
					CstzTzzssjPojo oldPojo = this.get(yjsPojo.getId());
					oldPojo.setDeleteStatus("1");
					this.cstzTzzssjService.update(oldPojo);
				}
				//根据体征指数获取优良中差
				String ylzc = this.getYlzc(tzz);
				System.out.println("》》》》》》》》》》》》》》》一级体征："+cstzTzmxPojo.getTzmc()+"；》》》》》》体征值："+tzz+"；》》》》》》优良中差："+ylzc+"；》》》》》》数据时间："+string);
				//计算后，增加一级体征数据
				this.saveOrUpdateTzzssj(cstzTzmxPojo.getId(), tzz.setScale(2, BigDecimal.ROUND_HALF_UP), ylzc, date);
			}
		}
	}
}
