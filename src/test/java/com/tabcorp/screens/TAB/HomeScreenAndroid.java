package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by chanielyu on 2/3/17.
 * HomeScreenAndroid
 */
@SuppressWarnings("unused")
@Component
@Profile("android")
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
@Scope("cucumber-glue")
public class HomeScreenAndroid extends HomeScreen {

    @AndroidFindBy(id = "toolbar_logo")
    private MobileElement toolbarLogo;
    @Autowired
    public HomeScreenAndroid(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isHomeScreen() {
        try {
            return toolbarLogo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void passWhatsNew() {
        try {
            okGotItButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
