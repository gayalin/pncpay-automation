package TestSuite;

import com.pnc.pncpay.automation.regression.TestClasses.EnrollCardsPageTest;
import com.pnc.pncpay.automation.regression.TestClasses.LoginPNCPayTest;
import com.pnc.pncpay.automation.regression.TestClasses.TandCsPageTest;
import com.pnc.pncpay.automation.regression.TestClasses.TutorialPageTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by GWITHARANA on 5/1/2017.
 */
public class E2ETestSuite {

    @BeforeTest
    public void beforeTest(){
        System.out.println("E2E Test is Started");
    }

    @Test(priority = 1)
    public void TC01_loginToMassmarketApp()throws InterruptedException{
        LoginPNCPayTest loginPNCPayTest = new LoginPNCPayTest();
        loginPNCPayTest.verifyLoginToPNCPayAsValidUser();
    }
    @Test(priority = 2,dependsOnMethods = {"TC01_loginToMassmarketApp"})
    public void TC02_VerifyTutorialPage()throws InterruptedException{
        TutorialPageTest tutorialPageTest = new TutorialPageTest();
        tutorialPageTest.verifyLandingTutorialPage();
        tutorialPageTest.userCanSwipeAndReadTheContent();
    }
    @Test(priority = 3,dependsOnMethods = {"TC02_VerifyTutorialPage"})
    public void TC03_VerifyTandCsPage()throws InterruptedException{
        TandCsPageTest tandCsPageTest = new TandCsPageTest();
        tandCsPageTest.verifyLandingTandCsPage();
        tandCsPageTest.verify_ClickingCancelReturningBackToTutorialPage();
    }
    @Test(priority = 4,dependsOnMethods = {"TC03_VerifyTandCsPage"})
    public void TC04_verifyEnrollCardPage()throws InterruptedException{
        EnrollCardsPageTest enrollCardsPageTest = new EnrollCardsPageTest();
        enrollCardsPageTest.verifyLandingEnrollCardsPage();
        enrollCardsPageTest.verifyclickingCancelButtonReturningBackToTutorialPage();
        enrollCardsPageTest.verifyNavigatingBackFromTutorialPage();
        enrollCardsPageTest.verifyCardEnrollmentSuccessfull();
    }
        }