package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

    public void checkVisibility(WebElement element){
        //check if element is visible
        if(element.isDisplayed()){
            System.out.println("Element is visible");
        }
        else{
            System.out.println("Element is not visible");
        }
    }

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        Activity5_1 a1 = new Activity5_1();
        //open a browser using link
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());

        //find checkbox
        WebElement checkbox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));

        a1.checkVisibility(checkbox);

        //click on remove checkbox button
        driver.findElement(By.id("toggleCheckbox")).click();
        a1.checkVisibility(checkbox);

        driver.quit();

    }
}
