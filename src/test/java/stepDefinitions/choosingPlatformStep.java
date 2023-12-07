package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.choosingPlatformPage;
import utilities.Hooks;

public class choosingPlatformStep extends Hooks {

    choosingPlatformPage dc = new choosingPlatformPage();

    @Given("The user launches the app")
    public void theUserLaunchesTheApp() {
        setUp();
    }

    @When("The user chooses a platform")
    public void theUserChoosesAPlatform() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.liveButton));
        androidDriver.findElement(dc.liveButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.continueButton));
        androidDriver.findElement(dc.continueButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.switchButton));
        androidDriver.findElement(dc.switchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.technoStudyButton));
        androidDriver.findElement(dc.technoStudyButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.continueButton));
        androidDriver.findElement(dc.continueButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.switchButton));
        androidDriver.findElement(dc.switchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.demoButton));
        androidDriver.findElement(dc.demoButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.continueButton));
        androidDriver.findElement(dc.continueButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.switchButton));
        androidDriver.findElement(dc.switchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.testButton));
        androidDriver.findElement(dc.testButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.continueButton));
        androidDriver.findElement(dc.continueButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.switchButton));
        androidDriver.findElement(dc.switchButton).click();
    }

    @Then("The user should be directed to the platform")
    public void theUserShouldBeDirectedToThePlatform() {
        tearDown();
    }
}
