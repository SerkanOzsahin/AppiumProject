package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Hooks;

public class ChoosingPlatformPage extends Hooks {

    public ChoosingPlatformPage() {
        PageFactory.initElements(androidDriver, this);
    }

    public By liveButton = By.xpath(" //android.widget.Button[@text=\"Live\"] ");
    public By continueButton = By.xpath(" //android.widget.Button[@text=\"CONTINUE\"] ");
    public By technoStudyButton = By.xpath(" //android.widget.Button[@text=\"Techno Study\"] \n");
    public By switchButton = By.xpath("//android.widget.TextView[@text=\"Switch Platform\"]");
    public By demoButton = By.xpath(" //android.widget.Button[@text=\"Demo\"] ");
    public By testButton = By.xpath(" //android.widget.Button[@text=\"Test\"] ");
}
