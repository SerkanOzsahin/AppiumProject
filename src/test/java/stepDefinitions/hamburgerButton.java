package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.DragPageSS;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class hamburgerButton extends Hooks {

    ReusableMethods rs = new ReusableMethods();
    DragPageSS dc = new DragPageSS();

    @Given("Navigate to campus app and click on the demo button")
    public void navigateToCampusAppAndClickOnTheDemoButton() {
        setUp();
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text='Techno Study']"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rs.waitFor(2);
            androidDriver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
            rs.waitFor(2);
        }
    }

    @When("The user enters username and password")
    public void theUserEntersUsernameAndPassword() {
        androidDriver.findElement(dc.username).sendKeys((ConfigReader.getProperty("username")));
        androidDriver.findElement(dc.password).sendKeys((ConfigReader.getProperty("password")));
        androidDriver.findElement(dc.singIn).click();
    }

    @Then("The user should able to see hamburger button")
    public void theUserShouldAbleToSeeHamburgerButton() {
        AndroidElement HamburgerButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text='menu']"));
        Assert.assertTrue(HamburgerButton.isEnabled());
        androidDriver.findElement(dc.hamburgerButton).click();
        androidDriver.findElement(dc.courses).click();
        dc.staleElement(dc.backButton);
        androidDriver.findElement(dc.hamburgerButton).click();
        androidDriver.findElement(dc.assignments).click();
        dc.staleElement(dc.backButton);
        androidDriver.findElement(dc.hamburgerButton).click();
        androidDriver.findElement(dc.chatButton).click();
        dc.staleElement(dc.backButton);
        androidDriver.findElement(dc.hamburgerButton).click();
        androidDriver.findElement(dc.messages).click();
        dc.staleElement(dc.backButton);
        androidDriver.findElement(dc.hamburgerButton).click();
        androidDriver.findElement(dc.announcements).click();
        dc.staleElement(dc.backButton);
        androidDriver.findElement(dc.hamburgerButton).click();
        androidDriver.findElement(dc.settingsButton).click();
        dc.staleElement(dc.backButton);
        androidDriver.findElement(dc.hamburgerButton).click();
        androidDriver.findElement(dc.gradingButton).click();
        dc.staleElement(dc.backButton);
    }
}
