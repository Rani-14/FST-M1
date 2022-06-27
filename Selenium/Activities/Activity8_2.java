package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_2 {

        public static void main(String[] args) {
            //create a driver object
            WebDriver driver = new FirefoxDriver();

            //open a browser using link
            driver.get("https://training-support.net/selenium/tables");

            List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tbody/tr"));
            System.out.println("Number of Rows : " + rows.size());

            List<WebElement> cols = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tbody/tr[1]/td"));
            System.out.println("Number of Cols : " + cols.size());

            //Value of 2nd row, 2nd column
            WebElement secRow = driver.findElement(By.xpath("//table[@id = 'sortableTable']/tbody/tr[2]/td[2]"));
            System.out.println("Values in 2nd Row 2nd Column : " + secRow.getText());

            //sort on Name
            WebElement firstHeading = driver.findElement(By.xpath("//table[@id = 'sortableTable']/thead/tr/th[1]"));
            firstHeading.click();

            //Value of 2nd row, 2nd column after sort
            WebElement sortedSecRow = driver.findElement(By.xpath("//table[@id = 'sortableTable']/tbody/tr[2]/td[2]"));
            System.out.println("Values in 2nd Row 2nd Column after sorting : " + sortedSecRow.getText());
            //close the browser
            driver.quit();


        }

}
