package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){

        //Instantiate driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void testNavigationPane(){

        //Get copyright text
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        String color = driver.findElement(By.cssSelector("div.container-fluid")).getCssValue("color");
        System.out.println("Color : " + color);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
