package com.epam.reutska.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.reutska.domain.BaseGood;

public class SelectedItemComponent extends Component {

	private static final String ALL_PARAM_LOCATOR = ".panel.corner.item-stats .row";

	private static final String PARAM_NAME = ".pr";

	private static final String PARAM_VALUE = ".val";
	private static final String MIN_BOUNDARY_RANGE_PRICE = ".other-prices>b:first-of-type";
	private static final String MAX_BOUNDARY_RANGE_PRICE = ".other-prices>b:last-of-type";

	@FindBy(css = ALL_PARAM_LOCATOR)
	private List<WebElement> rows;
	@FindBy(css = MIN_BOUNDARY_RANGE_PRICE)
	private WebElement minBoundaryRangePrice;
	@FindBy(css = MAX_BOUNDARY_RANGE_PRICE)
	private WebElement maxBoundaryRangePrice;
	
	
	public WebElement getMinBoundaryRangePrice(){
		return minBoundaryRangePrice;
	}
	public WebElement getMaxBoundaryRangePrice(){
		return maxBoundaryRangePrice;
	}

	public BaseGood getItem() {

		Map<String, String> map = new HashMap<String, String>();

		for (WebElement paramRow : rows) {
			map.put(paramRow.findElement(By.cssSelector(PARAM_NAME)).getText(),
					paramRow.findElement(By.cssSelector(PARAM_VALUE)).getText());
		}

		BaseGood baseGood = new BaseGood();

		baseGood.withPram(map);
		baseGood.setMinBoundaryRangePrice(Double.valueOf(minBoundaryRangePrice.getText().replaceAll(" ","")));
		baseGood.setMaxBoundaryRangePrice(Double.valueOf(maxBoundaryRangePrice.getText().replaceAll(" ","")));
		return baseGood;
	}

	public SelectedItemComponent(WebDriver driver) {
		super(driver);
	}

}
