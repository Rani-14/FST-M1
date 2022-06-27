package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp(){

        //Instantiate driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void testTitle(){
        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
        //get title
        String title = driver.getTitle();
        Assert.assertEquals(title,"SuiteCRM");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
