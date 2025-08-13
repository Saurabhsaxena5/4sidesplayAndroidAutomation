package Appium.Appium;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Login {

	private AndroidDriver driver1;
	WebDriver wait;
	  private AndroidDriver driver;
	    private final String APP_PACKAGE = "com.FourSidesTV.ott";
	    private final String APP_ACTIVITY = "com.FourSidesTV.ott.MainActivity";

	@BeforeMethod
	public void startSession() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("platformName", "Android");
			dc.setCapability("appium:deviceName", "Xiaomi 23028RN4DI API 33");
			dc.setCapability("appium:automationName", "Uiautomator2");
			dc.setCapability("appium:appPackage", "com.FourSidesTV.ott");
			dc.setCapability("appium:appActivity", "com.FourSidesTV.ott.MainActivity");

			// ✅ Use correct URL for Appium 2.x
			URL url = new URL("http://127.0.0.1:4723"); // no /wd/hub for Appium 2

			driver1 = new AndroidDriver(url, dc);
			System.out.println("Session started successfully.");
			

			driver1.findElement(By.xpath(
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
		driver1.findElement(By.xpath("//android.view.View[@content-desc=\"Movies\"]")).click();

	}

	@Test
	public void login() {
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));

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
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));

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
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Send OTP\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).sendKeys("1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Verify OTP\"]")))
				.click();
		System.out.println("Login successfull");

		boolean homepagevisible = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).isDisplayed();
		if (homepagevisible = true) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Failed");
		}

	}

	@Test
	public void wrongPhoneNumber() {
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));

		// Wait for first element
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.ImageView[2]")))
				.click();

		// Wait for second element
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc='Watch Episode 1']"))).click();

		// Enter phone number
		WebElement phoneField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
		phoneField.click();
		phoneField.sendKeys("9634420847");

		// Click image inside ScrollView
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]"))).click();

		// Click Send OTP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Send OTP']")))
				.click();

		// Enter OTP
		WebElement otpField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
		otpField.click();
		otpField.sendKeys("1234");

		// Click outside
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();

		// Click Verify OTP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Verify OTP']")))
				.click();

		// ✅ Check homepage without waiting for it
		boolean homepageVisible = driver1.findElements(By.xpath(
				"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView"))
				.size() > 0;

		if (!homepageVisible) {
			System.out.println("Test Passed — OTP failed as expected for wrong phone number");
		} else {
			System.out.println("Test Failed — Homepage opened with wrong phone number");
		}
	}

	@Test
	public void loginwithEmail() {
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));

		// Click first element
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.ImageView[2]")))
				.click();

		// Click "Watch Episode 1"
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc='Watch Episode 1']"))).click();

		// Click some view (index 5)
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.View[5]")))
				.click();

		// Enter Email
		WebElement emailField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
		emailField.click();
		emailField.sendKeys("rajnish.kumar@unvii.com");

		// Click "Send OTP"
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Send OTP']")))
				.click();

		// Enter OTP
		WebElement otpField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
		otpField.click();
		otpField.sendKeys("1234");

		// Click outside to close keyboard (optional)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();

		// Click "Verify OTP" (FIXED XPATH)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Verify OTP']")))
				.click();

		// Check if homepage is visible
		boolean homepageVisible = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).isDisplayed();

		if (homepageVisible) {
			System.out.println("Login successful");
		} else {
			System.out.println("Failed");
		}
	}

	@Test
	public void verifywrongemailid() {
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));

		// Click first element
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.ImageView[2]")))
				.click();

		// Click "Watch Episode 1"
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc='Watch Episode 1']"))).click();

		// Click view 5
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.View[5]")))
				.click();

		// Enter wrong email
		WebElement emailField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
		emailField.click();
		emailField.sendKeys("saurabhsaxena@unvii.com");

		// Send OTP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Send OTP']")))
				.click();

		// Enter OTP
		WebElement otpField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
		otpField.click();
		otpField.sendKeys("1234");

		// Click outside
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();

		// ✅ Check if homepage element exists without failing
		boolean homepageVisible = driver1.findElements(By.xpath(
				"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView"))
				.size() > 0;

		if (!homepageVisible) {
			System.out.println("Test Passed — OTP failed as expected for wrong email");
		} else {
			System.out.println("Test Failed — homepage opened with wrong email");
		}
	}

	@Test
	public void loginInStuff() {
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));

		// Match using contains to avoid newline issues
		WebElement clickOnMyStuff = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[contains(@content-desc,'My Stuff')]")));
		clickOnMyStuff.click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Login\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")))
				.sendKeys("8920689888");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Send OTP\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).sendKeys("1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Verify OTP\"]")))
				.click();

		boolean homepagevisible = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).isDisplayed();
		if (homepagevisible = true) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Failed");
		}

	}

	@Test
	public void Mystuff() {
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));

		WebElement clickOnMyStuff = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[contains(@content-desc,'My Stuff')]")));
		clickOnMyStuff.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Log in \"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")))
				.sendKeys("8920689888");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Send OTP\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).sendKeys("1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Verify OTP\"]")))
				.click();
		System.out.println("Login successfull");

		boolean homepagevisible = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).isDisplayed();
		if (homepagevisible = true) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Failed");
		}

	}

	@Test
	public void loginInsearchBox() {
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));

		// Step 1: Click the "Find" button
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[contains(@content-desc,'Find')]"))).click();

		// Step 2: Click search box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();

		// Step 3: Type text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText")))
				.sendKeys("Hello pooja");

		// Step 3.5: Press ENTER using Android key event
		((AndroidDriver) driver1).longPressKey(new KeyEvent(AndroidKey.ENTER));

		// Step 4: Wait for the next element to appear and click it
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ImageView[2]")))
				.click();
		Duration.ofSeconds(15);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Watch Now\"]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")))
				.sendKeys("8920689888");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Send OTP\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).sendKeys("1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Verify OTP\"]")))
				.click();

		boolean homepagevisible = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).isDisplayed();
		if (homepagevisible = true) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Failed");
		}

	}
	
	@Test
	public void loginwithrealtedvideo() {
		
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));

		// Step 1: Click the "Find" button
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ImageView[contains(@content-desc,'Find')]"))).click();

		// Step 2: Click search box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();

		// Step 3: Type text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText")))
				.sendKeys("Hello pooja");

		// Step 3.5: Press ENTER using Android key event
		((AndroidDriver) driver1).longPressKey(new KeyEvent(AndroidKey.ENTER));
		
		

		// Step 4: Wait for the next element to appear and click it
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ImageView[2]")))
				.click();
		Duration.ofSeconds(15);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.View[11]/android.view.View/android.widget.ImageView[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Watch Now\"]"))).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")))
				.sendKeys("8920689888");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Send OTP\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText"))).sendKeys("1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Verify OTP\"]")))
				.click();

		boolean homepagevisible = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView"))).isDisplayed();
		if (homepagevisible = true) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Failed");
		}
		
		
	}
	
	/*
	 * @AfterMethod public void closeApp() { // Kill the app after each test
	 * driver.terminateApp(APP_PACKAGE);
	 * System.out.println("App closed after test."); }
	 */
	

	@AfterMethod
	public void teardown() {
		if (driver1 != null) {
			driver1.quit();
			
			
		}
	}
}
