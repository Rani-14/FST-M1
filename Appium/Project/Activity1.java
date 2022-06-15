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

public class Activity1 {

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
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testCreateActivity() {
        //add first task
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Create new task")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        //add second task
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        //add third task
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        // take all task as list of webelements
        List<WebElement> tasks = driver.findElements(AppiumBy.androidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")"));
        // print each task
        for (WebElement task : tasks) {
            System.out.println(task.getText());
        }

        Assert.assertEquals(tasks.get(0).getText(), "Complete the second Activity Google Keep");
        Assert.assertEquals(tasks.get(1).getText(), "Complete Activity with Google Keep");
        Assert.assertEquals(tasks.get(2).getText(), "Complete Activity with Google Tasks");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
