package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

import java.util.concurrent.TimeUnit;

/**
 * Created by chanielyu on 2/3/17.
 * HomeScreen
 */
public abstract class HomeScreen extends BaseScreen {
    public HomeScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "au.com.tabcorp.tab_android_dev:id/btn_login")
    protected MobileElement loginButton;

    @WithTimeout(time = 3, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "close_btn")
    protected MobileElement OkGotItButton; // the close what's new screen

    public abstract boolean isUserLogedin();

    public abstract void passWhatsNew();
}
