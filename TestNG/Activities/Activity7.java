package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setup(){

        driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/login-form");

    }

    @DataProvider (name = "Authentication")
    public Object[][] credentials(){
        return new Object[][] {
                { "admin", "password" },
                { "testuser_2", "Test@456" }
        };
    }

    @Test (dataProvider = "Authentication")
    public void testLogin(String username, String password){

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        String mes = driver.findElement(By.id("action-confirmation")).getText();
        if(mes.equals("Invalid Credentials")){
            Assert.assertTrue(false);
        }
        else{
            Assert.assertTrue(true);
        }

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
