package com.cloud.icenter.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
* @ClassName: Ignore 
* @Description: TODO(这里用一句话描述这个类的作用) 
* 组装查询条件时如果字段上面有该注解那么久
* 忽略掉，不进行组装。
* @author Chen_JIAN
* @date 2015年7月22日 下午6:00:50 
*
 */

@Target(ElementType.FIELD)//这个标注应用于属性
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented
public @interface Ignore {

}
