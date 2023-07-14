package steps;

import Screens.LoginScreen;
import config.BaseTest;
import io.cucumber.java.en.Given;

public class StartAppStep {
    @Given("^Start application$")
    public void start_application() throws Throwable {
        new BaseTest();
        new LoginScreen()
                .skipWarning();

    }
}
