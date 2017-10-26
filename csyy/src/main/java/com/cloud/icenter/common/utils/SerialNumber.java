package com.cloud.icenter.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 编码生成器
 * 生成规则为组织编码+业务类型+日期+4位流水号
 * @author menglit
 *
 */
public class SerialNumber {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	/**
	 * 
	 * @param organCode
	 * @param type
	 * @param currentNum 当前的编号
	 * @return
	 */
	public static String getSerialNumber(String organCode,String type,int currentNum){
		String date = format.format(new Date());
		StringBuffer value = new StringBuffer(organCode);
		value.append(type);
		value.append(date);
		value.append(getNextNum(currentNum));
		return value.toString();
	}
	
	private static Object getNextNum(int currentNum) {
		currentNum +=1;
		String tmp = String.valueOf(currentNum);
		if(tmp.length() == 1){
			return "000"+currentNum;
		}else if(tmp.length() == 2){
			return "00"+currentNum;
		}else if(tmp.length() == 3){
			return "0"+currentNum;
		}else {
			return currentNum;
		}
	}
}
