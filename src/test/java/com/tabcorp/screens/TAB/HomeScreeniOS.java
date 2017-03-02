package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * Created by chanielyu on 2/3/17.
 * HomeScreeniOS
 */
@SuppressWarnings("unused")
@Component
@Configuration
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
@Profile("ios")
public class HomeScreeniOS extends HomeScreen {
    @Autowired
    public HomeScreeniOS(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isUserLogedin() {
        return false;
    }

    @Override
    public void passWhatsNew() {

    }
}
