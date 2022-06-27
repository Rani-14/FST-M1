package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {

    public static void main(String[] args) {
        //create a driver object
        WebDriver driver = new FirefoxDriver();

        //open a browser using link
        driver.get("https://training-support.net/selenium/selects");
        WebElement selectDrop = driver.findElement(By.id("multi-select"));

        //new Select class object
        Select select = new Select(selectDrop);

        //Check if the HTML element is a multi-list
        if(select.isMultiple()){
            //Select the options
            select.selectByVisibleText("Javascript");
            select.selectByValue("node");
            select.selectByIndex(4);
            select.selectByIndex(5);
            select.selectByIndex(6);
            select.deselectByValue("node");
            select.deselectByIndex(7);
            System.out.println("First Selected option : " + select.getFirstSelectedOption().getText());

            List<WebElement> multiOptions = select.getAllSelectedOptions();
            System.out.println("List of all selected options : ");
            for(WebElement option:multiOptions){
                System.out.println(option.getText());
            }

            select.deselectAll();


        }
        else{
            System.out.println("Not a multiselect dropdown");
        }


        driver.quit();
    }
}

