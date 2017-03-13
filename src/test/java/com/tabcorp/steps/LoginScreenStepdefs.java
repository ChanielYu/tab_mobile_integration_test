package com.tabcorp.steps;

import com.tabcorp.screens.TAB.HomeScreen;
import com.tabcorp.screens.TAB.LoginScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by yuc on 3/13/17.
 * LoginScreenStepdefs
 */
public class LoginScreenStepdefs {
    @Autowired
    private LoginScreen loginScreen;

    @When("^I am in Login screen$")
    public void iAmInLoginScreen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(loginScreen.isLoginScreen());
    }

    @Then("^I login with user \"([^\"]*)\" password \"([^\"]*)\"$")
    public void iLoginWithUserPassword(String userName, String passWord) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginScreen.login(userName, passWord);
    }
}
