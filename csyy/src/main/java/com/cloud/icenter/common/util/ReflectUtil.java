package com.cloud.icenter.common.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * 
* @ClassName: ReflectUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* 反射辅助类
* @author Chen_JIAN
* @date 2015年7月10日 下午12:59:07 
*
 */
public class ReflectUtil {
	private ReflectUtil(){}
	
	@SuppressWarnings("unchecked")
	public static <T> T getModelClass(Class<?> cls,int index){
		try{
			Type genType = cls.getGenericSuperclass();
			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
			return (T)params[index];
		}catch(Exception err){
			err.printStackTrace();
			Type genType = cls.getSuperclass().getGenericSuperclass();
			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
			return (T) params[index];
		}
	}

	/**
	 * 获取字段的值
	 * @param obj
	 * @param name
	 * @return
	 */
	public static Object getValue(Object obj, String name) {
		Object ret = null;
		Method ms[] = obj.getClass().getMethods();
		for (Method mth : ms) {
			if (mth.getName().equalsIgnoreCase("get" + name)) {
				try {
					ret = mth.invoke(obj, new Object[] {});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	public static String getStrValue(Object obj, String name) {
		if(getValue(obj, name) != null) {
			return getValue(obj, name).toString();
		} else {
			return "";
		}
	}
	
	public static Integer getIntValue(Object obj,String name){
		return Integer.parseInt("" + getValue(obj, name));
	}
	
	public static Float getFloatValue(Object obj,String name){
		return Float.parseFloat("" + getValue(obj, name));
	}
	
	public static Double getDoubleValue(Object obj,String name){
		return Double.parseDouble("" + getValue(obj, name));
	}
	
	public static Long getLongValue(Object obj,String name){
		return Long.parseLong("" + getValue(obj, name));
	}
	
	public static Boolean getBooleanValue(Object obj,String name){
		if (getValue(obj, name) != null) {
			return Boolean.parseBoolean("" + getValue(obj, name));
		} else {
			return false;
		}
	}
	
	public static Date getDataValue(Object obj, String name) {
		return (Date) getValue(obj, name);
	}
}
