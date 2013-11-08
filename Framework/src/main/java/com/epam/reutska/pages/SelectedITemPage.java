package com.epam.reutska.pages;

import org.openqa.selenium.WebDriver;

import com.epam.reutska.components.SelectedItemComponent;
import com.epam.reutska.helpers.core.MyPageFactory;

public class SelectedITemPage extends AnyPage {
	private SelectedItemComponent selectedItemComponent;

	public SelectedITemPage(WebDriver driver) {
		super();
		selectedItemComponent=MyPageFactory.getPage(driver, SelectedItemComponent.class);
	}

	public SelectedItemComponent getSelectedItemComponent() {
		return selectedItemComponent;
	}

	
	

}
