package com.tabcorp.ui.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
@Component
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
public abstract class BaseComponent {

    @Value("${explicit.wait}")
    public int explicitWaitTime;

    @Value("${implicit.wait}")
    public int implicitWaitTime;

    @Value("${default.wait}")
    public int defaultWaitTime;

    @Autowired
    private Environment env;

    public AppiumDriver<? extends MobileElement> driver;

    public BaseComponent(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, implicitWaitTime, TimeUnit.SECONDS), this);
    }

}
