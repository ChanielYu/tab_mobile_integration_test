package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuc on 3/10/17.
 * LoginScreen
 */
@SuppressWarnings("unused")
@Component
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
@Scope("cucumber-glue")
public class LoginScreen extends BaseScreen {
    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "editTextUsername")
    protected MobileElement userName;
    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "editTextPassword")
    protected MobileElement passWord;
    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "submit")
    protected MobileElement loginBt;

    @Autowired
    public LoginScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public boolean isLoginScreen() {
        boolean ret = false;
        try {
            return userName.isDisplayed()
                    && passWord.isDisplayed()
                    && loginBt.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void login(String un, String pw) {
        userName.sendKeys(un);
        passWord.sendKeys(pw);
        loginBt.click();
    }
}
