package com.tabcorp.ui.core;

import io.appium.java_client.MobileElement;


public class Link extends BaseCore{

    public Link(MobileElement mobileElement) {
        this.mobileElement = mobileElement;
        this.safeMode = false;
    }

    public Link(MobileElement mobileElement, boolean safeMode) {
        try {
            this.mobileElement = mobileElement;
            this.safeMode = true;
        } catch( Exception e) {
            System.out.println(e.toString());
        }
    }


}
