package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidModule {

    public static AppiumDriver appiumDriver;

    public AppiumDriver driverInitialization(){
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
//        caps.setCapability("app", config.getString("user.dir") + config.getString("env.beta.app-path"));
        caps.setCapability("app",  "/Users/sergii.myslovskyi/Documents/Projects/tui/tui/apk/appiumChallenge.apk");
        caps.setCapability("appPackage", "");
        caps.setCapability("noReset", false);
        caps.setCapability("fullReset", true);
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("newCommandTimeout", 9999);
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
//        caps.setCapability("appWaitActivity", "*");

        try {
            appiumDriver = new AndroidDriver(new URL("http://0.0.0.0:4723" + "/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return appiumDriver;
    }
}
