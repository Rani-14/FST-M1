package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        //Instantiate driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void testLeadsPageTable() {
        //Get copyright text
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
        //find all names and users
        List<WebElement> names = driver.findElements(By.xpath("//tbody/tr/td[3]/b/a"));
        List<WebElement> users = driver.findElements(By.xpath("//tbody/tr/td[8]/a"));

        int count=0;
        for (WebElement name:names){
            //print only 10 records
            if (count == 10) {
                break;
            }
            System.out.println("Names : " + name.getText());
            count++;

        }
        count = 0;
        for (WebElement user:users){
            //print only 10 records
            if (count == 10) {
                break;
            }
            System.out.println("User : " + user.getText());
            count++;
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
