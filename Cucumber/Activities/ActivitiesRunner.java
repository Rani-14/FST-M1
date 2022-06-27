package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"html: test-reports/index.html"},
        //plugin = {"json: test-reports/json-report.json"},
        monochrome = true
)

public class ActivitiesRunner {
    //empty
}