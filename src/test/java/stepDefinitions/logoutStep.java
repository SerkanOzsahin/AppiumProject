package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class logoutStep extends Hooks {

    ReusableMethods rm = new ReusableMethods();

    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        setUp();
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rm.waitFor(2);
            androidDriver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
            rm.waitFor(2);
        }
        androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-0\"]")).sendKeys(ConfigReader.getProperty("username"));
        rm.waitFor(2);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]")).sendKeys(ConfigReader.getProperty("password"));
        rm.waitFor(2);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='SIGN IN']")).click();
        rm.waitFor(2);
    }

    @When("The user navigates to the Settings page in the Hamburger Menu")
    public void theUserNavigatesToTheSettingsPageInTheHamburgerMenu() {
        androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"menu\"]")).click();
        rm.waitFor(2);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Settings\"]")).click();
        rm.waitFor(2);
    }

    @And("The user clicks on the Sign Out button")
    public void theUserClicksOnTheSignOutButton() {
        androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"Sign out\"]")).click();
        rm.waitFor(2);
    }

    @Then("The user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        WebElement signButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"SIGN IN\"]"));
        Assert.assertTrue(signButton.isDisplayed());
        tearDown();
    }
}
