package com.cloud.icenter.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
* @ClassName: Custom 
* @Description: TODO(这里用一句话描述这个类的作用) 
* 自定义jpql语句 属性识别注解
* @author Chen_JIAN
* @date 2015年8月6日 下午3:02:53 
*
 */
@Target(ElementType.FIELD)//这个标注应用于属性
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented
public @interface Custom {

}
