package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

import java.util.List;

import static config.BaseTest.getDriver;

public class WheelPickerScreen {
    public WheelPickerScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
    MobileElement color;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    MobileElement colorPicker;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView")
    List<MobileElement> colorOptions;

    public String getSelectedColor(){
        return color.getAttribute("text").replaceAll("Current Color: ", "").trim();
    }

    public WheelPickerScreen selectColor(String color){
        colorPicker.click();
        ElementUtils.isElementShown(colorOptions.get(0));
        colorOptions.stream().filter(e->e.getAttribute("text").equals(color)).findFirst().get().click();
        return this;
    }
}
