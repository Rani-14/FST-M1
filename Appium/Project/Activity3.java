package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3 {

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
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void testToDoListPage() throws InterruptedException {
        // Open the browser with the URL
        driver.get("https://www.training-support.net/selenium");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text = 'Get Started!']")));

        // Scroll for the element to be visible
        String UiScrollable = "new UiScrollable(new UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingToEnd(5)"));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']//android.widget.TextView"));
        // print each task
        System.out.println(tasks.size());
        for (WebElement task : tasks) {
            System.out.println(task.getText());
            task.click();
        }

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();
        List<WebElement> tasks1 = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']//android.widget.TextView"));
        System.out.println(tasks1.size());
        if (tasks1.size() == 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
