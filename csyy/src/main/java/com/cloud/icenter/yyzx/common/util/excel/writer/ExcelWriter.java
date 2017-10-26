package com.cloud.icenter.yyzx.common.util.excel.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cloud.icenter.common.utils.ZipUtil;
import com.cloud.icenter.yyzx.common.util.excel.AnnotationFieldUtil;
import com.cloud.icenter.yyzx.common.util.excel.ExcelConstants;
import com.cloud.icenter.yyzx.common.util.excel.ExcelFieldInfo;
import com.cloud.icenter.yyzx.common.util.excel.RegexUtil;
import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelField;
import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelObject;

/**
 * Excel输出器
 */
public class ExcelWriter<T> {
	private int maxSheets = 10;
	private int maxSheetRows = 65535;
	private Sheet currentSheet;
	private Workbook currentWorkBook;

	private List<String> sheetTittles;

	private InputStream templateIn;

	// private CellStyle cellStyle;

	private int version;

	private String sheetName;
	private int currentSheetIndex = 1;

	private int startRow;
	private int startColumn;
	private Class<T> clazz;
	private Method method;
	private int nowSheetRowIndex;
	private Map<String, ExcelFieldInfo> fieldsMap;
	private Workbook subWorkBook;
	private String fileName;
	private File filePath;
	private String fileSuffix;

	private String finalFile;

	private int fileType = -1;
	private boolean pushing = false;

	private static final SimpleDateFormat DEFAULT_DATEFORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");

	public void setStartRow(int startRow) {
		this.startRow = startRow;
		this.nowSheetRowIndex = this.startRow;
	}

	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}

	public ExcelWriter(InputStream templateIn, String fileName,
			String filePath, int version, String sheetName, Class<T> clazz) {
		this.version = version;
		this.templateIn = templateIn;
		this.sheetName = sheetName;
		this.clazz = clazz;
		this.fileName = fileName;
		this.filePath = new File(filePath + File.separator
				+ UUID.randomUUID().toString() + File.separator + fileName);
		init();
	}

	private void createNewWorkBook() {
		try {
			switch (this.version) {
			case ExcelConstants.OFFICE_2003:
				this.currentWorkBook = new HSSFWorkbook(templateIn);
				this.subWorkBook = this.currentWorkBook;
				this.fileSuffix = ".xls";
				break;
			case ExcelConstants.OFFICE_2007:
				XSSFWorkbook tempWorkBook = new XSSFWorkbook(templateIn);
				this.currentWorkBook = new SXSSFWorkbook(tempWorkBook, 1000);
				this.subWorkBook = tempWorkBook;
				this.fileSuffix = ".xlsx";
				break;
			case ExcelConstants.OFFICE_2010:
				XSSFWorkbook tempWorkBook1 = new XSSFWorkbook(templateIn);
				this.currentWorkBook = new SXSSFWorkbook(tempWorkBook1, 1000);
				this.subWorkBook = tempWorkBook1;
				this.fileSuffix = ".xlsx";
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.nowSheetRowIndex = this.startRow;
		createNewSheet();
	}

	private void init() {
		ExcelObject excelObject = clazz.getAnnotation(ExcelObject.class);
		if (null != excelObject) {
			try {
				method = ExcelWriter.class.getDeclaredMethod("objectPush",
						new Class[] { Object.class });
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				method = ExcelWriter.class.getDeclaredMethod("otherPush",
						new Class[] { Object.class });
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		method.setAccessible(true);
		// 文件存放目录
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		this.fieldsMap = AnnotationFieldUtil.fieldMaps(this.clazz);
		createNewWorkBook();
	}

	private void createNewSheet() {
		this.pushing = false;
		this.currentSheet = this.subWorkBook.cloneSheet(0);
		this.currentWorkBook.setSheetName(this.currentSheetIndex,
				this.sheetName + this.currentSheetIndex);
		this.currentSheetIndex++;
		if (this.currentSheetIndex > maxSheets) {
			writeToFile();
			createNewWorkBook();
			this.currentSheetIndex = 1;
		}
	}

	private void writeToFile() {
		File[] files = this.filePath.listFiles();
		String fileTrueName = this.fileName + this.fileSuffix;
		if (files.length > 0) {
			fileTrueName = this.fileName + files.length + this.fileSuffix;
		}
		File file = new File(this.filePath.getPath() + File.separator
				+ fileTrueName);
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			this.currentWorkBook.removeSheetAt(0);
			this.currentWorkBook.write(out);
		} catch (Exception e) {
		} finally {
			try {
				if (null != out) {
					out.flush();
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void push(List<T> list) {
		int size = list.size();
		try {
			for (int i = 0; i < size; i++) {
				method.invoke(this, list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void objectPush(T object) throws Exception {
		Row row = this.currentSheet.createRow(this.nowSheetRowIndex++);
		if (this.nowSheetRowIndex > maxSheetRows) {
			createNewSheet();
		}
		Iterator<Entry<String, ExcelFieldInfo>> it = fieldsMap.entrySet()
				.iterator();
		while (it.hasNext()) {
			this.pushing = true;
			Entry<String, ExcelFieldInfo> en = it.next();
			String key = en.getKey();
			ExcelFieldInfo excelFieldInfo = en.getValue();
			ExcelField excelField = excelFieldInfo.getExcelField();
			String decimalStr = excelField.decimal();
			String dateFormat = excelField.dateFormat();
			int decimal = 0;
			if (null != decimalStr && decimalStr.trim().length() > 0
					&& RegexUtil.isNumber(decimalStr.trim())) {
				decimal = Integer.parseInt(decimalStr.trim());
			}
			if (RegexUtil.isNumber(key)) {
				Cell cell = row.createCell(Integer.parseInt(key) - 1);
				Field field = excelFieldInfo.getField();
				Class<?> fieldClazz = field.getType();
				Object valueObj = field.get(object);
				if (null == valueObj) {
					continue;
				}
				if (fieldClazz == String.class) {
					cell.setCellValue(valueObj.toString());
				} else if (fieldClazz == Integer.class
						|| fieldClazz == int.class) {
					cell.setCellValue(Integer.parseInt(valueObj.toString()));
				} else if (fieldClazz == short.class
						|| fieldClazz == Short.class) {
					cell.setCellValue(Short.parseShort(valueObj.toString()));
				} else if (fieldClazz == long.class || fieldClazz == Long.class) {
					cell.setCellValue(Long.parseLong(valueObj.toString()));
				} else if (fieldClazz == float.class
						|| fieldClazz == Float.class) {
					BigDecimal bigDecimal = new BigDecimal(valueObj.toString());
					bigDecimal = bigDecimal.setScale(decimal,
							BigDecimal.ROUND_HALF_UP);
					cell.setCellValue(bigDecimal.toPlainString());
				} else if (fieldClazz == double.class
						|| fieldClazz == Double.class) {
					BigDecimal bigDecimal = new BigDecimal(valueObj.toString());
					bigDecimal = bigDecimal.setScale(decimal,
							BigDecimal.ROUND_HALF_UP);
					cell.setCellValue(bigDecimal.toPlainString());
				} else if (fieldClazz == BigInteger.class) {
					BigInteger bigInteger = new BigInteger(valueObj.toString());
					cell.setCellValue(bigInteger.toString());
				} else if (fieldClazz == BigDecimal.class) {
					BigDecimal bigDecimal = new BigDecimal(valueObj.toString());
					bigDecimal = bigDecimal.setScale(decimal,
							BigDecimal.ROUND_HALF_UP);
					cell.setCellValue(bigDecimal.toPlainString());
				} else if (fieldClazz == Date.class) {
					SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
					cell.setCellValue(sdf.format((Date) valueObj));
				}
			}
		}
	}

	public List<Object> changeDate(T object) {
		return new ArrayList<Object>();
	}

	protected void otherPush(T object) {
		Row row = this.currentSheet.createRow(this.nowSheetRowIndex++);
		List<Object> listField = changeDate(object);
		int size = listField.size();
		int tempStartCloumn = startColumn;
		for (int i = 0; i < size; i++) {
			this.pushing = true;
			Object valueObj = listField.get(i);
			if (null == valueObj) {
				continue;
			}
			Cell cell = row.createCell(tempStartCloumn++);
			Class<?> tempClazz = valueObj.getClass();
			if (tempClazz == String.class) {
				cell.setCellValue(valueObj.toString());
			} else if (tempClazz == Integer.class || tempClazz == int.class) {
				cell.setCellValue(Integer.parseInt(valueObj.toString()));
			} else if (tempClazz == short.class || tempClazz == Short.class) {
				cell.setCellValue(Short.parseShort(valueObj.toString()));
			} else if (tempClazz == long.class || tempClazz == Long.class) {
				cell.setCellValue(Long.parseLong(valueObj.toString()));
			} else if (tempClazz == float.class || tempClazz == Float.class) {
				BigDecimal bigDecimal = new BigDecimal(valueObj.toString());
				cell.setCellValue(bigDecimal.toPlainString());
			} else if (tempClazz == double.class || tempClazz == Double.class) {
				BigDecimal bigDecimal = new BigDecimal(valueObj.toString());
				cell.setCellValue(bigDecimal.toPlainString());
			} else if (tempClazz == BigInteger.class) {
				BigInteger bigInteger = new BigInteger(valueObj.toString());
				cell.setCellValue(bigInteger.toString());
			} else if (tempClazz == BigDecimal.class) {
				BigDecimal bigDecimal = new BigDecimal(valueObj.toString());
				cell.setCellValue(bigDecimal.toPlainString());
			} else if (tempClazz == Date.class) {
				cell.setCellValue(DEFAULT_DATEFORMAT.format((Date) valueObj));
			}
		}

	}

	public void flush() {
		if (this.pushing) {
			writeToFile();
		}
		try {
			File[] files = this.filePath.listFiles();
			if (files.length > 1) {// 压缩
				this.finalFile = this.filePath.getParent();
				ZipUtil.zip(this.filePath.getPath(), finalFile, this.fileName);
				fileType = ExcelConstants.FILE_TYPE_ZIP;
			} else if (files.length == 1) {
				this.finalFile = files[0].toString();
				fileType = ExcelConstants.FILE_TYPE_EXCEL;
			}
			// this.currentWorkBook.write(this.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getFileType() {
		if (this.fileType == -1) {
			new Exception("Please flush the excel!");
		}
		return this.fileType;
	}

	public String getFinalFile() {
		if (this.fileType == -1) {
			new Exception("Please flush the excel!");
		}
		return this.finalFile;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		if (this.fileType == -1) {
			new Exception("Please flush the excel!");
		}
		return new FileInputStream(this.finalFile);
	}

	public String getFinalFileName() {
		if (this.fileType == -1) {
			new Exception("Please flush the excel!");
		}
		return new File(this.finalFile).getName();
	}
}
