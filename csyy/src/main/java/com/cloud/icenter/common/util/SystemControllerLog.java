package com.cloud.icenter.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/***
 * 系统操作日记描述
* @ClassName: SystemControllerLog 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Chen_JIAN
* @date 2015年11月6日 下午3:30:57 
*
 */

@Target(ElementType.METHOD)//这个标注应用于属性
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented
public @interface SystemControllerLog {

	 
      //操作类型
	 String OperateType() default "";
	 //模块名称
	 String moduleName() default "";
	 //功能描述
	 String description () default "";
	 
	 public final static String  oper_query="1";
	 public final static String  oper_add="2";
	 public final static String  oper_eidt="3";
	 public final static String  oper_del="4";
	 

}
