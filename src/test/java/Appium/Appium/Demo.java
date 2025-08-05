package Appium.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Demo {

	AndroidDriver driver;

	@BeforeTest
	public void setup() {

		DesiredCapabilities dc = new DesiredCapabilities();
		try {

			// ✅ Use correct Appium 2 + W3C capability format
			dc.setCapability("platformName", "Android");
			dc.setCapability("platformName", "Android");

			dc.setCapability("appium:deviceName", "Xiaomi 23028RN4DI");
			dc.setCapability("appium:automationName", "uiautomator2");
			dc.setCapability("appium:app", "C:\\Users\\Yash\\.appium\\4isesplay.apk");

			// ✅ Proper server URL
			URL url = new URL("http://127.0.0.1:4723/");

			AndroidDriver driver = new AndroidDriver(url, dc);
			System.out.println("Session started successfully.");
		} catch (Exception e) {
			System.out.println("If it is failed so :" + e.getMessage());
		}
	}

	@Test
	public void clickonbanner() {
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.ImageView[2]")).click();
		
	}
	
	
	@AfterTest
	public void Teardorn() {

		driver.quit();
	}
}
