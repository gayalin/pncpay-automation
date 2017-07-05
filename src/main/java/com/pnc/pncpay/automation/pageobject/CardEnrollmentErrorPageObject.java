package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.SeleniumUtil;
import com.pnc.pncpay.automation.util.WaitUtil;
import com.pnc.pncpay.automation.util.PncpayAsserterUtil;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardEnrollmentErrorPageObject {

	private By button_Ok = By
			.xpath("//android.widget.Button[contains(@resource-id,'com.fisglobal.lfi.pnc:id/pncpay_error_button')]");
	private By title_EnrollmentErrorTitle = By
			.xpath("//android.widget.TextView[contains(@resource-id,'com.fisglobal.lfi.pnc:id/toolbar_title_text') and @text='Enrollment Error']");
	private By cardNumber = By.xpath("//android.widget.TextView[@text='�����7748']");
	private By cardButtonPath =By.xpath ("//android.widget.LinearLayout[@index=1]/android.widget.RelativeLayout[@index=0]/android.widget.LinearLayout[@index=1]/android.widget.TextView[@text='�����0022']");
	private SeleniumUtil seleniumUtils;
	private String myList2;
	private AndroidDriver driver;
	private WaitUtil waitUtil;

	public CardEnrollmentErrorPageObject(AndroidDriver driver) {
		this.driver = driver;
		this.seleniumUtils = new SeleniumUtil(driver);
	}

	public boolean isPresent() {
		return seleniumUtils.isPresent(title_EnrollmentErrorTitle);
	}

	public void compareCardText() {
		WebElement element = driver.findElement(cardButtonPath);
		String actual = element.getText();
		System.out.println("actual text is: " + actual);
		int index = 0;
		String expected = seleniumUtils.getArrayValue(index);
		System.out.println("expected text is: " + expected);
		PncpayAsserterUtil.assertEquals(driver, actual, expected);

	}

	public TutorialPageObject clickOkFromCardEnrollErrorPage() {
		WebElement okButton = driver.findElement(button_Ok);
		if (okButton.isDisplayed())
			okButton.click();
		return new TutorialPageObject(driver);
	}

	// public void selectCards(int... cardIndexes) {

	// for (int i = 0; i < myList2.length(); i++) {
	// ScrollPage scrollPage = new ScrollPage(driver);
	// scrollPage.ScrollToText(myList2[i]);
	// EnrollCardsPageObject enrollCardsPage = new
	// EnrollCardsPageObject(driver);
	// enrollCardsPage.clickOnElementNameText(myList2[i]);
	// }
	// }

	public String getCardNumberText(){
		return driver.findElement(cardButtonPath).getText();
					
	}
	public boolean waitForVisibilityOfEnrollErrorPageTitle() {
		return waitUtil.waitForElement(title_EnrollmentErrorTitle);
	}
}
