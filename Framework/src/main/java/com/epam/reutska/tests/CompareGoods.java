package com.epam.reutska.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.reutska.dataprovider.TestDataProvider;
import com.epam.reutska.helpers.testsupport.CompareGoodsPageHelper;
import com.epam.reutska.helpers.testsupport.TestBase;
import com.epam.reutska.pages.CompareGoodsPage;
import com.epam.reutska.pages.FilterPage;

public class CompareGoods extends TestBase {
	FilterPage filterPage;
	CompareGoodsPage compareGoodsPage;

	@BeforeMethod
	public void initPages() {
		filterPage = new FilterPage(driver);
		compareGoodsPage = new CompareGoodsPage(driver);
	}

	@Test(dataProvider = "readPositiveTest", dataProviderClass = TestDataProvider.class)
	public void compareGoods(String category) throws Exception {
		filterPage.goToCategoryGood(mainPage, category);
		CompareGoodsPageHelper.verifyComparingTwoGoods(filterPage,
				compareGoodsPage);
	}

}
