package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/input-events");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());

        Actions action = new Actions(driver);
        action.sendKeys("R").build().perform();

        WebElement data = driver.findElement(By.id("keyPressed"));
        System.out.println("Data after first action : " + data.getText());

        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        data = driver.findElement(By.className("content"));
        System.out.println("Data after second action : " + data.getText());



        //driver.quit();

    }

}
