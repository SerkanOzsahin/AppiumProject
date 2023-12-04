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

    ReusableMethods rs = new ReusableMethods();

    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        setUp();
        List<AndroidElement> testButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (testButton.size() > 0) {
            testButton.get(0).click();
            rs.waitFor(2);
            androidDriver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
            rs.waitFor(2);
        }
        androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-0\"]")).sendKeys(ConfigReader.getProperty("username"));
        rs.waitFor(2);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]")).sendKeys(ConfigReader.getProperty("password"));
        rs.waitFor(2);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='SIGN IN']")).click();
        rs.waitFor(2);
    }

    @When("The user navigates to the Settings page in the Hamburger Menu")
    public void theUserNavigatesToTheSettingsPageInTheHamburgerMenu() {
        androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"menu\"]")).click();
        rs.waitFor(2);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Settings\"]")).click();
        rs.waitFor(2);
    }

    @And("The user clicks on the Sign Out button")
    public void theUserClicksOnTheSignOutButton() {
        androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"Sign out\"]")).click();
        rs.waitFor(2);
    }

    @Then("The user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        WebElement signButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"SIGN IN\"]"));
        Assert.assertTrue(signButton.isDisplayed());
        tearDown();
    }
}
