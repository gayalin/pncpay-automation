package com.pnc.pncpay.automation.regression.TestClasses;
import com.pnc.pncpay.automation.base.BaseTest;
import com.pnc.pncpay.automation.pageobject.LoginPageObject;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;
import com.pnc.pncpay.automation.pageobject.TutorialPageObject;
import com.pnc.pncpay.automation.util.ScrollPageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TutorialPageTest extends BaseTest {

	private AccountsPageObject welcomePage;
	private TutorialPageObject tutorialPage;
	private LoginPageObject loginPageObject;
	

	@BeforeTest
	public void beforeTutorialTest() throws InterruptedException {
		System.out.println("Login test is started");
		// Create LoginPage object
		loginPageObject = new LoginPageObject(driver);
		String UserName = "wallet07";
		//wait for UserID text box & set username
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

	}

	@Test(priority = 0)
	public void verifyLandingTutorialPage() {
		//Click on "OpenMenu" button
		welcomePage.clickOpenMenu();
		//Wait for "Cards" tab is displayed
		welcomePage.waitForVisibilityOfCardsTab();
		//Click "Cards" button to navigate to "Tutorial Page"
		tutorialPage = welcomePage.clickCardsButton();
		//Wait for "Cards" title bar
		tutorialPage.waitForVisibilityOfTutorialPageTitleBar();
		//click Allow to make and manage phone calls
		tutorialPage.clickAllowButtonIfAvailable();
		Assert.assertTrue(tutorialPage.verifyTutorialPageTitle(), "Tutorial page title doesn't match");

	}

	@Test(priority = 1,dependsOnMethods = {"verifyLandingTutorialPage"})
	public void userCanSwipeAndReadTheContent() throws InterruptedException {
		// Create "ScrollPage" object
		ScrollPageUtil scrollPage = new ScrollPageUtil(driver);
		for (int i = 1; i < 3; i++) {
			scrollPage.horizontalScrollRightToLeft(0.90, 0.10);
		}
		// Verify "Fraud Protection" text view
		Assert.assertTrue(tutorialPage.isViewFraudProtectionTextAvailable(), "Fraud Protection text is not displayed,Test failed");

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		 driver.quit();
	}

}
