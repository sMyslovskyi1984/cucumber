package uitests;

import Screens.LoginScreen;
import config.BaseTest;
import org.testng.annotations.Test;

public class checkMainCategoriesTest extends BaseTest {

    @Test
    public void checkCategoriesTest(){
        new LoginScreen()
                .skipWarning()
                .clickLoginButton()
                .getCategoriesNames();
    }
}
