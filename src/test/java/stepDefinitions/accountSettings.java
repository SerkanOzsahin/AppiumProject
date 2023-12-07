package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DragPageSS;
import utilities.Hooks;

public class accountSettings extends Hooks {

    DragPageSS dc = new DragPageSS();

    @When("The user should be able to see settings button and that button must be clickable")
    public void theUserShouldBeAbleToSeeSettingsButtonAndThatButtonMustBeClickable() {
        androidDriver.findElement(dc.hamburgerButton).click();
        WebElement settingsButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Settings']"));
        Assert.assertTrue(settingsButton.isEnabled());
        androidDriver.findElement(dc.settingsButton).click();
    }

    @Then("The user should be able to click on all links")
    public void theUserShouldBeAbleToClickOnAllLinks() {
        androidDriver.findElement(dc.editAccount).click();
        androidDriver.findElement(dc.backButton).click();
        androidDriver.findElement(dc.switchSchool).click();
        androidDriver.findElement(dc.backButton).click();
        androidDriver.findElement(dc.changePassword).click();
        dc.staleElement(dc.backButton);
        androidDriver.findElement(dc.language).click();
        dc.staleElement(dc.backButton);
        androidDriver.findElement(dc.notification).click();
        dc.staleElement(dc.backButton);
    }
}
