package com.tabcorp.steps;

import com.tabcorp.screens.TAB.SplashScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by chanielyu on 2/3/17.
 * GenericStepdefs
 */
public class GenericStepdefs {

    @Autowired
    private SplashScreen splashScreen;

    @Given("^Splash screen launched$")
    public void splashScreenLaunched() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(splashScreen.isImageViewSeen());
    }

    @And("^I grant location permission$")
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

    @Given("^Quit appium session$")
    public void quitAppiumSession() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        splashScreen.getDriver().closeApp();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        splashScreen.getDriver().launchApp();
    }
}
