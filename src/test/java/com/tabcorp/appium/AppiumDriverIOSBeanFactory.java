package com.tabcorp.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
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
 * AppiumDriverIOSBeanFactory
 */
@SuppressWarnings("unused")
@Configuration
@Profile("ios")
public class AppiumDriverIOSBeanFactory {
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
        AppiumDriver<? extends MobileElement> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, newCommandTimeout);

        driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        /*String env = null;
        env = System.getenv("UAT");
        if (env == null) {
            env = "SUNBETS";
        }
        System.out.println("\nApplication under Test is " + env + " - iOS");*/
        return driver;
    }
}
