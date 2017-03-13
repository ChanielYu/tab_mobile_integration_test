package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;

/**
 * Created by chanielyu on 2/3/17.
 * HomeScreen
 */
@Scope("cucumber-glue")
public abstract class HomeScreen extends BaseScreen {
    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "toolbar_balance")
    protected MobileElement toolbar_balance;

    @WithTimeout(time = 3, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "au.com.tabcorp.tab_android_dev:id/btn_login")
    protected MobileElement loginButton;

    @WithTimeout(time = 3, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "close_btn")
    protected MobileElement OkGotItButton; // to close what's new screen

    public HomeScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public boolean isUserLogedin() {
        try {
            return toolbar_balance.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterLoginScreen() {
        loginButton.click();
    }

    public abstract boolean isHomeScreen();

    public abstract void passWhatsNew();
}
