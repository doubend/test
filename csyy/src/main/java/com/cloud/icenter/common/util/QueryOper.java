package com.cloud.icenter.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * 自定义查询标注 
 * <p>Title:Region</p>
 * <p>Description:
 * 用来灵活设置要进行条件查询的实体类属性的运算符
 * 如： =、<、>、>=、<=、<>、like
 * </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Date: 2013-4-8</p>
 * @author 陈剑
 * @version 1.0
 */

@Target(ElementType.FIELD)//这个标注应用于属性
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented//将此注解包含在javadoc中
public @interface QueryOper {
	String formula() default "=";
	String field() default "" ;
}
