package com.cloud.icenter.common.util;

import java.beans.Transient;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.cloud.icenter.common.annotation.DateRegex;
import com.cloud.icenter.common.annotation.Table;

/**
 * 
 * <p>Title:SQLBuildFactory</p>
 * <p>Description:      </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2014年8月14日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */

public class SQLBuildFactory {
	private static Logger log = Logger.getLogger(SQLBuildFactory.class);
	private static  final DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
	private static String msg=null;


	/**
	 * 根据不同的数据厂商组装分页的SQL
	 * @param sql
	 * @param dbType
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public static String buildPageSql(String sql, String dbType, int pageNow, int pageSize) {
		String sql_str = null;
		
   
		if ("mysql".equalsIgnoreCase(dbType)) {
			sql_str = sql + " LIMIT " + (pageNow - 1) * pageSize + "," + pageSize;
		} else if("oracle".equalsIgnoreCase(dbType)){
			StringBuffer _sql = new StringBuffer(
					"SELECT * FROM (SELECT t1.*,rownum sn1 FROM (");
			_sql.append(sql);
			_sql.append(") t1) t2 WHERE t2.sn1 BETWEEN ");
			_sql.append((pageNow - 1) * pageSize + 1);
			_sql.append(" AND ");
			_sql.append(pageNow * pageSize);
			sql_str = _sql.toString();
		}else{
			log.error("没有找到相应的数据库类型。");
		}

		return sql_str.toString();
	}

	/**
	 * 
	 * <p>name:getInserSql</p>
	 * <p>Description:
	 *  根据解析值对象的注解，拼接Insert语句 </p>
	 * <p>Date:2012-12-31</p>
	 * @author 陈剑
	 * @version 1.0
	 * @param object
	 * @param glob 是否将对象属性的值封装 
	 * glob=true 如下：
	 *    INSERT INTO B_DM_CORP_CUST(CUST_ID,CUST_NAME)VALUES('1','你好')
	 * glob=false 如下：
	 *    INSERT INTO B_DM_CORP_CUST(CUST_ID,CUST_NAME)VALUES(?,?)
	 * @return 返回拼接好的sql 语句
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @String
	 */

	
	public static String getInserSql(Object object,boolean glob) throws IllegalArgumentException, IllegalAccessException{
		   boolean flag=false,sing=false;
		   Class<? extends Object> clazz=object.getClass();
		   flag=clazz.isAnnotationPresent(Table.class);//clazz实体类是否有TableName 标注
		   String tableName=null;
		   String cloumsName=null;
		   String keyID=null;
		   String sequence=null;
		   Field field=null;
		   Object value=null;
		   String regex="YYYY-mm-DD";//默认的日期格式
		
		   if(flag){
			
			   Table table=(Table) clazz.getAnnotation(Table.class);
			   
			   tableName=table.name();//xx
			
			   keyID=table.keyId().toUpperCase();
			   sequence=table.sequence();
			//   System.out.println("表名为："+table.name()+" 主键："+table.keyId()+" sequence为："+table.sequence());
		   }
		   Field[] fields= clazz.getDeclaredFields();//获取该对象所有的私有属性
		   StringBuffer sql=new StringBuffer("INSERT INTO ");
		   StringBuffer valueSql=new StringBuffer("VALUES(");
		   sql.append(tableName).append("(");
		  for(int i=0;i<fields.length;i++){
			    //判断该实体类相应的属性是否存在 Columns 注解
			   field=fields[i];
			   flag= field.isAnnotationPresent(Columns.class);
			   sing= field.isAnnotationPresent(Transient.class);//不进行生成sql的字段
			   if(sing) continue;
			   field.setAccessible(true);
			   value=field.get(object);
			   
			   if(flag){ 
					//获得该属性上的注解 该注解的 name()方法得到的值就 属性所对应数据库表的字段名称
				   Columns columns=field.getAnnotation(Columns.class);
				   cloumsName=columns.name().toUpperCase();
			   }else{
				   
				   //如果没有属性没有 Columns注解 那属性名称就是 对应的数据库表的字段名称
				   cloumsName=field.getName().toUpperCase();
				  // System.out.println(field.getName()+" 属性没有配置columns注解，因此不知道其所对应的字段名称！"); 
			   }
			   //过滤掉 类的序列号字段名称
			   if(cloumsName.equals("SERIALVERSIONUID")){
				   continue;
			   }
				 //过滤掉没有值的字段，除了配置有sequence 的主键字段
				 if(value!=null&&!"".equals(value)||(cloumsName.equals(keyID)&&sequence!=null&&!"".equals(sequence))){
//				   //拼接插入数据字段的名称 如 INSERT INTO B_DM_CORP_CUST(CUST_ID,CUST_NAME,SRC_SYS_CUST_ID，...
				  sql.append(cloumsName).append(",");
				  //当主键生成策略的sequence不等于null 并且当前的字段名正好是 主键的字段名的时候，并且当前主键所对应的字段的值是NULL的时候，
				  //或者主键值为空的是字符窜的时候 用配置的sequence 生成主键值
				  if((sequence!=null&&!"".equals(sequence)&&cloumsName.equals(keyID))&&(value==null||"".equals(value)||Integer.valueOf(value.toString())==0)){
					  valueSql.append(sequence+".nextval").append(",");
					  
				  }else if(field.getType().getSimpleName().equals("String")){
					  if(glob){
						  value=value.toString().replaceAll("'", "''");//将所有字符串类型的值（如： BANKERS ' ACCEPTANCE  ） 包含有单引号的 进行转义 才能插入数据库 否则会报缺少逗号  
						  valueSql.append("'").append(value).append("'").append(",");
					  }
					
				  }else if(field.getType().getSimpleName().equals("Date")){
					if(glob){ 
							   flag= field.isAnnotationPresent(DateRegex.class);
						   if(flag){
							   regex=field.getAnnotation(DateRegex.class).regex();
						   }
						try {
							
							//处理日期表达式 将日期表达式转成 yyyy-MM-dd  年小写-月大写 -日小写
							 regex=regex.replaceAll("Y", "y").replaceAll("m", "M").replaceAll("D", "d");
							 SimpleDateFormat dfs = new SimpleDateFormat(regex);
							 Date date = df.parse(String.valueOf(value));
							 value=dfs.format(date);
						} catch (Exception e) {
							msg=clazz.getName()+"Date类型属性： "+cloumsName+"格式："+regex+"与字段值"+value+"不匹配！";
						log.error(msg);	
						continue;
						}
						 valueSql.append("to_date('"+value+"','"+regex+"')").append(",");
							
					}
					 	  
				  }else{
					  if(glob){
					  valueSql.append(value).append(",");
					  }
					  
				  }
				  if(!glob){
					  valueSql.append("?").append(",");
					  }
				//   System.out.println(field.getName()+" 所对应表的字段名为："+cloumsName);
				//  sql.append(cloumsName).append(",");
			    }
			  
		  }
		  sql.deleteCharAt(sql.lastIndexOf(","));//去掉最后一个逗号
		  sql.append(")");
		  valueSql.deleteCharAt(valueSql.lastIndexOf(","));//去掉最后一个逗号
		  valueSql.append(")");	  
		  return sql.append(valueSql).toString().toUpperCase();
	}

	

}
