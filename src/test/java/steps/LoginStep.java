package steps;

import screens.LoginScreen;
import io.cucumber.java.en.When;

public class LoginStep {
    @When("^Login$")
    public void login() throws Throwable {
        new LoginScreen().clickLoginButton();
    }
}
