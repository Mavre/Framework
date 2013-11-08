package com.epam.reutska.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.reutska.domain.BaseGood;

public class CompareGoodsComponent extends Component {

	private static final String ALL_PARAM_LOCATOR = "//table[@class='compare']/tbody/tr/td[2]/..";

	private static final String COMPARE_GOOD_LOCATOR = "td[%s]";

	private static final String COMPARE_GOOD_NAME_LOCATOR = ".//th[@class='row-2'][%s]";

	private static final String COMPARE_GOOD_PRICE_LOCATOR = ".//th[@class='price-2'][%s]";
	private static final String DIFFERENT_CLASS_LOCATOR = "//table[@class='compare']/tbody/tr[@class='different']/td[contains(text(),'%s')][1]";

	@FindBy(xpath = ALL_PARAM_LOCATOR)
	private List<WebElement> compareParams;

	public CompareGoodsComponent(WebDriver driver) {
		super(driver);
	}

	public BaseGood getItem(int n) {

		n = n + 1;
		
		Map<String, String> map = new HashMap<>();

		for (WebElement row : compareParams) {
			WebElement paramName = row.findElement(By.xpath(String.format(
					COMPARE_GOOD_LOCATOR, 1)));
			WebElement paramValue = row.findElement(By.xpath(String.format(
					COMPARE_GOOD_LOCATOR, n + 1)));

			map.put(paramName.getText(), paramValue.getText());
		}

		BaseGood comparebleBaseGood = new BaseGood();

		String name = driver.findElement(
				By.xpath(String.format(COMPARE_GOOD_NAME_LOCATOR, n)))
				.getText();

		Double price = Double.valueOf(driver
				.findElement(
						By.xpath(String.format(COMPARE_GOOD_PRICE_LOCATOR, n)))
				.getText().replaceAll("( )|(грн)", ""));

		comparebleBaseGood.withName(name);
		comparebleBaseGood.withPrice(price);

		comparebleBaseGood.withPram(map);

		return comparebleBaseGood;
	}
	public boolean isDifferent(String paramName){
	      return driver.findElements(By.xpath(String.format(DIFFERENT_CLASS_LOCATOR, paramName))).size() > 0;
	}
}
