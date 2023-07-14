package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VerticalSwipingScreen extends BaseScreen{
    public VerticalSwipingScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView")
    List<MobileElement> buttons;

    public int getButtonYcordByIndex(int buttonIndex){
        return buttons.get(buttonIndex).getLocation().getY();
    }
}
