package com.cloud.icenter.yyzx.common.util.excel.reader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.cloud.icenter.yyzx.common.util.excel.AnnotationFieldUtil;
import com.cloud.icenter.yyzx.common.util.excel.ExcelFieldInfo;
import com.cloud.icenter.yyzx.common.util.excel.WorkBookUtil;
import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelObject;


/**
 * 
 * Excel读取器
 */
public class ExcelReader<T> {
	private Integer startColumn;
	private Integer endColumn;
	private Integer startRow;
	private Integer endRow;

	private Class<T> clazz;

	private Map<String, ExcelFieldInfo> fieldMaps;

	public void setStartColumn(Integer startColumn) {
		this.startColumn = startColumn;
	}

	public void setEndColumn(Integer endColumn) {
		this.endColumn = endColumn;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	/**
	 * Excel数据读取器
	 * 
	 * @param startColumn
	 *            起始列（必填，从0开始）
	 * @param endColumn
	 *            终止列（必填）
	 * @param startRow
	 *            起始行 （可以为NULL，从0开始，默认从第0行开始）
	 * @param endRow
	 *            终止行 （可以为NULL）
	 * @param clazz
	 */
	public ExcelReader(Integer startColumn, Integer endColumn,
			Integer startRow, Integer endRow, Class<T> clazz) {
		this.startColumn = startColumn;
		this.endColumn = endColumn;
		this.startRow = startRow;
		this.endRow = endRow;
		this.clazz = clazz;
		this.fieldMaps = AnnotationFieldUtil.fieldMaps(this.clazz);
	}

	/**
	 * Excel数据读取器
	 * 
	 * @param startColumn
	 *            起始列（必填，从0开始）
	 * @param endColumn
	 *            终止列（必填）
	 * @param startRow
	 *            起始行 （可以为NULL，从0开始，默认从第0行开始）
	 * @param clazz
	 */
	public ExcelReader(Integer startColumn, Integer endColumn,
			Integer startRow, Class<T> clazz) {
		this(startColumn, endColumn, startRow, null, clazz);
	}

	/**
	 * Excel数据读取器
	 * 
	 * @param startColumn
	 *            起始列（必填，从0开始）
	 * @param endColumn
	 *            终止列（必填）
	 * @param clazz
	 */
	public ExcelReader(Integer startColumn, Integer endColumn, Class<T> clazz) {
		this(startColumn, endColumn, null, null, clazz);
	}

	/**
	 * 读取Excel数据
	 * 
	 * @Title read
	 * @Description TODO
	 * @param in
	 *            Excel数据流
	 * @return 读取结果
	 * @throws Exception
	 * @date 2015年11月16日-上午9:33:35
	 * @update
	 *
	 */
	public List<T> read(InputStream in) throws Exception {
		Workbook hssfWorkbook = WorkBookUtil.createWorkBook(in);
		List<T> list = new ArrayList<T>();
		if (null == startColumn) {
			throw new NullPointerException("Please set startColumn！");
		}
		if (null == endColumn) {
			throw new NullPointerException("Please set endColumn！");
		}
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			Sheet sheet = hssfWorkbook.getSheetAt(numSheet);
			if (sheet == null) {
				continue;
			}
			int lastRowNum = null != endRow ? endRow : sheet.getLastRowNum();
			int rowNum = null != startRow ? startRow : 0;
			if (clazz == List.class) {
				readToList(sheet, list, lastRowNum, rowNum);
			} else {
				readToBean(sheet, list, lastRowNum, rowNum);
			}
		}
		return list;
	}

	/**
	 * 读取数据为List&lt;List&lt;Object&gt;&gt;类型
	 * 
	 * @Title readToList
	 * @Description TODO
	 * @param sheet
	 * @param list
	 * @param lastRowNum
	 * @param rowNum
	 * @throws Exception
	 * @date 2015年11月16日-上午9:34:12
	 * @update
	 *
	 */
	@SuppressWarnings("unchecked")
	private void readToList(Sheet sheet, List<T> list, int lastRowNum,
			int rowNum) throws Exception {
		for (; rowNum <= lastRowNum; rowNum++) {
			Row hssfRow = sheet.getRow(rowNum);
			if (null == hssfRow) {
				break;
			}
			List<Object> inList = new ArrayList<Object>();
			for (int column = startColumn; column <= endColumn; column++) {
				Cell cell = hssfRow.getCell(column);
				String str = WorkBookUtil.getValue(cell);
				inList.add(str);
			}
			list.add((T) inList);

		}
	}

	/**
	 * 读取数据为List&lt;Object&gt;类型,其中Object为通过泛型设置的类型
	 * 
	 * @Title readToBean
	 * @Description TODO
	 * @param sheet
	 * @param list
	 * @param lastRowNum
	 * @param rowNum
	 * @throws Exception
	 * @date 2015年11月16日-上午9:35:44
	 * @update
	 *
	 */
	private void readToBean(Sheet sheet, List<T> list, int lastRowNum,
			int rowNum) throws Exception {
		ExcelObject excelObject = clazz.getAnnotation(ExcelObject.class);
		if (null == excelObject || !excelObject.value()) {
			return;
		}
		for (; rowNum <= lastRowNum; rowNum++) {
			Row hssfRow = sheet.getRow(rowNum);
			if (null == hssfRow) {
				break;
			}
			if (WorkBookUtil.rowIsNull(hssfRow, startColumn, endColumn)) {
				return;
			}
			T obj = (T) Class.forName(clazz.getName()).newInstance();
			int excelColumn = 1;
			for (int column = startColumn; column <= endColumn; column++) {
				Cell cell = hssfRow.getCell(column);
				ExcelFieldInfo excelField = fieldMaps.get(excelColumn++ + "");
				String strValue = WorkBookUtil.getValue(cell);
				if (null == strValue || strValue.trim().length()==0) {
					continue;
				}
				Field field = excelField.getField();
				Class<?> fieldClazz = field.getType();
				if (fieldClazz == String.class) {
					field.set(obj, strValue);
				} else if (fieldClazz == Integer.class
						|| fieldClazz == int.class) {
					field.set(obj, CellDataReader.readInt(strValue));
				} else if (fieldClazz == short.class
						|| fieldClazz == Short.class) {
					field.set(obj, CellDataReader.readShort(strValue));
				} else if (fieldClazz == long.class || fieldClazz == Long.class) {
					field.set(obj, CellDataReader.readLong(strValue));
				} else if (fieldClazz == float.class
						|| fieldClazz == Float.class) {
					int decimal = Integer.parseInt(excelField.getExcelField()
							.decimal());
					field.set(obj, CellDataReader.readFloat(strValue, decimal));
				} else if (fieldClazz == double.class
						|| fieldClazz == Double.class) {
					int decimal = Integer.parseInt(excelField.getExcelField()
							.decimal());
					field.set(obj, CellDataReader.readDouble(strValue, decimal));
				} else if (fieldClazz == BigInteger.class) {
					field.set(obj, CellDataReader.readBigInteger(strValue));
				} else if (fieldClazz == BigDecimal.class) {
					int decimal = Integer.parseInt(excelField.getExcelField()
							.decimal());
					field.set(obj,
							CellDataReader.readBigDecimal(strValue, decimal));
				} else if (fieldClazz == Date.class) {
					String dateFormat = excelField.getExcelField().dateFormat();
					field.set(obj,
							CellDataReader.readDate(strValue, dateFormat));
				}
			}
			list.add(obj);
		}
	}

}
