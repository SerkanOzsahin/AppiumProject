package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty", "json:target/cucumber.json",},
        features = "src/test/resources/featureFiles",
        glue = "stepDefinitions"
)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
