package com.tabcorp.ui.core;

import io.appium.java_client.MobileElement;

public class Button extends BaseCore {

    public Button(MobileElement mobileElement) {
        this.mobileElement = mobileElement;
        this.safeMode = false;
    }

    public Button(MobileElement mobileElement, boolean safeMode) {
        try {
            this.mobileElement = mobileElement;
            this.safeMode = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}
