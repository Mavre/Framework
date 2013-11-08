package com.epam.reutska.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.reutska.dataprovider.TestDataProvider;
import com.epam.reutska.helpers.testsupport.FilterPageHelper;
import com.epam.reutska.helpers.testsupport.TestBase;
import com.epam.reutska.pages.CompareGoodsPage;
import com.epam.reutska.pages.FilterPage;

public class TestFilterByPrice extends TestBase {
	FilterPage filterPage;
	CompareGoodsPage compareGoodsPage;

	@BeforeMethod
	public void initPages() {
		filterPage = new FilterPage(driver);
		compareGoodsPage = new CompareGoodsPage(driver);

	}

	@Test(dataProvider = "readPositiveTest", dataProviderClass = TestDataProvider.class)
	public void testFilterByPrice(String category, String filterNameMinPrice,
			Object filterValueMinPrice, String filterNameMaxPrice,
			Object filterValueMaxPrice) throws Exception {
		goToMainPage();

		filterPage.goToCategoryGood(mainPage, category);
		FilterPageHelper.verifyFilterOptionByPrice(filterPage,
				filterNameMinPrice, filterValueMinPrice, filterNameMaxPrice,
				filterValueMaxPrice);

	}
}
