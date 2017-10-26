package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.ServiceCategoryDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovernmentService;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.ServiceCategory;

/**
* Created with gender.
* @author: yuhaitao
* Date: 2017-04-01 11:36:04
*/
@Repository
public class ServiceCategoryDaoImpl extends BaseDaoImpl<ServiceCategory> implements ServiceCategoryDao {

	/**
	 * 获取行政审批事项数量
	 * 子项数量
	 */
	public List<Tourism> getEventCount(){
		try{
			String sql="SELECT count(*)as event,sum(zxs) as eventchild FROM `t_zwfw_sxfl` where sslb='行政审批事项'";
			Query query=createSQLQuery(sql);
			List<Tourism> result=query.list();
			return result;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 可在线办理的事项数量
	 */
	public List<Tourism> getOnlineCount(){
		try{
			String sql="SELECT count(*) as online FROM `t_zwfw_sxfl` where isonline=1";
			Query query=createSQLQuery(sql);
			List<Tourism> result=query.list();
			return result;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据所属单位获取各单位事项数及子项数
	 */
	public List<Tourism> getBureauOverview(String ssdw){
		try{
			String sql="SELECT count(*) as event,sum(zxs)as eventchild FROM `t_zwfw_sxfl` where ssdw='"+ssdw+"'";
			Query query=createSQLQuery(sql);
			List<Tourism> result=query.list();
			return result;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据所属单位获取各单位事项列表
	 */
	public List<ServiceCategory> getEventList(String ssdw){
		try{
			String sql="SELECT * FROM `t_zwfw_sxfl` where ssdw='"+ssdw+"'";
			Query query=createSQLQuery(sql);
			List<ServiceCategory> eventList=query.list();
			return eventList;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 获取所有的委办局名称
	 */
	public List<ServiceCategory> getAllBureau(){
		try{
			String sql="SELECT * FROM `t_zwfw_sxfl` GROUP BY ssdw";
			Query query=createSQLQuery(sql).addEntity(ServiceCategory.class);
			List<ServiceCategory> eventList=query.list();
			return eventList;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 遍历委办局名称，拼接json对象
	 */
	public JSONObject getAllData(){
		List<ServiceCategory> bureaus=this.getAllBureau();
		JSONObject jsonobj=new JSONObject();
		List<JSONObject> jsonobjList=new ArrayList<JSONObject>();
		
		for(ServiceCategory pojo:bureaus){
			//单个委办局对象【包含：委办局名称，委办局事项及事项数，委办局子项、及子项数】
			JSONObject eventjsonobj=new JSONObject();
			//委办局名称
			String ssdw=pojo.getSsdw();
			//事项子项结果集
			List<String> eventList=new ArrayList<String>();	
			eventList=getEventNum(ssdw);
			
			//构建toplist数组
			List<String> toplist=new ArrayList<String>();			
			toplist.add(ssdw);
			toplist.add("事项数");
			toplist.add(eventList.get(0).toString());
			toplist.add("子项");
			toplist.add(eventList.get(1).toString());			
			
			//构建事项名称结果集列表
			List<String> eventDetailList=new ArrayList<String>();	
			eventDetailList=getEventDetail(ssdw);
			//构建rowlist数组
			List<String> rowlist=new ArrayList<String>();			
			Iterator it=eventDetailList.iterator();
			while(it.hasNext()){
				rowlist.add(it.next().toString());
			}
			eventjsonobj.put("row", rowlist);
			eventjsonobj.put("top", toplist);
			jsonobjList.add(eventjsonobj);
		}
		jsonobj.put("data", jsonobjList);
		return jsonobj;
	}
	/*
	 * 根据委办局名称，获取事项数、子项数
	 */
	public List<String> getEventNum(String ssdw){
		try{
			String sql="SELECT RTRIM(t.`event`)as count from (SELECT ssdw,count(*) as event,sum(zxs)as eventchild FROM `t_zwfw_sxfl` group by ssdw)t"
					+" where t.ssdw='"+ssdw+"'"
					+" union all (SELECT RTRIM(t.eventchild) as count from (SELECT ssdw,count(*) as event,sum(zxs)as eventchild FROM `t_zwfw_sxfl` group by ssdw)t"
					+" where t.ssdw='"+ssdw+"')";
			Query query=createSQLQuery(sql);
			List<String> eventList=query.list();
			return eventList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 根据委办局名称，获取事项名称列表
	 */
	public List<String> getEventDetail(String ssdw){
		try{
			String sql="SELECT t1.sxmc from  (SELECT ssdw,sxmc FROM `t_zwfw_sxfl` t)t1 "
					+" where t1.ssdw='"+ssdw+"'";
			Query query=createSQLQuery(sql);
			List<String> eventList=query.list();
			return eventList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}