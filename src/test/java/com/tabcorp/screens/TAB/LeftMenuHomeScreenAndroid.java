package com.tabcorp.screens.TAB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    private ArrayList<String> topLeftMenulinksTitleList;
    private ArrayList<String> bottomLeftMenulinksTitleList;

    @Autowired
    public LeftMenuHomeScreenAndroid(AppiumDriver<? extends MobileElement> driver) {

        super(driver);
        topLeftMenulinksList = buildTopLinksList();
        bottomLeftMenulinksList = buildTabLinksList();
        topLeftMenulinksTitleList = buildTopLinksTitleList();
        bottomLeftMenulinksList = buildBottomLinksTitleList();
    }

    @Override
    public boolean areTabLinksDisplayed() {

        MobileElement leftMenuItems = leftMenu.findElement(By.id("linear_list"));
        scroll("down");
        List<MobileElement> itemsList = leftMenuItems.findElementsByClassName("android.widget.LinearLayout");

        for (int i = 0; i < bottomLeftMenulinksList.size(); i++) {
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

        for (int i = 0; i < topLeftMenulinksList.size(); i++) {
            String itemTitle = topLeftMenulinksList.get(i);
            assertEquals(itemTitle,itemsList.get(i).findElementById("label").getText());
        }
        return true;
    }

    @Override
    public boolean areLeftMenuLinksValid(){

        //TODO find a nicer way to scroll up
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        openLeftMenu();
        MobileElement topLeftMenuItems = leftMenu.findElement(By.id("linear_list"));
        List<MobileElement> itemsList = topLeftMenuItems.findElementsByClassName("android.widget.RelativeLayout");
        assertEquals(topLeftMenulinksList.size(),itemsList.size());
        //verify Home link
        itemsList.get(0).click();
        //TODO verify homescreen
        openLeftMenu();

        for (int i = 1; i < itemsList.size(); i++) {
            System.out.println(itemsList.get(i).findElementById("label").getText() + itemsList.get(i).getAttribute("clickable"));
            itemsList.get(i).click();
            assertTrue(verifyPageTitle(topLeftMenulinksTitleList.get(i-1)));
            openLeftMenu();
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

        ArrayList<String> items = new ArrayList<String>(Arrays.asList("Promotions", "Check & Collect", "What's New","TAB Locator","Settings","Legal","Contact Us","Give Feedback"));
        return items;
    }

    public ArrayList<String> buildTopLinksTitleList() {
        ArrayList<String> items = new ArrayList<String>(Arrays.asList("Racing","Sport","Watch & In-Play"));
        return items;
    }

    public ArrayList<String> buildBottomLinksTitleList() {
        ArrayList<String> items = new ArrayList<String>(Arrays.asList("Promotions", "Check & Collect", "What's New","TAB Locator","Settings","Legal","Contact Us"));
        return items;
    }

}
