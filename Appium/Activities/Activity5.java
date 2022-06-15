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

public class Activity5 {

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
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void sendMessageTest() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Start chat")));
        driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("recipient_text_view")));
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("8668989273");

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Create group']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Create group']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("container_action_button")));
        driver.findElement(AppiumBy.id("container_action_button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("compose_message_text")));
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();


        Thread.sleep(5000);
        String mes = driver.findElements(AppiumBy.androidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/message_text\")")).get(1).getText();
        System.out.println(mes);
        Assert.assertEquals(mes, "Hello from Appium");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
