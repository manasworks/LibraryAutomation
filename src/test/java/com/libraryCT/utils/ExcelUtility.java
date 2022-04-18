package com.libraryCT.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains Excel related methods
 */
public class ExcelUtility {

	static Workbook book;
	static Sheet sheet;

	public static void openExcel(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void getSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	public static int getRowsCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int getColsCount(int rowNum) {
		return sheet.getRow(rowNum).getPhysicalNumberOfCells();
	}

	public static String getCellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	public static List<Map<String, String>> excelToListMap(String filePath, String sheet) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map;
		openExcel(filePath);
		getSheet(sheet);
		for (int r = 1; r < getRowsCount(); r++) {
			map = new LinkedHashMap<String, String>();
			for (int c = 0; c < getColsCount(r); c++) {
				String key = getCellData(0, c);
				String value = getCellData(r, c);
				map.put(key, value);
			}
			list.add(map);
		}
		return list;

	}

	public static void saveIntoExcel(String fromFilePath, String sheet, int rowNum, int colNum, String value,
			String outputFilePath) {
		openExcel(fromFilePath);
		getSheet(sheet);
		book.getSheet(sheet).getRow(rowNum).createCell(colNum).setCellValue(value);
		try {
			FileOutputStream fos = new FileOutputStream(outputFilePath);
			book.write(fos);
			book.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
