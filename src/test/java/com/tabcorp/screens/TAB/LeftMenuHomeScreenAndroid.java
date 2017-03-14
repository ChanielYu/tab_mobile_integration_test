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
import org.springframework.context.annotation.Scope;
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
@Scope("cucumber-glue")
public class LeftMenuHomeScreenAndroid extends LeftMenuHomeScreen {

    @Autowired
    private ToolbarAndroid topToolebar;
    @AndroidFindBy(id = "left_drawer")
    private MobileElement leftMenu;
    @AndroidFindBy(id = "join_button")
    private MobileElement joinNowButton;
    @AndroidFindBy(id = "login_button")
    private MobileElement loginButton;
    @AndroidFindBy(id = "header_home_ntg_label")
    private MobileElement nextToGoHeader;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement permissionAllowButton;
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
        bottomLeftMenulinksTitleList = buildBottomLinksTitleList();
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
        return (verifyTopLeftMenuLinksValid() && verifyBottomLeftMenuLinksValid());
    }

    private boolean verifyTopLeftMenuLinksValid() {
        //TODO find a nicer way to scroll up
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        topToolebar.openLeftMenu();
        MobileElement topLeftMenuItems = leftMenu.findElement(By.id("linear_list"));
        List<MobileElement> topItemsList = topLeftMenuItems.findElementsByClassName("android.widget.RelativeLayout");
        //verify Home link
        topItemsList.get(0).click();
        assertTrue(verifyHomepage());
        topToolebar.openLeftMenu();

        for (int i = 1; i < topItemsList.size(); i++) {
            topItemsList.get(i).click();
            assertTrue(topToolebar.verifyPageTitle(topLeftMenulinksTitleList.get(i-1)));
            topToolebar.openLeftMenu();
        }

        return true;
    }

    private boolean verifyBottomLeftMenuLinksValid() {

        MobileElement bottomLeftMenuItems = leftMenu.findElement(By.id("linear_list"));
        scroll("down");
        List<MobileElement> bottomItemsList = bottomLeftMenuItems.findElementsByClassName("android.widget.LinearLayout");

        for (int i = 0; i < bottomLeftMenulinksTitleList.size(); i++) {
            bottomItemsList.get(i).click();
            //in the Check & Collect, we'll have to click 'Allow' in order to continue
            if (bottomLeftMenulinksTitleList.get(i).equals("Check & Collect") && permissionAllowButton.isDisplayed()){
                permissionAllowButton.click();
            }
            assertTrue(topToolebar.verifyPageTitle(bottomLeftMenulinksTitleList.get(i)));
            topToolebar.openLeftMenu();
            scroll("down");
            scroll("down");
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

    private ArrayList<String> buildTopLinksTitleList() {
        ArrayList<String> items = new ArrayList<String>(Arrays.asList("Racing","Sport","Watch & In-Play"));
        return items;
    }

    private ArrayList<String> buildBottomLinksTitleList() {
        ArrayList<String> items = new ArrayList<String>(Arrays.asList("Promotions", "Check & Collect", "What's New","TAB Locator","Settings","Legal","Contact Us"));
        return items;
    }

    private boolean verifyHomepage(){
        return nextToGoHeader.isDisplayed();
    }

}
