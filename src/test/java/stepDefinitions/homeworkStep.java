package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class homeworkStep extends Hooks {

    ReusableMethods rm= new ReusableMethods();
    @Given("The user is at homework page")
    public void theUserIsAtHomeworkPage() {
        setUp();
        List<AndroidElement> testButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (testButton.size() > 0) {
            testButton.get(0).click();
        }
            rm.waitFor(2);
            androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-0\"]")).sendKeys(ConfigReader.getProperty("username"));
            rm.waitFor(2);
            androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]")).sendKeys(ConfigReader.getProperty("password"));
            rm.waitFor(2);
            androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"SIGN IN\"]")).click();
    }

    @When("The user clicks on a homework")
    public void theUserClicksOnAHomework() {

        }


    @Then("The user should be able to see homework details")
    public void theUserShouldBeAbleToSeeHomeworkDetails() {
    }
}
