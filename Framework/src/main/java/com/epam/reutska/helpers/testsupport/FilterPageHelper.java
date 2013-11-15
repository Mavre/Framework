package com.epam.reutska.helpers.testsupport;

import static org.testng.Assert.assertTrue;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.epam.reutska.components.SelectedItemComponent;
import com.epam.reutska.domain.BaseGood;
import com.epam.reutska.helpers.core.MyPageFactory;
import com.epam.reutska.pages.FilterPage;

public class FilterPageHelper {

	public static List<BaseGood> getFilterResults(FilterPage filterPage,
			boolean readAllParams) {
		List<BaseGood> results = new ArrayList<>();
		//int i = 0;
		do {
			for (int j = 0; j < filterPage.getFilterResultsComponents()
					.getLinkResultItems().size(); j++) {
				results.add(getItem(filterPage, j, readAllParams));
			}
			if (filterPage.getNavigationComponent().hasNext()) {
				Reporter.log("GoingNextPage"+"<br>");
				filterPage.clickLinkNavigationNext();

				/*i++;
				if (i == 3)
					break;*/

			}
		} while (filterPage.getNavigationComponent().hasNext());

		return results;

	}

	public static BaseGood getItem(FilterPage filterPage, int n,
			boolean readAllParams) {

		WebElement row = filterPage.getFilterResultsComponents()
				.getLinkResultItems().get(n);

		String name = filterPage.getItemName(row);

		Double price = filterPage.getItemPrice(row);

		String description = filterPage.getItemDescription(row);
		String id = filterPage.getItemId(row);
		Matcher m = FilterPage.getGoodIdPattern().matcher(id);
		if (m.find()) {
			id = m.group(1);
		}

		BaseGood baseGood = new BaseGood();

		if (readAllParams) {
			Reporter.log("ChooseOneGood"+"<br>");
			filterPage.clickItemName(row);

			SelectedItemComponent selectedItemComponent = MyPageFactory
					.getPage(filterPage.driver, SelectedItemComponent.class);

			baseGood = selectedItemComponent.getItem();
			filterPage.back();

		}
		baseGood.withName(name);

		baseGood.withPrice(price);
		baseGood.withDescription(description);
		baseGood.setId(Integer.valueOf(id));

		return baseGood;
	}

	public static void verifyNameSorting(FilterPage filterPage) {

		Collator collator = Collator.getInstance();
		Reporter.log("SortingByName"+"<br>");

		filterPage.clickLinkSortName();

		List<BaseGood> list = getFilterResults(filterPage, false);

		for (int i = 1; i < list.size(); i++) {
			assertTrue(
					list.get(i - 1).getName().compareTo(list.get(i).getName()) < 0
							|| collator.compare(list.get(i - 1).getName(), list
									.get(i).getName()) < 0
							|| collator.compare(list.get(i - 1).getName(), list
									.get(i).getName()) == 0, "left name: "
							+ list.get(i - 1).getName() + "; right name: "
							+ list.get(i).getName());
		}

	}

	public static void verifyPriceSorting(FilterPage filterPage) {

		filterPage = new FilterPage(filterPage.driver);
		Reporter.log("SortingByPrice"+"<br>");
		filterPage.clickLinkSortPrice();

		List<BaseGood> list = getFilterResults(filterPage, false);

		for (int i = 1; i < list.size(); i++) {
			assertTrue(list.get(i - 1).getPrice() <= list.get(i).getPrice(),
					"left price: " + list.get(i - 1).getPrice()
							+ "; right price: " + list.get(i).getPrice());
		}

	}

	public static void verifyFilterOptionByPrice(FilterPage filterPage,
			String filterNameMinPrice, Object filterValueMinPrice,
			String filterNameMaxPrice, Object filterValueMaxPrice) {
		Reporter.log("ChooseMinPrice "+  filterValueMinPrice+"<br>");
		filterPage.clickFilterOptionValue(String.valueOf(filterNameMinPrice),
				String.valueOf(filterValueMinPrice).replace(".0", ""));
		Reporter.log("ChooseMaxPrice "+ filterValueMaxPrice+"<br>");
		filterPage.clickFilterOptionValue(String.valueOf(filterNameMaxPrice),
				String.valueOf(filterValueMaxPrice).replace(".0", ""));
		double minPrice =Double.valueOf(filterValueMinPrice.toString());
		double maxPrice = Double.valueOf(filterValueMaxPrice.toString());
		for (BaseGood good : getFilterResults(filterPage, false)) {
			assertTrue(good.getPrice() >= minPrice
					&& good.getPrice() <= maxPrice, good.getPrice() + ">="
					+ minPrice + "&&" + good.getPrice() + "<=" + maxPrice);
		}
	}

	public static void verifyFilterOptionByProducer(FilterPage filterPage,
			String filterName) {
		Reporter.log("ChooseAllProducers"+"<br>");
		filterPage.clickLinkShowAllProducers();

		Set<String> filterSet = new HashSet<>();

		for (WebElement webElement : filterPage.getFilterOptionComponent()
				.getFilterOptionLocatorForProducer(filterName)) {
			filterSet.add(webElement.getText().toUpperCase());
		}

		Set<String> setFilterResults = new HashSet<>();

		for (BaseGood baseGood : getFilterResults(filterPage, false)) {
			setFilterResults.add(baseGood.getName()
					.substring(0, baseGood.getName().indexOf(" "))
					.toUpperCase());
		}

		SortedSet<String> firstSet = new TreeSet<>(filterSet);

		SortedSet<String> secondSet = new TreeSet<>(setFilterResults);
		assertTrue(firstSet.equals(secondSet), "firstSet " + firstSet
				+ "secondSet " + secondSet);
	}

	public static void verifyFilterOptionByWeightAdjustment(
			FilterPage filterPage, String filterName, String filterParam) {
		Reporter.log("ChooseFilterParam "+"\"Регулировка веса\""+"<br>");
		filterPage.clickFilterOptionValue(filterName, filterParam);
		List<BaseGood> itemsDescription = getFilterResults(filterPage, false);
		for (BaseGood goodDescription : itemsDescription) {
			assertTrue(
					goodDescription.getDescription().contains(filterParam),
					"goodDescription.getDescription() "
							+ goodDescription.getDescription() + " filterName"
							+ filterName);
		}
	}
}
