package com.epam.reutska.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryComponent extends Component {

	private static final String LINK_CATEGORY ="//a[contains(text(),'%s')]";

	public CategoryComponent(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = CategoryComponent.LINK_CATEGORY)
	private WebElement linkCategory;

	public WebElement getLinkCategory( String s) {
		String locator=String.format(LINK_CATEGORY, s);
		
		
		return driver.findElement(By.xpath(locator));
	}

	

}
