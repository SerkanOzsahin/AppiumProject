package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Hooks;
import utilities.ReusableMethods;

public class choosingPlatformStep extends Hooks {

    ReusableMethods rs =new ReusableMethods();

    @Given("The user launches the app")
    public void theUserLaunchesTheApp() {
    }

    @When("The user chooses a platform")
    public void theUserChoosesAPlatform() {
    }

    @Then("The user should be directed to the platform")
    public void theUserShouldBeDirectedToThePlatform() {
    }
}
