package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class homeworkStep extends Hooks {

    ReusableMethods rm= new ReusableMethods();
    @Given("The user is at homework page")
    public void theUserIsAtHomeworkPage() {
        setUp();
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rm.waitFor(2);
            androidDriver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
            rm.waitFor(2);
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
        androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"Testing B4 HTML Ödevi - 00:00 Gönderme Durumu : Gönderildi\"]")).click();
        rm.waitFor(2);
    }


    @Then("The user should be able to see homework details")
    public void theUserShouldBeAbleToSeeHomeworkDetails() {
        WebElement homework =androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"Testing B4 HTML Ödevi - 00:00 Gönderme Durumu : Gönderildi\"]"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"Testing B4 HTML Ödevi - 00:00 Gönderme Durumu : Gönderildi\"]")).click();
        Assert.assertTrue(homework.isDisplayed());
        rm.waitFor(2);
    }
}
