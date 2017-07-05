package com.pnc.pncpay.automation.base;

import com.pnc.pncpay.automation.pageobject.LoginPageObject;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;
import com.pnc.pncpay.automation.util.SeleniumDriverUtil;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

/**
 * Created by GWITHARANA on 4/26/2017.
 */
public class SignInHelper {
    private AccountsPageObject accountsPageObject;
    private AndroidDriver driver = SeleniumDriverUtil.getDriver();




    public AccountsPageObject signInPNCPayAsValidUser()throws InterruptedException{
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.setUserName("Paytest05");
        loginPageObject.clickContinue();
        loginPageObject.waitForVisibilityOfSignInTitle();
        if (loginPageObject.isDisplayAnswerTitleText()){
            loginPageObject.setAnswer("wall");
            loginPageObject.clickContinue();
            loginPageObject.waitForEnterYourPasswordTitle();
            loginPageObject.setPassword("wall1234");


        }else if (loginPageObject.isDisplayPasswordTitleText()){
            loginPageObject.setPassword("wall1234");
        }else {
            RuntimeException e = new RuntimeException("error");
            throw e;
        }

         return loginPageObject.clickSignOn();
    }

    public String signInPNCPayAsInvalidUser()throws InterruptedException{
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.setUserName("Paytest01");
        if(loginPageObject.waitForVisibilityOfErrorTextBox()){
            loginPageObject.getLoginError();
        }
        return loginPageObject.getLoginError();
    }

}
