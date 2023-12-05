package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Hooks;
import utilities.ReusableMethods;

import java.util.List;


public class _03_Accessing_Hamburger_Button extends Hooks {
    ReusableMethods rs = new ReusableMethods();


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
        rs.waitFor(3);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='ion-input-0']")).sendKeys(ConfigReader.getProperty("username"));
        rs.waitFor(2);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='ion-input-1']")).sendKeys(ConfigReader.getProperty("password"));
        rs.waitFor(2);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='SIGN IN']")).click();
        rs.waitFor(2);
    }

    @Then("The user should able to see hamburger button")
    public void theUserShouldAbleToSeeHamburgerButton() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);

        AndroidElement HamburgerButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text='menu']"));
        Assert.assertTrue(HamburgerButton.isEnabled());
        HamburgerButton.click();

        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Courses']")).click();
        AndroidElement BackButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text='back']"));
        BackButton.click();

        WebElement ElementHamburgerButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='menu']")));
        ElementHamburgerButton.click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Assignments']")).click();
        WebElement ElementBackButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='back']")));
        ElementBackButton.click();

        WebElement ElementHamburgerButton1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='menu']")));
        ElementHamburgerButton1.click();
        WebElement ChatButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Chat']")));
        ChatButton.click();
        WebElement ElementBackButton1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='back']")));
        ElementBackButton1.click();


        WebElement ElementHamburgerButton2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='menu']")));
        ElementHamburgerButton2.click();
        WebElement Messages=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Messages']")));
        Messages.click();
        WebElement ElementBackButton2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='back']")));
        ElementBackButton2.click();

        WebElement ElementHamburgerButton3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='menu']")));
        ElementHamburgerButton3.click();
        WebElement Announcements=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Announcements']")));
        Announcements.click();
        WebElement ElementBackButton3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='back']")));
        ElementBackButton3.click();

        WebElement ElementHamburgerButton4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='menu']")));
        ElementHamburgerButton4.click();
        WebElement Settings=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Settings']")));
        Settings.click();
        WebElement ElementBackButton4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='back']")));
        ElementBackButton4.click();

        WebElement ElementHamburgerButton5 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='menu']")));
        ElementHamburgerButton5.click();
        WebElement GradingButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Grading']")));
        GradingButton.click();





    }

}

