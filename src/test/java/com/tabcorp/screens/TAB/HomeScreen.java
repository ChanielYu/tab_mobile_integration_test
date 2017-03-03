package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by chanielyu on 2/3/17.
 * HomeScreen
 */
public abstract class HomeScreen extends BaseScreen {
    public HomeScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "au.com.tabcorp.tab_android_dev:id/btn_login")
    private MobileElement loginButton;

    @AndroidFindBy(id = "close_btn")
    private MobileElement OkGotItButton; // the close what's new screen

    public abstract boolean isUserLogedin();

    public abstract void passWhatsNew();


    public MobileElement getOkGotItButton() {
        return OkGotItButton;
    }


    public MobileElement getLoginButton() {
        return loginButton;
    }




}
