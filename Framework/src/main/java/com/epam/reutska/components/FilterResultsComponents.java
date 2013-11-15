package com.epam.reutska.components;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterResultsComponents extends Component {

	public static final String LINK_RESULT_ITEMS = ".item";
	public static final String DESCRIPTION_RESULT_ITEMS = ".description";
	public static final String LINK_RESULT_ITEM_NAME = ".//div[@class='name']/a";
	public static final String LINK_RESULT_ITEM_PRICE = ".//div[@class='price']/strong";
	public static final String LINK_RESULT_ITEM_FIRST_ADD_COMPARE = "//div[@class='item'][1]//span[@class='compare_add_link comparep cs']";
	public static final String LINK_RESULT_ITEM_SECOND_ADD_COMPARE = "//div[@class='item'][2]//span[@class='compare_add_link comparep cs']";
	public static final String GO_TO_COMPARING_PAGE = "//a[contains(@href,'compare')]";

	public static final String NAME_FIRST_GOOD = "//div[@class='item'][1]/div[@class='name']/a";
	public static final String NAME_SECOND_GOOD = "//div[@class='item'][2]/div[@class='name']/a";
	public static final String PRICE_ONE_GOOD = "//div[@class='item'][%s]/div[@class='price']/strong";

	public static final String NAME_ONE_GOOD = "//div[@class='item'][%s]/div[@class='name']/a";

	public FilterResultsComponents(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = FilterResultsComponents.DESCRIPTION_RESULT_ITEMS)
	private List<WebElement> descriptionResultItems;

	@FindBy(css = FilterResultsComponents.NAME_ONE_GOOD)
	private WebElement nameOneGood;

	@FindBy(xpath = FilterResultsComponents.NAME_FIRST_GOOD)
	private WebElement nameFirstGood;

	@FindBy(xpath = FilterResultsComponents.NAME_SECOND_GOOD)
	private WebElement nameSecondGood;

	@FindBy(xpath = FilterResultsComponents.PRICE_ONE_GOOD)
	private WebElement priceOneGood;

	@FindBy(xpath = FilterResultsComponents.GO_TO_COMPARING_PAGE)
	private WebElement goToComparingPage;
	@FindBy(css = FilterResultsComponents.LINK_RESULT_ITEMS)
	private List<WebElement> linkResultItems;

	@FindBy(xpath = FilterResultsComponents.LINK_RESULT_ITEM_NAME)
	private List<WebElement> linkResultItemName;
	@FindBy(xpath = FilterResultsComponents.LINK_RESULT_ITEM_PRICE)
	private List<WebElement> linkResultItemPrice;

	@FindBy(xpath = FilterResultsComponents.LINK_RESULT_ITEM_FIRST_ADD_COMPARE)
	private WebElement linkResultItemFirstAddCompare;

	@FindBy(xpath = FilterResultsComponents.LINK_RESULT_ITEM_SECOND_ADD_COMPARE)
	private WebElement linkResultItemSecondAddCompare;

	public WebElement getLinkResultItemFirstAddCompare() {
		return linkResultItemFirstAddCompare;
	}

	public WebElement getLinkResultItemSecondAddCompare() {
		return linkResultItemSecondAddCompare;
	}

	public List<WebElement> getLinkResultItemName() {
		return linkResultItemName;
	}

	public WebElement getGoToComparingPage() {
		return goToComparingPage;
	}

	public List<WebElement> getLinkResultItemPrice() {
		return linkResultItemPrice;
	}

	public List<WebElement> getLinkResultItems() {
		return linkResultItems;
	}

	public WebElement getNameFirstGood() {
		return nameFirstGood;
	}

	public WebElement getNameSecondGood() {
		return nameSecondGood;
	}

	public WebElement getPriceOneGood() {
		return priceOneGood;
	}

	public WebElement getNameOneGood() {
		return nameOneGood;
	}

	public List<WebElement> getDescriptionResultItems() {
		return descriptionResultItems;
	}

}
