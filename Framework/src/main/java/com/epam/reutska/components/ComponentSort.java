package com.epam.reutska.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComponentSort extends Component {

	private static final String LINK_SORT_NAME = "//a[contains(@href,'sort=name')]";
	private static final String LINK_SORT_PRICE = "//a[contains(@href,'sort=price')]";

	public ComponentSort(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ComponentSort.LINK_SORT_NAME)
	private WebElement linkSortName;
	@FindBy(xpath = ComponentSort.LINK_SORT_PRICE)
	private WebElement linkSortPrice;

	public WebElement getLinkSortName() {
		return linkSortName;
	}

	public WebElement getLinkSortPrice() {
		return linkSortPrice;
	}

}
