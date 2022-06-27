package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_3 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        //open a browser using link
        driver.get("https://training-support.net/selenium/drag-drop");
        //get title of page
        System.out.println("Title of page : " + driver.getTitle());

        Actions action = new Actions(driver);
        //find ball
        WebElement draggable = driver.findElement(By.id("draggable"));
        //find drop-zones
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        //drag to dropzone1
        action.click(draggable).dragAndDrop(draggable, dropzone1).build().perform();
        //verify if dropped correctly
        String drop1 = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        if (drop1.equals("Dropped!")) {
            System.out.println("Ball is moved to dropzone 1");
        } else {
            System.out.println("Ball is not moved to dropzone 1");
        }
        //drag to dropzone2
        action.click(draggable).dragAndDrop(draggable, dropzone2).build().perform();
        //verify if dropped correctly
        String drop2 = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        if (drop2.equals("Dropped!")) {
            System.out.println("Ball is moved to dropzone 2");
        } else {
            System.out.println("Ball is not moved to dropzone 2");
        }
        driver.quit();
    }
}
