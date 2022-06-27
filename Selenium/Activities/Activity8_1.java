package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {

    public static void main(String[] args) {
        //create a driver object
        WebDriver driver = new FirefoxDriver();

        //open a browser using link
        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tbody/tr"));
        System.out.println("Number of Rows : " + rows.size());

        List<WebElement> cols = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tbody/tr[1]/td"));
        System.out.println("Number of Cols : " + cols.size());

        //Value of 3rd row
        System.out.println("Values in 3rd Row : ");
        List<WebElement> values = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tbody/tr[3]/td"));
        for(WebElement value : values) {
            System.out.println("Cell Value: " + value.getText());
        }

        //Value of 2nd row, 2nd column
        WebElement secRow = driver.findElement(By.xpath("//table[@id = 'sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Values in 2nd Row 2nd Column : " + secRow.getText());

        //close the browser
        driver.quit();


    }
}
