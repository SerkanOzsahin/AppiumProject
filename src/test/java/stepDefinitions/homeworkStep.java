package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.homeworkPage;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;

public class homeworkStep extends Hooks {

    homeworkPage hp=new homeworkPage();
    ReusableMethods rm= new ReusableMethods();
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
       //WebElement homework =androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"Testing B4 HTML Ödevi - 00:00 Gönderme Durumu : Gönderildi\"]"));
       //androidDriver.findElement(By.xpath("//android.widget.Button[@text=\"Testing B4 HTML Ödevi - 00:00 Gönderme Durumu : Gönderildi\"]")).click();
       //Assert.assertTrue(homework.isDisplayed());
       //rm.waitFor(2);
    }
}
