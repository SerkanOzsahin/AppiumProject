package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.logoutPage;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class logoutStep extends Hooks {

    logoutPage dc = new logoutPage();
    WebDriverWait wait = new WebDriverWait(androidDriver, 10);
    ReusableMethods rm = new ReusableMethods();

    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        setUp();
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rm.waitFor(1);
            androidDriver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(dc.username));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.username));
        androidDriver.findElement(dc.username).sendKeys(ConfigReader.getProperty("username"));
        androidDriver.findElement(dc.password).sendKeys(ConfigReader.getProperty("password"));
        androidDriver.findElement(dc.signButton).click();
    }

    @When("The user navigates to the Settings page in the Hamburger Menu")
    public void theUserNavigatesToTheSettingsPageInTheHamburgerMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.hamburgerButton));
        androidDriver.findElement(dc.hamburgerButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.settingsButton));
        androidDriver.findElement(dc.settingsButton).click();
    }

    @And("The user clicks on the Sign Out button")
    public void theUserClicksOnTheSignOutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.signOutButton));
        androidDriver.findElement(dc.signOutButton).click();
    }

    @Then("The user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.signButton));
        WebElement signButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"SIGN IN\"]"));
        Assert.assertTrue(signButton.isDisplayed());
        tearDown();
    }
}
