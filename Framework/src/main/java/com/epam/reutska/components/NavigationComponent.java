package com.epam.reutska.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationComponent extends Component {

	private static final String LINK_NEXT = ".pager-next a";
	private static final String LINK_GO_TO_PRICES = "//div[@class='link']/a";

	public NavigationComponent(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = NavigationComponent.LINK_NEXT)
	private WebElement linkNext;
	@FindBy(xpath = NavigationComponent.LINK_GO_TO_PRICES)
	private WebElement linkGoToPrices;

	public WebElement getLinkNext() {
		return linkNext;
	}
	public WebElement getLinkGoToPricesPage() {
		return linkGoToPrices;
	}
	public boolean hasNext() {
		return getDriver().findElements(By.cssSelector(LINK_NEXT)).size() > 0;
	}
}
