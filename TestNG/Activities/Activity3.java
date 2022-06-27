package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){

        driver = new FirefoxDriver();
        //open a browser using link
        driver.get(" https://www.training-support.net/selenium/login-form");

    }

    @Test
    public void testLoginPage() {
        // send values
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        //login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //check the message
        String mes = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(mes, "Welcome Back, admin");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
