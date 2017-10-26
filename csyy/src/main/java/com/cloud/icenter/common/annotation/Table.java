package com.cloud.icenter.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * 
 * <p>Title:Table</p>
 * <p>Description:自定义实体对应的表的名称  
 *    name---表名称
 *    keyId---主键名称
 *    sequence--
 * 
 * </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: 中科软科技股份有限公司</p>
 * <p>Date:2012-12-30</p>
 * @author 陈剑
 * @version 1.0
 */
//@Target(ElementType.FIELD)//这个标注应用于属性


@Target(ElementType.TYPE)//这个标注应用于类

@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时

@Documented//将此注解包含在javadoc中

public @interface Table {
     
    String name();
    String keyId();
    String sequence();

}