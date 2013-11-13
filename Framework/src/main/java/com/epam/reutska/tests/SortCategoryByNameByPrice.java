

package com.epam.reutska.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.reutska.dataprovider.TestDataProvider;
import com.epam.reutska.helpers.testsupport.FilterPageHelper;
import com.epam.reutska.helpers.testsupport.TestBase;
import com.epam.reutska.pages.FilterPage;

public class SortCategoryByNameByPrice extends TestBase {
	FilterPage filterPage;

	@BeforeMethod
	public void initPages() {
		filterPage = new FilterPage(driver);

	}

	@Test(dataProvider = "readPositiveTest", dataProviderClass = TestDataProvider.class)
	public void sortRefrigeratorName(String category) throws Exception {

		filterPage.goToCategoryGood(mainPage, category);
		FilterPageHelper.verifyNameSorting(filterPage);

	}

	@Test(dataProvider = "readPositiveSortPriceTest", dataProviderClass = TestDataProvider.class)
	public void sortRefrigeratorPrice(String category) throws Exception {
		filterPage.goToCategoryGood(mainPage, category);
		FilterPageHelper.verifyPriceSorting(filterPage);
	}
}
