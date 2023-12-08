package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class LoginStep extends Hooks {

    LoginPage lo = new LoginPage();
    ReusableMethods rm = new ReusableMethods();

    @Given("the user opens the Campus application")
    public void theUserOpensTheCampusApplication() {
        setUp();
    }

    @When("the user logs in with the username and password")
    public void theUserLogsInWithTheUsernameAndPassword() {
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rm.waitFor(1);
            androidDriver.findElement(lo.continueButton).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.username));
        androidDriver.findElement(lo.username).clear();
        androidDriver.findElement(lo.username).sendKeys(ConfigReader.getProperty("username"));
        androidDriver.findElement(lo.password).clear();
        androidDriver.findElement(lo.password).sendKeys(ConfigReader.getProperty("password"));
        androidDriver.findElement(lo.signButton).click();
    }

    @Then("the user should successfully log into their account")
    public void theUserShouldSuccessfullyLogIntoTheirAccount() {
        tearDown();
    }
}
