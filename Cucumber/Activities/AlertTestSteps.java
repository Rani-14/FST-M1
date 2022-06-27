package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTestSteps {

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("User is on the page")
    public void UserOnPage(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("User clicks the Simple Alert button")
    public void UserClicksSimpleAlert(){

        driver.findElement(By.id("simple")).click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @When("User clicks the Confirm Alert button")
    public void UserClicksConfirmAlert(){

        driver.findElement(By.id("confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @When("User clicks the Prompt Alert button")
    public void UserClicksPromptAlert(){

        driver.findElement(By.id("prompt")).click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("Alert opens")
    public void AlertOpens(){

        alert = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public  void ReadText(){

        System.out.println("Alert Message : " + alert.getText());
    }

    @And("Close the alert")
    public void CloseAlert(){
        alert.accept();

    }

    @And("Close the alert with Cancel")
    public void CloseAlertWithCancel(){
        alert.dismiss();
    }

    @And("Write a custom {string} in it")
    public void WriteMessage(String message) {
        alert.sendKeys(message);

    }

    @And("Close Browser")
    public void CloseBrowserW(){
        driver.quit();
    }
}
