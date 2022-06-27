package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());
        //find checkbox
        WebElement checkbox = driver.findElement(By.name("toggled"));
        //find toggle button
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));

        toggleButton.click();
        // wait until checkbox is disappeared
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        toggleButton.click();
        // wait until checkbox is appeared
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        //click on checkbox
        checkbox.click();

        driver.quit();


    }
}
