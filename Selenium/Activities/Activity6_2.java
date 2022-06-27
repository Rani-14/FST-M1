package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Activity6_2 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://training-support.net/selenium/ajax");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());
        //click on Change Content button
        driver.findElement(By.className("violet")).click();
        //wait till hello appears
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
        System.out.println(driver.findElement(By.id("ajax-content")).getText());
        //wait till I am late appears
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        System.out.println(driver.findElement(By.id("ajax-content")).getText());

        driver.quit();

    }
}
