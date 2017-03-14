package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by stolerb on 10/3/17.
 */
@SuppressWarnings("unused")
@Component
@Profile("ios")
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
@Scope("cucumber-glue")
public class ToolbarIOS extends Toolbar {
    public ToolbarIOS(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @Override
    public void openLeftMenu() {

    }
}
