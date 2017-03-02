package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Created by chanielyu on 2/3/17.
 * HomeScreen
 */
public abstract class HomeScreen extends BaseScreen {
    public HomeScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public abstract boolean isUserLogedin();

    public abstract void passWhatsNew();
}
