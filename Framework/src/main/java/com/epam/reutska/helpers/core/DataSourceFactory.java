package com.epam.reutska.helpers.core;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.epam.reutska.configuration.TestConfig;
import com.epam.reutska.dataprovider.TestDataProvider;

public class DataSourceFactory{
	
	private static final Logger LOG = Logger.getLogger(TestDataProvider.class);
	   public IReader getReader() throws IOException{
		   IReader read=null;
		   switch (TestConfig.getSourceData()) {
			case "excel":
				Reporter.log("Read from :" + TestConfig.getExcelFilePath());
				 read = new ExcelRead(TestConfig.getExcelFilePath());
				return read;
			case "xml":
				Reporter.log("Read from :" + TestConfig.getXMLFilePath());
				 read = new XMLReader(TestConfig.getXMLFilePath());
				return read;
			default:
				LOG.error("DataSource isn't correct");
				Reporter.log("DataSource isn't correct");
				throw new IllegalArgumentException("DataSource isn't correct");
			}
		
		   
	   }
	}