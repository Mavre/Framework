package com.epam.reutska.components.filteroption;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.reutska.components.Component;

public class FilterOptionComponent extends Component {

	private static final String FILTER_OPTION_LOCATOR = "//div[contains(text(),'%s')]/../div[2]/a[text()='%s']";
	
	private static final String FILTER_OPTION_LOCATOR_FOR_PRODUCER="//div[contains(text(),'%s')]/../div/descendant::a[not(@class='show_common_producer')][not(@href='javascript:void(0);')]";
	private static final String LINK_SHOW_ALL_PRODUCERS="//a[text()='показать все']";

	
	@FindBy(xpath = LINK_SHOW_ALL_PRODUCERS)
	private WebElement linkShowAllProducers;
	
	public WebElement getLinkShowAllProducers() {
		return linkShowAllProducers;
	}

	
	public FilterOptionComponent(WebDriver driver) {
		super(driver);
	}	

	public WebElement getFilterOptionLocator(String filterName,
			String filterParam) {
		String locator = String.format(FILTER_OPTION_LOCATOR, filterName,
				filterParam);
		return driver.findElement(By.xpath(locator));
	}
	public List<WebElement> getFilterOptionLocatorForProducer(String filterName) {
		String locator = String.format(FILTER_OPTION_LOCATOR_FOR_PRODUCER, filterName);
		return driver.findElements(By.xpath(locator));
	}

	

	
}
