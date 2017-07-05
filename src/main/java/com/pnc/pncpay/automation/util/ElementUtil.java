package com.pnc.pncpay.automation.util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by GWITHARANA on 5/19/2017.
 */
public class ElementUtil {
    public static AndroidDriver driver;
    //public static By locator;

    public static void click(By locator){
        WebElement element = driver.findElement(locator);
        if (element.isDisplayed()||element.isEnabled());
        element.click();
    }
}
