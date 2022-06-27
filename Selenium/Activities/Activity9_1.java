package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {

    public static void main(String[] args) {
        //create a driver object
        WebDriver driver = new FirefoxDriver();

        //open a browser using link
        driver.get("https://training-support.net/selenium/selects");
        WebElement selectDrop = driver.findElement(By.id("single-select"));

        //new Select class object
        Select select = new Select(selectDrop);

        //Select the second option using selectByVisibleText()
        select.selectByVisibleText("Option 2");
        //Thread.sleep(2000);
        //Select the third option using selectByIndex()
        select.selectByIndex(3);
        //Thread.sleep(2000);
        //Select the fourth option using selectByValue()
        select.selectByValue("4");

        //get all the options in the dropdown and print them one by one
        List<WebElement> options = select.getOptions();
        System.out.println("List of all the options : ");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}