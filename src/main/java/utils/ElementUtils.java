package utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.NoSuchElementException;

import static config.BaseTest.getDriver;

public class ElementUtils {
    public static boolean isElementShown(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public void swipeToText(String text){
        AndroidElement element =  (AndroidElement) getDriver().findElement(MobileBy.AndroidUIAutomator(              "new UiScrollable(new UiSelector().scrollable(false).index(0)).scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))"));
    }

    public void swipeDown(){
        try {
            AndroidElement element = (AndroidElement) getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).index(0)).scrollIntoView(new UiSelector().text(\"test\").instance(0))"));
        }catch(org.openqa.selenium.NoSuchElementException e){}
        }
}
