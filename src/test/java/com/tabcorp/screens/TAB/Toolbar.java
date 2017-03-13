package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by stolerb on 10/3/17.
 *
 * Top Toolbar
 */
public abstract class Toolbar extends BaseScreen {


    @AndroidFindBy(id = "toolbar_title")
    private MobileElement toolbarTitle;

    @AndroidFindBy(id = "toolbar")
    private MobileElement topToolbar;

    public Toolbar(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public abstract void openLeftMenu();

    public boolean verifyPageTitle(String title){
        waitForElementPresent(toolbarTitle,3);
        return title.equals(toolbarTitle.getText());
    }


    public MobileElement getTopToolbar() {
        return topToolbar;
    }


}
