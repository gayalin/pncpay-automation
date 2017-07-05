package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.SeleniumUtil;
import com.pnc.pncpay.automation.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class SelectDefaultCardPageObject {
	
public AndroidDriver driver;
public By button_continue = By.id("com.fisglobal.lfi.pnc:id/pncpay_select_default_card_continue_btn");
private By title_SelectDefaultCardheader = By.xpath("//android.widget.TextView[contains(@resource-id,'com.fisglobal.lfi.pnc:id/toolbar_title_text') and @text='Select a Default Card']");
By newDefaultCardText = By.xpath("//android.widget.TextView[@text='�����5829']");
private String defaultTextElementPath =("//android.widget.FrameLayout[@index=%d]/android.widget.RelativeLayout[@index=0]/android.widget.LinearLayout[@index=2]/android.widget.TextView[@index=0]");
private String cardNumberElementPath = ("//android.widget.FrameLayout[@index=%d ]/android.widget.RelativeLayout[@index= 0]/android.widget.LinearLayout[@index=1]/android.widget.LinearLayout[@index=0]/android.widget.TextView[@index=1]");
private SeleniumUtil seleniumUtil;
private WaitUtil waitUtil;

public SelectDefaultCardPageObject(AndroidDriver driver) {
this.driver = driver;
this.seleniumUtil = new SeleniumUtil(driver);
this.waitUtil = new WaitUtil(driver);
}

public By getDefaultTextElementByFrameIndex(int index) {
	return By.xpath(String.format(defaultTextElementPath, index));
	
}

public By getCardNumberElementByFrameIndex(int index) {
	return By.xpath(String.format(cardNumberElementPath, index));
	
}

public String findCardNumberText(int Index) {
	try {
		return driver.findElement(getCardNumberElementByFrameIndex(Index)).getText();
	} catch (Exception nse) {
		System.out.println("=========== Card Number not found. :"
				+ nse.getMessage());
		return null;
	}
}

public boolean isDefaultTextElementPresent(int index) {
	try {
		return driver.findElement(getDefaultTextElementByFrameIndex(index)).isDisplayed();
	} catch (Exception nse) {
		System.out.println("=========== Default label is not present"
				+ nse.getMessage());
		return (Boolean) null;
	}
}

public String getCardNumberForFrameIndex(int index){
		return findCardNumberText(index);	
}

public void findDefaulTextElementOnCards(){
	int index =0;
	for(index=0; index<11; index++){
		boolean isDisplayed =  isDefaultTextElementPresent(index);
        if(isDisplayed){
        	break;
        }         
   }
	System.out.println("Default text is found at frame index  " + index);
	getCardNumberForFrameIndex(index);
	
	
}

public EnrollmentCompletePageObject clickButtonContinue(){
	WebElement continueButton = driver.findElement(button_continue);
	if (continueButton.isDisplayed())
		continueButton.click();
	return new EnrollmentCompletePageObject(driver);
}

public String getTitleSelectDefaultCardPage() {
    return driver.findElement(title_SelectDefaultCardheader).getText();
	}
	
	public boolean verifySelectDefaultCardPageTitle() {
		String expectedTitle = "Select a Default Card";
		return getTitleSelectDefaultCardPage().contains(expectedTitle);
	}

public void ChangeDefaultCard(){
	WebElement newDefaultElement = driver.findElement(newDefaultCardText);
	if(newDefaultElement.isDisplayed())
		newDefaultElement.click();
}

public boolean isPresent(){
	return seleniumUtil.isPresent(title_SelectDefaultCardheader);
}

public boolean waitForVisibilityOfSelectDefaultCardPageTitle() {
	return waitUtil.waitForElement(title_SelectDefaultCardheader);
}

public void checkLoaderElementPresent() {
	  //There is not any element like Loader on screen.
	  //So iselementpresent will be set to false.
	 WebElement defaultTextElement1 = driver.findElement(newDefaultCardText);
	  Boolean iselementpresent = driver.findElementsByName("Loader").size() != 0;
	  //iselementpresent will be false so assertion will fail and so test method will fail too.
	  Assert.assertTrue(iselementpresent,"Targeted element Loader is not present on screen");
	  System.out.println("Targeted element Loader is present on screen.");
	 }
}
