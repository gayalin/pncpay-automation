package com.pnc.pncpay.automation.util;

import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	private AndroidDriver driver;
	private static Logger log = Logger.getLogger(Log.class);
	public WaitUtil(AndroidDriver driver) {
		this.driver = driver;
	}

	public boolean waitForElement(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			log.info(locator + " is visible");
			return true;
		}catch (Throwable e){
			log.error(e.getMessage());
		//new CreateScreenShotsUtil(driver).takeScreenshot("CardTestCase");
		return false;
	}


	}

}
