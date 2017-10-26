package com.cloud.icenter.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * 人口库查询日志描述
 * @author 叶方忠
 * 
 */
@Target(ElementType.METHOD)//这个标注应用于属性
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented  //将此注解包含在javadoc中
public @interface PbidSystemControlLog {
	 
     //url请求参数名称
	 String OperateType() default "";  
	 //模块名称
	 String moduleName() default "";
	 
	 public final static String  oper_checkbasi="1";  //查看基本信息
	 public final static String  oper_relation="2";	  //查看家庭关系
	 public final static String  oper_location="3";	  //定位
}
