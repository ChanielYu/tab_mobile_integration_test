package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Created by bat-elstoler on 2/3/17.
 */
public abstract class LeftMenuHomeScreen extends BaseScreen {

    public LeftMenuHomeScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public abstract boolean isLoginJoinDisplayed();

    public abstract void openLeftMenu();


}
