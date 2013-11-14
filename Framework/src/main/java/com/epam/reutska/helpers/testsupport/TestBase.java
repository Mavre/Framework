package com.epam.reutska.helpers.testsupport;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;

import com.epam.reutska.configuration.TestConfig;
import com.epam.reutska.helpers.core.WebDriverFactory;
import com.epam.reutska.pages.MainPage;

public class TestBase {
	protected WebDriver driver;
	protected String baseUrl;
	protected WebDriverWait wait;

	protected StringBuffer verificationErrors = new StringBuffer();
	protected MainPage mainPage;

	@BeforeTest
	public void init() {
		TestConfig.setTestName(this.getClass().getSimpleName());
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = WebDriverFactory.getDriver(TestConfig.getCapabilities());
		if (System.getProperty("baseURL").isEmpty()) {
			baseUrl = TestConfig.getBaseURL();
		} else {
			baseUrl = System.getProperty("baseURL");
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		goToMainPage();
	}

	protected MainPage goToMainPage() {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver.get(baseUrl + "/");
		mainPage = new MainPage(driver);
		PageFactory.initElements(driver, mainPage);
		return mainPage;
	}

}
