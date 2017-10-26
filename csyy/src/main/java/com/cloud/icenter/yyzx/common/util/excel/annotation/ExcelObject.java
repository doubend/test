package com.cloud.icenter.yyzx.common.util.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注VO是否支持Excel<br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExcelObject {
	/**
	 * 标注VO是否支持Excel,true支持，false不支持，默认值为false
	 * @Title value
	 * @Description TODO
	 * @return
	 * @date 2015年11月16日-上午9:25:16
	 * @update
	 *
	 */
	boolean value() default false;
}
