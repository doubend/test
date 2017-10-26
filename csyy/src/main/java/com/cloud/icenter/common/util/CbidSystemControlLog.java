package com.cloud.icenter.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 法人库查询日志描述
 * @author 叶方忠
 * 
 */
@Target(ElementType.METHOD)//这个标注应用于属性
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented  //将此注解包含在javadoc中
public @interface CbidSystemControlLog {
	 //操作类型
	 String OperateType() default "";
	 //模块名称
	 String moduleName() default "";
}
