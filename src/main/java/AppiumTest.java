import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class AppiumTest {

	static AppiumDriver driver;

	public static void main(String args[]) throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "Galaxy A72");
		cap.setCapability("udid", "R58R40C381M");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		openCalculator(url, cap);

		System.out.println(" Application Started");

		addNumbers();

	 closeApplication();

	}

	private static void addNumbers() {

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

	public static void openCalculator(URL url, DesiredCapabilities cap) {

		try {
			driver = new AppiumDriver(url, cap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeApplication() {
		driver.quit();
		//driver.close();
	}

}
