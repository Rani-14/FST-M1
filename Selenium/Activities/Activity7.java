package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        //Instantiate driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void testPopupAdditionalInfo(){

        //Open application
        driver.get("http://alchemy.hguy.co/crm");

        //login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        //Click Sales Menu
        driver.findElement(By.id("grouptab_0")).click();
        //wait till next menu loads
        wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Leads")));
        driver.findElement(By.id("moduleTab_9_Leads")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Assign")));
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.phone")));
        //store the text from popup
        String phone = driver.findElement(By.cssSelector("span.phone")).getText();
        System.out.println("Phone number : " + phone);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
