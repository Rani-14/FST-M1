package activities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Activity13_2b {
    public static void main(String[] args) throws IOException, InterruptedException {

        String path = "src/resources/sample13_2a.xlsx";
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(path);
        //get the sheet1
        XSSFSheet sheet = workbook.getSheetAt(0);

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open a browser using link
        driver.get("https://www.training-support.net/selenium/simple-form");
        //get title of page
        System.out.println("Title of page : " + driver.getTitle());


        int row;
        for (row = 1; row <= sheet.getLastRowNum(); row++) {

            driver.findElement(By.id(("firstName"))).sendKeys(sheet.getRow(row).getCell(1).toString());
            driver.findElement(By.id(("lastName"))).sendKeys(sheet.getRow(row).getCell(2).toString());
            driver.findElement(By.id(("email"))).sendKeys(sheet.getRow(row).getCell(3).toString());
            driver.findElement(By.id(("number"))).sendKeys(sheet.getRow(row).getCell(4).toString());
            driver.findElement(By.xpath("//input[@type = 'submit']")).click();
            //switch to alert
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();

            //Get alert message
            System.out.println("Alert message: " + alert.getText());
            alert.accept();
            Thread.sleep(2000);


        }
        driver.quit();
    }
}
