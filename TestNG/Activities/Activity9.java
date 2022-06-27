package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){

        driver = new FirefoxDriver();
        //open a browser using link
        Reporter.log("Launch the application");
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log(driver.getTitle());

    }

    @BeforeMethod
    public void setUpForEachTest(){
        Reporter.log("Switch to the main window");
        driver.switchTo().defaultContent();

    }

    @Test(priority = 0)
    public void simpleAlertTestCase(){
        Reporter.log("Simple Alert test started");
        driver.findElement(By.id("simple")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        Reporter.log("Switched to alert");
        String mes = alert.getText();
        Reporter.log("Alert message : " + mes);
        Assert.assertEquals(mes, "This is a JavaScript Alert!");
        alert.accept();
        Reporter.log("Simple Alert test ended");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase(){
        Reporter.log("Confirm Alert test started");
        driver.findElement(By.id("confirm")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        Reporter.log("Switched to alert");
        String mes = alert.getText();
        Reporter.log("Alert message : " + mes);
        Assert.assertEquals(mes, "This is a JavaScript Confirmation!");
        alert.accept();
        Reporter.log("Confirm Alert test ended");
    }

    @Test(priority = 2)
    public void promptAlertTestCase(){
        Reporter.log("Prompt Alert test started |");
        driver.findElement(By.id("prompt")).click();
        Alert alert= driver.switchTo().alert();
        //wait.until(ExpectedConditions.alertIsPresent());
        Reporter.log("Switched to alert |");
        alert.sendKeys("Hi !, This is to test prompt");
        String mes = alert.getText();
        Reporter.log("Alert message : " + mes + " |");
        Assert.assertEquals(mes, "This is a JavaScript Prompt!");
        alert.accept();
        Reporter.log("Prompt Alert test ended |");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){

        Reporter.log("Close the browser");
        driver.quit();
    }
}
