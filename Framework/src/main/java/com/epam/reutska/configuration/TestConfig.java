package com.epam.reutska.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestConfig {
	private static final Logger LOG = Logger.getLogger(TestConfig.class);

	private static final String sFileName = "config.properties";

	private static String sDirSeparator = System.getProperty("file.separator");

	private static Properties props = new Properties();
	
	static {
		try {
			File currentDir = new File(".");

			String sFilePath = currentDir.getCanonicalPath() + sDirSeparator
					+ sFileName;
			FileInputStream ins = new FileInputStream(sFilePath);

			// загружаем свойства

			props.load(ins);
		} catch (IOException e) {
			LOG.error("Can not read props", e);
			e.printStackTrace();
		}

	}

	public static Capabilities getCapabilities() {
		String browser;
		if (System.getProperty("browser") != null){
			browser = System.getProperty("browser");
		} else {
			browser = props.getProperty("browser");
		}
		switch (browser) {
		case "firefox":
			return DesiredCapabilities.firefox();
		case "opera":
			return DesiredCapabilities.opera();
		case "internetExplorer":
			return DesiredCapabilities.internetExplorer();
		case "chrome":
			return DesiredCapabilities.chrome();

		default:
			LOG.error("Browser's property is incorrect");
			throw new IllegalArgumentException(
					"Browser's property is incorrect");
		}
	}

	// private static String server = "http://localhost/Maslova/";

	private static volatile String className = "";

	private static int excelSheetForPositiveTest = 0;

	private static int excelSheetForPositiveSortPriceTest = 1;

	public static void setTestName(String className) {
		TestConfig.className = className;
	}

	// Getters
	public static int getSheetForPositiveTest() {
		return excelSheetForPositiveTest;
	}

	public static int getSheetForPositiveSortPriceTest() {
		return excelSheetForPositiveSortPriceTest;
	}

	/*
	 * public static String getMailFolderPath() { return mailFolderPath; }
	 */

	public static String getExcelFilePath() {
		return String.format(props.getProperty("srcExcel"), className);
	}
	public static String getXMLFilePath() {
		return String.format(props.getProperty("srcXML"), className);
	}

	public static String getSourceData() {
		return props.getProperty("sourceData");
	}
	public static String  getOperaBinaryPath(){
		return props.getProperty("operaBinaryPath");
		
	}
	public static String  getInternetExplorerPath(){
		return props.getProperty("internetExplorerPath");
		
	}
	public static String  getChromePath(){
		return props.getProperty("chromePath");
		
	}
	
	
	
	/*
	 * public static String getServer() { return server; }
	 */

}
