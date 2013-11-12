package com.epam.reutska.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.epam.reutska.configuration.TestConfig;
import com.epam.reutska.helpers.core.DataSourceFactory;

public class TestDataProvider {
	//private static final Logger LOG = Logger.getLogger(TestDataProvider.class);
	private static DataSourceFactory dataSourceFactory= new DataSourceFactory();
	
	@DataProvider
	public static Object[][] readPositiveTest() throws IOException {
		return dataSourceFactory.getReader().read(TestConfig.getSheetForPositiveTest());
	}

	@DataProvider
	public static Object[][] readPositiveSortPriceTest() throws IOException {
		return dataSourceFactory.getReader().read(TestConfig.getSheetForPositiveSortPriceTest());
	}

}
