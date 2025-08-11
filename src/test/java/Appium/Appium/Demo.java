package Appium.Appium;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class Demo {

    private AndroidDriver driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities dc = new DesiredCapabilities();

            // ✅ Appium 2.x W3C format
            dc.setCapability("platformName", "Android");
            dc.setCapability("appium:deviceName", "Xiaomi 23028RN4DI API 33");
            dc.setCapability("appium:automationName", "uiautomator2");
            dc.setCapability("appium:app", "C:\\Users\\Yash\\.appium\\4isesplay.apk");

            // ✅ Proper server URL
            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            // ✅ Assign to class variable, not local
            driver = new AndroidDriver(url, dc);
            System.out.println("Session started successfully.");

        } catch (Exception e) {
            System.out.println("Setup failed: " + e.getMessage());
        }
   

    @Test
    public void clickonbanner() {
        driver.findElement(By.xpath(
            "//android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.ImageView[2]"
        )).click();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
