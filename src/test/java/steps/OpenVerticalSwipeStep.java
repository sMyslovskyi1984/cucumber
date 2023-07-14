package steps;

import Screens.HomeScreen;
import io.cucumber.java.en.When;

public class OpenVerticalSwipeStep {
    @When("^Open Vertical Swipe Sample Screen$")
    public void openVerticalSwipe() throws Throwable {
        new HomeScreen()
                .openSampleScreen("Vertical swiping");
    }
}
