package com.pnc.pncpay.automation.regression.TestClasses;

import com.pnc.pncpay.automation.base.BaseTest;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;
import com.pnc.pncpay.automation.pageobject.TutorialPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.pnc.pncpay.automation.pageobject.LoginPageObject;
import com.pnc.pncpay.automation.pageobject.TermsAndConditionsPageObject;

public class TandCsPageTest extends BaseTest {

	private AccountsPageObject accountsPageObject;
	private TutorialPageObject tutorialPageObject;
	private TermsAndConditionsPageObject termsAndConditionsPageObject;
	private LoginPageObject loginPageObject;

	@BeforeTest
	public void beforeTandCsTest() throws InterruptedException {
		System.out.println("Login test is started");
		// Create LoginPage object
		loginPageObject = new LoginPageObject(driver);
		String UserName = "wallet01";
		// wait for UserID text box & set username
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
	}

	@Test(priority = 0)
	public void verifyLandingTandCsPage() throws InterruptedException {
		// Click "Get Started" button
		termsAndConditionsPageObject = tutorialPageObject.clickGetStarted1();
		// Wait for "TandCs" header title bar is displayed
		termsAndConditionsPageObject.waitForVisibilityOfTandCsPageTitleBar();
		// verify "Terms & Conditions" title text on header
		Assert.assertTrue(termsAndConditionsPageObject.verifyTandCsPageTitle(),
				"TandCs page title doesn't match");

	}

	@Test(priority = 1,dependsOnMethods = {"verifyLandingTandCsPage"})
	public void verify_ClickingCancelReturningBackToTutorialPage() {
		tutorialPageObject = termsAndConditionsPageObject.clickCancelButton();
		// Wait for "Cards" title bar is displayed
		tutorialPageObject.waitForVisibilityOfTutorialPageTitleBar();
		Assert.assertTrue(tutorialPageObject.verifyTutorialPageTitle(),
				"Tutorial page title doesn't match");
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
