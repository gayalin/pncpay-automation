package com.pnc.pncpay.automation.regression.TestClasses;

import com.pnc.pncpay.automation.base.BaseTest;
import com.pnc.pncpay.automation.util.PncpayAsserterUtil;
import com.pnc.pncpay.automation.util.ScrollPageUtil;
import com.pnc.pncpay.automation.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.pnc.pncpay.automation.pageobject.CardHubPageObject;
import com.pnc.pncpay.automation.pageobject.CardHubTandCsPageObject;
import com.pnc.pncpay.automation.pageobject.EnrollCardsPageObject;
import com.pnc.pncpay.automation.pageobject.EnrollmentCompletePageObject;
import com.pnc.pncpay.automation.pageobject.LoginPageObject;
import com.pnc.pncpay.automation.pageobject.SelectDefaultCardPageObject;
import com.pnc.pncpay.automation.pageobject.TermsAndConditionsPageObject;
import com.pnc.pncpay.automation.pageobject.TutorialPageObject;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;


public class CardHubPageTest extends BaseTest {

	private CardHubPageObject cardHubPageObject;
	private ScrollPageUtil scrollPageUtil;
	private CardHubTandCsPageObject cardHubTandCsPage;
	private WaitUtil waitUtil;
	private By locator;
	private AndroidDriver driver;

	@BeforeTest
	public void beforeCardHubTest() throws InterruptedException {
		// Create LoginPage object
		LoginPageObject loginPageObject = new LoginPageObject(driver);
		// Use Page object-LoginPAge,set UserName
		loginPageObject.setUserName("UserName");
		// Click "Continue"
		loginPageObject.clickContinue();
		Thread.sleep(3000L);
		// Create WelcomePage object
		AccountsPageObject welcome = new AccountsPageObject(driver);
		// Using PageObjects,Click "Open Menu"
		welcome.clickOpenMenu();
		// Using PageObjects,Click "Cards"
		welcome.clickCardsButton();
		// Create "TutorialPage" page object using "TutorialPage" page object
		// class
		TutorialPageObject tutorialpage = new TutorialPageObject(driver);
		// Click on "Get Started" using page object class
		tutorialpage.clickGetStarted1();
		Thread.sleep(5000L);
		// Create "terms & Conditions" object
		TermsAndConditionsPageObject termsandconditions = new TermsAndConditionsPageObject(
				driver);
		// Click on "Agree" button using page object class
		termsandconditions.clickAgreeButton();
		Thread.sleep(3000L);
		// Create EnrollCardsPage object
		EnrollCardsPageObject enrollCardsPage = new EnrollCardsPageObject(driver);
		// Create ScrollPage object
		ScrollPageUtil scrollPageUtil = new ScrollPageUtil(driver);
		// scroll bottom to up until CardName by text is found
		String text = "PNC CARD 1";
		scrollPageUtil.verticalScrollBottomToUpUntilTextIsFound(text);
		// click on CardName text
		enrollCardsPage.clickOnElementNameText(text);
		// scroll to until text "Continue" is found
		String continueText = "CONTINUE";
		enrollCardsPage.scrollToExactText(continueText);
		// Click on "Continue" button
		enrollCardsPage.clickContinueButtonForSuccessfullCards();
		Thread.sleep(10000L);
		// create "SelectDefaultCardPage" object
		SelectDefaultCardPageObject selectDefaultCardPage = new SelectDefaultCardPageObject(
				driver);
		// click "Continue" button
		selectDefaultCardPage.clickButtonContinue();
		Thread.sleep(4000L);
		// Create "CardHubPage" object
		cardHubPageObject = new CardHubPageObject(driver);
	}

	@Test(priority = 0 ,groups = {"grp1,grp2"})
	public void VerifyNavigatingCardHubPage() throws InterruptedException {

		// Create "EnrollmentCompletePage" object using page object class
		EnrollmentCompletePageObject enrollmentCompletePage = new EnrollmentCompletePageObject(
				driver);
		enrollmentCompletePage.clickButtonContinue();
		Thread.sleep(3000L);
		// verify the "Cards" header title text in CardHub page
		String actual = cardHubPageObject.getCardHubToolbarTitleText();
		String expected = "Cards";
		PncpayAsserterUtil.assertEquals(driver, actual, expected);
		Thread.sleep(2000L);
	}

	@Test(priority = 1)
	public void verifyLoadingCardHubTandCsPage() throws InterruptedException {
		// click "See More" butoon
		cardHubPageObject.clickSeeMore();
		// Create ScrollPage object
		String text = "Terms & Conditions";
		scrollPageUtil.ScrollToText(text);
		// Click on "T & Cs" text link
		cardHubTandCsPage = cardHubPageObject.clickTandCsTextLink();
		//Wait for visibility of HeaderText
		cardHubTandCsPage.waitForVisibilityOfHeaderText();
       // verify the "Terms & Conditions" header title text in CardHub page
		String actual = cardHubTandCsPage.getCardHubTandCsTitle();
		String expected = "Terms & Conditions";
		PncpayAsserterUtil.assertEquals(driver, actual, expected);
		Thread.sleep(2000L);
	}

	@Test(priority = 2)
	public void verifyNavigatingBackCardHubFromTandCsPage()
			throws InterruptedException {

		// Click "Close" button on "T&Cs" page
		cardHubTandCsPage.clickonCloseButton();
		//Wait for visibility of HeaderText
		cardHubPageObject.waitForVisibilityOfHeaderText();
		// verify the "Cards" header title text in CardHub page
		String actual = cardHubPageObject.getCardHubToolbarTitleText();
		String expected = "Cards";
		PncpayAsserterUtil.assertEquals(driver, actual, expected);
		Thread.sleep(2000L);

	}

	@Test(priority = 3)
	public void verifySecondaryEnrollmentCardHub() throws InterruptedException {
       // click "See More" button
		cardHubPageObject.clickSeeMore();
		Thread.sleep(2000L);
		// Create ScrollPage object
		ScrollPageUtil scrollPageUtil = new ScrollPageUtil(driver);
		// scroll for Exact "" text is found
		// String text = "PNC Consumer Card";
		// scrollPage.verticalScrollBottomToUpUntilTextIsFound(text);
		// Click on Card for Secondary enrollment
		// cardhubpage.clickOnElementNameText(text);
		// Click on card for secondary enrollment
		cardHubPageObject.clickForSecondaryEnrollment();
		Thread.sleep(2000L);
		// Click on "Enroll" button
		cardHubPageObject.clickEnrollCardsInPNCPay();
		Thread.sleep(6000L);
		// create "EnrollmentCompletePage" object
		EnrollmentCompletePageObject enrollmentCompletePage = new EnrollmentCompletePageObject(
				driver);
		// Verify "Enrollment Complete" text
		String actual = enrollmentCompletePage.getTitleText();
		String expected = "Enrollment Complete";
		PncpayAsserterUtil.assertEquals(driver, actual, expected);
	}

	@Test(priority = 3)
	public void verifySetDefaultCardCardHub() throws InterruptedException {
		// Create "EnrollmentCompletePage" object using page object class
		EnrollmentCompletePageObject enrollmentCompletePage = new EnrollmentCompletePageObject(
				driver);
		enrollmentCompletePage.clickButtonContinue();
		// click on "Enrolled" card for setting it as "Default"
		cardHubPageObject.clickSeeMore();
		cardHubPageObject.clickForSecondaryEnrollment();
		// click on "SET AS DEFAULT CARD"
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
