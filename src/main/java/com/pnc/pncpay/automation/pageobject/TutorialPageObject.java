package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.PncpayAsserterUtil;
import com.pnc.pncpay.automation.util.SeleniumUtil;
import com.pnc.pncpay.automation.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TutorialPageObject {

	private AndroidDriver driver;
	private By button_GetStarted = By
			.xpath("//android.widget.Button[@text='GET STARTED']");
	private By titleCards = By
			.xpath("//android.widget.TextView[@text='Cards']");
	private By textFraudProtection = By
			.xpath("//android.widget.TextView[@text='Fraud Protection']");
	private By button_Allow = By
			.xpath("//android.widget.Button[contains(@resource-id,'com.android.packageinstaller:id/permission_allow_button') and @text='Allow']");

	private SeleniumUtil seleniumUtils;
	private WaitUtil waitUtils;
	public TutorialPageObject(AndroidDriver driver) {
		this.driver = driver;
		this.seleniumUtils = new SeleniumUtil(driver);
		this.waitUtils = new WaitUtil(driver);
	}

	public String getTutorialPageTitle() {
		return driver.findElement(titleCards).getText();
	}

	public boolean verifyTutorialPageTitle() {
		String expectedTitle = "Cards";
		return getTutorialPageTitle().contains(expectedTitle);
	}

	// Click on GetStarted button to navigate Terms and Conditions page

	public TermsAndConditionsPageObject clickGetStarted1() {

		WebElement getStartedButton = driver.findElement(button_GetStarted);

		if (getStartedButton.isDisplayed() || getStartedButton.isEnabled())
			getStartedButton.click();
		return new TermsAndConditionsPageObject(driver);

	}

	// Get "Cards" title text
	public String getTitleCards() {

		return driver.findElement(titleCards).getText();

	}

	// verify "Fraud Protection " text view

	public void viewFraudProtectionText() {
		PncpayAsserterUtil pncPayAsserter = new PncpayAsserterUtil(driver);
		pncPayAsserter.assertTrueIsDisplayed(driver, textFraudProtection);

	}

	public boolean isViewFraudProtectionTextAvailable(){

		return driver.findElement(textFraudProtection).isDisplayed();
	}

	// Returning back to "EnrollCardsPage" upon clicking on "Get Started" button

	public EnrollCardsPageObject clickGetStarted2() {
		WebElement getStartedButton = driver.findElement(button_GetStarted);
		if (getStartedButton.isDisplayed() || getStartedButton.isEnabled())
			getStartedButton.click();
		return new EnrollCardsPageObject(driver);
	}

	public boolean isPresent() {
		return seleniumUtils.isPresent(titleCards);
	}
	
	public void clickAllowButtonIfAvailable(){
    WebElement allowButton = driver.findElement(button_Allow);
	if (allowButton.isDisplayed()||allowButton.isEnabled())
		allowButton.click();
	}

	public boolean waitForVisibilityOfTutorialPageTitleBar() {
		return waitUtils.waitForElement(titleCards);
	}

	public boolean waitForVisibilityOfAllowButton() {
		return waitUtils.waitForElement(button_Allow);
	}
}
