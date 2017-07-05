package com.pnc.pncpay.automation.regression.TestClasses;

import com.pnc.pncpay.automation.base.BaseTest;
import com.pnc.pncpay.automation.pageobject.EnrollCardsPageObject;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;
import com.pnc.pncpay.automation.util.SeleniumUtil;
import com.pnc.pncpay.automation.pageobject.SelectDefaultCardPageObject;
import com.pnc.pncpay.automation.util.ScrollPageUtil;
import com.pnc.pncpay.automation.pageobject.LoginPageObject;
import com.pnc.pncpay.automation.pageobject.TutorialPageObject;
import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.pnc.pncpay.automation.pageobject.TermsAndConditionsPageObject;

public class SelectDefaultCardPageTest extends BaseTest {

	private AccountsPageObject accountsPageObject;
	private LoginPageObject loginPageObject;
	private TutorialPageObject tutorialPageObject;
	private TermsAndConditionsPageObject termsAndConditionsPageObject;
	private ScrollPageUtil scrollPageUtil;
	private SeleniumUtil seleniumUtil;
	private EnrollCardsPageObject enrollCardsPageObject;
	private SelectDefaultCardPageObject selectDefaultCardPageObject;
	private AndroidDriver driver;

	@BeforeTest
	public void beforeSelectDefaultTest() throws InterruptedException {
		System.out.println("Login test is started");
		// Create LoginPage object
		loginPageObject = new LoginPageObject(driver);
		String UserName = "wallet01";
		// set username
		loginPageObject.waitForVisibilityOfSignInTitle();
		loginPageObject.setUserName(UserName);
		// click "Continue" button
		loginPageObject.clickContinue();
		loginPageObject.waitForAnswerTitle();
		// set an answer for security question
		String Answer = "wall";
		loginPageObject.setAnswer(Answer);
		// click "Continue" button
		loginPageObject.clickContinue();
		loginPageObject.waitForEnterYourPasswordTitle();
		// set password
		String Password = "wall1234";
		loginPageObject.setPassword(Password);
		accountsPageObject = loginPageObject.clickSignOn();
		accountsPageObject.waitForVisibilityOfAccountsTitleBar();
		// Click on "OpenMenu" button
		accountsPageObject.clickOpenMenu();
		// Wait for "Cards" tab is displayed
		accountsPageObject.waitForVisibilityOfCardsTab();
		// Click "Cards" button to navigate to "Tutorial Page"
		tutorialPageObject = accountsPageObject.clickCardsButton();
		// Wait for "Cards" title bar is displayed
		tutorialPageObject.waitForVisibilityOfTutorialPageTitleBar();
		// Click "Get Started" button
		termsAndConditionsPageObject = tutorialPageObject.clickGetStarted1();
		// Wait for "TandCs" header title bar is displayed
		termsAndConditionsPageObject.waitForVisibilityOfTandCsPageTitleBar();
		// landing "Enroll Cards " page
		enrollCardsPageObject = termsAndConditionsPageObject.clickAgreeButton();
		// wait for displaying "Enroll in PNC Pay" tool bar text
		enrollCardsPageObject.waitForVisibilityOfEnrollInPNCPayPageTitle();

	}

	@Test(priority = 0)
	public void verify_LandingSelectdefaultCardPage()
			throws InterruptedException {
		String text1 = "�����1135";
		enrollCardsPageObject.scrollToText(text1);
		// click on text
		enrollCardsPageObject.clickOnElementNameText(text1);
		selectDefaultCardPageObject = enrollCardsPageObject
				.clickContinueButtonForSuccessfullCards();
		// wait for loading "Select a Default card page"
		selectDefaultCardPageObject
				.waitForVisibilityOfSelectDefaultCardPageTitle();
		Assert.assertTrue(
				selectDefaultCardPageObject.verifySelectDefaultCardPageTitle(),
				"Select Default Card page title doesn't match");

	}

	@Test(priority = 1)
	public void printDefaultCardElementText() {
		selectDefaultCardPageObject.findDefaulTextElementOnCards();
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
