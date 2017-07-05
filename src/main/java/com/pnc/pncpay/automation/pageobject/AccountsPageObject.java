package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.ElementUtil;
import com.pnc.pncpay.automation.util.SeleniumUtil;
import com.pnc.pncpay.automation.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AccountsPageObject {

	private AndroidDriver driver;
	private By buttonHamburger = By
			.id("com.pnc.ecommerce.mobile.finder:id/image_navigation");
	private By titleAccounts = By
			.xpath("//android.widget.TextView[contains(@resource-id,'com.pnc.ecommerce.mobile.finder:id/toolbar_title_text') and @text='ACCOUNTS']");
	private By buttonCards = By
			.xpath("//android.widget.Button[contains(@resource-id,'com.pnc.ecommerce.mobile.finder:id/contextual_icon') and @text='CARDS']");

	private SeleniumUtil seleniumUtils;
	private WaitUtil waitUtils;

	public AccountsPageObject(AndroidDriver driver) {
		this.driver = driver;
		this.seleniumUtils = new SeleniumUtil(driver);
		this.waitUtils = new WaitUtil(driver);
	}
	// click OpenMenu button

	public void clickOpenMenu() {
		WebElement MenuButton = driver.findElement(buttonHamburger);
		if (MenuButton.isDisplayed() || MenuButton.isEnabled());
		MenuButton.click();
	}

	//Click on "CARDS"
	public TutorialPageObject clickCardsButton(){
		ElementUtil elementUtil = new ElementUtil();
		return new TutorialPageObject(driver);
	}
	// Get Accounts page title
	public String getWelcomePageTitle() {
		return driver.findElement(titleAccounts).getText();
	}

	public boolean verifyAccountPageTitle() {
		String expectedTitle = "ACCOUNTS";
		return getWelcomePageTitle().contains(expectedTitle);
	}

	public boolean waitForVisibilityOfAccountsTitleBar() {
	return waitUtils.waitForElement(titleAccounts);
	}

	public boolean waitForVisibilityOfCardsTab() {
		return waitUtils.waitForElement(buttonCards);
	}
}
