package com.cloud.icenter.common.engine.cache;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.common.engine.command.GroupCommand;
import com.cloud.icenter.common.engine.command.IfCommand;
import com.cloud.icenter.common.engine.command.OrderCommand;
import com.cloud.icenter.common.engine.command.SetCommand;
import com.cloud.icenter.common.engine.command.TrimCommand;
import com.cloud.icenter.common.engine.command.WhereCommand;
import com.cloud.icenter.common.engine.core.JavaScript;
import com.cloud.icenter.common.engine.tag.InsertTag;
import com.cloud.icenter.common.engine.tag.SelectTag;
import com.cloud.icenter.common.engine.tag.UpdateTag;
import com.cloud.icenter.common.engine.tag.commTag;
import com.cloud.icenter.common.engine.util.SQLBuilder;

/**
 * 
 * <p>Title:SQLContext</p>
 * <p>Description: SQL上下文     </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月12日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
public class SQLContext {
	private static Logger logger = Logger.getLogger(SQLContext.class);
	
	private final static String SQL="sql";
	private final static String PAMS="pams";

/**
 * 	根据sqlXml 配置文件
 *  对应sql 的key 获取
 *  动态生成的SQL 以及 
 *  对应别名的参数 数组
 *    
 * @param key  sql 对应的key
 * @param pams  参数对象
 * @return JSONObject   json.getString("sql")  json.get("pams") 参数数组
 * @throws Exception
 */
public static synchronized JSONObject get(String key,Object pams){	
	long stat = System.currentTimeMillis();
	JSONObject json=null;
	try {
		json=EngineContext.get(key);
	json = buliSQL(buliSQL(json, pams,false),pams,json.getString("type"));
	long end = System.currentTimeMillis();
	logger.info("[key="+key+"]SQL引擎解析模板生成脚本:"+json.getString("sql")+"[总共消耗" + String.valueOf(end - stat) + "毫秒]");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		logger.error(e.getMessage(), e);
	}
 			return json;
	}


/**
 * 获取固定的sql
 * @param key
 * @return
 * @throws Exception
 */
public static String get(String key) {	
	long stat = System.currentTimeMillis();
	commTag tag;
	String sql=null;
	try {
		tag = (commTag) EngineContext.get(key).get("tag");
		sql=Pattern.compile("#\\{.+?\\}",Pattern.CASE_INSENSITIVE).matcher(tag.getSql()).replaceAll("?");
		long end = System.currentTimeMillis();
		logger.info("[key="+key+"]SQL引擎解析模板生成脚本:"+sql+"[总共消耗" + String.valueOf(end - stat) + "毫秒]");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sql;
}
/**
 * 生成动态sq
 * 根据sql 标签JSON对象
 * 和参数生成对应的sql
 * @param json
 * @param pams
 * @param flag
 * @return
 * @throws Exception
 */
private static synchronized String buliSQL(JSONObject json, Object pams,boolean flag) throws Exception {
		
//		long stat = System.currentTimeMillis();
		String sql=null;
		String type = json.getString("type");
//		System.out.println("JSON------>"+json.toJSONString());
		SQLBuilder sqlBuil = new SQLBuilder(" ");
		TrimCommand trim = null;
		List<IfCommand> ifcommand = null;
		OrderCommand order=null;
		GroupCommand group=null;
		if ("select".equalsIgnoreCase(type)) {
			SelectTag select = (SelectTag) json.get("tag");
			sqlBuil.append(select.getSql());
			trim = select.getTrim();
			//&& ifcommand != null
			if (trim != null ) {
				ifcommand = trim.getIfCommand();
				if ("where".equalsIgnoreCase(trim.getPrefix())) {
					sqlBuil.append(trim.getPrefix()).append("1=1");
				} else {
					sqlBuil.append(trim.getPrefix());
				}
				if(ifcommand==null||ifcommand.isEmpty())
					throw new Exception("SQLxml配置文件[key="+select.getKey()+"]trim指令语法出错,trim指令至少包含一对if元素!");
		
				builderIfCommandSQL(ifcommand, pams, sqlBuil);
			}
			order=select.getOrder();
			group=select.getGroup();
			if(group!=null){
				sqlBuil.append("group by").append(group.getExp());
				String having=group.getHaving();
				 if(having!=null){
					 sqlBuil.append(" having ").append(having);
				 }
				

			}
			if(order!=null){
				sqlBuil.append("order by").append(order.getExp()).append(order.getValue());
			}
			
              sql=sqlBuil.toString();
//              System.out.println("组装完成>>>"+sql);
		} else if ("update".equalsIgnoreCase(type)) {
			UpdateTag update=(UpdateTag) json.get("tag");
			sqlBuil.append(update.getSql());
			SetCommand set=update.getSet();
			 trim=update.getTrim();
			WhereCommand where=update.getWhere();
			if(set!=null){
				sqlBuil.append("set");
				ifcommand=set.getIfCommand();
				if(ifcommand==null) throw new Exception("SQLxml配置文件[key="+update.getKey()+"]set指令语法出错,set指令至少包含一对if元素!");
				builderIfCommandSQL(ifcommand, pams, sqlBuil);  
			}
		
			if(trim!=null){
				if("set".equalsIgnoreCase(trim.getPrefix())){
					  sqlBuil.append(trim.getPrefix());
					  ifcommand=trim.getIfCommand();
						if(ifcommand==null) throw new Exception("SQLxml配置文件[key="+update.getKey()+"]set指令语法出错,set指令至少包含一对if元素!");
						builderIfCommandSQL(ifcommand, pams, sqlBuil);  
					
				}else if("where".equalsIgnoreCase(trim.getPrefix())){
					if(sqlBuil.toString().toLowerCase().indexOf("set")==-1)
						throw new Exception("SQLxml配置文件[key="+update.getKey()+"]update标签语法有误,缺乏set元素！");
					
					    sqlBuil.append(trim.getPrefix());
						ifcommand=trim.getIfCommand();
						builderIfCommandSQL(ifcommand, pams, sqlBuil);  
				}else{
					if(sqlBuil.toString().toLowerCase().indexOf("set")==-1)
						throw new Exception("SQLxml配置文件[key="+update.getKey()+"]update标签语法有误,缺乏set元素！");
				    sqlBuil.append(trim.getPrefix());
					ifcommand=trim.getIfCommand();
					builderIfCommandSQL(ifcommand, pams, sqlBuil);  	
				}	
			}
			if(where!=null){
				if(sqlBuil.toString().toLowerCase().indexOf("where")>-1)
				 throw new Exception("SQLxml配置文件[key="+update.getKey()+"]update标签语法有误,sql已经存在where关键字,就不可以再使用where标签");
				sqlBuil.append("where");
				ifcommand=where.getIfCommand();
				builderIfCommandSQL(ifcommand, pams, sqlBuil);  
			}
			 sql=sqlBuil.toString().replaceAll("set\\s+,", "set ");//将set 前的逗号删除
			

		} else if ("insert".equalsIgnoreCase(type)) {

			InsertTag insert=(InsertTag) json.get("tag");
			sqlBuil.append(insert.getSql());
            sql=sqlBuil.toString();

		} else if ("delete".equalsIgnoreCase(type)) {

		}
//		long end = System.currentTimeMillis();
		//对应别名替换成占位符 ？
		if(flag){
			 Pattern pattern = Pattern.compile("#\\{.+?\\}",Pattern.CASE_INSENSITIVE);
			 sql= pattern.matcher(sql).replaceAll("?");
//			logger.info("[key="+json.getString("key")+"]SQL引擎解析模板生成脚本:"+sql+"[总共消耗" + String.valueOf(end - stat) + "毫秒]");
		}
	
	
		return sql;
	}	

/**
 * 根据参数拼装好的一条完整的sql
 * 所有的占位符已经替换成对应参数的值
 * @param key
 * @param pams
 * @return
 * @throws Exception
 */
public static String getSQL(String key,Object pams) {
	long stat = System.currentTimeMillis();
    String sql=null;
	try {
		 sql = buliSQL(EngineContext.get(key), pams,false);
	     sql=replaceSQLval(sql, pams);
	  	long end = System.currentTimeMillis();
		logger.info("[key="+key+"]SQL引擎解析模板生成脚本:"+sql+"[总共消耗" + String.valueOf(end - stat) + "毫秒]");
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
	}


	return sql;
}

/**
 * 将sql表达式中的占位符替换成 
 * 对应参数的值
 * @param sql
 * @param pams
 * @return
 * @throws Exception
 * 有待扩展
 */
private static String replaceSQLval(String sql,Object pams) throws Exception{
	 Pattern pattern = Pattern.compile("#\\{.+?\\}",Pattern.CASE_INSENSITIVE);
	 Matcher matcher=pattern.matcher(sql);
	    Object obj=null;
		 while(matcher.find()){
			  String key=matcher.group().replaceAll("#\\{|\\}", "");//获取参数名称		
			   obj=PropertyUtils.getNestedProperty(pams,key);
			 
			 if(obj instanceof Integer){
				 obj=StringEscapeUtils.escapeSql(obj.toString());
//				 System.out.println(key+"参数类型为："+obj.getClass().getSimpleName());
			 }else if(obj instanceof String){
				 if(!((String) obj).contains(",")){
					 obj="'"+StringEscapeUtils.escapeSql(obj.toString())+"'";//StringEscapeUtils.escapeSql(obj.toString()); 
				 }
			
//				 System.out.println(key+"参数类型为："+obj.getClass().getSimpleName());
			 }else{
				 obj=obj==null?"null":obj;
			 }
	
			sql=sql.replaceAll("#\\{"+key+"\\}", (String) obj);
		
		 }
	 return sql;
}

/**
 * 将拼接好的SQL相关的
 * 别名替换成占位符？
 * 并且封装好对应的参数返回一个
 * JSONObject 对象 
    json.getString("sql") 带占位符的sql
    json.get("pams")  参数数组
 * @param sql
 * @param pams
 * @return
 * @throws Exception
 */
private static JSONObject buliSQL(String sql,Object pams,String type) throws Exception{
	 JSONObject json=new JSONObject();
	 if("insert".equals(type) || "update".equals(type)){
		 Pattern pattern = Pattern.compile("#\\{.+?\\}",Pattern.CASE_INSENSITIVE);
		 Matcher matcher=pattern.matcher(sql);
		 List<Object> list=new ArrayList<Object>(0);
		    Object obj=null;
		    //遍历封装别名参数
			 setPams(pams, json, matcher, list);
	  }else{
		 Pattern pattern = Pattern.compile("'#\\{.+?\\}'\\s|#\\{.+?\\}\\s|'%#\\{.+?\\}%'|'#\\{.+?\\}%'|%#\\{.+?\\}%|#\\{.+?\\}%",Pattern.CASE_INSENSITIVE);
		 Matcher matcher=pattern.matcher(sql);
		 List<Object> list=new ArrayList<Object>(0);
		    Object obj=null;
		    setPams(pams, json, matcher, list);
	  }
	 return json;
}


private static void setPams(Object pams, JSONObject json, Matcher matcher,
		List<Object> list) throws IllegalAccessException,
		InvocationTargetException, NoSuchMethodException {
	String sql;
	Object obj;
	while(matcher.find()){
		  String key=matcher.group().replaceAll("#\\{|\\}", "");//获取参数名称			
		  //处理like 操作符的情况
	     if(key.startsWith("'%")&&key.endsWith("%'")||key.startsWith("%")&&key.endsWith("%")){
	    
	    	 obj=PropertyUtils.getNestedProperty(pams,key.replaceAll("'|%","").trim());
		     list.add("%"+obj+"%");  
	     }else if(key.startsWith("'%")&&!key.endsWith("%'")||key.startsWith("%")&&!key.endsWith("%")){
	    	 obj=PropertyUtils.getNestedProperty(pams,key.replaceAll("'|%","").trim());
		     list.add("%"+obj);  
	     }else if(!key.startsWith("'%")&&key.endsWith("%'")||!key.startsWith("%")&&key.endsWith("%")){
	    	 obj=PropertyUtils.getNestedProperty(pams,key.replaceAll("'|%","").trim());
		     list.add(obj+"%");  
	     }else{
	    	 obj=PropertyUtils.getNestedProperty(pams,key.replaceAll("'","").trim());
	         list.add(obj);  
	     }
	      
	 }
	 //修改
	 sql=matcher.replaceAll(" ? ");//将所有别名替换成展望占位符 ？
	 json.put("sql", sql);
	 json.put("pams", list.toArray());
}
	
	
/**
 * if指令规则运算
 * @param test
 * @param pams
 * @return
 * @throws Exception
 */
private static Boolean  ifOper(String test,Object pams) throws Exception{
	 if(test.indexOf("#")<0) throw new Exception("SQL配置文件IF指令存在非法参数["+test+"],IF指令参数格式必须为：#xx_xx||#xx");
	 test=test.replaceAll("\\sand\\b\\s"," && " ).replaceAll("\\sor\\b\\s", " || ").replaceAll("\\slt\\b\\s", " < ").replaceAll("\\sle\\b\\s", " <= ").replaceAll("\\sgt\\b\\s", " > ").replaceAll("\\sge\\b\\s", ">=").replaceAll("\\seq\\b\\s", " == ");//转换 or| and 操作符
	 Pattern patterns = Pattern.compile("#\\w+",Pattern.CASE_INSENSITIVE);
	 Matcher matchers=patterns.matcher(test);
	 while(matchers.find()){
//		 System.out.println("test>>"+matchers.group());
		 String key=matchers.group().replaceAll("#","");
		 Object obj=BeanUtils.getProperty(pams,key);
//      		System.out.println(obj.getClass().getSimpleName());
      		if(obj==null||"".equals(obj)){
      			obj="null";
      		}else if(obj instanceof String){
      			obj="'"+obj+"'";
      			
      		}
		    test= test.replaceAll("#"+key,obj.toString());

		 }
//	 logger.error(">>>>>>>>>>>>"+test);
	 
	  return (Boolean) JavaScript.MathValue(test);
}
/**
 * 构造if指令SQL
 * @param ifcommand if指令实体
 * @param pams      参数对象
 * @param builder   sql构造器
 * @throws Exception
 */

private static void builderIfCommandSQL(List<IfCommand> ifcommand ,Object pams,SQLBuilder builder) throws Exception{
	
	for (IfCommand ifCommand : ifcommand) {
		String test = ifCommand.getTest();
		if (ifOper(test, pams)) {
			builder.append(ifCommand.getPrefix()).append(
					ifCommand.getExp());
		}
	}
	

	
}


}
enum engineCaticon {
    sql,
    pams
}