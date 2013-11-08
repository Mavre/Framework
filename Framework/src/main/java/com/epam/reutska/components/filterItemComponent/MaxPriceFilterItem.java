package com.epam.reutska.components.filterItemComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaxPriceFilterItem extends FilterItemComponent {
	// public static final String MIN_PRICE_FILTER =
	// "//div[contains(text(),'Минимальная цена, грн:')]/../div[@class='is_empty_items']/a";
	private static final String MAX_PRICE_FILTER = "//div[@class='panel corner criteria']//a[contains(.,'%s')]";
	// String selector = String.format(MIN_PRICE_FILTER, filterName);

	@FindBy(xpath = MAX_PRICE_FILTER)
	private WebElement maxPriceFilter;

	public MaxPriceFilterItem(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getMaxPriceFilter() {
		return maxPriceFilter;
	}
}
