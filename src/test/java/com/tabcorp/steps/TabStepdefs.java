package com.tabcorp.steps;

import com.tabcorp.screens.TAB.MainScreen;
import com.tabcorp.screens.TAB.HomeScreen;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by chanielyu on 2017/2/26.
 * TabStepdefs
 */
public class TabStepdefs {
    @Autowired
    private HomeScreen homeScreen;
    @Autowired
    private MainScreen mainScreen;

    @And("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int seconds) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (java.lang.InterruptedException e) {

        }
    }

    @And("^I am in Home screen$")
    public void iAmInHomeScreen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(homeScreen.isUserLogedin());
    }

    @Given("^Clean up$")
    public void cleanUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
