package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass (alwaysRun = true)
    public void setup(){

        driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/target-practice");

    }

    @Test
    public void testPageTitle(){

        String title = driver.getTitle();
        Assert.assertEquals(title, "Target Practice");

    }

    @Test (groups = { "HeaderTests" })
    public void testCheckHeader1(){
        String text = driver.findElement(By.id("third-header")).getText();
        Assert.assertEquals(text, "Third header");

    }

    @Test (groups = { "HeaderTests" })
    public void testCheckHeader2(){
        String color = driver.findElement(By.tagName("h5")).getCssValue("color");
        Assert.assertEquals(color, "rgb(33, 186, 69)");

    }

    @Test (groups = { "ButtonTests" })
    public void testButton1(){
        String text = driver.findElement(By.cssSelector("button.olive")).getText();
        Assert.assertEquals(text, "Olive");

    }

    @Test (groups = { "ButtonTests" })
    public void testButton2(){
        String color = driver.findElement(By.cssSelector("button.brown")).getCssValue("background-color");
        Assert.assertEquals(color, "rgb(165, 103, 63)");

    }



    @AfterClass (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
