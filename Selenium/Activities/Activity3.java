package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //open a browser using link
        driver.get("https://training-support.net/selenium/simple-form");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());
        //add data to the fields
        driver.findElement(By.id("firstName")).sendKeys("Test_User");
        driver.findElement(By.id("lastName")).sendKeys("Password");
        driver.findElement(By.id("email")).sendKeys("test123@gmail.com");
        driver.findElement(By.id("number")).sendKeys("9434748741");
        driver.findElement(By.xpath("//div[@class='field']/textarea")).sendKeys("Test Message");
        //submit the form
        driver.findElement(By.className("green")).click();
        Thread.sleep(3000);
        //close the browser
        driver.quit();
    }
}
