package config;

import io.appium.java_client.AppiumDriver;

public class BaseTest {

//    private static AppiumDriver driver;

    public BaseTest(){
        if (AndroidModule.appiumDriver==null) {
            new AndroidModule().driverInitialization();
            System.out.println();
        }
    }

    public static AppiumDriver getDriver(){
        return AndroidModule.appiumDriver;
    }
}
