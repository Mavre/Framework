package com.epam.reutska.helpers.core;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.reutska.configuration.TestConfig;
import com.epam.reutska.dataprovider.TestDataProvider;

public class DataSourceFactory{
	
	private static final Logger LOG = Logger.getLogger(TestDataProvider.class);
	   public Object[][] readAll(int sheetNumber) throws IOException{
	
		   switch (TestConfig.getSourceData()) {
			case "excel":
				IReader read = new ExcelRead(TestConfig.getExcelFilePath());
				return read.read(sheetNumber);
			default:
				LOG.error("DataSource isn't correct");
				throw new IllegalArgumentException("DataSource isn't correct");
			}
		
		   
	   }
	}