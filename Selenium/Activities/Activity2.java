package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args) {

        //create a driver object
        WebDriver driver = new FirefoxDriver();

        //open a browser using link
        driver.get("https://www.training-support.net");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());

        WebElement elementById = driver.findElement(By.id("about-link"));
        System.out.println("The text displayed on Link using ID : " + elementById.getText());

        WebElement elementByClass = driver.findElement(By.className("huge"));
        System.out.println("The text displayed on Link using Class : " + elementByClass.getText());

        WebElement elementByLinkText = driver.findElement(By.linkText("About Us"));
        System.out.println("The text displayed on Link using LinkText : " + elementByLinkText.getText());

        WebElement elementByCSS = driver.findElement(By.cssSelector("#about-link"));
        System.out.println("The text displayed on Link using CssSelector : " + elementByCSS.getText());

        //close the browser
        driver.quit();
    }
}
