package com.cloud.icenter.common.engine.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;


/**
 * 
 * <p>Title:SQLBuilder</p>
 * <p>Description: SQL构造器     </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p> 
 * <p>Date:2015年1月2日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
public class SQLBuilder {
	
  private static  StringBuffer sqlBuil;
  
  private Logger log=Logger.getLogger(SQLBuilder.class);


	
  public SQLBuilder(String sql){
	  sqlBuil=new StringBuffer(sql);
	  
  }
  public SQLBuilder(){};
  
  
  
  /**
   * 动态拼接sql
   * 防止SQL注入  如 ： "1' or '1'='1"
   * @param key 参数名称
   * @param val 参数值    
   * @return
   */
  
 public   SQLBuilder append(Object key,Object val){
	
	sqlBuil.append(key).append(StringEscapeUtils.escapeSql(val.toString()));
	
		return this ;
	}
	
 public   SQLBuilder append(String str){
		
		sqlBuil.append(" ").append(str).append(" ");

		return this;
	}
 
 /**
  * 用于拼接SQL
  * 动态参数值 
  * 将拼接的值给转义
  * 防止sql注入 
  * @param val  如 ： "1' or '1'='1"
  * @return
  */
 public   SQLBuilder append(Object val){
		sqlBuil.append(StringEscapeUtils.escapeSql(val.toString()));
		return this ;
  }
 
 public String toString(){
//	 log.info("sql:>>>"+sqlBuil.toString());
		return sqlBuil.toString();
	}

 
public static void main(String[] args) {
	String userName = "1' or '1'='1";
	SQLBuilder builder=new SQLBuilder("SELECT COUNT(userId) FROM t_user");
	builder.append(" WHERE ").append("userName='", userName);
	builder.toString();
}


}
