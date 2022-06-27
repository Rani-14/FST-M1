package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());
        //enter the information
        driver.findElement(By.cssSelector("input[class$= 'username']")).sendKeys("UserTest");
        driver.findElement(By.cssSelector("input[class$= 'password']")).sendKeys("TestPWD");
        driver.findElement(By.xpath("//label[contains(text(),'Confirm Password')]/following::input")).sendKeys("TestPWD");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@xyz.com");
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();

        //wait for login message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        //print the message
        System.out.println("Message : " + driver.findElement(By.id("action-confirmation")).getText());

        driver.quit();
    }
}
