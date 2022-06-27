package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of page : " + driver.getTitle());

        //Use findElement() to find the button to open a CONFIRM alert and click it
        WebElement confirm = driver.findElement(By.id("confirm"));
        confirm.click();
        //wait until alert is present
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Text in Alert : " + alert.getText());
        alert.accept();
        Thread.sleep(2000);

        //open alert
        confirm.click();
        //wait until alert is present
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Text in Alert : " + alert1.getText());
        alert.dismiss();

        driver.close();

    }
}
