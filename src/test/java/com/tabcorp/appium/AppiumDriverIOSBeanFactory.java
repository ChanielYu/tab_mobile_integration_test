package com.tabcorp.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
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
 * AppiumDriverIOSBeanFactory
 */
@SuppressWarnings("unused")
@Configuration
@Profile("ios")
public class AppiumDriverIOSBeanFactory {
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
            String env = null;
            env = System.getenv("UAT");
            if (env == null) {
                env = "SUNBETS";
            }
            System.out.println("\nApplication under Test is " + env + " - iOS");

            capabilities.setCapability("platform-version", "9.1");
            capabilities.setCapability("deviceName", "iPhone 6");
            capabilities.setCapability("platform-name", "iOS");
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("newCommandTimeout", newCommandTimeout);

            driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        }
        return driver;
    }
}
