package com.au.automation.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	
	String homePageImg = "#main-content div.MarqueeImgContent.SeventyThirty";

	public HomePage(WebDriver driver) {
		super(driver);
	//	new WebDriverWait(driver,null)
	//	.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(homePageImg))));
	}
	
	

}
