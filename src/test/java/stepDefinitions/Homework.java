package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HomeworkPage;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class Homework extends Hooks {

    HomeworkPage hp = new HomeworkPage();
    ReusableMethods rm = new ReusableMethods();

    @Given("The user is at homework page")
    public void theUserIsAtHomeworkPage() {
        setUp();
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rm.waitFor(2);
            androidDriver.findElement(hp.continueButton).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(hp.username));
        androidDriver.findElement(hp.username).clear();
        androidDriver.findElement(hp.username).sendKeys(ConfigReader.getProperty("username"));
        androidDriver.findElement(hp.password).clear();
        androidDriver.findElement(hp.password).sendKeys(ConfigReader.getProperty("password"));
        androidDriver.findElement(hp.signButton).click();
    }

    @When("The user clicks on a homework")
    public void theUserClicksOnAHomework() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hp.hamburgerButton));
        androidDriver.findElement(hp.hamburgerButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hp.homeworksButton));
        androidDriver.findElement(hp.homeworksButton).click();
    }

    @Then("The user should be able to see homework details")
    public void theUserShouldBeAbleToSeeHomeworkDetails() {
        rm.waitFor(2);
        WebElement assignmentsText = androidDriver.findElement(By.xpath("//android.view.View[@resource-id=\"main-content\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView"));
        Assert.assertEquals(assignmentsText.getText().toLowerCase(), "assignments");
    }
}
