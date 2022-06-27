package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){

        //Instantiate driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void testCopyrightText(){

        //Get copyright text
        driver.get("http://alchemy.hguy.co/crm");
        String text = driver.findElement(By.id("admin_options")).getText();
        System.out.println("Copyright text : " + text);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
