package com.epam.reutska.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.reutska.dataprovider.TestDataProvider;
import com.epam.reutska.helpers.testsupport.PricesPageHelper;
import com.epam.reutska.helpers.testsupport.TestBase;
import com.epam.reutska.pages.FilterPage;
import com.epam.reutska.pages.PricesPage;

public class GoodsInformationNameAndPrice extends TestBase {
	FilterPage filterPage;
	PricesPage pricesPage;

	@BeforeMethod
	public void initPages() {
		filterPage = new FilterPage(driver);
		pricesPage = new PricesPage(driver);
	}

	@Test(dataProvider = "readPositiveTest", dataProviderClass = TestDataProvider.class)
	public void testGoodsInformationNamePrice(String category) throws Exception {
		filterPage.goToCategoryGood(mainPage, category);
		PricesPageHelper.verifyGoodsInformationNamePrices(filterPage,
				pricesPage);

	}

}
