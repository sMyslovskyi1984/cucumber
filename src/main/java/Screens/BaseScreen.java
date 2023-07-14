package screens;

import config.AndroidModule;
import io.appium.java_client.AppiumDriver;

public class BaseScreen{

    public AppiumDriver getDriver(){
        return AndroidModule.appiumDriver;
    }
}
