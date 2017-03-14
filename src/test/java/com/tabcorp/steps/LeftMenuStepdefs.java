package com.tabcorp.steps;

import com.tabcorp.screens.TAB.LeftMenuHomeScreen;
import com.tabcorp.screens.TAB.Toolbar;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * Created by chanielyu on 2017/2/26.
 * LeftMenuStepdefs
 */
public class LeftMenuStepdefs {
    @Autowired
    private LeftMenuHomeScreen leftMenu;

    @Then("^Login/Join Now is displayed$")
    public void loginJoinNowIsDisplayed() throws Throwable {
        assertTrue(leftMenu.isLoginJoinDisplayed());
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
