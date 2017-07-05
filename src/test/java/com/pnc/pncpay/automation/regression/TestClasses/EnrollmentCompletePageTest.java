package com.pnc.pncpay.automation.regression.TestClasses;
import com.pnc.pncpay.automation.base.BaseTest;
import com.pnc.pncpay.automation.util.PncpayAsserterUtil;
import com.pnc.pncpay.automation.util.ScrollPageUtil;
import com.pnc.pncpay.automation.pageobject.EnrollmentCompletePageObject;
import com.pnc.pncpay.automation.pageobject.TutorialPageObject;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pnc.pncpay.automation.pageobject.EnrollCardsPageObject;
import com.pnc.pncpay.automation.pageobject.LoginPageObject;
import com.pnc.pncpay.automation.pageobject.SelectDefaultCardPageObject;
import com.pnc.pncpay.automation.pageobject.TermsAndConditionsPageObject;


public class EnrollmentCompletePageTest extends BaseTest {

	private AndroidDriver driver;

	@BeforeTest
	public void beforeEnrollmentTest() throws InterruptedException {
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
		EnrollCardsPageObject enrollCardsPageObject = new EnrollCardsPageObject(driver);
		// Create ScrollPage object
		ScrollPageUtil scrollPageUtil = new ScrollPageUtil(driver);
		// scroll bottom to up until CardName by text is found
		String text = "PNC CARD 1";
		scrollPageUtil.verticalScrollBottomToUpUntilTextIsFound(text);
		// click on CardName text
		enrollCardsPageObject.clickOnElementNameText(text);
		// // scroll to until text "Continue" is found
		String continueText = "CONTINUE";
		enrollCardsPageObject.scrollToExactText(continueText);
		// Click on "Continue" button
		enrollCardsPageObject.clickContinueButtonForSuccessfullCards();
		Thread.sleep(8000L);
	}

	@Test
	public void verifyEnrollmentComplete() throws InterruptedException {

		// create "SelectDefaultCardPage" object
		SelectDefaultCardPageObject selectDefaultCardPage = new SelectDefaultCardPageObject(
				driver);
		// click "Continue" button
		selectDefaultCardPage.clickButtonContinue();
		Thread.sleep(4000L);
		// Create "EnrollmentCompletePage" object using page object class
		EnrollmentCompletePageObject enrollmentCompletePage = new EnrollmentCompletePageObject(
				driver);
		// verify the "Enrollment Complete" header title text in
		// EnrollmentComplete page
		String actual = enrollmentCompletePage.getTitleText();
		String expected = "Enrollment Complete";
		PncpayAsserterUtil.assertEquals(driver, actual, expected);
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
