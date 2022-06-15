package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
        //desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Rani's Galaxy A52");
        System.out.println(options.getDeviceName());
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddNote(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("New text note")));
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("First Note");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("This is my First Note");
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("index_note_title")));
        String title = driver.findElement(AppiumBy.id("index_note_title")).getText();
        System.out.println(title);

        Assert.assertEquals(title, "First Note");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
