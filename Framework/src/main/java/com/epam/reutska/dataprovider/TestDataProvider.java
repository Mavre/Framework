package com.epam.reutska.dataprovider;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.epam.reutska.configuration.TestConfig;
import com.epam.reutska.helpers.core.ExcelRead;

public class TestDataProvider {
	private static final Logger LOG = Logger.getLogger(TestDataProvider.class);
	
	@DataProvider
	public static Object[][] readPositiveTest() throws IOException {
		switch (TestConfig.getSourceData()) {
		case "excel":
			ExcelRead read = new ExcelRead(TestConfig.getExcelFilePath());
			return read.readExcel(TestConfig.getSheetForPositiveTest());

		default:
			LOG.error("DataSource isn't correct");
			throw new IllegalArgumentException("DataSource isn't correct");
		}
	}

	@DataProvider
	public static Object[][] readPositiveSortPriceTest() throws IOException {
		switch (TestConfig.getSourceData()) {
		case "excel":
			ExcelRead read = new ExcelRead(TestConfig.getExcelFilePath());
			return read
					.readExcel(TestConfig.getSheetForPositiveSortPriceTest());

		default:
			LOG.error("DataSource isn't correct");
			throw new IllegalArgumentException("DataSource isn't correct");
		}
	}

}
