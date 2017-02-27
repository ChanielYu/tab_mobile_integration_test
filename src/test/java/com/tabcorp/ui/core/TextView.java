package com.tabcorp.ui.core;

import io.appium.java_client.MobileElement;

public class TextView extends BaseCore{

    public TextView(MobileElement mobileElement) {
        this.mobileElement = mobileElement;
        this.safeMode = false;
    }

    public TextView(MobileElement mobileElement, boolean safeMode) {
        try {
            this.mobileElement = mobileElement;
            this.safeMode = true;
        } catch( Exception e) {
            System.out.println(e.toString());
        }
    }



}
