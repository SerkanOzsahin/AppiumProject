package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Hooks;

public class LoginPage extends Hooks {

    public LoginPage() {
        PageFactory.initElements(androidDriver, this);
    }

    public By continueButton = By.xpath("//android.widget.Button[@text='CONTINUE']");
    public By username = By.xpath("//android.widget.EditText[@resource-id=\"ion-input-0\"]");
    public By password = By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]");
    public By signButton = By.xpath("//android.widget.Button[@text='SIGN IN']");
    public By hamburgerButton = By.xpath("//android.widget.Button[@text=\"menu\"]");
    public By settingsButton = By.xpath("//android.widget.TextView[@text=\"Settings\"]");
    public By signOutButton = By.xpath("//android.widget.Button[@text=\"Sign out\"]");
}
