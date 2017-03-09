package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.ElementNotVisibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by chanielyu on 2/3/17.
 * SplashScreenAndroid
 */
@SuppressWarnings("unused")
@Component
@Profile("android")
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
public class SplashScreenAndroid extends SplashScreen {
    @AndroidFindBy(className = "android.widget.ImageView")
    private MobileElement imageView;

    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement permissionAllowButton;

    @WithTimeout(time = 2, unit = TimeUnit.SECONDS)
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[1]")
    private MobileElement laterButton;

    @WithTimeout(time = 20, unit = TimeUnit.SECONDS)
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[2]")
    private MobileElement okButton;

    private boolean appReset;

    @Autowired
    public SplashScreenAndroid(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
        appReset = true;
    }

    @Override
    public boolean isImageViewSeen() {
        return imageView.isDisplayed();
    }

    @Override
    public void grantLocationPermission() {
        try {
            if (permissionAllowButton.isDisplayed()) {
                permissionAllowButton.click();
            } else {
                appReset = false;
            }
        } catch (Exception e) {
            appReset = false;
            e.printStackTrace();
        }
    }

    @Override
    public void ignoreUpdate() {
        try {
            if (laterButton.isDisplayed() && "later".equalsIgnoreCase(laterButton.getText())) {
                laterButton.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void confirmOver18() {
        if (appReset) {
            try {
                if (okButton.isDisplayed() && "ok".equalsIgnoreCase(okButton.getText())) {
                    okButton.click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
