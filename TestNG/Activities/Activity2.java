package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void setup(){

        driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/target-practice");

    }

    @Test
    public void testTitle(){
        String title = driver.getTitle();
        System.out.println("Title of the page : " + title );
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void testButton(){

        String text = driver.findElement(By.className("black")).getText();
        Assert.assertEquals(text , "black");
    }

    @Test(enabled = false)
    public void testSkipping(){
        System.out.println("This test is skipped");
    }

    @Test
    public void testSkipWithException() throws SkipException {

            throw new SkipException("The title matched so skip");

    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
