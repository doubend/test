package com.cloud.icenter.yyzx.cszc.tjfx.service.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.impl.SQLServiceImp;
import com.cloud.icenter.common.engine.cache.SQLContext;
import com.cloud.icenter.common.util.JSONRowMapper;
import com.cloud.icenter.yyzx.cszc.security.pojo.QueryPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.EmploymentInfoService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Transactional
@Service
public class EmploymentInfoServiceImpl extends SQLServiceImp implements
        EmploymentInfoService {

    @Autowired JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String, String>> getEmploymentByYear(String sql,QueryPojo pojo) {
        JSONObject jsonObject = SQLContext.get(sql, pojo);
        Object[] pams = (Object[])jsonObject.get("pams");
        List<JSONObject> queryJsonToList = this.queryJsonToList(jsonObject.getString("sql"), pams);
        
        List<Map<String , String>> res = Lists.newArrayList();
        if(queryJsonToList == null || queryJsonToList.size() == 0) return res;
        
        for(JSONObject obj : queryJsonToList){
            Map<String , String> map = Maps.newHashMap();
            String qy = obj.getString("QY");
            String num = obj.getString("RS");
            map.put("town", qy);
            map.put("num", num);
            res.add(map);
        }
        return res;
    }

    @Override
    public List<JSONObject> getListPram(String sql, Object obj) {
        JSONObject jsonObject = SQLContext.get(sql, obj);
        Object[] pams = (Object[]) jsonObject.get("pams");
        setParameter(pams);
        return jdbcTemplate.query(sql, new JSONRowMapper(), this.getParameter().toArray());
    }

    @Override
    public List<Map<String, String>> queryThreeIndustryByYear(String sql,
            QueryPojo pojo) {
        JSONObject jsonObject = SQLContext.get(sql, pojo);
        Object[] pams = (Object[])jsonObject.get("pams");
        List<JSONObject> queryJsonToList = this.queryJsonToList(jsonObject.getString("sql"), pams);
        
        List<Map<String , String>> res = Lists.newArrayList();
        if(queryJsonToList == null || queryJsonToList.size() == 0) return res;
        
        LinkedHashMap<String , Map<String , String>> info = Maps.newLinkedHashMap();
        String[] xb = {"0","1","2"};
        String[] xbVal = {"all","male","female"};
        String[] ind ={"0700","0701","0702","0703"};
        String[] indVal = {"totalIndustry","firstIndustry","secondIndustry","thirdIndustry"};
        String key = "";
        
        for (JSONObject obj : queryJsonToList) {
            String qy = obj.getString("QY");
            String ztfl = obj.getString("ZTFL");
            String num = obj.getString("RS");
            String sex = obj.getString("XB");
            
            Map<String , String> map =info.containsKey(qy)?info.get(qy):new HashMap<String , String>();
            boolean flag = false; 
            for (int i = 0; i < xb.length; i++) {
                if(xb[i].equals(sex)){
                    for (int j = 0; j < ind.length;j++) {
                        if(ind[j].equals(ztfl)){
                            key = indVal[j]+xbVal[i];
                            flag = true;
                            break;
                        }
                    }
                    if(flag)break;
                }
            }
            //String type = "0700".equals(ztfl)?"allEmployment":"0701".equals(ztfl)?"firstIndustry":"0702".equals(ztfl)?" secondIndustry":"thirdlyIndustry";
            //map.put("type", type);        
            map.put(key, num);
            info.put(qy, map);
        }
        for(Entry<String, Map<String, String>> entry : info.entrySet()){
            entry.getValue().put("town", entry.getKey());
            res.add(entry.getValue());
        }
        return res;
    }

    @Override
    public List<Map<String, String>> queryOnceEmployment(String sql,
            QueryPojo pojo) {
        JSONObject jsonObject = SQLContext.get(sql, pojo);
        Object[] pams = (Object[])jsonObject.get("pams");
        List<JSONObject> queryJsonToList = this.queryJsonToList(jsonObject.getString("sql"), pams);
        
        List<Map<String , String>> res = Lists.newArrayList();
        if(queryJsonToList == null || queryJsonToList.size() == 0) return res;
        
        for(JSONObject obj : queryJsonToList){
            String qy = obj.getString("QY");
            String ztfl = obj.getString("ZTFL");
            String num = obj.getString("RS");
            //villagelabour  农村劳动力转岗
            //laidoff 下岗再就业
            //retire 离退休再就业
            String key = "0704".equals(ztfl)?"villagelabour":"0705".equals(ztfl)?"laidoff":"retire";
            Map<String , String> map = Maps.newHashMap();
            map.put("town", qy);
            //map.put("type", key);
            map.put(key, num);
            res.add(map);
        }
        return res;
    }

    @Override
    public List<Map<String, String>> queryEdudegree(String sql, QueryPojo pojo) {
        JSONObject jsonObject = SQLContext.get(sql, pojo);
        Object[] pams = (Object[])jsonObject.get("pams");
        List<JSONObject> queryJsonToList = this.queryJsonToList(jsonObject.getString("sql"), pams);
        
        List<Map<String , String>> res = Lists.newArrayList();
        if(queryJsonToList == null || queryJsonToList.size() == 0) return res;
        
        Map<String , Map<String ,String>> ms = Maps.newHashMap();
        String[] ztfls ={"0701","0702","0703"};
        String[] ztflss ={"industry1","industry2","industry3"};
        String[] securitys = {"0810","0811","0812"};
        String[] securityss = {"security1","security2","security3"};
        String[] number = {"1","2","3"};
        String[] chanye = {"一产","二产","三产"};        
         for(JSONObject obj : queryJsonToList){
            String ztfl = obj.getString("ZTFL");
            String edu = obj.getString("edu");
            String num = obj.getString("total");
            String key = "";
            String security = "";
            
            for (int i = 0; i < ztfls.length; i++) {
                if(ztfls[i].equals(ztfl)) {
                    key = ztflss[i];break;
                }
                if(securitys[i].equals(ztfl)){
                    security = securityss[i];
                }
            }
            if(key.equalsIgnoreCase("")){
                String str = "industry"+security.substring(security.length()-1,security.length()); 
                Map<String ,String> map = ms.containsKey(str)?ms.get(str):new HashMap<String ,String>();
                map.put(security.substring(0,security.length()-1), num);
                ms.put(str,map);
            }else{
                Map<String ,String> map = ms.containsKey(key)?ms.get(key):new HashMap<String ,String>();
                map.put(edu, num);
                ms.put(key, map);
            }
        }
         Map<String, Map<String, String>> sortMapByKey = this.sortMapByKey(ms);
         for(Entry<String, Map<String, String>> entry:sortMapByKey.entrySet()){
             for(int i =0;i<number.length;i++){
                 if(number[i].equals(entry.getKey().substring(entry.getKey().length()-1, entry.getKey().length()))){
                     ms.get(entry.getKey()).put("industryType", chanye[i]);
                 }
             }
             res.add(entry.getValue());
         }
        return res;
    }

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public Map<String, Map<String, String>> sortMapByKey(Map<String, Map<String, String>> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, Map<String, String>> sortMap = new TreeMap<String, Map<String , String>>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }
}
class MapKeyComparator implements Comparator<String>{

    @Override
    public int compare(String str1, String str2) {
        
        return str1.compareTo(str2);
    }
}