package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.context.annotation.Scope;

/**
 * Created by chanielyu on 2/3/17.
 * SplashScreen
 */
public abstract class SplashScreen extends BaseScreen {
    public SplashScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public abstract boolean isImageViewSeen();

    public abstract void grantLocationPermission();

    public abstract void ignoreUpdate();

    public abstract void confirmOver18();
}
