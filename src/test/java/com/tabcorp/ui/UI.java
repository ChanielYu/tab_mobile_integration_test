package com.tabcorp.ui;

import com.tabcorp.ui.core.*;
import io.appium.java_client.MobileElement;

public class UI {

    //Unsafe means if this element is not found, this cases will be failed and all the following test cases will be ignored
    public static Button asButton(MobileElement mobileElement) {
        return new Button(mobileElement);
    }

    public static Dropdown asDropdown(MobileElement mobileElement) {
        return new Dropdown(mobileElement);
    }

    public static InputField asInputField(MobileElement mobileElement) {
        return new InputField(mobileElement);
    }

    public static Link asLink(MobileElement mobileElement) {
        return new Link(mobileElement);
    }

    public static List asList(MobileElement mobileElement) {
        return new List(mobileElement);
    }

    public static TextView asText(MobileElement mobileElement) {
        return new TextView(mobileElement);
    }

    //Safe means even this element is not found, this test case will still continue, will not impact the following test
    public static Button asButtonSafe(MobileElement mobileElement) {
        return new Button(mobileElement,true);
    }

    public static Dropdown asDropdownSafe(MobileElement mobileElement) {
        return new Dropdown(mobileElement );
    }

    public static InputField asInputFieldSafe(MobileElement mobileElement) {
        return new InputField(mobileElement,true);
    }

    public static Link asLinkSafe(MobileElement mobileElement) {
        return new Link(mobileElement,true);
    }

    public static List asListSafe(MobileElement mobileElement) {
        return new List(mobileElement,true);
    }

    public static TextView asTextSafe(MobileElement mobileElement) {
        return new TextView(mobileElement,true);
    }

}
