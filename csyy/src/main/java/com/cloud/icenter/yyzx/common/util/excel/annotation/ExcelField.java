package com.cloud.icenter.yyzx.common.util.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelField {
	/**
	 * Excel列位置
	 * @Title index
	 * @Description TODO
	 * @return
	 * @date 2015年11月11日-下午6:46:03
	 * @update
	 *
	 */
	String index();

	/**
	 * 小数位数
	 * @Title decimal
	 * @Description TODO
	 * @return
	 * @date 2015年11月11日-下午6:45:45
	 * @update
	 *
	 */
	String decimal() default "0";

	/**
	 * 日期格式
	 * @Title dateFormat
	 * @Description TODO
	 * @return
	 * @date 2015年11月16日-上午9:24:25
	 * @update
	 *
	 */
	String dateFormat() default "yyyy-MM-dd";

}
