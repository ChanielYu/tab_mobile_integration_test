package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * Created by chanielyu on 2/3/17.
 * SplashScreen
 */
@SuppressWarnings("unused")
@Component
@Profile("android")
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
public abstract class SplashScreen extends BaseScreen {
    @AndroidFindBy(className = "android.widget.ImageView")
    private MobileElement imageView;

    public SplashScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public boolean isImageViewSeen() {
        return imageView.isDisplayed();
    }
}
