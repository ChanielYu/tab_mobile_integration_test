package com.tabcorp.steps;

import com.tabcorp.screens.TAB.LeftMenuHomeScreen;
import com.tabcorp.screens.TAB.MainScreen;
import com.tabcorp.screens.TAB.HomeScreen;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
    @Autowired
    private LeftMenuHomeScreen leftMenu;

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

    @When("^I pass whats new screen$")
    public void iPassWhatsNewScreen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeScreen.passWhatsNew();
    }

    @Given("^Clean up$")
    public void cleanUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }


    @Given("^Left menu is open$")
    public void leftMenuIsOpen() throws Throwable {
       leftMenu.openLeftMenu();
    }


    @Then("^Login/Join Now is displayed$")
    public void loginJoinNowIsDisplayed() throws Throwable {
        assertTrue(leftMenu.isLoginJoinDisplayed());
    }

    @And("^Home/Racing/Sport/Watch links are displayed$")
    public void homeRacingSportWatchLinksAreDisplayed() throws Throwable {
        leftMenu.areTabLinksDisplayed();
    }
}
