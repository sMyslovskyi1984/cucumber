package steps;

import Screens.WheelPickerScreen;
import io.cucumber.java.en.Then;
import utils.Assertions;

public class CheckWheelPickerStep {
    @Then("^Check Wheel Picker option$")
    public void check_wheel_picker_option() throws Throwable {
        WheelPickerScreen wheelPickerScreen = new WheelPickerScreen();
        wheelPickerScreen.selectColor("blue");

        Assertions.shouldBeEqual(wheelPickerScreen.getSelectedColor(),  "blue","Blue color should be selected");

    }
}
