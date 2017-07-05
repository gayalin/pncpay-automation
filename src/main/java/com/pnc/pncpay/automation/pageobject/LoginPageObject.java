package com.pnc.pncpay.automation.pageobject;


import com.pnc.pncpay.automation.util.SeleniumUtil;
import com.pnc.pncpay.automation.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPageObject {

	private AndroidDriver driver;
	private By txtbx_UserID = By.xpath("//android.widget.EditText[contains(@resource-id,'com.pnc.ecommerce.mobile.finder:id/submit_edit_text_entry')]");
	private By txtbx_Error = By
			.id("com.fisglobal.lfi.pnc:id/submit_edit_text_error");
	private By button_Continue = By
			.xpath("//android.widget.Button[@text='CONTINUE']");
	private By txtbx_Answer = By
			.xpath("//android.widget.EditText[contains(@resource-id,'com.pnc.ecommerce.mobile.finder:id/submit_edit_text_entry') and @text='Enter Answer']");
	private By txtbx_Password = By.xpath("//android.widget.EditText[contains(@resource-id,'com.pnc.ecommerce.mobile.finder:id/submit_edit_text_entry')]");
	private By buttonSignOn = By
			.xpath("//android.widget.Button[@text='SIGN ON']");
	private By titleSignIn = By.xpath("//android.widget.TextView[contains(@resource-id,'com.pnc.ecommerce.mobile.finder:id/toolbar_title_text') and @text='SIGN IN']");

	private By enterYourPasswordTitle =By.xpath("//android.widget.TextView[@text='Enter your password']");
	private By answerQuestionTitle =By.xpath("//android.widget.TextView[@text='Answer the security question']");
	//private By ErrorMessage = By.xpath("//android.widget.TextView[@text='Services unavailable. Please try again.']");

	private WaitUtil waitUtil;
	private SeleniumUtil seleniumUtil;
	private static Logger log = Logger.getLogger(Log.class);
	

	public LoginPageObject(AndroidDriver driver) {
	this.driver = driver;
	this.waitUtil = new WaitUtil(driver);
	}

	public String getLoginPageTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("pageTitle");
		return pageTitle;

	}

	public boolean verifyLoginPageTitle() {
		String expectedTitle = "Accounts";
		return getLoginPageTitle().contains(expectedTitle);

	}

	// Set UserName in textbox
	public void setUserName(String UserName) throws InterruptedException {
	WebElement userIDTxtBox = driver.findElement(txtbx_UserID);
		if (userIDTxtBox.isDisplayed()|userIDTxtBox.isEnabled())
			userIDTxtBox.sendKeys(UserName);
	}

	public String getLoginError(){
		WebElement errorText = driver.findElement(txtbx_Error);
		if (errorText.isDisplayed())
			errorText.getText();
		return errorText.getText();
	}

	// Set an answer for security answer
	public void setAnswer(String Answer) {
		WebElement answerTxtBox = driver.findElement(txtbx_Answer);
		if (answerTxtBox.isDisplayed())
			answerTxtBox.sendKeys(Answer);
	}

	// set a password
	public void setPassword(String Password) {
		WebElement passwordTxtBox = driver.findElement(txtbx_Password);
		if (passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(Password);
	}

	// Click on "Continue" button

	public void clickContinue() throws InterruptedException {
        driver.hideKeyboard();
		WebElement continueButton = driver.findElement(button_Continue);
		if (continueButton.isDisplayed())
			log.info("Click on Continue");
			continueButton.click();
		
		
		
		// driver.wait(3000L);
	}

	public AccountsPageObject LoginToPNCPayAsValidUser(String UserName)
			throws InterruptedException {

		setUserName(UserName);
		clickContinue();
		return new AccountsPageObject(driver);

	}

	public AccountsPageObject clickSignOn() {
		driver.hideKeyboard();
		WebElement element = driver.findElement(buttonSignOn);
		if (element.isDisplayed() || element.isEnabled())
			element.click();
		return new AccountsPageObject(driver);
	}

	public LoginPageObject LoginToPNCPayAsInValidUser(String UserName)
			throws InterruptedException {

		setUserName(UserName);
		clickContinue();
		return this;
	}

	public void clearKeyBoard(){
		driver.hideKeyboard();
	}

	public boolean waitForAnswerTitle() {
		return waitUtil.waitForElement(answerQuestionTitle);

	}

	public boolean waitForEnterYourPasswordTitle() {
		return waitUtil.waitForElement(enterYourPasswordTitle);

	}

	public boolean waitForVisibilityOfErrorTextBox() {
		return waitUtil.waitForElement(txtbx_Error);

	}

	public void PrintPasswordTitleText(){
		WebElement passwordTitle = driver.findElement(enterYourPasswordTitle);
		System.out.println(passwordTitle.getText());
	}

	public boolean isDisplayPasswordTitleText(){
		WebElement passwordTitle = driver.findElement(enterYourPasswordTitle);
		return passwordTitle.isDisplayed();
	}
//Verify "Answer the security question" title
	public boolean isDisplayAnswerTitleText(){
		WebElement answerTitle = driver.findElement(answerQuestionTitle);
		return answerTitle.isDisplayed();
	}

	
	public boolean waitForVisibilityOfSignInTitle() {
		return waitUtil.waitForElement(titleSignIn);
	}

	public boolean waitForVisibilityOfContinueButton() {
		return waitUtil.waitForElement(button_Continue);
	}
}
