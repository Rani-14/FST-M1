package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

    public static void main(String[] args) {
        //create a driver object
        WebDriver driver = new FirefoxDriver();

        //open a browser using link
        driver.get("https://www.training-support.net");

        //close the browser
        driver.close();

    }
}