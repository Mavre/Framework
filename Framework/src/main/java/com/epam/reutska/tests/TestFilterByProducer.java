package com.epam.reutska.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.reutska.dataprovider.TestDataProvider;
import com.epam.reutska.helpers.testsupport.FilterPageHelper;
import com.epam.reutska.helpers.testsupport.TestBase;
import com.epam.reutska.pages.FilterPage;

public class TestFilterByProducer extends TestBase {
	FilterPage filterPage;

	@BeforeMethod
	public void initPages() {
		filterPage = new FilterPage(driver);

	}

	@Test(dataProvider = "readPositiveTest", dataProviderClass = TestDataProvider.class)
	public void testFilterByProducer(String category, String filterName)
			throws Exception {
		goToMainPage();
		filterPage.goToCategoryGood(mainPage, category);

		FilterPageHelper.verifyFilterOptionByProducer(filterPage, filterName);

	}

}
