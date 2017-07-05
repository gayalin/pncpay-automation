package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PNCPaySettingsPageObject {
	AndroidDriver driver;
	private By button_clearData = By
			.xpath("//android.widget.Button[contains(@resource-id,'com.android.settings:id/right_button') and @text='Clear data']");
	
	private By linkAppInfo = By.xpath("//android.widget.TextView[contains(@resource-id,'com.fisglobal.lfi.pnc:id/dd_debug_settings_info_title') and @text='App info']");
	private By clearPopupButton = By.xpath("//android.widget.Button[contains(@resource-id,'android:id/button1') and @text='Clear']");
	private WaitUtil waitUtil;
	

	public PNCPaySettingsPageObject(AndroidDriver driver) {

		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}

	public void clickClearData() {
		
		WebElement clearDataElement = driver.findElement(button_clearData);
		if (clearDataElement.isDisplayed() || clearDataElement.isEnabled())
			clearDataElement.click();
	}
	
	public void clickClearPopUpButton() {
		
		WebElement clearPopUpElement = driver.findElement(clearPopupButton);
		if (clearPopUpElement.isDisplayed()||clearPopUpElement.isEnabled())
			clearPopUpElement.click();
		System.out.println("Cleared the cache");
	}
	
	public void clickOnAppInfoLink(){
		WebElement appInfoElement = driver.findElement(linkAppInfo);
		if (appInfoElement.isDisplayed()||appInfoElement.isEnabled())
			appInfoElement.click();
	}

	public boolean waitForVisibilityOfClearDataButton() {
		return waitUtil.waitForElement(button_clearData);
	}
	
	public boolean waitForVisibilityOfClearPopUpButton() {
		return waitUtil.waitForElement(clearPopupButton);
	}
}
