package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());
        //enter the information
        driver.findElement(By.xpath("//input[starts-with(@class,'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class,'password')]")).sendKeys("password");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        //wait for login message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        //print the message
        System.out.println("Message : " + driver.findElement(By.id("action-confirmation")).getText());

        driver.quit();



    }
}
