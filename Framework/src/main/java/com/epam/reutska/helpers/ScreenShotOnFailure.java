package com.epam.reutska.helpers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.epam.reutska.configuration.TestConfig;
import com.epam.reutska.dataprovider.TestDataProvider;
import com.epam.reutska.helpers.core.WebDriverFactory;

public class ScreenShotOnFailure extends TestListenerAdapter {
	private static final Logger LOG = Logger.getLogger(ScreenShotOnFailure.class);
	@Override
	public void onTestFailure(ITestResult tr) {
		WebDriver driver = WebDriverFactory.getDriver(TestConfig
				.getCapabilities());
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ssaa");
		String destDir = "target/surefire-reports/html/screenshots/";
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			LOG.error("Creating file isn't possible",e);
			e.printStackTrace();
		}
		Reporter.setEscapeHtml(false);
		Reporter.log("Saved <a href=screenshots/" + destFile
				+ ">Screenshot</a>");
	}
}
