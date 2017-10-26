package com.cloud.icenter.common.util;


/**
 * 数据类型匹配
 * @author whcai
 *
 */
public class DataTypeMatch {
	
	/**
	 * 获取匹配后的数据类型
	 * @param dType
	 * @return
	 */
	public static String getMatchDataType(String dType){
		String resType = "string";
		if(dType.equalsIgnoreCase("TINYINT") || dType.equalsIgnoreCase("INT") || dType.equalsIgnoreCase("BIT") ||
		   dType.equalsIgnoreCase("INTEGER") || dType.equalsIgnoreCase("SMALLINT") || dType.equalsIgnoreCase("NUMERIC") ||
		   dType.equalsIgnoreCase("DECIMAL") || dType.equalsIgnoreCase("BIGINT") || dType.equalsIgnoreCase("NUMBER")){
			resType = "int";
		}
		else if(dType.equalsIgnoreCase("FLOAT") || dType.equalsIgnoreCase("DOUBLE")){
			resType = "double";
		}
		else if(dType.equalsIgnoreCase("CHAR") || dType.equalsIgnoreCase("VARCHAR") || dType.equalsIgnoreCase("STRING") ||
				dType.equalsIgnoreCase("VARCHAR2") || dType.equalsIgnoreCase("TEXT")){
			resType = "string";
		}
		else if(dType.equalsIgnoreCase("DATE") || dType.equalsIgnoreCase("DATETIME") || 
				dType.equalsIgnoreCase("TIME") || dType.equalsIgnoreCase("TIMESTAMP")){
			resType = "datetime";
		}
		return resType;
	}
}
