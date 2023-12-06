package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.logoutPage;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class logoutStep extends Hooks {

    logoutPage lo = new logoutPage();
    ReusableMethods rm = new ReusableMethods();

    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        setUp();
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rm.waitFor(2);
            androidDriver.findElement(lo.continueButton).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.username));
        androidDriver.findElement(lo.username).clear();
        androidDriver.findElement(lo.username).sendKeys(ConfigReader.getProperty("username"));
        androidDriver.findElement(lo.password).clear();
        androidDriver.findElement(lo.password).sendKeys(ConfigReader.getProperty("password"));
        androidDriver.findElement(lo.signButton).click();
    }

    @When("The user navigates to the Settings page in the Hamburger Menu")
    public void theUserNavigatesToTheSettingsPageInTheHamburgerMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.hamburgerButton));
        androidDriver.findElement(lo.hamburgerButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.settingsButton));
        androidDriver.findElement(lo.settingsButton).click();
    }

    @And("The user clicks on the Sign Out button")
    public void theUserClicksOnTheSignOutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.signOutButton));
        androidDriver.findElement(lo.signOutButton).click();
    }

    @Then("The user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.signButton));
        WebElement signButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"SIGN IN\"]"));
        Assert.assertTrue(signButton.isDisplayed());
        tearDown();
    }
}
