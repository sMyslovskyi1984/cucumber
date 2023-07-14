package config;

import io.appium.java_client.AppiumDriver;

public class BaseTest {

    public BaseTest(){
        if (AndroidModule.appiumDriver==null) {
            new AndroidModule().driverInitialization();
        }
    }

    public static AppiumDriver getDriver(){
        return AndroidModule.appiumDriver;
    }
}
