package com.epam.reutska.helpers.testsupport;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.epam.reutska.domain.BaseGood;
import com.epam.reutska.pages.FilterPage;
import com.epam.reutska.pages.PricesPage;

public class PricesPageHelper {

	public static void verifyGoodsInformationNamePrices(FilterPage filterPage,
			PricesPage pricesPage) {

		List<BaseGood> catalogItems = new ArrayList<>();

		filterPage.clickLinkSortPrice();
		for (int i = 0; i < 4; i++) {
			catalogItems.add(FilterPageHelper.getItem(filterPage, i, false));
		}
		List<BaseGood> itemsAllInformation = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			itemsAllInformation.add(FilterPageHelper.getItem(filterPage, i,
					true));

		}
		filterPage.clickLinkGoToPricesPage();

		List<BaseGood> itemsPricesList = new ArrayList<>();
		List<BaseGood> helpList = new ArrayList<>();
		for (int i = 0; i < itemsAllInformation.size(); i++) {
			pricesPage.cleanInputSearchField();
			pricesPage.writeNameItemInputSearchField(itemsAllInformation.get(i)
					.getName());
			pricesPage.clickSearchButton();
			helpList = PricesPageHelper.getFilterResults(pricesPage);
			for (int j = 0; j < helpList.size(); j++) {
				if (checkPriceInBounds(helpList.get(j),
						itemsAllInformation.get(i))
						&& (helpList.get(j).getName()
								.compareTo(itemsAllInformation.get(i).getName())) == 0) {
					itemsPricesList.add(helpList.get(j));
					break;

				}
			}

		}
		for (int i = 0; i < catalogItems.size(); i++) {

			assertTrue(
					(catalogItems.get(i).getName().compareTo(itemsAllInformation
							.get(i).getName())) == 0
							&& (itemsAllInformation.get(i).getName().compareTo(itemsPricesList
									.get(i).getName())) == 0
							&& checkPriceInBounds(itemsPricesList.get(i),
									itemsAllInformation.get(i))
							&& checkPriceInBounds(catalogItems.get(i),
									itemsAllInformation.get(i)),
					"catalogItems=[ " + catalogItems + " ]"
							+ "itemsPricesList= [ " + itemsPricesList + "] "
							+ "itemsAllInformation= [" + itemsAllInformation
							+ "]");
		}

	}

	private static boolean checkPriceInBounds(BaseGood comparableBaseGood,
			BaseGood minMaxBaseGood) {
		return Math.round(comparableBaseGood.getPrice()) >= minMaxBaseGood
				.getMinBoundaryRangePrice()
				&& Math.round(comparableBaseGood.getPrice()) <= minMaxBaseGood
						.getMaxBoundaryRangePrice();
	}

	public static List<BaseGood> getFilterResults(PricesPage pricesPage) {
		List<BaseGood> results = new ArrayList<>();

		do {
			for (int j = 0; j < pricesPage.getPriceListResultsComponent()
					.getResultItems().size(); j++) {
				results.add(getItem(pricesPage, j));
			}
			if (pricesPage.getNavigationComponent().hasNext()) {
				pricesPage.clickLinkNavigationNext();
			}
		} while (pricesPage.getNavigationComponent().hasNext());

		return results;

	}

	public static BaseGood getItem(PricesPage pricesPage, int n) {

		WebElement row = pricesPage.getPriceListResultsComponent()
				.getResultItems().get(n);

	

		String name = pricesPage.getResultItemName(n);

		Double price = pricesPage.getResultItemPrice(n);

		String id = pricesPage.getIdResultItem(row);
		

		BaseGood baseGood = new BaseGood();

	
		baseGood.withName(name);

		baseGood.withPrice(price);
		baseGood.setId(Integer.valueOf(id));
		// baseGood.withDescription(description);

		return baseGood;
	}

	public static void verifyGoodsInformationLinks(FilterPage filterPage,
			PricesPage pricesPage) {

		List<BaseGood> catalogItems = new ArrayList<>();

		filterPage.clickLinkSortPrice();
		for (int i = 0; i < 4; i++) {
			catalogItems.add(FilterPageHelper.getItem(filterPage,i, false));
		}
		List<BaseGood> itemsAllInformation = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			itemsAllInformation.add(FilterPageHelper.getItem(filterPage,i, true));

		}
		filterPage.clickLinkGoToPricesPage();

		List<BaseGood> itemsPricesList = new ArrayList<>();
		List<BaseGood> helpList = new ArrayList<>();
		
		for (int i = 0; i < itemsAllInformation.size(); i++) {
			pricesPage.cleanInputSearchField();
			pricesPage.writeNameItemInputSearchField(itemsAllInformation.get(i).getName());
			
			pricesPage.clickSearchButton();
			helpList = PricesPageHelper.getFilterResults(pricesPage);
			for (int j = 0; j < helpList.size(); j++) {
				if (checkPriceInBounds(helpList.get(j),
						itemsAllInformation.get(i))
						&& (helpList.get(j).getName()
								.compareTo(itemsAllInformation.get(i).getName())) == 0) {
					itemsPricesList.add(helpList.get(j));
					break;

				}
			}

		}
		for (int i = 0; i < catalogItems.size(); i++) {

			assertTrue(
					(catalogItems.get(i).getId() == itemsPricesList.get(i)
							.getId())
							&& (catalogItems.get(i).getId() == itemsAllInformation
									.get(i).getId()), "catalogItems=[ "
							+ catalogItems + " ]" + "itemsPricesList= [ "
							+ itemsPricesList + "] " + "itemsAllInformation= ["
							+ itemsAllInformation + "]");
		}
	}

}
