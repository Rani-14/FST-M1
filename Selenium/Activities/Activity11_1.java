package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_1 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        //get title of page
        System.out.println("Title of page : " + driver.getTitle());

        //Use findElement() to find the button to open a SIMPLE alert and click it
        driver.findElement(By.id("simple")).click();
        //wait until alert is present
        wait.until(ExpectedConditions.alertIsPresent());
        //switch to alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Text in Alert : " + alert.getText());
        alert.accept();

        driver.quit();


    }

}
