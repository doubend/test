
package com.cloud.icenter.yyzx.fzjc.rkgx.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.fzjc.rkgx.dao.RenkJbxxDao;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.RenkJbxx;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.SerchParam;

/**
* Created with gender.
* @author: whcai
* Date: 2017-06-27 15:21:48
*/
@Repository
public class RenkJbxxDaoImpl extends BaseDaoImpl<RenkJbxx> implements RenkJbxxDao {

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 查询人口关系
	 */
	public Map<String, List<JSONObject>> getPopRelationBySfz(String sfz){
		try{
			Map<String, List<JSONObject>> resMap = new HashMap<String,List<JSONObject>>();
			
			//自己
			Date cur_csrq = format.parse("1983-11-29 00:00:00");
			String sql = "select xingming,sfzhm,xingbie,csrq from t_renk_base_jbxx where sfzhm='" + sfz + "'";
			Query query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			if(result != null && result.size() > 0){
				Map map = (Map)result.get(0);
				
				cur_csrq = format.parse(String.valueOf(map.get("csrq")));
			}
			
			//爷爷奶奶
			List<JSONObject> lstGrandpa = new ArrayList<JSONObject>();
			sql = "select fqxm,fqsfzhm,mqxm,mqsfzhm from t_renk_base_jbxx where sfzhm=(select fqsfzhm from t_renk_base_jbxx where sfzhm='" + sfz + "')";
			query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result5 = query.list();
			if(result5 != null && result5.size() > 0){
				Map map = (Map)result5.get(0);
				
				//爷爷
				if(!StringUtil.isEmpty(String.valueOf(map.get("fqxm")))){
					JSONObject grandpa = new JSONObject();
					grandpa.put("name", String.valueOf(map.get("fqxm")));
					grandpa.put("sfz", String.valueOf(map.get("fqsfzhm")));
					grandpa.put("xb", "男");
					grandpa.put("relation", "爷爷");
					lstGrandpa.add(grandpa);
				}
				
				//奶奶
				if(!StringUtil.isEmpty(String.valueOf(map.get("mqxm")))){
					JSONObject grandma = new JSONObject();
					grandma.put("name", String.valueOf(map.get("mqxm")));
					grandma.put("sfz", String.valueOf(map.get("mqsfzhm")));
					grandma.put("xb", "女");
					grandma.put("relation", "奶奶");
					lstGrandpa.add(grandma);
				}
			}
			//resMap.put("grandpa", lstGrandpa);
			
			//外公外婆
			List<JSONObject> lstGrandfather = new ArrayList<JSONObject>();
			sql = "select fqxm,fqsfzhm,mqxm,mqsfzhm from t_renk_base_jbxx where sfzhm=(select mqsfzhm from t_renk_base_jbxx where sfzhm='" + sfz + "')";
			query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result6 = query.list();
			if(result6 != null && result6.size() > 0){
				Map map = (Map)result6.get(0);
				
				//外公
				if(!StringUtil.isEmpty(String.valueOf(map.get("fqxm")))){
					JSONObject grandfather = new JSONObject();
					grandfather.put("name", String.valueOf(map.get("fqxm")));
					grandfather.put("sfz", String.valueOf(map.get("fqsfzhm")));
					grandfather.put("xb", "男");
					grandfather.put("relation", "外公");
					lstGrandfather.add(grandfather);
				}
				
				//外婆
				if(!StringUtil.isEmpty(String.valueOf(map.get("mqxm")))){		
					JSONObject grandmother = new JSONObject();
					grandmother.put("name", String.valueOf(map.get("mqxm")));
					grandmother.put("sfz", String.valueOf(map.get("mqsfzhm")));
					grandmother.put("xb", "女");
					grandmother.put("relation", "外婆");
					lstGrandfather.add(grandmother);
				}
			}
			//resMap.put("grandfather", lstGrandfather);
			
			//父母
			List<JSONObject> lstParents = new ArrayList<JSONObject>();
			sql = "select fqxm,fqsfzhm,mqxm,mqsfzhm from t_renk_base_jbxx where sfzhm ='" + sfz + "'";
			query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result1 = query.list();
			if(result1 != null && result1.size() > 0){
				Map map = (Map)result1.get(0);
				
				//父亲
				if(!StringUtil.isEmpty(String.valueOf(map.get("fqxm")))){
					JSONObject father = new JSONObject();
					father.put("name", String.valueOf(map.get("fqxm")));
					father.put("sfz", String.valueOf(map.get("fqsfzhm")));
					father.put("xb", "男");
					father.put("relation", "父亲");
					father.put("other", lstGrandpa);  //爷爷奶奶
					lstParents.add(father);
				}
				
				//母亲
				if(!StringUtil.isEmpty(String.valueOf(map.get("mqxm")))){
					JSONObject mother = new JSONObject();
					mother.put("name", String.valueOf(map.get("mqxm")));
					mother.put("sfz", String.valueOf(map.get("mqsfzhm")));
					mother.put("xb", "女");
					mother.put("relation", "母亲");
					mother.put("other", lstGrandfather); //外公外婆
					lstParents.add(mother);
				}
			}
			resMap.put("parents", lstParents);

			//子女
			List<JSONObject> lstChildren = new ArrayList<JSONObject>();
			sql = "select xingming,sfzhm,xingbie from t_renk_base_jbxx where fqsfzhm='" + sfz + "' or mqsfzhm='" + sfz + "'";
			query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result2 = query.list();
			if(result2 != null){
				for(int j = 0;j < result2.size(); j++){
					Map map = (Map)result2.get(j);
					
					JSONObject children = new JSONObject();
					children.put("name", String.valueOf(map.get("xingming")));
					String cur_sfz = String.valueOf(map.get("sfzhm"));
					children.put("sfz", cur_sfz);
					String xb = String.valueOf(map.get("xingbie"));
					if("男".equals(xb)){
						children.put("xb", xb);
						children.put("relation", "儿子");
						
						//孙子孙女
						List<JSONObject> lstGrandson = new ArrayList<JSONObject>();
						sql = "select xingming,sfzhm,xingbie from t_renk_base_jbxx where fqsfzhm='" + cur_sfz + "'";
						query=createSQLQuery(sql);
						query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
						List result7 = query.list();
						if(result7 != null){
							for(int k = 0;k < result7.size(); k++){
								Map mapItem = (Map)result7.get(k);
								
								JSONObject grandson = new JSONObject();
								grandson.put("name", String.valueOf(mapItem.get("xingming")));
								grandson.put("sfz", String.valueOf(mapItem.get("sfzhm")));
								String xingbie = String.valueOf(mapItem.get("xingbie"));
								grandson.put("xb", xingbie);
								grandson.put("relation", "男".equals(xingbie)?"孙子":"孙女");
								lstGrandson.add(grandson);
							}
						}
						children.put("other", lstGrandson);  //孙子孙女
						lstChildren.add(children);
					}else{
						children.put("xb", xb);
						children.put("relation", "女儿");
						
						//外孙、外孙女
						List<JSONObject> lstGrandchildren = new ArrayList<JSONObject>();
						sql = "select xingming,sfzhm,xingbie from t_renk_base_jbxx where mqsfzhm='" + cur_sfz + "'";
						query=createSQLQuery(sql);
						query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
						List result8 = query.list();
						if(result8 != null){
							for(int p = 0;p < result8.size(); p++){
								Map mapItem = (Map)result8.get(p);
								
								JSONObject grandchildren = new JSONObject();
								grandchildren.put("name", String.valueOf(mapItem.get("xingming")));
								grandchildren.put("sfz", String.valueOf(mapItem.get("sfzhm")));
								String xingbie = String.valueOf(mapItem.get("xingbie"));
								grandchildren.put("xb", xingbie);
								grandchildren.put("relation", "男".equals(xingbie)?"外孙":"外孙女");
								lstGrandchildren.add(grandchildren);
							}
						}	
						children.put("other", lstGrandchildren);  //外孙、外孙女
						lstChildren.add(children);
					}	
				}
			}
			resMap.put("children", lstChildren);
			
			//配偶
			List<JSONObject> lstSpouse = new ArrayList<JSONObject>();
			sql = "select nfxm,nfsfzhm,nfcsrq,nvfxm,nvfsfzhm,nvcsrq from t_renk_hyzk where nfsfzhm='" + sfz + "' or nvfsfzhm='" + sfz + "'";
			query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result3 = query.list();
			if(result3 != null && result3.size() > 0){
				Map map = (Map)result3.get(0);
				
				if(!StringUtil.isEmpty(String.valueOf(map.get("nfxm"))) && !StringUtil.isEmpty(String.valueOf(map.get("nvfxm")))){
					JSONObject spouse = new JSONObject();
					String nfSfz = String.valueOf(map.get("nfsfzhm"));
					if(sfz.equalsIgnoreCase(nfSfz)){
						String nvSfz = String.valueOf(map.get("nvfsfzhm"));
						Date nvCsrq = format.parse(String.valueOf(map.get("nvcsrq")));
						spouse.put("name", String.valueOf(map.get("nvfxm")));
						spouse.put("sfz", nvSfz);
						spouse.put("xb", "女");
						spouse.put("relation", "妻子");
						
						List<JSONObject> lstOther = new ArrayList<JSONObject>();
						//岳父岳母
						sql = "select fqxm,fqsfzhm,mqxm,mqsfzhm from t_renk_base_jbxx where sfzhm='" + nvSfz + "'";
						query=createSQLQuery(sql);
						query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
						List result9 = query.list();
						if(result9 != null && result9.size() > 0){
							Map map9 = (Map)result9.get(0);
							
							//岳父
							if(!StringUtil.isEmpty(String.valueOf(map9.get("fqxm")))){
								JSONObject father = new JSONObject();
								father.put("name", String.valueOf(map9.get("fqxm")));
								father.put("sfz", String.valueOf(map9.get("fqsfzhm")));
								father.put("xb", "男");
								father.put("relation", "岳父");
								lstOther.add(father);
							}
							
							//岳母
							if(!StringUtil.isEmpty(String.valueOf(map9.get("mqxm")))){
								JSONObject mother = new JSONObject();
								mother.put("name", String.valueOf(map9.get("mqxm")));
								mother.put("sfz", String.valueOf(map9.get("mqsfzhm")));
								mother.put("xb", "女");
								mother.put("relation", "岳母");
								lstOther.add(mother);
							}
						}
						
						//大舅子小舅子大姨子小姨子（老婆的兄弟姐妹）
						sql = "select xingming,sfzhm,xingbie,csrq from t_renk_base_jbxx where fqsfzhm=(select fqsfzhm from t_renk_base_jbxx where sfzhm='" + nvSfz + "' and fqsfzhm <> '') and sfzhm != '" + nvSfz + "'";
						query=createSQLQuery(sql);
						query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
						List result10 = query.list();
						if(result10 != null){
							for(int i = 0;i < result10.size(); i++){
								Map map10 = (Map)result10.get(i);
								
								JSONObject obj = new JSONObject();
								obj.put("name", String.valueOf(map10.get("xingming")));
								obj.put("sfz", String.valueOf(map10.get("sfzhm")));
								String xb = String.valueOf(map10.get("xingbie"));
								obj.put("xb", xb);
								
								Date csrq = format.parse(String.valueOf(map10.get("csrq")));
								if("男".equals(xb)){
									if(nvCsrq.getTime() > csrq.getTime()){
										obj.put("relation", "大舅子");
									}else{
										obj.put("relation", "小舅子");
									}
								}else{
									if(nvCsrq.getTime() > csrq.getTime()){
										obj.put("relation", "大姨子");
									}else{
										obj.put("relation", "小姨子");
									}
								}

								lstOther.add(obj);
							}
						}
						
						spouse.put("other", lstOther);  //岳父岳母、大舅子小舅子大姨子小姨子
						lstSpouse.add(spouse);
					}else{
						Date nanCsrq = format.parse(String.valueOf(map.get("nvcsrq")));
						spouse.put("name", String.valueOf(map.get("nfxm")));
						spouse.put("sfz", nfSfz);
						spouse.put("xb", "男");
						spouse.put("relation", "丈夫");
						
						List<JSONObject> lstOther = new ArrayList<JSONObject>();
						//公公婆婆
						sql = "select fqxm,fqsfzhm,mqxm,mqsfzhm from t_renk_base_jbxx where sfzhm ='" + nfSfz + "'";
						query=createSQLQuery(sql);
						query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
						List result11 = query.list();
						if(result11 != null && result11.size() > 0){
							Map map11 = (Map)result11.get(0);
							
							//公公
							if(!StringUtil.isEmpty(String.valueOf(map11.get("fqxm")))){
								JSONObject father = new JSONObject();
								father.put("name", String.valueOf(map11.get("fqxm")));
								father.put("sfz", String.valueOf(map11.get("fqsfzhm")));
								father.put("xb", "男");
								father.put("relation", "公公");
								lstOther.add(father);
							}
							
							//婆婆
							if(!StringUtil.isEmpty(String.valueOf(map11.get("mqxm")))){
								JSONObject mother = new JSONObject();
								mother.put("name", String.valueOf(map11.get("mqxm")));
								mother.put("sfz", String.valueOf(map11.get("mqsfzhm")));
								mother.put("xb", "女");
								mother.put("relation", "婆婆");
								lstOther.add(mother);
							}
						}
						
						//大伯小叔大姑小姑（老公的兄弟姐妹）
						sql = "select xingming,sfzhm,xingbie,csrq from t_renk_base_jbxx where fqsfzhm=(select fqsfzhm from t_renk_base_jbxx where sfzhm='" + nfSfz + "' and fqsfzhm <> '') and sfzhm != '" + nfSfz + "'";
						query=createSQLQuery(sql);
						query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
						List result12 = query.list();
						if(result12 != null){
							for(int i = 0;i < result12.size(); i++){
								Map map12 = (Map)result12.get(i);
								
								JSONObject obj = new JSONObject();
								obj.put("name", String.valueOf(map12.get("xingming")));
								obj.put("sfz", String.valueOf(map12.get("sfzhm")));
								String xb = String.valueOf(map12.get("xingbie"));
								obj.put("xb", xb);
								
								Date csrq = format.parse(String.valueOf(map12.get("csrq")));
								if("男".equals(xb)){
									if(nanCsrq.getTime() > csrq.getTime()){
										obj.put("relation", "大伯");
									}else{
										obj.put("relation", "小叔");
									}
								}else{
									if(nanCsrq.getTime() > csrq.getTime()){
										obj.put("relation", "大姑");
									}else{
										obj.put("relation", "小姑");
									}
								}

								lstOther.add(obj);
							}
						}
						
						spouse.put("other", lstOther);  //公公婆婆、大伯小叔大姑小姑
						lstSpouse.add(spouse);
					}
				}
			}
			resMap.put("spouse", lstSpouse);
			
			//兄弟姐妹
			List<JSONObject> lstSiblings = new ArrayList<JSONObject>();
			sql = "select xingming,sfzhm,xingbie,csrq from t_renk_base_jbxx where fqsfzhm=(select fqsfzhm from t_renk_base_jbxx where sfzhm='" + sfz + "' and fqsfzhm <> '') and sfzhm != '" + sfz + "'";
			query=createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result4 = query.list();
			if(result4 != null){
				for(int i = 0;i < result4.size(); i++){
					Map map = (Map)result4.get(i);
					
					JSONObject obj = new JSONObject();
					obj.put("name", String.valueOf(map.get("xingming")));
					obj.put("sfz", String.valueOf(map.get("sfzhm")));
					String xb = String.valueOf(map.get("xingbie"));
					obj.put("xb", xb);
					
					Date csrq = format.parse(String.valueOf(map.get("csrq")));
					if("男".equals(xb)){
						if(cur_csrq.getTime() > csrq.getTime()){
							obj.put("relation", "哥哥");
						}else{
							obj.put("relation", "弟弟");
						}
					}else{
						if(cur_csrq.getTime() > csrq.getTime()){
							obj.put("relation", "姐姐");
						}else{
							obj.put("relation", "妹妹");
						}
					}

					lstSiblings.add(obj);
				}
			}
			resMap.put("siblings", lstSiblings);
				
			return resMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询个人基本信息
	 * @return
	 */
	public JSONObject getPopBasicInfoBySfz(String sfz){
		try{
			JSONObject popObj = new JSONObject();
			String sql = "select a.xingming,a.sfzhm,replace(a.sfzhm,SUBSTR(a.sfzhm,13,4),'****') as sfz,a.xingbie,a.minzu,a.guoji,a.jzdxzqhmc,a.xxdz,a.csdxzqhmc,date_format(a.csrq,'%Y-%m-%d') as csrq,a.swzt,a.mqxm,a.mqgj,a.mqmz,a.fqxm,a.fqgj,a.fqmz,b.jhzbh from t_renk_base_jbxx a left join t_renk_hyzk b on a.sfzhm=b.nfsfzhm or a.sfzhm=b.nvfsfzhm where a.sfzhm='" + sfz + "'";
			Query query = createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			List result = query.list();
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(result != null && result.size() > 0){
				Map map = (Map)result.get(0);
				
				popObj.put("name", String.valueOf(map.get("xingming")));
				popObj.put("sfzhm", String.valueOf(map.get("sfzhm")));
				popObj.put("sfz", String.valueOf(map.get("sfz")));
				popObj.put("xb", String.valueOf(map.get("xingbie")));
				popObj.put("mz", String.valueOf(map.get("minzu")));
				popObj.put("gj", String.valueOf(map.get("guoji")));
				popObj.put("ssqx", String.valueOf(map.get("jzdxzqhmc")));
				popObj.put("xjzd", String.valueOf(map.get("xxdz")));
				popObj.put("csd", String.valueOf(map.get("csdxzqhmc")));
				popObj.put("csrq", String.valueOf(map.get("csrq")));
				String swzt = String.valueOf(map.get("swzt"));
				popObj.put("swzt", "0".equals(swzt)?"在世":"死亡");
				String jhzbh = String.valueOf(map.get("jhzbh"));
				popObj.put("hyzk", StringUtil.isEmpty(jhzbh)?"未婚":"已婚");
				popObj.put("fqxm", String.valueOf(map.get("fqxm")));
				popObj.put("fqgj", String.valueOf(map.get("fqgj")));
				popObj.put("fqmz", String.valueOf(map.get("fqmz")));
				popObj.put("mqxm", String.valueOf(map.get("mqxm")));
				popObj.put("mqgj", String.valueOf(map.get("mqgj")));
				popObj.put("mqmz", String.valueOf(map.get("mqmz")));
			}
			
			return popObj;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询人口信息
	 * @param param
	 * @return
	 */
	public Map<String,Object> queryByCondition(SerchParam param, PagingUtil pagingUtil){
		try{
			String sql = "select xingming,sfzhm,replace(sfzhm,SUBSTR(sfzhm,13,4),'****') as sfz,xingbie,jzdxzqhmc from t_renk_base_jbxx where 1=1";
			if(!StringUtil.isEmpty(param.getName())){
				sql += " and xingming like '%" + param.getName() + "%'";
			}
			if(!StringUtil.isEmpty(param.getSfz())){
				sql += " and sfzhm='" + param.getSfz() + "'";
			}
			if(!StringUtil.isEmpty(param.getQxdm())){
				sql += " and jzdxzqhbm='" + param.getQxdm() + "'";
			}
			if(!StringUtil.isEmpty(param.getXb())){
				sql += " and xingbie='" + param.getXb() + "'";
			}
			if(!StringUtil.isEmpty(param.getMz())){
				if("其他".equals(param.getMz())){
					sql += " and minzu not in('汉','回') ";
				}else{
					sql += " and minzu='" + param.getMz() + "'";
				}
			}
			if(!StringUtil.isEmpty(param.getKssj()) && !StringUtil.isEmpty(param.getJssj())){
				sql += " and csrq between :kssj and :jssj";
			}
			
			SQLQuery query = createSQLQuery(sql);
			SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");  //总记录数
			
			if(!StringUtil.isEmpty(param.getKssj()) && !StringUtil.isEmpty(param.getJssj())){
	        	Date ksDate = format.parse(param.getKssj());
	        	Date jsDate = format.parse(param.getJssj());
				query.setDate("kssj", ksDate);
				query.setDate("jssj", jsDate);
				querySize.setDate("kssj", ksDate);
				querySize.setDate("jssj", jsDate);
			}
			
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			query.setFirstResult(pagingUtil.getPageStart());
			query.setMaxResults(pagingUtil.getRows());
			List result = query.list();
			Map<String,Object> map = new HashMap<String,Object>();
			if(result != null && result.size() > 0){
				map.put("total", querySize.list().get(0));
				map.put("rows", result);
			}
			
			return map;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
     /**
      * 查询第一条数据
      */
	@Override
	public JSONObject queryFristRow() {
		JSONObject popObj = new JSONObject();
		String sql = "select sfzhm from t_renk_base_jbxx LIMIT 1";
		Query query = createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		List result = query.list();
		if(result != null && result.size() > 0){
			Map map = (Map)result.get(0);
			popObj.put("sfzhm", String.valueOf(map.get("sfzhm")));
		}
		return popObj;
	}
}