package com.cloud.icenter.yyzx.common.util.excel.reader;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;

import com.cloud.icenter.yyzx.common.util.excel.RegexUtil;


/**
 * 按照数据类型读取Excel中Cell中的数据<br>
 */
public class CellDataReader {
	/**
	 * 检查字符串数组是否为空、是否是数字
	 * 
	 * @Title checkNumber
	 * @Description TODO
	 * @param value
	 * @date 2015年11月16日-上午9:26:38
	 * @update
	 *
	 */
	private static void checkNumber(String value) {
		if (null == value || value.length() == 0) {
			throw new NullPointerException("value is null!");
		}
		if (!RegexUtil.isNumber(value)) {
			throw new RuntimeException(value + "is not a number!");
		}
	}

	/**
	 * 把字符串数字转换成整数字符串
	 * 
	 * @Title createInteger
	 * @Description TODO
	 * @param value
	 * @return
	 * @date 2015年11月16日-上午9:27:24
	 * @update
	 *
	 */
	private static String createInteger(String value) {
		checkNumber(value);
		int dotIndex = value.lastIndexOf(".");
		if (dotIndex != -1) {
			value = value.substring(0, dotIndex);
		}
		return value;
	}

	/**
	 * 读取字符串数字为int类型
	 * 
	 * @Title readInt
	 * @Description TODO
	 * @param value
	 * @return
	 * @date 2015年11月16日-上午9:27:53
	 * @update
	 *
	 */
	public static int readInt(String value) {
		value = createInteger(value);
		return Integer.parseInt(value);
	}

	/**
	 * 读取字符串数字为short类型
	 * 
	 * @Title readShort
	 * @Description TODO
	 * @param value
	 * @return
	 * @date 2015年11月16日-上午9:28:15
	 * @update
	 *
	 */
	public static short readShort(String value) {
		value = value = createInteger(value);
		return Short.parseShort(value);
	}

	/**
	 * 读取字符串数字为long类型
	 * 
	 * @Title readLong
	 * @Description TODO
	 * @param value
	 * @return
	 * @date 2015年11月16日-上午9:28:24
	 * @update
	 *
	 */
	public static double readLong(String value) {
		value = createInteger(value);
		return Long.parseLong(value);
	}

	/**
	 * 读取字符串数字为float类型
	 * 
	 * @Title readFloat
	 * @Description TODO
	 * @param value
	 * @param decimal
	 * @return
	 * @date 2015年11月16日-上午9:28:33
	 * @update
	 *
	 */
	public static float readFloat(String value, int decimal) {
		checkNumber(value);
		BigDecimal bigDecimalValue = new BigDecimal(value);
		return bigDecimalValue.setScale(decimal, BigDecimal.ROUND_HALF_UP)
				.floatValue();
	}

	/**
	 * 读取字符串数字为double类型
	 * 
	 * @Title readDouble
	 * @Description TODO
	 * @param value
	 * @param decimal
	 * @return
	 * @date 2015年11月16日-上午9:28:41
	 * @update
	 *
	 */
	public static double readDouble(String value, int decimal) {
		checkNumber(value);
		BigDecimal bigDecimalValue = new BigDecimal(value);
		return bigDecimalValue.setScale(decimal, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * 读取字符串数字为BigInteger类型
	 * 
	 * @Title readBigInteger
	 * @Description TODO
	 * @param value
	 * @return
	 * @date 2015年11月16日-上午9:28:53
	 * @update
	 *
	 */
	public static BigInteger readBigInteger(String value) {
		value = createInteger(value);
		return new BigInteger(value);
	}

	/**
	 * 读取字符串数字为BigDecimal类型
	 * 
	 * @Title readBigDecimal
	 * @Description TODO
	 * @param value
	 * @param decimal
	 * @return
	 * @date 2015年11月16日-上午9:29:06
	 * @update
	 *
	 */
	public static BigDecimal readBigDecimal(String value, int decimal) {
		checkNumber(value);
		return new BigDecimal(value)
				.setScale(decimal, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 读取字符串数字为Date类型
	 * 
	 * @Title readDate
	 * @Description TODO
	 * @param value
	 * @param dateFormat
	 * @return
	 * @throws ParseException
	 * @date 2015年11月16日-上午9:29:21
	 * @update
	 *
	 */
	public static Date readDate(String value, String dateFormat)
			throws ParseException {
		Date date = null;
		if (RegexUtil.isNumber(value)) {
			date = DateUtil.getJavaDate(Double.parseDouble(value));
		} else {
			if (null != dateFormat
					&& (dateFormat = dateFormat.trim()).length() != 0) {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				date = sdf.parse(value);
			}
		}
		return date;
	}
}
