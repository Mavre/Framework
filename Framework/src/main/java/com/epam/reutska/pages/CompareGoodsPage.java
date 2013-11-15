package com.epam.reutska.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.epam.reutska.components.CompareGoodsComponent;
import com.epam.reutska.helpers.core.MyPageFactory;

public class CompareGoodsPage extends AnyPage {
	private CompareGoodsComponent compareGoodsComponent;

	public CompareGoodsPage(WebDriver driver) {
		super();
		compareGoodsComponent = MyPageFactory.getPage(driver, CompareGoodsComponent.class);
	}
	
	public CompareGoodsComponent getCompareGoodsComponent() {
		Reporter.log("getCompareGoodsComponent");
		return compareGoodsComponent;
	}
}

