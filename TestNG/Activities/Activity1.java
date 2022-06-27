package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://www.training-support.net");

    }

    @Test
    public void testTitle() {
        String title = driver.getTitle();
        System.out.println("Title of the page : " + title);
        Assert.assertEquals(title, "Training Support");

        driver.findElement(By.id("about-link")).click();
        //get title
        title = driver.getTitle();
        System.out.println("Title of the page : " + title);
        Assert.assertEquals(title, "About Training Support");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
