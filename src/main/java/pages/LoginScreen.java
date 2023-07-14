package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends BaseScreen{
    public LoginScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"login\"]/android.widget.Button/android.widget.TextView")
    MobileElement loginButton;

    @AndroidFindBy(id = "android:id/button1")
    MobileElement ok;

    public LoginScreen skipWarning(){
        ok.click();
        return this;
    }

    public HomeScreen clickLoginButton(){
        loginButton.click();
        return new HomeScreen();
    }

}
