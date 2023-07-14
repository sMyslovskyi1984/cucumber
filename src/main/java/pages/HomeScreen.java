package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

import java.util.List;
import java.util.stream.Collectors;

public class HomeScreen extends BaseScreen{

    public HomeScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc]//android.widget.TextView")
    List<MobileElement> categories;

    public List<String> getCategoriesNames(){
        return categories.stream().map(e->e.getAttribute("text")).collect(Collectors.toList());
    }

    public void openSampleScreen(String option){
        if(!getCategoriesNames().contains(option)){
            new ElementUtils().swipeDown();
        }
        categories.stream().filter(e->e.getAttribute("text").equals(option)).findFirst().get().click();
    }



}
