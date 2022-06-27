package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Login page")
    public void LoginPage() {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/login-form");
        Assert.assertEquals(driver.getTitle(), "Login Form");

    }

    @When("User enters username and password")
    public void EnterUsernamePassword() {

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @When("User enters {string} and {string}")
    public void EnterUsernamePassword(String username, String password) {

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("Read the page title and confirmation message")
    public void ReadPageTitle() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        String mes = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Title of the page : " + driver.getTitle());
        System.out.println("Message : " + mes);

    }

    @And("Close the browser window")
    public void CloseBrowserWindow(){
        driver.quit();

    }

}
