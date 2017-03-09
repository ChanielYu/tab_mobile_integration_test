package com.tabcorp.ui.core;

import io.appium.java_client.MobileElement;

import java.util.concurrent.TimeUnit;

public class BaseCore {

    protected MobileElement mobileElement;
    protected Boolean safeMode;

    public void click() {
        if(safeMode) {
            try {
                mobileElement.click();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }else {
            mobileElement.click();
        }
    }

    public Boolean isDisplayed() {
        if( safeMode) {
            try {
                return mobileElement.isDisplayed();
            } catch (Exception e) {
                System.out.println(e.toString());
                return false;
            }
        }
        else {
            return mobileElement.isDisplayed();
        }
    }

    public Boolean waitToDisplayed(Integer waitSeconds) {
        Integer count = 0;
        Integer maxCount = waitSeconds /10;
        long start = System.currentTimeMillis();
        while (true) {
            try {
                if ( mobileElement.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            try {
                TimeUnit.SECONDS.sleep(waitSeconds / 10);
                count++;
            } catch (java.lang.InterruptedException e) {

            }
            if (count >= maxCount) {
                return false;
            }

        }
    }

    public String getText(){
        if(safeMode) {
            try {
                return mobileElement.getText();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        else {
            return mobileElement.getText();
        }
        return "";
    }

    public void text(String text) {
        if(safeMode) {
            try {
                mobileElement.sendKeys(text);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }else {
            mobileElement.sendKeys(text);
        }
    }

}
