package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by chanielyu on 2017/2/26.
 * MainScreen
 */
@SuppressWarnings("unused")
@Component
@Scope("cucumber-glue")
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
public class MainScreen {
    private AppiumDriver<? extends MobileElement> driver;

    @Autowired
    public MainScreen(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
    }

    public void closeApp() {
        driver.closeApp();
    }
}
