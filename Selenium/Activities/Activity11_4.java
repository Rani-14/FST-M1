package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity11_4 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/tab-opener");
        //get title of page
        System.out.println("Title of page : " + driver.getTitle());
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // get all the open tabs in a variable.
        Set<String> handles = driver.getWindowHandles();

        // Loop through the Set and switch to the window
        for (String handle : handles) {
            System.out.println(handle);
            if (handle != mainWindow) {
                driver.switchTo().window(handle);
            }
        }
        wait.until(ExpectedConditions.titleIs("Newtab"));
        System.out.println("Title of new window : " + driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'content']")));
        String heading = driver.findElement(By.xpath("//div[@class= 'content']")).getText();
        System.out.println("Heading for new tab : "+heading);
        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        //Print New Tab Title
        System.out.println("Title of second window : " + driver.getTitle());

        //Get heading on new page
        heading = driver.findElement(By.xpath("//div[@class= 'content']")).getText();
        System.out.println("Heading for second window : " + heading);

        driver.quit();



    }
}
