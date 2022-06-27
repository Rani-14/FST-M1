package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

    public void checkIfEnabled(WebElement element){
        //check if element is enabled
        if(element.isEnabled()){
            System.out.println("Element is enabled");
        }
        else{
            System.out.println("Element is not enabled");
        }
    }

    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        Activity5_3 a1 = new Activity5_3();
        //open a browser using link
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //get title of page
        System.out.println("Title of page : " + driver.getTitle());
        //find textbox
        WebElement textBox = driver.findElement(By.id("input-text"));
        //call the function
        a1.checkIfEnabled(textBox);

        //click on enable input button
        driver.findElement(By.id("toggleInput")).click();
        //call the function

        //Thread.sleep(3000);
        a1.checkIfEnabled(textBox);

        //close the browser
        driver.quit();

    }
}