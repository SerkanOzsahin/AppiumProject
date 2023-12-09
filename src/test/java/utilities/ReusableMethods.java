package utilities;

import io.appium.java_client.android.AndroidTouchAction;

public class ReusableMethods extends Hooks {

    AndroidTouchAction action;

    public void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
