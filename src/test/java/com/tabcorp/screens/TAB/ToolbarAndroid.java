package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * Created by stolerb on 10/3/17.
 */
@SuppressWarnings("unused")
@Component
@Profile("android")
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
public class ToolbarAndroid extends Toolbar {

    @Autowired
    public ToolbarAndroid(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }


    public void openLeftMenu() {

        MobileElement hamburgerMenu =  getTopToolbar().findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.ImageButton[1]"));
        hamburgerMenu.click();
    }
}
