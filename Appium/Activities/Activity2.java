package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {

    AndroidDriver driver;
    WebDriverWait wait;

    //setup method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // add capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Rani's Galaxy A52");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appServer, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void checkHeaderTest() {
        // Open the browser with the URL
        driver.get("https://www.training-support.net/");

        // Locate heading on page and print it
        String pageTitle = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
        System.out.println("Title : " + pageTitle);

        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text = 'About Us']")));
        String newTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'About Us']")).getText();
        System.out.println("New Title: " + newTitle);

        Assert.assertEquals(pageTitle, "Training Support");
        Assert.assertEquals(newTitle, "About Us");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
