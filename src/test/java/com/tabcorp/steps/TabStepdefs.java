package com.tabcorp.steps;

import com.tabcorp.screens.TAB.HomeScreen;
import com.tabcorp.screens.TAB.LeftMenuHomeScreen;
import com.tabcorp.screens.TAB.LoginScreen;
import com.tabcorp.screens.TAB.MainScreen;
import com.tabcorp.screens.TAB.Toolbar;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by chanielyu on 2017/2/26.
 * TabStepdefs
 */
public class TabStepdefs {
    @Autowired
    private HomeScreen homeScreen;
    @Autowired
    private LoginScreen loginScreen;
    @Autowired
    private LeftMenuHomeScreen leftMenu;
    @Autowired
    private Toolbar topToolbar;

    @And("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int seconds) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

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

    @Given("^Clean up$")
    public void cleanUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }


    @Given("^Left menu is open$")
    public void leftMenuIsOpen() throws Throwable {
       topToolbar.openLeftMenu();
    }


    @Then("^Login/Join Now is displayed$")
    public void loginJoinNowIsDisplayed() throws Throwable {
        assertTrue(leftMenu.isLoginJoinDisplayed());
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

    @Then("^User is logged in$")
    public void userIsLoggedIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(homeScreen.isUserLogedin());
    }

    @And("^Home/Racing/Sport/Watch links are displayed$")
    public void homeRacingSportWatchLinksAreDisplayed() throws Throwable {
        assertTrue(leftMenu.areTopLinksDisplayed());
    }

    @And("^TAB links are displayed$")
    public void tabLinksAreDisplayed() throws Throwable {
        assertTrue(leftMenu.areTabLinksDisplayed());
    }


    @And("^links are valid$")
    public void linksAreValid() throws Throwable {
        System.out.println("in linksAreValid");
        leftMenu.areLeftMenuLinksValid();
    }

    @And("^Other links are displayed$")
    public void otherLinksAreDisplayed() throws Throwable {
    }
}
