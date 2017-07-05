package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.SeleniumUtil;
import com.pnc.pncpay.automation.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TermsAndConditionsPageObject {

	private AndroidDriver driver;
	private By button_Agree = By
			.id("com.fisglobal.lfi.pnc:id/pncpay_terms_continue_button");
	private By button_Cancel = By
			.id("com.fisglobal.lfi.pnc:id/pncpay_terms_cancel_button");
	private By title_TermsandConditions = By
			.xpath("//android.widget.TextView[contains(@resource-id,'com.fisglobal.lfi.pnc:id/toolbar_title_text') and @text='Terms & Conditions']");
	private SeleniumUtil seleniumUtils;
	private WaitUtil waitUtils;

	public TermsAndConditionsPageObject(AndroidDriver driver) {
		this.driver = driver;
		this.seleniumUtils = new SeleniumUtil(driver);
		this.waitUtils = new WaitUtil(driver);
	}

	// Click "Agree" button
	public EnrollCardsPageObject clickAgreeButton() {
		WebElement agreeButton = driver.findElement(button_Agree);
		if (agreeButton.isDisplayed() || agreeButton.isEnabled())
			agreeButton.click();
		return new EnrollCardsPageObject(driver);

	}

	// Click "Cancel"
	public TutorialPageObject clickCancelButton() {
		WebElement cancelButton = driver.findElement(button_Cancel);
		if (cancelButton.isDisplayed() || cancelButton.isEnabled())
			cancelButton.click();
		return new TutorialPageObject(driver);

	}

	// Get title "TermsandConditions"

	public String getTandCsPageTitle() {

		return driver.findElement(title_TermsandConditions).getText();
	}

	public boolean verifyTandCsPageTitle() {
		String expectedTitle = "Terms & Conditions";
		return getTandCsPageTitle().contains(expectedTitle);
	}

	public boolean isPresent() {
		return seleniumUtils.isPresent(title_TermsandConditions);
	}

	public boolean waitForVisibilityOfTandCsPageTitleBar() {
		return waitUtils.waitForElement(title_TermsandConditions);
	}
}
