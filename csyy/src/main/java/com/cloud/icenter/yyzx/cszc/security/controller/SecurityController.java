package com.cloud.icenter.yyzx.cszc.security.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.yyzx.cszc.security.pojo.QueryPojo;
import com.cloud.icenter.yyzx.cszc.security.service.SecurityService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 社保情况controller
 * @date 2017年3月14日
 * @author dxliug
 */
@Controller
@RequestMapping(value="/security")
public class SecurityController {

	 private static final Logger logger = Logger.getLogger(SecurityController.class);
	 @Autowired
	 private SecurityService service;
	 
	 @RequestMapping(value="/toList")
	 public String toList(){
		 
		 return "/cszc/statistics/security";
	 }
	 /**
	  * 查询人口养老情况表
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value="/queryTable")
	 public String queryTable(QueryPojo pojo){
		 List<Map> list;
		 List<Map<String, Object>> res;
		  try {
		
				List<JSONObject> list2 = service.findBaseListBySfz(pojo, "queryAmount");
				List<JSONObject> list1 = service.findBaseListBySfz(pojo, "queryPeople");
			
				res = Lists.newArrayList();
				
				LinkedHashMap<String, Map<String, Object>> ms = Maps.newLinkedHashMap();
				if(list1 != null && list1.size() != 0){
				for(JSONObject obj :list1){
					String jmyl = null;String qyyl = null;String jgdwyl=null;
					String qy = obj.getString("QY");
					if("0807".equals(obj.getString("ZTFL"))){
						jmyl = obj.getString("RS");//居民养老
					}
					if("0808".equals(obj.getString("ZTFL"))){
						qyyl = obj.getString("RS");//企业养老
					}
					if("0809".equals(obj.getString("ZTFL"))){
						jgdwyl = obj.getString("RS");//机关单位养老
					}
		    		Map<String,Object> map = ms.containsKey(qy)? ms.get(qy):new HashMap<String,Object>();
                    map.put("qy", qy);
                    if(jmyl != null){
                    	map.put("jmyl", jmyl);
                    }
                    if(qyyl != null){
                    	map.put("qyyl", qyyl);
                    } if(jgdwyl != null){
                    	map.put("jgdwyl", jgdwyl);
                    }
                    ms.put(qy, map);
				 }
				}
				if(list2 != null && list2.size() != 0){
				for(JSONObject obj2 :list2){
					String jmylAm = null;
					String qyylAm = null;
					String jgdwylAm = null;
					String qy = obj2.getString("QY");
					if("03".equals(obj2.getString("SBJJLX"))){
						jmylAm = obj2.getString("BXJNJE");
					}
					if("04".equals(obj2.getString("SBJJLX"))){
						qyylAm = obj2.getString("BXJNJE");
					}
					if("05".equals(obj2.getString("SBJJLX"))){
						jgdwylAm = obj2.getString("BXJNJE");
					}
					Map<String,Object> map = ms.containsKey(qy)? ms.get(qy):new HashMap<String,Object>();
                    map.put("qy", qy);
                    if(jmylAm != null){
                    	map.put("jmylAm", jmylAm);
                    }
                    if(qyylAm != null){
                    	map.put("qyylAm", qyylAm);
                    }
                    if(jgdwylAm != null){
                    	map.put("jgdwylAm", jgdwylAm);
                    }
                    ms.put(qy, map);
				 }
				}
				String[] areas = {"桓台县","城区","索镇","起凤镇","田庄镇","荆家镇","马桥镇","新城镇","唐山镇","果里镇"};
				for(int i=0;i<areas.length;i++){
					Map<String,Object> map  = new HashMap<String,Object>();
					if(ms.containsKey(areas[i]) == false){
						map.put("jmyl", 0);
						map.put("qyyl", 0);
						map.put("jgdwyl", 0);
						map.put("jmylAm", 0);
						map.put("qyylAm", 0);
						map.put("jgdwylAm", 0);
						map.put("qy", areas[i]);
						ms.put(areas[i], map);
					}
				}
				for(Entry<String, Map<String, Object>> entry : ms.entrySet()){
					
		    		res.add(entry.getValue());
		    	}
		} catch (Exception e) {
           logger.info("查询人口养老情况失败"+e.getMessage());
           throw e;
		}	 
		  return JSON.toJSONString(res);
	 }
	 
	
	 /**
	  * 地图展示,鼠标悬浮展示每个地区的参保人数
	  * @param entity
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value="/queryMap")
	 public String queryMap(QueryPojo entity){
		 List<Map<String, Object>> res;
		 try {
			    List<JSONObject> result = service.findBaseListBySfz(entity, "queryMap");
				res = new ArrayList<Map<String, Object>>();
				LinkedHashMap<String, Map<String, Object>> ms = Maps.newLinkedHashMap();
				if(result == null || result.size() == 0) return JSON.toJSONString(res); 
				for(JSONObject obj:result){
					String sybx = null;
					String jbylbx = null;
					String shhyl = null;
					String ylbx = null;
					String syebx = null;
					String gsbx = null;
					
 					String qy = obj.getString("QY");
					 if(obj.getString("ZTFL").equals("0806")){
						   sybx =obj.getString("RS");
					    }if(obj.getString("ZTFL").equals("0801")){
					    	jbylbx = obj.getString("RS");
						}if(obj.getString("ZTFL").equals("0802")){
							shhyl=obj.getString("RS");
						}if(obj.getString("ZTFL").equals("0803")){//有歧义
							ylbx=obj.getString("RS");
						}if(obj.getString("ZTFL").equals("0804")){
							syebx=obj.getString("RS");
						}if(obj.getString("ZTFL").equals("0805")){
							gsbx=obj.getString("RS");
						}
			      Map<String,Object> map = ms.containsKey(qy)? ms.get(qy):new HashMap<String,Object>();
                  map.put("qy", qy);
                  if(sybx != null){
                	  map.put("sybx", sybx);
                  } if(jbylbx != null){
                	  map.put("jbylbx", jbylbx);
                  } if(shhyl != null){
                	  map.put("shhyl", shhyl);
                  } if(ylbx != null ){
                	  map.put("ylbx", ylbx);
                  } if(syebx != null ){
                	  map.put("syebx", syebx);
                  } if(gsbx != null ){
                	  map.put("gsbx", gsbx);
                  }
					ms.put(qy, map);
				}
                  /**
                   * 遍历获取所有的参保人数
                   */
				
				String[] areas = {"桓台县","城区","索镇","起凤镇","田庄镇","荆家镇","马桥镇","新城镇","唐山镇","果里镇"};
				for(int i=0;i<areas.length;i++){
					Map<String,Object> map  = new HashMap<String,Object>();
					if(ms.containsKey(areas[i]) == false){
						map.put("sybx", "0");
						map.put("jbylbx", "0");
						map.put("shhyl", "0");
						map.put("ylbx", "0");
						map.put("syebx", "0");
						map.put("gsbx", "0");
						map.put("qy", areas[i]);
						ms.put(areas[i], map);
					}
				}
				int count = 0;
				for(Entry<String, Map<String, Object>> entry : ms.entrySet()){
					Map<String, Object> value = entry.getValue();
					Object sybx = value.get("sybx");
					Object gsbx = value.get("gsbx");
					Object shhyl = value.get("shhyl");
					Object ylbx = value.get("ylbx");
					Object jbylbx = value.get("jbylbx");
					Object syebx = value.get("syebx");
					count = Integer.parseInt((String)sybx == null?"0":(String)sybx)+Integer.parseInt((String)gsbx == null?"0":(String)gsbx)+
							Integer.parseInt((String)shhyl == null?"0":(String)shhyl)+Integer.parseInt((String)ylbx == null?"0":(String)ylbx)+
							Integer.parseInt((String)jbylbx == null?"0":(String)jbylbx)+Integer.parseInt((String)syebx == null?"0":(String)syebx);
					value.put("canbaors", count);
		    		res.add(entry.getValue());
		    	}
		} catch (Exception e) {
			logger.info("查询社保情况失败"+e.getMessage());
			throw e;
       }
		 return JSON.toJSONString(res);
	 }
}
