package com.cloud.icenter.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * 
* @ClassName: SignatureUtil 
* 签名
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Chen_JIAN
* @date 2015年9月15日 下午2:33:57 
*
 */
public class SignatureUtil {
	
private static Logger log=Logger.getLogger(SignatureUtil.class);


  
  /**
   * 
   * toSignature(这里用一句话描述这个方法的作用)
   * 生成签名窜
   * @param timestamp  时间戳
   * @param nonce      双方指定的一个数据作为安全因子
   * @return String
   * @exception 
   * @version  1.0.0
   * @date 2015年9月15日 
   *
   */
  public static String toSignature( String timestamp,String nonce){
	        
	  
	  
	  return toMd5(timestamp+nonce);
  }
    
  
  /**
   * 
   * getTimestamp(这里用一句话描述这个方法的作用)
   * 获取当前时间戳
   * @return String
   * @exception 
   * @version  1.0.0
   * @date 2015年9月15日 
   *
   */
  public static String getTimestamp(){
	  DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
	  
	  return format.format(new Date());
  }
  
   /**
    * 
    * toMd5(这里用一句话描述这个方法的作用)
    * 生成MD5加密窜
    * @param str
    * @return String
    * @exception 
    * @version  1.0.0
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
					hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("生成MD5码出错",e);
		}

		String code = hexString.toString().toUpperCase();
		return code;
	}


}
