package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup(){

        driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/login-form");

    }
    @Test
    @Parameters ({"username","password"})
    public void testLogin(String username, String password){

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
