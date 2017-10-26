package com.cloud.icenter.yyzx.common.util.excel;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelField;
import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelObject;

/**
 * Excel注解帮助类<br>
 */
public class AnnotationFieldUtil {
	/**
	 * 获取列与VO属性对应关系
	 * 
	 * @Title fieldMaps
	 * @Description TODO
	 * @param clazz
	 * @return
	 * @author XuZhen
	 * @date 2015年11月16日-上午9:37:42
	 * @update
	 *
	 */
	public static Map<String, ExcelFieldInfo> fieldMaps(Class<?> clazz) {
		Map<String, ExcelFieldInfo> fieldMaps = new HashMap<String, ExcelFieldInfo>();
		ExcelObject excelObject = clazz.getAnnotation(ExcelObject.class);
		if (null == excelObject || !excelObject.value()) {
			return fieldMaps;
		}
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			ExcelField excelField = fields[i].getAnnotation(ExcelField.class);
			if (null != excelField) {
				ExcelFieldInfo excelFieldVO = new ExcelFieldInfo();
				excelFieldVO.setField(fields[i]);
				excelFieldVO.setExcelField(excelField);
				fieldMaps.put(excelField.index(), excelFieldVO);
			}
		}
		Class<?> superClazz = clazz.getSuperclass();
		ExcelObject excelObj = superClazz.getAnnotation(ExcelObject.class);
		if (null != excelObj && excelObj.value()) {
			fieldMaps.putAll(fieldMaps(superClazz));
		}
		return fieldMaps;
	}

}
