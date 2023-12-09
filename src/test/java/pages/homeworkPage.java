package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Hooks;

public class homeworkPage extends Hooks {
    public homeworkPage() {
        PageFactory.initElements(androidDriver,this);
    }

    public By continueButton = By.xpath("//android.widget.Button[@text='CONTINUE']");
    public By username = By.xpath("//android.widget.EditText[@resource-id=\"ion-input-0\"]");
    public By password = By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]");
    public By signButton = By.xpath("//android.widget.Button[@text='SIGN IN']");
    public By hamburgerButton = By.xpath("//android.widget.Button[@text=\"menu\"]");

    /***********************************************************/
    public By homeworksButton=(By.xpath("//android.widget.TextView[@text=\"Assignments\"]"));

    public By description=By.xpath("//android.widget.TextView[@text=\"Description\"]");
}
