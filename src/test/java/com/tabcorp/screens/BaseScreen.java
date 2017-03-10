package com.tabcorp.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.utils.WebDriverUnpackUtility;
import org.apache.commons.io.FileUtils;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by chanielyu on 2/3/17.
 * BaseScreen
 */
@SuppressWarnings("unused")
@Component
@Profile("android")
@PropertySources({
        @PropertySource("classpath:config_test.properties")
})
public abstract class BaseScreen {
    @Value("${explicit.wait}")
    protected int explicitWaitTime;

    @Value("${implicit.wait}")
    public int implicitWaitTime;

    @Value("${default.wait}")
    protected int defaultWaitTime;

    @Value("${environment}")
    public String environment;

    @Value("${scroll.maximumCount}")
    protected int maxScrollCount;

    @Autowired
    private Environment env;

    protected String platform;

    @AndroidFindBy(id = "toolbar_title")
    private MobileElement toolbarTitle;

    protected AppiumDriver<? extends MobileElement> driver;

    public BaseScreen(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
        /*
         * Property variable is not populated during constructor.
         */
        PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public AppiumDriver<? extends MobileElement> getDriver() {
        return driver;
    }

    public boolean isElementPresent(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(MobileElement mobileElement) {
        try {
            return mobileElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //toolbar_title

    public MobileElement getElement(String locatorName) {
        try {
            //String locatorKeyVal = env.getProperty(locatorName);
            String locatorStrategy;
            String locatorValue = null;
            locatorStrategy = locatorName.split(":")[0];
            if (locatorName.split(":").length > 1) {
                locatorValue = locatorName.split(":")[1];
            }
            if (locatorValue == null) {
                return null;
            }
            MobileElement element = null;

            switch (locatorStrategy) {
                case "name":
                    element = driver.findElement(MobileBy.name(locatorValue));
                    break;
                case "AccessibilityID":
                    element = driver.findElement(MobileBy.AccessibilityId(locatorValue));
                    break;
                case "Class":
                    element = driver.findElement(MobileBy.className(locatorValue));
                    break;
                case "Xpath":
                    element = driver.findElement(MobileBy.xpath(locatorValue));
                    break;
                case "AndroidUIAutomator":
                    element = driver.findElement(MobileBy.AndroidUIAutomator(locatorValue));
                    break;
                case "Css":
                    element = driver.findElement(MobileBy.cssSelector(locatorValue));
                    break;
                case "Id":
                    element = driver.findElement(MobileBy.id(locatorValue));
                    break;
                case "Tag":
                    element = driver.findElement(MobileBy.tagName(locatorValue));
                    break;
                case "LinkText":
                    element = driver.findElement(MobileBy.linkText(locatorValue));
                    break;
                case "PartialLinkText":
                    element = driver.findElement(MobileBy.partialLinkText(locatorValue));
                    break;
                default:
                    element = driver.findElement(MobileBy.xpath(locatorName));
                    break;
            }
            return element;
        } catch (NoSuchElementException e) {
            System.out.println("Exception from getElement :" + e.toString());
            return null;
        }
    }

    public void takeScreenShot(String fileName) {
        File file = new File(fileName + ".png");
        File tmpFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tmpFile, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] takeScreenShot() {
        final byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public String getPlatform() {
        platform = WebDriverUnpackUtility.getPlatform(driver);
        return platform;
    }

    public boolean isiOSPlatform() {
        if (getPlatform().equalsIgnoreCase("iOS")) {
            return true;
        }
        return false;
    }

    public boolean waitUntilElementExist(MobileElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, explicitWaitTime);
            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
            return true;
        } catch (Exception ex) {
            System.out.println("Exception from waitUntilElementExist :" + ex.toString());
            return false;
        }
    }

    public boolean waitForElementPresent(MobileElement element) {
        return waitForElementPresent(element, explicitWaitTime);
    }

    public boolean waitForElementPresent(MobileElement element, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            wait.pollingEvery(5, TimeUnit.SECONDS);
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception ex) {
            System.out.println("Exception from waitUntilElementDisplay :" + ex.toString());
            return false;
        }
    }

    public boolean fluentWaitElementPresent(MobileElement element, int timeoutSeconds) {
        FluentWait<AppiumDriver> fluentWait = new FluentWait<AppiumDriver>(driver)
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                //.ignoring(NoSuchElementException.class)
                .ignoring(NullPointerException.class);
        try {
            fluentWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement fluentWaitElementExist(String locator) {
        FluentWait<AppiumDriver> fluentWait = new FluentWait<AppiumDriver>(driver)
                .withTimeout(defaultWaitTime, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(NullPointerException.class);
        WebElement element = fluentWait.until(ExpectedConditions.visibilityOf(getElement(locator)));
        return element;
    }

    public void fluentWaitElementDisappear(String locator) {
        FluentWait<AppiumDriver> fluentWait = new FluentWait<AppiumDriver>(driver)
                .withTimeout(defaultWaitTime, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(TimeoutException.class);
        fluentWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(getElement(locator))));

    }

    public void waitForRefreshToDisappear() {

        fluentWaitElementDisappear("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAStaticText[1]");
    }

    /*
    * This Method can be used whenever needs to wait for "Please wait" progress bar appears on the app to disappear.
    * */
    public void waitUntilProgressComplete() {
        try {
            FluentWait<AppiumDriver> fluentWait = new FluentWait<AppiumDriver>(driver)
                    .pollingEvery(5, TimeUnit.SECONDS)
                    .withTimeout(explicitWaitTime, TimeUnit.SECONDS)
                    .ignoring(TimeoutException.class)
                    .ignoring(NoSuchElementException.class);
            if (isiOSPlatform()) {
                // fluentWait.until(ExpectedConditions.numberOfElementsToBeLessThan((MobileBy.xpath("//UIAApplication/UIAWindow")), 5));
                fluentWait.until(ExpectedConditions.invisibilityOfElementLocated((MobileBy.AccessibilityId("Please wait"))));
            } else {
                fluentWait.until(ExpectedConditions.invisibilityOfElementLocated((MobileBy.xpath("//android.widget.ProgressBar"))));
            }
        } catch (Exception ex) {
            System.out.println("\nException from waitUntilProgressComplete :" + ex.toString());
        }

    }

    public void scrollToElement(String xPath) {
        int counter = 0;
        do {
            if (isElementPresent(getElement(xPath))) {
                break;
            } else {
                scroll("down");
                counter = counter + 1;
            }
        } while (counter < maxScrollCount);
    }

    public void scrollToElement(MobileElement element) {
        int counter = 0;
        do {
            if (isElementPresent(element)) {
                break;
            } else {
                scroll("down");
                counter = counter + 1;
            }
        } while (counter < maxScrollCount);
    }

    public void scrollUpToElement(MobileElement element) {
        int counter = 0;
        do {
            if (isElementPresent(element)) {
                break;
            } else {
                scroll("up");
                counter = counter + 1;
            }
        } while (counter < maxScrollCount);
    }

    public void scrollUpToElement(String xPath) {
        int counter = 0;
        do {
            if (isElementPresent(getElement(xPath))) {
                break;
            } else {
                scroll("up");
                counter = counter + 1;
            }
        } while (counter < maxScrollCount);
    }

    public boolean checkErrorMessage(String message, MobileElement element) {
        return element.getText().equalsIgnoreCase(message);
    }

    public void scroll(String direction) {
        Double screenHeightStart, screenHeightEnd;
        Dimension dimensions = driver.manage().window().getSize();
        if (isiOSPlatform()) {
            screenHeightStart = dimensions.getHeight() * 0.3;
            screenHeightEnd = dimensions.getHeight() * 0.2;
        } else {
            screenHeightStart = dimensions.getHeight() * 0.5;
            screenHeightEnd = dimensions.getHeight() * 0.2;
        }
        int scrollStart = screenHeightStart.intValue();
        int scrollEnd = screenHeightEnd.intValue();
        if (direction.equalsIgnoreCase("up")) {
            driver.swipe(0, scrollEnd, 0, scrollStart, 2000);
        } else {
            driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
        }
        Timeout.seconds(2);
    }

    public boolean verifyPageTitle(String title){
        waitForElementPresent(toolbarTitle,3);
        return title.equals(toolbarTitle.getText());
    }
}
