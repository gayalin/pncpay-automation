package com.pnc.pncpay.automation.util;

import com.pnc.pncpay.automation.pageobject.PNCPaySettingsPageObject;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class CacheClearPNCpayAppUtil {
	AndroidDriver driver;
	private PNCPaySettingsPageObject pNCPaySettingsPage;

	By text_AppInfo = By
			.xpath("//android.widget.ScrollView[@index=1]/android.widget.LinearLayout[@index=0]/android.widget.GridLayout[@index=11]/android.widget.TextView[@index=9]");
	By button_Clear = By.id("android:id/button1");
	By button_ClearData = By
			.xpath("//android.widget.Button[@text='Clear data']");

	public CacheClearPNCpayAppUtil(AndroidDriver driver) {

		this.driver = driver;
	}

	@Test
	public void CacheClearPNCPay() throws InterruptedException {
		ScrollPageUtil scrollPageUtil = new ScrollPageUtil(driver);
		scrollPageUtil.horizontalScrollRightToLeft(0.96, 0.30);
		String text = "App info";
		scrollPageUtil.ScrollToText(text);
		PNCPaySettingsPageObject pNCPaySettingsPage = new PNCPaySettingsPageObject(driver);
		pNCPaySettingsPage.clickOnAppInfoLink();
		System.out.println("waiting for displaying Clear Data Button");
		pNCPaySettingsPage.waitForVisibilityOfClearDataButton();
		
		pNCPaySettingsPage.clickClearData();
		// wait for "CLEAR" PopUp Button is visible
		pNCPaySettingsPage.waitForVisibilityOfClearPopUpButton();
		pNCPaySettingsPage.clickClearPopUpButton();
		

		// Thread.sleep(2000L);
		// driver.findElement(button_Clear).click();
	}

}
