package com.tabcorp.ui.core;

import io.appium.java_client.MobileElement;


public class List extends BaseCore{

    public List(MobileElement mobileElement) {
        this.mobileElement = mobileElement;
        this.safeMode = false;
    }

    public List(MobileElement mobileElement, boolean safeMode) {
        try {
            this.mobileElement = mobileElement;
            this.safeMode = true;
        } catch( Exception e) {
            System.out.println(e.toString());
        }
    }

    public void selectBySendKeys(String textValue) {
        this.text(textValue);
    }





}
