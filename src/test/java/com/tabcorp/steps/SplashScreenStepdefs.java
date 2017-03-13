package com.tabcorp.steps;

import com.tabcorp.screens.TAB.SplashScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * Created by yuc on 3/13/17.
 * SplashScreenStepdefs
 */
public class SplashScreenStepdefs {
    @Autowired
    private SplashScreen splashScreen;

    @Given("^Splash screen launched$")
    public void splashScreenLaunched() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(splashScreen.isImageViewSeen());
    }

    @Then("^I grant location permission$")
    public void iGrantLocationPermission() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        splashScreen.ignoreUpdate();
        splashScreen.grantLocationPermission();
    }

    @And("^I ignore update$")
    public void iIgnoreUpdate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        splashScreen.ignoreUpdate();
    }

    @And("^I confirm over (\\d+)$")
    public void iConfirmOver(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        splashScreen.ignoreUpdate();
        splashScreen.confirmOver18();
    }

    @Given("^Enter home screen$")
    public void enterHomeScreen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        splashScreen.passSplashScreen();
    }
}
