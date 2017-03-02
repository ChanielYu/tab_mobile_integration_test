package com.tabcorp.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by chanielyu on 2017/2/26.
 * AppiumDriverAndroidBeanFactory
 */
@SuppressWarnings("unused")
@Configuration
@Profile("android")
public class AppiumDriverAndroidBeanFactory {
    private static AppiumDriver<? extends MobileElement> driver;

    @Value("${appium.server.port}")
    private String appiumPort;

    @Value("${automation.instrumentation}")
    private String instrumentation;

    @Value("${explicit.wait}")
    public int explicitWaitTime;

    @Value("${implicit.wait}")
    public int implicitWaitTime;

    @Value("${default.wait}")
    public int defaultWaitTime;

    @Value("${new.command.timeout}")
    private String newCommandTimeout;
    @Value("${device.ready.timeout}")
    private String deviceReadyTimeout;

    @Bean(destroyMethod = "quit")
    @Scope("cucumber-glue")
    public AppiumDriver<? extends MobileElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("deviceName", "Galaxy_Nexus_API_23");
            String env = null;
            env = System.getenv("UAT");
            if (env == null) {
                env = "SUNBETS";
            }
            System.out.println("\nApplication under Test is " + env + " - Android");
            //capabilities.setCapability("deviceName", "Galaxy Nexus 5 -5.0.0 -API 21 - 1080*1920");
            capabilities.setCapability("appActivity", "au.com.tabcorp.sportsbet.ui.SplashActivity");
            //capabilities.setCapability("resetKeyboard", true);
            //capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, newCommandTimeout);

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
            driver.manage().logs().get("logcat");

        }
        return driver;
    }
}
