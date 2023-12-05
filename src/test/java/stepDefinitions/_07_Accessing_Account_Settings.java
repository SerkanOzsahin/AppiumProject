package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Hooks;
import utilities.ReusableMethods;

public class _07_Accessing_Account_Settings extends Hooks {
    ReusableMethods rs = new ReusableMethods();
    @When("The user should be able to see settings button and that button must be clickable")
    public void theUserShouldBeAbleToSeeSettingsButtonAndThatButtonMustBeClickable() {
        WebElement settingsButton= androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Settings']"));
        Assert.assertTrue(settingsButton.isEnabled());
        settingsButton.click();

    }

    @Then("The user should be able to click on all links")
    public void theUserShouldBeAbleToClickOnAllLinks() {
        WebElement editAccount=androidDriver.findElement(By.xpath("//android.widget.Button[@text='Edit Account']"));
        editAccount.click();


    }
}
