package com.epam.reutska.helpers.testsupport;

import static org.testng.Assert.assertTrue;

import com.epam.reutska.domain.BaseGood;
import com.epam.reutska.pages.CompareGoodsPage;
import com.epam.reutska.pages.FilterPage;

public class CompareGoodsPageHelper {
	private static BaseGood firstGood;
	private static BaseGood secondGood;
	private static BaseGood firstGoodForCompare;
	private static BaseGood secondGoodForCompare;

	public static void compareHasDifferent(CompareGoodsPage compareGoodsPage) throws Exception {
		for (String key : firstGoodForCompare.getParam().keySet()) {
			if (!firstGoodForCompare.getParam().get(key)
					.equals(secondGoodForCompare.getParam().get(key))) {
				assertTrue(compareGoodsPage.getCompareGoodsComponent()
						.isDifferent(key));
			}
		}

	}
	public static void compareGoodsFirst() throws Exception {
		assertTrue(firstGood.equals(firstGoodForCompare), firstGood
				+ " equals " + firstGoodForCompare);
	}
	public void compareGoodsSecond() throws Exception {
		assertTrue(secondGood.equals(secondGoodForCompare), secondGood
				+ " equals " + secondGoodForCompare);
	}
	public static void verifyComparingTwoGoods(FilterPage filterPage,CompareGoodsPage compareGoodsPage){
		

		firstGood = FilterPageHelper.getItem(filterPage,0, true);

		secondGood = FilterPageHelper.getItem(filterPage,1, true);

		filterPage.clickLinkResultItemFirstAddCompare();

		filterPage.clickLinkResultItemSecondAddCompare();

		filterPage.clickLinkGoToComparingPage();
		
		firstGoodForCompare = compareGoodsPage.getCompareGoodsComponent()
				.getItem(0);
		secondGoodForCompare = compareGoodsPage.getCompareGoodsComponent()
				.getItem(1);
	}
}
