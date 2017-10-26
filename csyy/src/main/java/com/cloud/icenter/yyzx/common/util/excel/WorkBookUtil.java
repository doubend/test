package com.cloud.icenter.yyzx.common.util.excel;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel帮助类<br>
 */
public class WorkBookUtil {
	/**
	 * 根据输入流创建一个Excel对象
	 * 
	 * @Title createWorkBook
	 * @Description TODO
	 * @param in
	 * @return
	 * @throws Exception
	 * @date 2015年11月16日-上午9:40:17
	 * @update
	 *
	 */
	public static Workbook createWorkBook(InputStream in) throws Exception {
		if (!in.markSupported()) {
			in = new PushbackInputStream(in, 8);
		}
		if (POIFSFileSystem.hasPOIFSHeader(in)) {
			return new HSSFWorkbook(in);
		}
		if (POIXMLDocument.hasOOXMLHeader(in)) {
			return new XSSFWorkbook(OPCPackage.open(in));
		}
		throw new Exception("MSG_此Excel版本目前无法解析");
	}

	/**
	 * 判断指定行是否为空
	 * 
	 * @Title rowIsNull
	 * @Description TODO
	 * @param row
	 *            指定行
	 * @param startColumn
	 *            起始列
	 * @param endColumn
	 *            终止列
	 * @return
	 * @date 2015年11月19日-下午7:04:36
	 * @update
	 *
	 */
	public static boolean rowIsNull(Row row, int startColumn, int endColumn) {
		int nullCount = 0;
		int totalColumn = endColumn - startColumn + 1;
		for (; startColumn <= endColumn; startColumn++) {
			Cell cell = row.getCell(startColumn);
			if (null == cell) {
				nullCount++;
				continue;
			}
			String value = getValue(cell);
			if (null == value || value.trim().length() == 0) {
				nullCount++;
			}
		}
		return totalColumn == nullCount;
	}

	/**
	 * 读取Excel中单个Cell的值
	 * 
	 * @Title getValue
	 * @Description TODO
	 * @param cell
	 * @return
	 * @update
	 *
	 */
	public static String getValue(Cell cell) {
		if (null == cell) {
			return null;
		}
		int cellType = cell.getCellType();
		if (cellType == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cellType == Cell.CELL_TYPE_NUMERIC) {
			double doubleValue = cell.getNumericCellValue();
			BigDecimal tempNumber = new BigDecimal(doubleValue);
			String strValue = tempNumber.toString();
			String[] strArray = strValue.split("\\.");
			DecimalFormat df = null;
			if (strArray.length == 2) {
				StringBuilder strb = new StringBuilder();
				strb.append("0");
				for (int i = 0; i < strArray[1].length(); i++) {
					if (i == 0) {
						strb.append(".");
					}
					strb.append("0");
				}
				df = new DecimalFormat(strb.toString());
			} else {
				df = new DecimalFormat("0");
			}
			return df.format(doubleValue);
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}
}
