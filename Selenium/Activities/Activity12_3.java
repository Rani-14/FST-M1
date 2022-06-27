package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12_3 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/popups");

        //get title of page
        System.out.println("Title of page : " + driver.getTitle());
        WebElement button = driver.findElement(By.className("orange"));
        Actions action = new Actions(driver);
        //hover
        action.moveToElement(button).build().perform();
        String tooltip = button.getAttribute("data-tooltip");
        System.out.println("Tooltip : "+ tooltip);
        button.click();
        //wait for sign in box to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Log in')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        String mes = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Message : " + mes);
        driver.quit();



    }
}