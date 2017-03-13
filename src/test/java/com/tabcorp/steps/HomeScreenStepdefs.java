package com.tabcorp.steps;

import com.tabcorp.screens.TAB.HomeScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by yuc on 3/13/17.
 * HomeScreenStepdefs
 */
public class HomeScreenStepdefs {
    @Autowired
    private HomeScreen homeScreen;

    @And("^I am in Home screen$")
    public void iAmInHomeScreen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(homeScreen.isHomeScreen());
    }

    @When("^I pass whats new screen$")
    public void iPassWhatsNewScreen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeScreen.passWhatsNew();
    }

    @And("^User is not logged in$")
    public void userIsNotLoggedIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(homeScreen.isUserLogedin());
    }

    @Then("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeScreen.enterLoginScreen();
    }

    @Then("^User is logged in$")
    public void userIsLoggedIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(homeScreen.isUserLogedin());
    }
}
