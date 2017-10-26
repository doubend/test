package com.cloud.icenter.yyzx.cszc.tjfx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.impl.SQLServiceImp;
import com.cloud.icenter.common.engine.cache.SQLContext;
import com.cloud.icenter.common.util.DataSource;
import com.cloud.icenter.common.util.JSONRowMapper;
import com.cloud.icenter.common.utils.RandomUtil;
import com.cloud.icenter.yyzx.cszc.security.pojo.QueryPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.EducationInfoService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 教育情况service 实现类
 * @date 2017年3月30日
 * @author dxliug
 */
@Service(value="educationInfoServiceImpl")
public class EducationInfoServiceImpl extends SQLServiceImp implements EducationInfoService {

	
   private List<Object> parameter;
	
	public List<Object> getParameter() {
		return parameter;
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Map<String, Object> getSingle(String sql) {
		Map<String, Object> map=jdbcTemplate.queryForMap(sql);
		return map;
	}

	@Override
	public List<Map<String, Object>> getList(String sql) {
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public List<JSONObject> getListPram(String sql, Object obj) {
		JSONObject jsonObject = SQLContext.get(sql, obj);
		Object[] pams = (Object[]) jsonObject.get("pams");
		setParameter(pams);
		return jdbcTemplate.query(sql, new JSONRowMapper(), this.getParameter().toArray());
	}
	
	
	
	
	/**
	 * 设置参数
	 * @param pams
	 */
	public void setParameter(Object... pams) {
		this.parameter = new ArrayList<Object>(0);
		for (Object object : pams) {
			if (object instanceof Object[]) {

				Object[] obejs = (Object[]) object;
				for (int i = 0; i < obejs.length; i++) {

					parameter.add(obejs[i]);
				}
			} else {
				parameter.add(object);
			}

		}

	
	}

	@Override
	public List<Map<String,Object>> findBaseListBySfz(QueryPojo pojo) {
		JSONObject jsonObject = SQLContext.get("queryTeaAndStu",pojo);
		Object[] pams = (Object[]) jsonObject.get("pams");//查询 的参数		 	
	    List<JSONObject> list = this.queryJsonToList(jsonObject.getString("sql"), pams);
	    List<Map<String, String>> res = Lists.newArrayList();
	    List<Map<String, Object>> rrr = Lists.newArrayList();
	    if(list ==null || list.size() == 0) return rrr;
	    LinkedHashMap<String, Map<String, String>> ms = Maps.newLinkedHashMap();
	    for(JSONObject obj:list){
	    	Map<String , String> mp = ms.containsKey(obj.getString("QY"))?ms.get(obj.getString("QY")):new TreeMap<String , String>();
	    	mp.put(obj.getString("XXLX")+"tea"+obj.getString("TJNF"), obj.getString("JZRYS"));
	    	mp.put(obj.getString("XXLX")+"stu"+obj.getString("TJNF"), obj.getString("ZXSRS"));
	    	mp.put("town",obj.getString("QY") );
	    	ms.put(obj.getString("QY"), mp);
	    }
	    for(Entry<String, Map<String, String>> entry : ms.entrySet()){
	      	  res.add(entry.getValue());
	     }
	    for(Map<String, String> map : res){
	    	Map<String,Object> mm = Maps.newHashMap();
	    	String town = map.get("town");
	    	int xxStu = map.get("02stu"+pojo.getNian())==null?0:Integer.parseInt(map.get("02stu"+pojo.getNian()));
	    	int xxtea = map.get("02tea"+pojo.getNian())==null?0:Integer.parseInt(map.get("02tea"+pojo.getNian()));
	    	int chStu =  map.get("03stu"+pojo.getNian())==null?0:Integer.parseInt(map.get("03stu"+pojo.getNian()));
	    	int chTea =  map.get("03tea"+pojo.getNian())==null?0:Integer.parseInt(map.get("03tea"+pojo.getNian()));
	    	int gzStu =  map.get("04stu"+pojo.getNian())==null?0:Integer.parseInt(map.get("04stu"+pojo.getNian()));
	    	int gzTea =  map.get("04tea"+pojo.getNian())==null?0:Integer.parseInt(map.get("04tea"+pojo.getNian())); 
	    	
	    	int bexxStu = map.get("02stu"+pojo.getBefNian())==null?0:Integer.parseInt(map.get("02stu"+pojo.getBefNian()));
	    	int bexxtea = map.get("02tea"+pojo.getBefNian())==null?0:Integer.parseInt(map.get("02tea"+pojo.getBefNian()));
	    	int bechStu =  map.get("03stu"+pojo.getBefNian())==null?0:Integer.parseInt(map.get("03stu"+pojo.getBefNian()));
	    	int bechTea =  map.get("03tea"+pojo.getBefNian())==null?0:Integer.parseInt(map.get("03tea"+pojo.getBefNian()));
	    	int begzStu =  map.get("04stu"+pojo.getBefNian())==null?0:Integer.parseInt(map.get("04stu"+pojo.getBefNian()));
	    	int begzTea =  map.get("04tea"+pojo.getBefNian())==null?0:Integer.parseInt(map.get("04tea"+pojo.getBefNian())); 
	    
	    	Object xxStuRaise = bexxStu==0 || xxStu==0?0.0:RandomUtil.getPercentage(xxStu-bexxStu,bexxStu);
	    	Object xxTeaRaise = bexxtea==0 || xxtea==0?0.0:RandomUtil.getPercentage(xxtea-bexxtea,bexxtea);
	    	
	    	Object czStuRaise = bechStu==0 || chStu==0?0.0:RandomUtil.getPercentage(chStu-bechStu,bechStu);
	    	Object czTeaRaise = bechTea==0 || chTea==0?0.0:RandomUtil.getPercentage(chTea-bechTea,bechTea);
	    	
	    	Object gzStuRaise = begzStu==0 || gzStu==0?0.0:RandomUtil.getPercentage(gzStu-begzStu,begzStu);
	    	Object gzTeaRaise = begzTea==0 || gzTea==0?0.0:RandomUtil.getPercentage(gzTea-begzTea,begzTea);
	    
	   
	    	mm.put("town", town);//区域
	    	mm.put("xxStu",xxStu);//小学学生
	    	mm.put("xxTea",xxtea);//小学老师
	    	mm.put("chStu",chStu);//初中学生
	    	mm.put("chTea",chTea);//初中老师
	    	mm.put("gzStu",gzStu);//高中学生
	    	mm.put("gzTea",gzTea);//高中老师
	    	mm.put("xxStuRaise",xxStuRaise);//小学学生增速
	    	mm.put("xxTeaRaise",xxTeaRaise);//小学老师增速
	    	mm.put("czStuRaise",czStuRaise);//初中学生增速
	    	mm.put("czTeaRaise",czTeaRaise);//初中老师增速
	    	mm.put("gzStuRaise",gzStuRaise);//高中学生增速
	    	mm.put("gzTeaRaise",gzTeaRaise);//高中老师增速
	    	rrr.add(mm);
	    }
		return rrr;
	}

	
	
	
	
	private List<JSONObject> sqlQuery(QueryPojo pojo, String sqlContext) {
		JSONObject jsonObject = SQLContext.get(sqlContext, pojo);
		Object[] pams = (Object[]) jsonObject.get("pams");
		List<JSONObject> obj = this.queryJsonToList(jsonObject.getString("sql"), pams);
		return obj;
	}
       /**
        * 查询教育机构与教师力量
        */
	@Override
	public List<Map<String, Object>> queryTeacherOffice(QueryPojo pojo,
			String string) {
		List<JSONObject> result = sqlQuery(pojo, string);
		List<Map<String, Object>> res = Lists.newArrayList();
		if(result ==null || result.size() == 0) return res;
		LinkedHashMap<String, Map<String, Object>> ms = Maps.newLinkedHashMap();
		
		   for(JSONObject obj:result){
			    String qy = obj.getString("QY");
	    		Map<String,Object> map = ms.containsKey(qy)? ms.get(qy):new HashMap<String,Object>();
                map.put("qy", qy);
                if("02".equals(obj.getString("XXLX"))){//小学
                	 if(obj.getString("JGSL") != null){//小学机构数量
                		 map.put("xjgsl", obj.getString("JGSL"));
                	 }
                	 if(obj.getString("JZRYS") != null){//小学老师数量
                		 map.put("xjzrys", obj.getString("JZRYS"));
                	 }
                	 if(obj.getString("ZXSRS") != null){//小学在校人数
                		 map.put("xzxsrs", obj.getString("ZXSRS"));
                	 }
                }
            	  if("03".equals(obj.getString("XXLX"))){//小学
                	 if(obj.getString("JGSL") != null){//小学机构数量
                		 map.put("cjgsl", obj.getString("JGSL"));
                	 }
                	 if(obj.getString("JZRYS") != null){//小学老师数量
                		 map.put("cjzrys", obj.getString("JZRYS"));
                	 }
                	 if(obj.getString("ZXSRS") != null){//小学在校人数
                		 map.put("czxsrs", obj.getString("ZXSRS"));
                	 }
            	  }
                	 if("04".equals(obj.getString("XXLX"))){//小学
                    	 if(obj.getString("JGSL") != null){//小学机构数量
                    		 map.put("gjgsl", obj.getString("JGSL"));
                    	 }
                    	 if(obj.getString("JZRYS") != null){//小学老师数量
                    		 map.put("gjzrys", obj.getString("JZRYS"));
                    	 }
                    	 if(obj.getString("ZXSRS") != null){//小学在校人数
                    		 map.put("gzxsrs", obj.getString("ZXSRS"));
                    	 }
                  }
                  ms.put(qy, map);
		         }
		          int office = 0; //机构
		          int teacher = 0; 
		          int student = 0;
		          
                  for(Entry<String, Map<String, Object>> entry : ms.entrySet()){
      	    		
                	  Map<String, Object> value = entry.getValue();
                	  office =Integer.parseInt((String)value.get("xjgsl")==null?"0":(String)value.get("xjgsl"))+Integer.parseInt((String)value.get("cjgsl")==null?"0":(String)value.get("cjgsl"))+
                			  Integer.parseInt((String) value.get("gjgsl") == null?"0":(String)value.get("gjgsl"));
                	  teacher =Integer.parseInt((String)value.get("xjzrys")==null?"0":(String)value.get("xjzrys"))+Integer.parseInt((String)value.get("cjzrys")==null?"0":(String)value.get("cjzrys"))+
                			  Integer.parseInt((String) value.get("gjzrys") == null?"0":(String)value.get("gjzrys"));
                	  student =Integer.parseInt((String)value.get("xzxsrs")==null?"0":(String)value.get("xzxsrs"))+Integer.parseInt((String)value.get("czxsrs")==null?"0":(String)value.get("czxsrs"))+
                			  Integer.parseInt((String) value.get("gzxsrs") == null?"0":(String)value.get("gzxsrs"));
                	  value.put("office", office);
                	  value.put("teacher", teacher);
                	  value.put("student", student);

      	    		res.add(entry.getValue());
      	    	}
      	     return res;
	  }
}