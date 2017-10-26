package com.cloud.icenter.yyzx.common.util.excel;

import java.lang.reflect.Field;

import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelField;

/**
 * VO属性与Excel列的对应关系<br>
 */
public class ExcelFieldInfo {

	private ExcelField excelField;

	private Field field;

	public ExcelField getExcelField() {
		return excelField;
	}

	public void setExcelField(ExcelField excelField) {
		this.excelField = excelField;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

}
