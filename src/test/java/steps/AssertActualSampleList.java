package steps;

import Screens.HomeScreen;
import io.cucumber.java.en.Then;
import utils.Assertions;
import utils.ElementUtils;

import java.util.Arrays;
import java.util.List;

public class AssertActualSampleList {
    @Then("^Assert actual list with expected list$")
    public void assertActualSampleList() throws Throwable {
        new ElementUtils().swipeDown();
        List<String> actualList = new HomeScreen().getCategoriesNames();
        List<String> expList = Arrays.asList("Drag & Drop", "Long Press");

        for (String option:expList) {
            Assertions.shouldBeTrue(actualList.contains(option), "Actual list should contain sample ["+option+"]");
        }

    }

}
