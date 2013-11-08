package com.epam.reutska.pages;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.reutska.components.ComponentSort;
import com.epam.reutska.components.FilterResultsComponents;
import com.epam.reutska.components.NavigationComponent;
import com.epam.reutska.components.filteroption.FilterOptionComponent;
import com.epam.reutska.helpers.core.MyPageFactory;

public class FilterPage extends AnyPage {
	private ComponentSort componentSort;
	private FilterResultsComponents filterResultsComponents;
	private NavigationComponent navigationComponent;
	private FilterOptionComponent filterOptionComponent;

	private static final Pattern GOOD_ID = Pattern
			.compile("(?:\\/|product_id=)([0-9]+)");

	public FilterPage(WebDriver driver) {
		super();
		this.driver = driver;
		refresh();
	}

	public void refresh() {
		componentSort = MyPageFactory.getPage(driver, ComponentSort.class);
		filterResultsComponents = MyPageFactory.getPage(driver,
				FilterResultsComponents.class);
		navigationComponent = MyPageFactory.getPage(driver,
				NavigationComponent.class);
		filterOptionComponent = MyPageFactory.getPage(driver,
				FilterOptionComponent.class);
	}

	public FilterOptionComponent getFilterOptionComponent() {
		return filterOptionComponent;
	}

	public ComponentSort getComponentSort() {
		return componentSort;
	}

	public FilterResultsComponents getFilterResultsComponents() {
		return filterResultsComponents;
	}

	public NavigationComponent getNavigationComponent() {
		return navigationComponent;
	}

	public static Pattern getGoodIdPattern() {
		return GOOD_ID;
	}

	public void goToCategoryGood(MainPage mainPage, String category) {
		mainPage.getCategoryComponent().getLinkCategory(category).click();
	}

	public void clickLinkGoToPricesPage() {

		getNavigationComponent().getLinkGoToPricesPage().click();
	}

	public void clickLinkResultItemFirstAddCompare() {
		getFilterResultsComponents().getLinkResultItemFirstAddCompare().click();
	}

	public void clickLinkResultItemSecondAddCompare() {
		getFilterResultsComponents().getLinkResultItemSecondAddCompare()
				.click();
	}

	public void clickLinkGoToComparingPage() {
		getFilterResultsComponents().getGoToComparingPage().click();
	}

	public void clickLinkNavigationNext() {
		getNavigationComponent().getLinkNext().click();
	}

	public String getItemName(WebElement row) {
		return 
				getItemNameElement(row).getText();
	}

	public Double getItemPrice(WebElement row) {
		return Double
				.valueOf(row
						.findElement(
								By.xpath(FilterResultsComponents.LINK_RESULT_ITEM_PRICE))
						.getText().replaceAll("( )|(грн)", ""));
	}

	public String getItemDescription(WebElement row) {
		return row
				.findElement(
						By.cssSelector(FilterResultsComponents.DESCRIPTION_RESULT_ITEMS))
				.getText();
	}

	public String getItemId(WebElement row) {

		return row.findElement(By.xpath(FilterResultsComponents.LINK_RESULT_ITEM_NAME))
				.getAttribute("href");
	}
	public void clickItemName(WebElement row){
		getItemNameElement(row).click();
	}
	private WebElement  getItemNameElement(WebElement row){
		return row.findElement(
				By.xpath(FilterResultsComponents.LINK_RESULT_ITEM_NAME));
	}

	public void back() {
		driver.navigate().back();	
		refresh();
	}

	public void clickLinkSortName() {
		getComponentSort().getLinkSortName().click();		
	}

	public void clickLinkSortPrice() {
		getComponentSort().getLinkSortPrice().click();		
	}

	public void clickFilterOptionValue(String filterName, String filterValue) {
			getFilterOptionComponent()
			.getFilterOptionLocator(filterName,
					filterValue)
			.click();
		
	}

	public void clickLinkShowAllProducers() {
		getFilterOptionComponent().getLinkShowAllProducers().click();		
	}
}
