package com.epam.reutska.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.reutska.components.ComponentSort;
import com.epam.reutska.components.NavigationComponent;
import com.epam.reutska.components.PriceListResultsComponent;
import com.epam.reutska.components.SearchComponent;
import com.epam.reutska.helpers.core.MyPageFactory;

public class PricesPage extends AnyPage {

	private NavigationComponent navigationComponent;
	private PriceListResultsComponent priceListResultsComponent;
	private SearchComponent searchComponent;
	private static final Pattern GOOD_ID = Pattern
			.compile("(?:/|product_id=)([0-9]+)");

	public PricesPage(WebDriver driver) {
		super();
		this.driver = driver;
		refresh();
	}

	public void refresh() {
		priceListResultsComponent = MyPageFactory.getPage(driver,
				PriceListResultsComponent.class);
		navigationComponent = MyPageFactory.getPage(driver,
				NavigationComponent.class);
		searchComponent = MyPageFactory.getPage(driver, SearchComponent.class);
	}

	public NavigationComponent getNavigationComponent() {
		return navigationComponent;
	}

	public PriceListResultsComponent getPriceListResultsComponent() {
		return priceListResultsComponent;
	}

	public void cleanInputSearchField() {

		getSearchComponent().getInputSearch().clear();
	}

	public void writeNameItemInputSearchField(String name) {

		getSearchComponent().getInputSearch().sendKeys(name);
	}

	public void clickSearchButton() {
		getSearchComponent().getInputSearchButton().click();
	}

	public SearchComponent getSearchComponent() {
		return searchComponent;
	}

	public void clickLinkNavigationNext() {
		getNavigationComponent().getLinkNext().click();
	}

	public String getResultItemName(int n) {
		return getPriceListResultsComponent().getResultItemsName().get(n)
				.getAttribute("title");
	}

	public Double getResultItemPrice(int n) {
		return Double.valueOf(getPriceListResultsComponent()
				.getResultItemsPrice().get(n).getText().replaceAll(" ", ""));
	}

	public String getIdResultItem(WebElement row) {
		String id = row.findElement(
				By.xpath(PriceListResultsComponent.RESULT_ITEMS_NAME))
				.getAttribute("href");
		Matcher m = FilterPage.getGoodIdPattern().matcher(id);
		if (m.find()) {
			id = m.group(1);
		}
		return id;
	}

}
