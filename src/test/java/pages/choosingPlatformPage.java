package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Hooks;

public class choosingPlatformPage extends Hooks {
    public choosingPlatformPage() {PageFactory.initElements(androidDriver, this);}

    public By liveButton=By.xpath(" //android.widget.Button[@text=\"Live\"] ");
    public By continueButton=By.xpath(" //android.widget.Button[@text=\"CONTINUE\"] ");
    public By technoStudyButton=By.xpath(" //android.widget.Button[@text=\"Techno Study\"] \n");
    public By switchButton=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.widget.TextView");
    public By demoButton=By.xpath(" //android.widget.Button[@text=\"Demo\"] ");
    public By testButton=By.xpath(" //android.widget.Button[@text=\"Test\"] ");



}
