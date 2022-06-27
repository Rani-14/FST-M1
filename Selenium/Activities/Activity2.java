package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity2 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){

        //Instantiate driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void testHeaderImageTitle(){

        //Get title and get the header image url
        driver.get("http://alchemy.hguy.co/crm");
        String url = driver.findElement(By.xpath("//div[@class='companylogo']/img")).getAttribute("src");
        System.out.println("Url of Header Image : " + url);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
