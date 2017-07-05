package com.pnc.pncpay.automation.regression.TestClasses;
import com.pnc.pncpay.automation.base.BaseTest;
import com.pnc.pncpay.automation.util.CacheClearPNCpayAppUtil;
import com.pnc.pncpay.automation.util.PncpayAsserterUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pnc.pncpay.automation.pageobject.CardEnrollmentErrorPageObject;
import com.pnc.pncpay.automation.pageobject.EnrollCardsPageObject;
import com.pnc.pncpay.automation.pageobject.LoginPageObject;
import com.pnc.pncpay.automation.pageobject.TermsAndConditionsPageObject;
import com.pnc.pncpay.automation.pageobject.TutorialPageObject;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;


public class CardEnrollmentErrorTest extends BaseTest {

	private AccountsPageObject welcomePage;
	private TutorialPageObject tutorialPage;
	private EnrollCardsPageObject enrollCardsPageObject;
	private CardEnrollmentErrorPageObject cardEnrollmentErrorPageObject;
	private TermsAndConditionsPageObject termsAndConditionsPage;
	private LoginPageObject loginPageObject;
	@BeforeTest
	public void beforeCardEnrollmentFailureTest() throws InterruptedException {
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
		// landing "Enroll Cards " page
		enrollCardsPageObject = termsAndConditionsPage.clickAgreeButton();
		// wait for displaying "Enroll in PNC Pay" tool bar text
		enrollCardsPageObject.waitForVisibilityOfEnrollInPNCPayPageTitle();
	}

	@Test(priority = 0)
	public void verifyLandingEnrollCardsErrorPage() throws InterruptedException {
		String text1 = "�����1135";
		enrollCardsPageObject.scrollToText(text1);
		// click on text
		enrollCardsPageObject.clickOnElementNameText(text1);
		String continueText = "CONTINUE";
		enrollCardsPageObject.scrollToExactText(continueText);
		// Click on "Continue" button
		cardEnrollmentErrorPageObject = enrollCardsPageObject
				.clickContinueButtonForErrorCards();
		//wait for Error Page Title
		cardEnrollmentErrorPageObject.waitForVisibilityOfEnrollErrorPageTitle();
		// verify "Error" text
		PncpayAsserterUtil.assertTrue(driver,cardEnrollmentErrorPageObject.isPresent());

	}



	//@Test(priority = 2)
	//public void verifyNavigateTutorialPageFromEnrollmentErrorPage()
	//		throws InterruptedException {
	//	cardEnrollmentErrorPage.clickOkFromCardEnrollErrorPage();
		// Verify "cards" text on TutorialPage
	//	PncpayAsserterUtil.assertTrue(driver, tutorialPage.isPresent());

	//}

	@AfterTest
	public void afterTestClearCache() throws InterruptedException {
		CacheClearPNCpayAppUtil cacheClearPNCpayApp = new CacheClearPNCpayAppUtil(
				driver);
		cacheClearPNCpayApp.CacheClearPNCPay();

		driver.quit();
	}
}
