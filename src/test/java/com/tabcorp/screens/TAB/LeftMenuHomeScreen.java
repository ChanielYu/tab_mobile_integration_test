package com.tabcorp.screens.TAB;

import com.tabcorp.screens.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

/**
 * Created by bat-elstoler on 2/3/17.
 */
@Scope("cucumber-glue")
public abstract class LeftMenuHomeScreen extends BaseScreen {

    public LeftMenuHomeScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public abstract boolean isLoginJoinDisplayed();

    public abstract boolean areTopLinksDisplayed();

    public abstract boolean areTabLinksDisplayed();

    public abstract boolean areLeftMenuLinksValid();

    public abstract ArrayList<String> buildTopLinksList();

    public abstract ArrayList<String> buildTabLinksList(); //top links in Android


}
