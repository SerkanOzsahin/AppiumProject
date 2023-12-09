package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.lessonExcusePage;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class lessonExcuseStep extends Hooks {

    lessonExcusePage dc = new lessonExcusePage();
    ReusableMethods rm = new ReusableMethods();

    @Given("The user has a scheduled class")
    public void theUserHasAScheduledClass() {
        setUp();
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rm.waitFor(2);
            androidDriver.findElement(dc.continueButton).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(dc.username));
        androidDriver.findElement(dc.username).clear();
        androidDriver.findElement(dc.username).sendKeys(ConfigReader.getProperty("username"));
        androidDriver.findElement(dc.password).clear();
        androidDriver.findElement(dc.password).sendKeys(ConfigReader.getProperty("password"));
        androidDriver.findElement(dc.signButton).click();

    }

    @When("The user unable to attend the class")
    public void theUserUnableToAttendTheClass() {
        androidDriver.findElement(dc.attendance).click();
        androidDriver.findElement(dc.excuses).click();
        androidDriver.findElement(dc.plusButton).click();
        androidDriver.findElement(dc.message).sendKeys("a");
        androidDriver.findElement(dc.sendButton).click();

    }

    @Then("The user should be able to notify teachers and authorities")
    public void theUserShouldBeAbleToNotifyTeachersAndAuthorities() {
        tearDown();
    }
}
