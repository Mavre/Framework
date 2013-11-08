package com.epam.reutska.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.reutska.dataprovider.TestDataProvider;
import com.epam.reutska.helpers.testsupport.FilterPageHelper;
import com.epam.reutska.helpers.testsupport.TestBase;
import com.epam.reutska.pages.FilterPage;

public class WeightAdjustment extends TestBase {
	FilterPage filterPage;

	@BeforeMethod
	public void initPages() {
		filterPage = new FilterPage(driver);

	}

	@Test(dataProvider = "readPositiveTest", dataProviderClass = TestDataProvider.class)
	public void testWeightAdjustment(String category, String filterName,
			String filterParam) throws Exception {
		filterPage.goToCategoryGood(mainPage, category);
		FilterPageHelper.verifyFilterOptionByWeightAdjustment(filterPage,
				filterName, filterParam);

	}
}
