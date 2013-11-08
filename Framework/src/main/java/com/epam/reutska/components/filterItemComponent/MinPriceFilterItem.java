package com.epam.reutska.components.filterItemComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MinPriceFilterItem extends FilterItemComponent {
	// public static final String MIN_PRICE_FILTER =
	// "//div[contains(text(),'Минимальная цена, грн:')]/../div[@class='is_empty_items']/a";

	private static final String MIN_PRICE_FILTER = "//div[@class='panel corner criteria']//a[contains(.,'%s')]";
	// String selector = String.format(MIN_PRICE_FILTER, filterName);
	@FindBy(xpath = MIN_PRICE_FILTER)
	private WebElement minPriceFilter;

	public MinPriceFilterItem(WebDriver driver) {
		super(driver);
	}

	public WebElement getMinPriceFilter() {
		return minPriceFilter;
	}
}
