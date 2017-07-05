package com.pnc.pncpay.automation.regression.TestClasses;
import com.pnc.pncpay.automation.base.BaseTest;
import com.pnc.pncpay.automation.util.CacheClearPNCpayAppUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.pnc.pncpay.automation.pageobject.EnrollCardsPageObject;
import com.pnc.pncpay.automation.pageobject.LoginPageObject;
import com.pnc.pncpay.automation.pageobject.SelectDefaultCardPageObject;
import com.pnc.pncpay.automation.pageobject.TermsAndConditionsPageObject;
import com.pnc.pncpay.automation.pageobject.TutorialPageObject;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;

public class EnrollCardsPageTest extends BaseTest {

	private AccountsPageObject welcomePage;
	private TutorialPageObject tutorialPage;
	private TermsAndConditionsPageObject termsAndConditionsPage;
	private EnrollCardsPageObject enrollCardsPage;
	private SelectDefaultCardPageObject selectDefaultCardPage;
	private LoginPageObject loginPageObject;

	@BeforeTest
	public void beforeEnrollCardsTest() throws InterruptedException {
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
		welcomePage = loginPageObject.clickSignOn();
		welcomePage.waitForVisibilityOfAccountsTitleBar();
		// Click on "OpenMenu" button
		welcomePage.clickOpenMenu();
		// Wait for "Cards" tab is displayed
		welcomePage.waitForVisibilityOfCardsTab();
		// Click "Cards" button to navigate to "Tutorial Page"
		tutorialPage = welcomePage.clickCardsButton();
		// Wait for "Cards" title bar is displayed
		tutorialPage.waitForVisibilityOfTutorialPageTitleBar();
		// Click "Get Started" button
		termsAndConditionsPage = tutorialPage.clickGetStarted1();
		// Wait for "TandCs" header title bar is displayed
		termsAndConditionsPage.waitForVisibilityOfTandCsPageTitleBar();
	}

	@Test(priority = 0)
	public void verifyLandingEnrollCardsPage() throws InterruptedException {
		// landing "Enroll Cards " page
		enrollCardsPage = termsAndConditionsPage.clickAgreeButton();
		// wait for displaying "Enroll in PNC Pay" tool bar text
		enrollCardsPage.waitForVisibilityOfEnrollInPNCPayPageTitle();
		// Verify "Enroll in PNC Pay" toolbar text
		Assert.assertTrue(enrollCardsPage.verifyEnrollCardsPageTitle(),
				"Enroll in PNC Pay page title doesn't match");
	}

	@Test(priority = 1,dependsOnMethods = {"verifyLandingEnrollCardsPage"})
	public void verifyclickingCancelButtonReturningBackToTutorialPage()
			throws InterruptedException {
		// Scroll to "Cancel" button
		String text = "Cancel";
		enrollCardsPage.scrollToText(text);
		// Click "cancel" button
		tutorialPage = enrollCardsPage.clickCancelButton();
		// Wait for "Cards" title bar (Tutorial Page) is displayed
		tutorialPage.waitForVisibilityOfTutorialPageTitleBar();
		Assert.assertTrue(tutorialPage.verifyTutorialPageTitle(),
				"Tutorial page title doesn't match");
	}

	@Test(priority = 2,dependsOnMethods = "verifyclickingCancelButtonReturningBackToTutorialPage")
	public void verifyNavigatingBackFromTutorialPage()
			throws InterruptedException {
		// navigate back from tutorial page
		enrollCardsPage = tutorialPage.clickGetStarted2();
		// wait for displaying "Enroll in PNC Pay" tool bar text
		enrollCardsPage.waitForVisibilityOfEnrollInPNCPayPageTitle();
		// Verify "Enroll in PNC Pay" toolbar text
		Assert.assertTrue(enrollCardsPage.verifyEnrollCardsPageTitle(),
				"Enroll in PNC Pay page title doesn't match");

	}

	@Test(priority = 3,dependsOnMethods = {"verifyNavigatingBackFromTutorialPage"})
	public void verifyCardEnrollmentSuccessfull() throws InterruptedException {
		// scroll for text
		String text1 = "�����1135";
		enrollCardsPage.scrollToText(text1);
		// click on text
		enrollCardsPage.clickOnElementNameText(text1);
		selectDefaultCardPage = enrollCardsPage
				.clickContinueButtonForSuccessfullCards();
		// wait for loading "Select a Default card page"
		selectDefaultCardPage.waitForVisibilityOfSelectDefaultCardPageTitle();

	}

	@AfterTest
	public void afterTestClearCache() throws InterruptedException {
		CacheClearPNCpayAppUtil cacheClearPNCpayApp = new CacheClearPNCpayAppUtil(
				driver);
		cacheClearPNCpayApp.CacheClearPNCPay();

		driver.quit();
	}

}
