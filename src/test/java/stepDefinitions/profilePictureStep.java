package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.logoutPage;
import pages.profilePicturePage;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class profilePictureStep extends Hooks {

    logoutPage lo = new logoutPage();
    profilePicturePage pp = new profilePicturePage();
    ReusableMethods rm = new ReusableMethods();
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        setUp();
        List<AndroidElement> tsButton = androidDriver.findElements(By.xpath("//android.widget.Button[@text=\"Techno Study\"]"));
        if (tsButton.size() > 0) {
            tsButton.get(0).click();
            rm.waitFor(1);
            androidDriver.findElement(lo.continueButton).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.username));
        androidDriver.findElement(lo.username).clear();
        androidDriver.findElement(lo.username).sendKeys(ConfigReader.getProperty("username"));
        androidDriver.findElement(lo.password).clear();
        androidDriver.findElement(lo.password).sendKeys(ConfigReader.getProperty("password"));
        androidDriver.findElement(lo.signButton).click();
    }

    @When("the user uploads a profile picture")
    public void theUserUploadsAProfilePicture() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.hamburgerButton));
        androidDriver.findElement(lo.hamburgerButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lo.settingsButton));
        androidDriver.findElement(lo.settingsButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pp.editAccount));
        androidDriver.findElement(pp.editAccount).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pp.changeButton));
        androidDriver.findElement(pp.changeButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pp.cameraButton));
        androidDriver.findElement(pp.cameraButton).click();
        rm.waitFor(1);
        List<AndroidElement> allowCamera = androidDriver.findElements(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]"));
        if (allowCamera.size() > 0) {
            for (int i = 0; i < 2; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                rm.waitFor(1);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            rm.waitFor(1);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(pp.takePicture));
        androidDriver.findElement(pp.takePicture).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pp.doneButton));
        androidDriver.findElement(pp.doneButton).click();
    }

    @Then("the profile picture is successfully uploaded")
    public void theProfilePictureIsSuccessfullyUploaded() {
        rm.waitFor(1);
        WebElement successMsg = androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"User avatar has successfully changed\"]"));
        Assert.assertTrue(successMsg.getText().toLowerCase().contains("success"));
        rm.waitFor(1);
    }

    @When("the user deletes their profile picture")
    public void theUserDeletesTheirProfilePicture() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pp.changeButton));
        androidDriver.findElement(pp.changeButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pp.deleteButton));
        androidDriver.findElement(pp.deleteButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pp.deleteButton2));
        androidDriver.findElement(pp.deleteButton2).click();
    }

    @Then("the profile picture is successfully deleted")
    public void theProfilePictureIsSuccessfullyDeleted() {
        rm.waitFor(1);
        WebElement deleteMsg = androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"User Avatar successfully changed\"]"));
        Assert.assertTrue(deleteMsg.getText().toLowerCase().contains("success"));
        rm.waitFor(1);
        tearDown();
    }
}
