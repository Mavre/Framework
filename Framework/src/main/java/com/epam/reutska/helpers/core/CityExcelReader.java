package com.epam.reutska.citygame.datasource;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class CityExcelReader implements IReader<String> {
	private String citiesPath;

	public CityExcelReader(String citiesPath) {
		this.citiesPath = citiesPath;
	}

	@Override
	public void write(Set<String> set) throws DataSourceException {
		//Set<String> set = new HashSet<String>();
		File exlFile = new File(citiesPath);
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(exlFile);

			WritableSheet writableSheet = writableWorkbook.createSheet(
					"Sheet1", 0);

			// Create Cells with contents of different data types.
			// Also specify the Cell coordinates in the constructor
			int y = 0;
			for (String str : set) {
				Label label = new Label(0, y++, str);

				writableSheet.addCell(label);
			}

			// Add the created Cells to the sheet

			// Write and close the workbook
			writableWorkbook.write();
			writableWorkbook.close();
		} catch (IOException  | WriteException e) {
			throw new DataSourceException(e);
		}

	}

	@Override
	public Set<String> read() throws DataSourceException {
		Set<String> set = new HashSet<String>();
		File inputWorkbook = new File(citiesPath);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			// Loop over first 10 column and lines

			for (int j = 0; j < sheet.getColumns(); j++) {
				for (int i = 0; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					set.add(cell.getContents());
				}
			}
			/*
			 * CellType type = cell.getType(); if (type == CellType.LABEL) {
			 * System.out.println("I got a label " + cell.getContents()); }
			 * 
			 * if (type == CellType.NUMBER) {
			 * System.out.println("I got a number " + cell.getContents()); }
			 * 
			 * }
			 */

		} catch (BiffException | IOException e) {
			throw new DataSourceException(e);
		}
		return set;
	}

}
