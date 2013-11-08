package com.epam.reutska.components;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceListResultsComponent extends Component {
	public static final String RESULT_ITEMS = "//table[@class='styled-result-table']/tbody//tr";
	
	public static final String RESULT_ITEMS_NAME=".//td[@class='n']/a[1]";
	public static final String RESULT_ITEMS_PRICE=	"//table[@class='styled-result-table']/tbody//td[2]";
	
	public PriceListResultsComponent(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = RESULT_ITEMS)
	private List<WebElement> resultItems;
	@FindBy(xpath = RESULT_ITEMS_NAME)
	private List<WebElement> resultItemsName;
	@FindBy(xpath = RESULT_ITEMS_PRICE)
	private List<WebElement> resultItemsPrice;
	
	
	public List<WebElement> getResultItems() {
		return resultItems;
	}
	public List<WebElement> getResultItemsName() {
		return resultItemsName;
	}
	public List<WebElement> getResultItemsPrice() {
		return resultItemsPrice;
	}

	
}
