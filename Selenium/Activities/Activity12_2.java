package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity12_2 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/nested-iframes");
        //get title of page
        System.out.println("Title of page : " + driver.getTitle());

        //switch to main frame
        driver.switchTo().frame(0);

        //Switch to first iFrame in that main frame
        driver.switchTo().frame(0);
        List<WebElement> frame1 = driver.findElements(By.cssSelector("div.content"));
        System.out.println("Frame 1 heading : " + frame1.get(1).getText());
        //switch to parent frame
        driver.switchTo().parentFrame();
        //Switch to second iFrame in that main frame
        driver.switchTo().frame(1);
        List<WebElement> frame2 = driver.findElements(By.cssSelector("div.content"));
        System.out.println("Frame 2 heading : " + frame2.get(1).getText());

    }
}
