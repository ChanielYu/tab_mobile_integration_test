package com.tabcorp.ui.core;

import io.appium.java_client.MobileElement;


public class Dropdown extends BaseCore{

    public Dropdown(MobileElement mobileElement) {
        this.mobileElement = mobileElement;
        this.safeMode = false;
    }

    public Dropdown(MobileElement mobileElement, boolean safeMode) {
        try {
            this.mobileElement = mobileElement;
            this.safeMode = true;
        } catch( Exception e) {
            System.out.println(e.toString());
        }
    }



}
