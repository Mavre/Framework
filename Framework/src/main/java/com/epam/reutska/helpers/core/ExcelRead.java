package com.epam.reutska.helpers.core;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelRead implements IReader{

	private String filePath;

	public ExcelRead(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public Object[][] read(int sheetNumber) throws IOException {

		Object[][] data = null;

		FileInputStream file = new FileInputStream(new File(filePath));

		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(sheetNumber);

		HSSFRow row = sheet.getRow(0);

		int numberOfRows = sheet.getLastRowNum();
		int numberOfColumns = row.getLastCellNum();

		data = new Object[numberOfRows][numberOfColumns];

		for (int rowNum = 1; rowNum < numberOfRows + 1; rowNum++) {

			for (int cellNum = 0; cellNum < numberOfColumns; cellNum++) {

				Cell cell = sheet.getRow(rowNum).getCell(cellNum);

			
				if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {

					data[rowNum - 1][cellNum] = " ";

				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

					data[rowNum - 1][cellNum] = cell.getNumericCellValue();

				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				
					data[rowNum - 1][cellNum] = cell.getStringCellValue();
				}
			}

		}

		file.close();
		return data;
	}

	

}
