package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity12_1 {

    public static void main(String[] args)  {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/iframes");

        //get title of page
        System.out.println("Title of page : " + driver.getTitle());
        //switch to first frame
        driver.switchTo().frame(0);

        List<WebElement> frame1 = driver.findElements(By.cssSelector("div.content"));
        System.out.println("Frame 1 heading : " + frame1.get(1).getText());

        WebElement button = driver.findElement(By.className("button"));
        System.out.println("Frame 1 Button Text : " + button.getText());
        System.out.println("Frame 1 Button color : " + button.getCssValue("background-color"));
        button.click();
        System.out.println("Frame 1 Button Text after click : " + button.getText());
        System.out.println("Frame 1 Button color after click : " + button.getCssValue("background-color"));
        // switch to main page
        driver.switchTo().defaultContent();

        //switch to second frame
        driver.switchTo().frame(1);
        driver.manage().window().fullscreen();
        List<WebElement> frame2 = driver.findElements(By.cssSelector("div.content"));
        System.out.println("Frame2 heading : " + frame2.get(1).getText());

        WebElement button2 = driver.findElement(By.className("button"));
        System.out.println("Frame 2 Button Text : " + button2.getText());
        System.out.println("Frame 2 Button color : " + button2.getCssValue("background-color"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("button")));
        button2.click();
        //wait.until(ExpectedConditions.textToBePresentInElement(button2, "Button Pressed"));
        System.out.println("Frame 2 Button Text after click: " + button2.getText());
        System.out.println("Frame 2 Button color after click : " + button2.getCssValue("background-color"));
        // switch to main page
        driver.switchTo().defaultContent();
        driver.quit();

    }
}
