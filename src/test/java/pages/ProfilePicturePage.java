package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Hooks;

public class ProfilePicturePage extends Hooks {

    public ProfilePicturePage() {
        PageFactory.initElements(androidDriver, this);
    }

    public By editAccount = By.xpath("//android.widget.Button[@text=\"Edit Account\"]");
    public By changeButton = By.xpath("//android.widget.Button[@text=\"CHANGE\"]");
    public By cameraButton = By.xpath("//android.widget.Button[@text=\"Camera\"]");
    public By takePicture = By.xpath("//android.widget.ImageView[@content-desc=\"Shutter\"]");
    public By doneButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Done\"]");
    public By deleteButton = By.xpath("//android.widget.Button[@text=\"Delete\"]");
    public By deleteButton2 = By.xpath("//android.widget.Button[@text=\"DELETE\"]");
}
