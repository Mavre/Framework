package com.epam.reutska.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends Component {

	
	private static final String INPUT_SEARCH="//input[@id='edit-name-1']";
	private static final String INPUT_SEARCH_BUTTON="//input[@id='edit-submit-1']";
	@FindBy(xpath = INPUT_SEARCH)
	private WebElement inputSearch;
	
	
	@FindBy(xpath = INPUT_SEARCH_BUTTON)
	private WebElement inputSearchButton;
	public SearchComponent(WebDriver driver) {
		super(driver);
	}
	public WebElement getInputSearch() {
		return inputSearch;
	}
	public WebElement getInputSearchButton() {
		return inputSearchButton;
	}
}
