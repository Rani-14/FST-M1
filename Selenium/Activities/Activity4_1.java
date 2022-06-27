package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        //open a browser using link
        driver.get("https://www.training-support.net");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());
        driver.findElement(By.xpath("//a[@id='about-link']")).click();
        System.out.println("Title of new page : "+ driver.getTitle());

        driver.quit();
    }
}
