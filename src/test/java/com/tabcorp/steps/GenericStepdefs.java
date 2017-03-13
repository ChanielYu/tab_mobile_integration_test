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


    @Given("^Quit appium session$")
    public void quitAppiumSession() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        splashScreen.getDriver().closeApp();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        splashScreen.getDriver().launchApp();
    }

    @And("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int seconds) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("^Clean up$")
    public void cleanUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
