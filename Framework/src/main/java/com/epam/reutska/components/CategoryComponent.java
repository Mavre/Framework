package com.epam.reutska.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryComponent extends Component {

	//private static final String LINK_CATEGORY_REFRIGERATOR = ".//a[@href='http://pn.com.ua/ct/2163/']";
	private static final String LINK_CATEGORY ="//a[contains(text(),'%s')]";
	private static final String LINK_CATEGORY_MICROWAVE = ".//a[@href='http://pn.com.ua/ct/2137/']";

	public CategoryComponent(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = CategoryComponent.LINK_CATEGORY)
	private WebElement linkCategory;
	@FindBy(xpath = CategoryComponent.LINK_CATEGORY_MICROWAVE)
	private WebElement linkCategoryMicrowave;

	public WebElement getLinkCategory( String s) {
		String locator=String.format(LINK_CATEGORY, s);
		
		
		return driver.findElement(By.xpath(locator));
		//return linkCategoryRefrigerator;
	}

	public WebElement getLinkCategoryMicrowave() {
		return linkCategoryMicrowave;
	}

}
