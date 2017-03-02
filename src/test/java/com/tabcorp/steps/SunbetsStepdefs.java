package com.tabcorp.steps;

import com.tabcorp.screens.TAB.MainScreen;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chanielyu on 27/2/17.
 * com.tabcorp.steps.SunbetsStepdefs
 */
public class SunbetsStepdefs {
    @Autowired
    MainScreen mainScreen;

    @Given("^I launch app$")
    public void iLaunchApp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mainScreen.closeApp();
    }
}
