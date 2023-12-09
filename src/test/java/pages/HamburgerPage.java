package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Hooks;

public class HamburgerPage extends Hooks {

    public HamburgerPage() {
        PageFactory.initElements(androidDriver, this);
    }

    public By editAccount = By.xpath("//android.widget.Button[@text='Edit Account']");
    public By backButton = By.xpath("//android.widget.Button[@text='back']");
    public By switchSchool = By.xpath("//android.widget.TextView[@text='Switch School']");
    public By changePassword = By.xpath("//android.widget.TextView[@text='Change Password']");
    public By notification = By.xpath("//android.widget.TextView[@text='Notification']");
    public By language = By.xpath("//android.widget.TextView[@text='Language']");
    public By settingsButton = By.xpath("//android.widget.TextView[@text='Settings']");
    public By hamburgerButton = By.xpath("//android.widget.Button[@text='menu']");
    public By courses = By.xpath("//android.widget.TextView[@text='Courses']");
    public By assignments = By.xpath("//android.widget.TextView[@text='Assignments']");
    public By chatButton = By.xpath("//android.widget.TextView[@text='Chat']");
    public By messages = By.xpath("//android.widget.TextView[@text='Messages']");
    public By announcements = By.xpath("//android.widget.TextView[@text='Announcements']");
    public By gradingButton = By.xpath("//android.widget.TextView[@text='Grading']");
    public By username = By.xpath("//android.widget.EditText[@resource-id='ion-input-0']");
    public By password = By.xpath("//android.widget.EditText[@resource-id='ion-input-1']");
    public By singIn = By.xpath("//android.widget.Button[@text='SIGN IN']");

    public void staleElement(By element) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        WebElement ElementBackButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='back']")));
        ElementBackButton.click();
    }
}
