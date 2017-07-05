package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class CardHubTandCsPageObject {

private AndroidDriver driver;

private By titleHeaderText = By.xpath("//android.widget.TextView[@text='Terms & Conditions']");
private By buttonClose = By.id("com.fisglobal.lfi.pnc:id/pncpay_terms_close_button");
private WaitUtil waitUtil;

public CardHubTandCsPageObject(AndroidDriver driver) {

		this.driver = driver;

	}
public String getCardHubTandCsTitle() {
	String pageTitle = driver.findElement(titleHeaderText).getText();
	return pageTitle;
}

public boolean waitForVisibilityOfHeaderText(){
	   return waitUtil.waitForElement(titleHeaderText);
}


public boolean verifySignInPageTitle() {
	String expectedTitle = "Terms & Conditions";
	return getCardHubTandCsTitle().contains(expectedTitle);
}

public CardHubPageObject clickonCloseButton() {
	WebElement element=driver.findElement(buttonClose);
	if(element.isDisplayed()||element.isEnabled())
		element.click();
	return new CardHubPageObject(driver);
	
	
}
}
