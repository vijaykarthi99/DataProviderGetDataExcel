package com.getData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {
	public static String[][] getExcelData() throws IOException {
		File f = new File("D:\\JavaClassProjectsEclipse\\DataProviderGetDataExcel\\Excel\\empDetails.xlsx");
		FileInputStream stream = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(stream);
		XSSFSheet sheet = w.getSheet("roll");
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				data[i - 1][j] = value;
				// System.out.println(value);

			}

		}
		return data;
	}
}
