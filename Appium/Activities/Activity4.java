package activities;

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

public class Activity4 {

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
        options.setAppPackage("com.samsung.android.app.contacts");
        options.setAppActivity("com.samsung.android.contacts.contactslist.PeopleActivity");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addContactTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Create contact")));
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("arrowButton")));
        // expand the options
        driver.findElement(AppiumBy.id("arrowButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("firstEdit")));
        driver.findElement(AppiumBy.id("firstEdit")).sendKeys("Aaditya");
        driver.findElement(AppiumBy.id("lastEdit")).sendKeys("Varma");
        // close the extra options so that phone element is visible
        driver.findElement(AppiumBy.id("arrowButton")).click();

        // wait for phone element to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Phone']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Phone']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");

        // save the contact
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Save']")).click();

        // wait until contact name appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("header")));
        String name = driver.findElement(AppiumBy.id("header")).getText();
        System.out.println(name);

        // add assertion to check if contact saved correctly
        Assert.assertEquals(name, "Aaditya Varma");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
