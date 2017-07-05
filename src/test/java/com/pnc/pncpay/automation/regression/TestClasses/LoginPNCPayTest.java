package com.pnc.pncpay.automation.regression.TestClasses;

import com.pnc.pncpay.automation.base.BaseTest;
import com.pnc.pncpay.automation.base.SignInHelper;
import com.pnc.pncpay.automation.pageobject.AccountsPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPNCPayTest extends BaseTest{

	private AccountsPageObject accountsPageObject;
	private SignInHelper signInHelper;


	@Test(priority = 1)
	public void verifyLoginToPNCPayAsValidUser() throws InterruptedException {
		//Login as valid user
		signInHelper = new SignInHelper();
		accountsPageObject =signInHelper.signInPNCPayAsValidUser();
		accountsPageObject.waitForVisibilityOfAccountsTitleBar();
		Assert.assertTrue(accountsPageObject.verifyAccountPageTitle(),
				"Welcome page title doesn't match");
	}

	@Test(priority = 2)
	public void verifyLoginToPNCPayAsInvalidUser() throws InterruptedException {
		signInHelper = new SignInHelper();
        String error = signInHelper.signInPNCPayAsInvalidUser();
        Assert.assertEquals(error,"Services unavailable. Please try again.","Invalid USer Login Test failed");
	}



}
