package com.epam.reutska.pages;

import org.openqa.selenium.WebDriver;

import com.epam.reutska.components.CategoryComponent;
import com.epam.reutska.helpers.core.MyPageFactory;

public class MainPage extends AnyPage {
	private CategoryComponent categoryComponent;

	public MainPage(WebDriver driver) {
		super();
		categoryComponent = MyPageFactory.getPage(driver,
				CategoryComponent.class);
	}

	public CategoryComponent getCategoryComponent() {
		return categoryComponent;
	}
}
