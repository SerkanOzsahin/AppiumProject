package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Hooks;

public class LessonExcusePage extends Hooks {
    public LessonExcusePage() {
        PageFactory.initElements(androidDriver, this);
    }

    public By continueButton = By.xpath("//android.widget.Button[@text='CONTINUE']");
    public By username = By.xpath("//android.widget.EditText[@resource-id=\"ion-input-0\"]");
    public By password = By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]");
    public By signButton = By.xpath("//android.widget.Button[@text='SIGN IN']");
    public By attendance = By.xpath("//android.widget.TextView[@text=\"ATTENDANCE\"]");
    public By excuses = By.xpath("//android.view.View[@text=\"EXCUSES\"]");
    public By plusButton = By.xpath("//android.view.View[@resource-id=\"main-content\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.Button");
    public By message = By.xpath("//android.widget.EditText[@resource-id=\"ion-textarea-0\"]");
    public By sendButton = By.xpath("//android.widget.Button[@text=\"SEND\"]");
}
