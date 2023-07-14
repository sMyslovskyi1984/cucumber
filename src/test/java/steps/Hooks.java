package steps;

import config.AndroidModule;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void initialization(){
        AndroidModule.appiumDriver=null;
    }


}
