package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * Created by bat-elstoler on 2/3/17.
 */
@SuppressWarnings("unused")
@Component
@Profile("android")
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
public class LeftMenuHomeScreenAndroid extends LeftMenuHomeScreen {

    @AndroidFindBy(id = "toolbar")
    private MobileElement topToolbar;
    @AndroidFindBy(id = "left_drawer")
    private MobileElement leftMenu;
    @AndroidFindBy(id = "join_button")
    private MobileElement joinNowButton;
    @AndroidFindBy(id = "login_buttonn")
    private MobileElement loginButton;



    @Autowired
    public LeftMenuHomeScreenAndroid(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }


    @Override
    public boolean isLoginJoinDisplayed() {
        return loginButton.isDisplayed() && joinNowButton.isDisplayed();
    }

    @Override
    public void openLeftMenu() {
        MobileElement hamburgerMenu =  topToolbar.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.ImageButton[1]"));
        hamburgerMenu.click();
    }
}
