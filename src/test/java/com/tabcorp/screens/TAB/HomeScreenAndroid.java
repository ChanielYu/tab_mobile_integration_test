package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

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
public class HomeScreenAndroid extends HomeScreen {

    @AndroidFindBy(id = "toolbar_logo")
    private MobileElement toolbar_logo;
    @Autowired
    public HomeScreenAndroid(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isHomeScreen() {
        try {
            return toolbar_logo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void passWhatsNew() {
        try {
            OkGotItButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
