package steps;

import pages.VerticalSwipingScreen;
import io.cucumber.java.en.Then;
import utils.Assertions;
import utils.ElementUtils;

public class CheckVerticalSwipeStep {
    @Then("^Check vertical swiping option$")
    public void checkVerticalSwipe() throws Throwable {
        VerticalSwipingScreen swipingScreen = new VerticalSwipingScreen();
        int coordYBeforeSwipe = swipingScreen.getButtonYcordByIndex(5);
        new ElementUtils().swipeDown();
        int coordYAfterSwipe = swipingScreen.getButtonYcordByIndex(5);

        Assertions.shouldBeTrue(coordYBeforeSwipe>coordYAfterSwipe, "Screen should be swiped down");

    }
}
