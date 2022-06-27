package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/target-practice");
        //get title of page
        System.out.println("Title of page : "+ driver.getTitle());

        //Find the third header on the page.
        String thirdHeader = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("Text for third heading : "+ thirdHeader);

        //Find the fifth header on the page and get it's 'colour' CSS Property
        String fifthHeader = driver.findElement(By.xpath("//h5")).getCssValue("color");
        System.out.println("Color of fifth heading : "+ fifthHeader);

        //Find the violet button on the page and print all the class attribute values
        String violetButton = driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class");
        System.out.println("Class attributes of violet button : "+ violetButton);

        //Find the grey button on the page with Absolute XPath
        String greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("Text for grey button : "+ greyButton);

        //close the browser
        driver.quit();
    }
}
