package com.cloud.icenter.yyzx.common.util.excel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则帮助类<br>
 */
public class RegexUtil {
	/**
	 * 字符串是否是数字
	 * 
	 * @Title isNumber
	 * @Description TODO
	 * @param src
	 * @return
	 * @author XuZhen
	 * @date 2015年11月16日-上午9:39:47
	 * @update
	 *
	 */
	public static boolean isNumber(String src) {
		String reg = "^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(src);
		return matcher.matches();
	}

}
