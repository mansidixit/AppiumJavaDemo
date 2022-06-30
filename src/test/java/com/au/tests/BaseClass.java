package com.au.tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	private WebDriver driver;
	private Properties prop;

	@Parameters({ "desiredCapability" })
	@BeforeSuite
	public void setUpCapabilities(@Optional String filePath) {
		try {
			System.out.println("Filename = " + filePath);
			InputStream input = new FileInputStream(filePath);
			prop = new Properties();
			// load a properties file
			prop.load(input);

			// get the property values into the desired Capabilities
			DesiredCapabilities cap = new DesiredCapabilities();

//			if (null != prop.getProperty(MobileCapabilityType.BROWSER_NAME)) {
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getProperty("browserName"));
		//	cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"src/test/resources/driver/chromedriver.exe");
		//		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
			//	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.gms.common.api.GoogleApiActivity");

		//	}
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			cap.setCapability(MobileCapabilityType.UDID, prop.getProperty("udid"));
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, prop.getProperty("60"));

			//cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));

			URL url = new URL(prop.getProperty("appiumURL"));

			// This loads specific driver - android or iOS
		//	if ("Android".equalsIgnoreCase(prop.getProperty(MobileCapabilityType.PLATFORM_NAME))) {
				System.out.println("%%%%%%%%%%%%%%%%%%%%%  DONE %%%%%%%%%%%%%%%%%%%%%%%%%%%");
				this.driver = new AppiumDriver(url, cap); // AppiumDriver(url, cap);
			//	System.out.println("Driver Initialized");
		//	}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void tearDown() {
		this.driver.quit();
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public String getAppProperty(String keyName) {
		return prop.getProperty(keyName);
	}

}
