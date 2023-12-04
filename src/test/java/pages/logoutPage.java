package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Hooks;

public class logoutPage extends Hooks {

    public logoutPage() {
        PageFactory.initElements(androidDriver, this);
    }
}
