package com.cloud.icenter.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * <p>Title:TableKeyID</p>
 * <p>Description: 自定义 实体对应的表字段标注
 *   name---表的字段名
 *    
 * </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: 中科软科技股份有限公司</p>
 * <p>Date:2012-12-30</p>
 * @author 陈剑
 * @version 1.0
 */

@Target(ElementType.FIELD)//这个标注应用于属性

@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时

@Documented//将此注解包含在javadoc中
public @interface  Columns {
	  String name();
	 
	 

}
