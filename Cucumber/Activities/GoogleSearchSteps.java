package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Google Home Page")
    public void Homepage() {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");

    }

    @When("User types in Cheese and hits ENTER")
    public void Search() {

        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);

    }

    @Then("Show how many search results were shown")
    public void SearchResult() {


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        String stats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of Results : " + stats);

    }

    @And("Close the browser")
    public void CloseBrowser(){
        driver.quit();

    }
}
