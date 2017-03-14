package com.tabcorp.steps;

import com.tabcorp.screens.TAB.Toolbar;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yuc on 3/14/17.
 * ToolbarStepdefs
 */
public class ToolbarStepdefs {
    @Autowired
    private Toolbar topToolbar;

    @Given("^Left menu is open$")
    public void leftMenuIsOpen() throws Throwable {
        topToolbar.openLeftMenu();
    }
}
