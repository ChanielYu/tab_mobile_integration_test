package com.tabcorp.screens.TAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static org.junit.Assert.assertEquals;

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
    @AndroidFindBy(id = "login_button")
    private MobileElement loginButton;
    private ArrayList<String> topLeftMenulinksList;
    private ArrayList<String> bottomLeftMenulinksList;

    @Autowired
    public LeftMenuHomeScreenAndroid(AppiumDriver<? extends MobileElement> driver) {

        super(driver);
        topLeftMenulinksList = buildTopLinksList();
        bottomLeftMenulinksList = buildTabLinksList();
    }

    @Override
    public boolean areTabLinksDisplayed() {

        MobileElement leftMenuItems = leftMenu.findElement(By.id("linear_list"));
        scroll("down");
        List<MobileElement> itemsList = leftMenuItems.findElementsByClassName("android.widget.LinearLayout");

        for (int i = 0; i < itemsList.size(); i++) {
            assertEquals(bottomLeftMenulinksList.get(i),itemsList.get(i).findElementById("label").getText());
        }

        return true;

    }

    @Override
    public void openLeftMenu() {

        MobileElement hamburgerMenu =  topToolbar.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.ImageButton[1]"));
        hamburgerMenu.click();
    }

    @Override
    public boolean isLoginJoinDisplayed() {
        return loginButton.isDisplayed() && joinNowButton.isDisplayed();
    }

    @Override
    public boolean areTopLinksDisplayed() {

        MobileElement leftMenuItems = leftMenu.findElement(By.id("linear_list"));
        List<MobileElement> itemsList = leftMenuItems.findElementsByClassName("android.widget.RelativeLayout");
        assertEquals(topLeftMenulinksList.size(),itemsList.size());

        for (int i = 0; i < itemsList.size(); i++) {
            assertEquals(topLeftMenulinksList.get(i),itemsList.get(i).findElementById("label").getText());
        }

        return true;
    }

    @Override
    public ArrayList<String> buildTopLinksList() {

        ArrayList<String> items = new ArrayList<String>(Arrays.asList("Home", "Racing", "Sport","Watch"));
        return items;
    }

    @Override
    public ArrayList<String> buildTabLinksList() {

        ArrayList<String> items = new ArrayList<String>(Arrays.asList("Promotions", "Check & Collect", "What's New","Tab Locator","Settings","Legal","Contact us","Give Feedback"));
        return items;
    }

}
