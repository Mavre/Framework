package com.epam.reutska.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends Component {

	public static final String LINK_MENU_MAIN_PAGE = ".mmenu .orange";

	public HeaderComponent(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = HeaderComponent.LINK_MENU_MAIN_PAGE)
	private WebElement linkMenuMainPage;

	public WebElement getLinkMenuMainPage() {
		return linkMenuMainPage;
	}
}
