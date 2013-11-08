package com.epam.reutska.components;

import org.openqa.selenium.WebDriver;

public class Component {
	public  WebDriver driver;
	public Component(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	
}
