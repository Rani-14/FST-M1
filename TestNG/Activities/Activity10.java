package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity10 {

    WebDriver driver;
    WebDriverWait wait;
    WebElement slider;
    Actions action;

    @BeforeClass
    public void setup(){

        driver = new FirefoxDriver();
        //open a browser using link
        Reporter.log("Launch the application ");
        driver.get("https://www.training-support.net/selenium/sliders");
        Reporter.log(driver.getTitle());
        action = new Actions(driver);

    }

    @Test
    public void testMiddleValue(){

        slider = driver.findElement(By.id("slider"));
        System.out.println(slider.getSize());
        Reporter.log("Move to middle |");
        action.clickAndHold(slider).moveByOffset(0, 0).release().build().perform();
        String value = driver.findElement(By.id("value")).getText();
        Assert.assertEquals(value, "50");

    }

    @Test
    public void testMaxValue(){
        slider = driver.findElement(By.id("slider"));
        Reporter.log("Move to End |");
        action.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();
        String value = driver.findElement(By.id("value")).getText();
        Assert.assertEquals(value, "100");

    }

    @Test
    public void testMinValue(){
        slider = driver.findElement(By.id("slider"));
        Reporter.log("Move to Start |");
        action.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
        String value = driver.findElement(By.id("value")).getText();
        Assert.assertEquals(value, "0");

    }

    @Test
    public void testThirtyPerValue(){
        slider = driver.findElement(By.id("slider"));
        Reporter.log("Move Thirty percent |");
        action.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
        String value = driver.findElement(By.id("value")).getText();
        Assert.assertEquals(value, "30");

    }

    @Test
    public void testEightyPerValue(){
        slider = driver.findElement(By.id("slider"));
        Reporter.log("Move Eighty percent |");
        action.clickAndHold(slider).moveByOffset(44, 0).release().build().perform();
        String value = driver.findElement(By.id("value")).getText();
        Assert.assertEquals(value, "80");

    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }

}
