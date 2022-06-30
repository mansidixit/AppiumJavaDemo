package com.au.automation.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.au.tests.BaseClass;

public class AddToCartTests extends BaseClass {

	private WebDriver driver;

	@Test
	public void testSortLowestToHighest() {
		this.driver = getDriver();
		System.out.println(" the application name is = "+ this.driver);
		driver.get("http://www.google.com");
		
		//HomePage homePage = new HomePage(driver);
		
		
	}

	public void jkhtestSortLowestToHighest() {

		driver = getDriver();

		String num5Id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_05";
		String num8Id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_08";
		String plusSignId = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_add";
		String eqSignId = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal";

		String resultScreenId = "com.sec.android.app.popupcalculator:id/calc_edt_formula";

		WebElement wbe = driver.findElement(By.id(num5Id));
		wbe.click();

		wbe = driver.findElement(By.id(plusSignId));
		wbe.click();

		wbe = driver.findElement(By.id(num8Id));
		wbe.click();

		wbe = driver.findElement(By.id(eqSignId));
		wbe.click();

		wbe = driver.findElement(By.id(resultScreenId));
		String resultStr = wbe.getText();

		System.out.println(" The result is =" + resultStr);

	}

}
