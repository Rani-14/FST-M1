package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

    public void checkSelection(WebElement element){
        //check if element is selected
        if(element.isSelected()){
            System.out.println("Element is Selected");
        }
        else{
            System.out.println("Element is not Selected");
        }
    }

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Activity5_2 a1 = new Activity5_2();
        //open a browser using link
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());

        //find checkbox
        WebElement checkbox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
        //call the function
        a1.checkSelection(checkbox);

        //click on checkbox button
        checkbox.click();
        //call the function
        a1.checkSelection(checkbox);

        driver.quit();

    }
}
