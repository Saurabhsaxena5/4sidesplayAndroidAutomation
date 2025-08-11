package Appium.Appium;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Testcase2 {

	private AndroidDriver driver;
	WebDriver wait;

	@BeforeMethod
	public void startSession() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("platformName", "Android");
			dc.setCapability("appium:deviceName", "Xiaomi 23028RN4DI API 33");
			dc.setCapability("appium:automationName", "uiautomator2");
			dc.setCapability("appium:appPackage", "com.FourSidesTV.ott");
			dc.setCapability("appium:appActivity", "com.FourSidesTV.ott.MainActivity");

			// ✅ Use correct URL for Appium 2.x
			URL url = new URL("http://127.0.0.1:4723"); // no /wd/hub for Appium 2

			driver = new AndroidDriver(url, dc);
			System.out.println("Session started successfully.");

			driver.findElement(By.xpath(
					"//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]"))
					.click();

		} catch (Exception e) {
			System.out.println("Setup failed: " + e.getMessage());
		}
	}

//Click on the Tab

	@Test
	public void clickonType() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Movies\"]")).click();

	}

	@Test
	public void login() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for first element
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.ImageView[2]")))
				.click();

		// Wait for second element
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Watch Episode 1\"]")))
				.click();

		boolean Validate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView")))
				.isDisplayed();
		if (Validate != false) {
			System.out.println("Login page open succefull" + Validate);
		} else {

			System.out.println("Login page open succefull" + Validate);

		}

	}

	@Test
	public void LoginWithphoneNo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for first element
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.ImageView[2]")))
				.click();

		// Wait for second element
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Watch Episode 1\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")))
				.sendKeys("8920689888");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Send OTP\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).sendKeys("1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Verify OTP\"]"))).click();
		System.out.println("Login successfull");
		


	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
