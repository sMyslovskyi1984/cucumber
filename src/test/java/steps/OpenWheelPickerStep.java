package steps;

import screens.HomeScreen;
import io.cucumber.java.en.When;

public class OpenWheelPickerStep {
    @When("^Open Wheel Picker Sample Screen$")
    public void open_Wheel_Picker_Sample_Screen() throws Throwable {
        new HomeScreen()
                .openSampleScreen("Wheel Picker");
    }
}
