package com.tabcorp.steps;

import com.tabcorp.screens.TAB.MainScreen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import cucumber.api.java.en.Given;

/**
 * Created by chanielyu on 2017/2/26.
 * TabStepdefs
 */
public class TabStepdefs {
    @Autowired
    MainScreen mainScreen;

    @Given("^I enter HOME$")
    public void iEnterHOME() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        mainScreen.closeApp();
    }
}
