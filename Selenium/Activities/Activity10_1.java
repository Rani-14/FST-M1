package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/input-events");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());

        Actions action = new Actions(driver);
        WebElement cube = driver.findElement(By.id("D3Cube"));
        //left click
        action.click(cube).build().perform();
        Thread.sleep(2000);
        WebElement activeCube = driver.findElement(By.className("active"));
        System.out.println("Value after left click : " + activeCube.getText());

        //double click
        action.doubleClick(cube).build().perform();
        activeCube = driver.findElement(By.className("active"));
        System.out.println("Value after double click : " + activeCube.getText());

        //double click
        action.contextClick(cube).build().perform();
        activeCube = driver.findElement(By.className("active"));
        System.out.println("Value after right click : " + activeCube.getText());

        driver.quit();

    }

}
