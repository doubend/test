package com.cloud.icenter.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * 字符处理工具类
 * 
 * @author zhanngle
 */
public class StringUtil {

	private static Logger log = Logger.getLogger(StringUtil.class);
	
	/**
	 * 判断字符是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 截取指定字符串的字节数
	 * 
	 * @param str
	 *            需要截取的字符串
	 * @param byteNum
	 *            字节数
	 * @return 截取后的字符串
	 */
	public static String getString(String str, int byteNum) {

		if (str == null)
			return null;
		str = str.replaceAll("\\s", "");
		str = str.replaceAll("\"|'", "");
		if (str.getBytes().length <= byteNum)
			return str;

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			String c = str.substring(i, i + 1);
			count += c.getBytes().length;
			if (count <= byteNum) {
				sb.append(c);
			} else {
				break;
			}
		}

		return sb.toString();
	}

	public static String getParameter(String data, String para) {
		String result = "";
		StringBuffer reStr = new StringBuffer();
		reStr.append("<");
		reStr.append(para);
		reStr.append(">");
		reStr.append("(.*?)");
		reStr.append("</");
		reStr.append(para);
		reStr.append(">");
		Pattern pattern = Pattern.compile(reStr.toString());
		Matcher matcher = pattern.matcher(data);
		if (matcher.find()) {
			result = matcher.group(1);
		}
		return result;
	}

	// 对比数组，返回不一致的
	public static String getExist(String[] lists, String[] list) {
		List<String> list1 = new ArrayList<String>(lists.length);
		for (String string : lists) {
			list1.add(string);
		}
		String str = "";
		for (String string : list) {
			if (!list1.contains(string)) {
				str += string + ",";
			}
		}
		return str.indexOf(",") > 0 ? str.substring(0, str.length() - 1) : str;
	}

	/**
	 * 
	 * toSignature(这里用一句话描述这个方法的作用) 生成签名窜
	 * 
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            双方指定的一个数据作为安全因子
	 * @return String
	 * @exception
	 * @version 1.0.0
	 * @date 2015年9月15日
	 * 
	 */
	public static String toSignature(String timestamp, String nonce) {
		return toMd5(timestamp + nonce);
	}

	/**
	 * 
	 * getTimestamp(这里用一句话描述这个方法的作用) 获取当前时间戳
	 * 
	 * @return String
	 * @exception
	 * @version 1.0.0
	 * @date 2015年9月15日
	 * 
	 */
	public static String getTimestamp() {
		DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");

		return format.format(new Date());
	}

	/**
	 * 
	 * toMd5(这里用一句话描述这个方法的作用) 生成MD5加密窜
	 * 
	 * @param str
	 * @return String
	 * @exception
	 * @version 1.0.0
	 * @date 2015年9月15日
	 * 
	 */

	public static String toMd5(String str) {

		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("参数不能为空!");
		}

		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();

			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("生成MD5码出错", e);
		}

		String code = hexString.toString().toUpperCase();
		return code;
	}
	
	/**
	 * 把list转成'xx','xx'格式的数据
	 * @param val
	 * @return
	 */
	public static String splitString(List<String> val){
		StringBuffer value = new StringBuffer();
		for(int i=0;i<val.size();i++){
			if(i != val.size()-1){
				value.append("'").append(val.get(i)).append("',");
			}else{
				value.append("'").append(val.get(i)).append("'");
			}
		}
		return value.toString();
	}
	
	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
	/**
	 * 把xx,xx转成'xx','xx'格式的数据
	 * @param val
	 * @return
	 */
	public static String splitString(String target,String split){
		String[] val = target.split(split);
		StringBuffer value = new StringBuffer();
		for(int i=0;i<val.length;i++){
			if(i != val.length-1){
				value.append("'").append(val[i]).append("',");
			}else{
				value.append("'").append(val[i]).append("'");
			}
		}
		return value.toString();
	}
	/**
	 * 对象转换成字符串
	 * @param target
	 * @return
	 */
	public static String objectToStr(Object obj){
		if(obj == null){
			return "";
		}else{
			return String.valueOf(obj);
		}
	}
}
