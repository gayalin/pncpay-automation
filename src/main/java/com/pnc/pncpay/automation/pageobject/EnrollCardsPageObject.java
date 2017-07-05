package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.SeleniumUtil;
import com.pnc.pncpay.automation.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class EnrollCardsPageObject {

	private AndroidDriver driver;
	private By button_ToolbarLeft = By
			.id("com.fisglobal.lfi.pnc:id/image_navigation");
	private By button_Continue = By
			.id("com.fisglobal.lfi.pnc:id/pncpay_enrollment_continue_button");
	private By button_Cancel = By
			.id("com.fisglobal.lfi.pnc:id/pncpay_enrollment_cancel_button");
	private By title_EnrollInPNCPay = By
			.xpath("//android.widget.TextView[contains(@resource-id,'com.fisglobal.lfi.pnc:id/toolbar_title_text') and @text='Enroll in PNC Pay']");

	private String cardButtonPath = ("//android.widget.FrameLayout[@index= %d]/android.widget.RelativeLayout[@index=0]/android.widget.LinearLayout[@index=1]/android.widget.LinearLayout[@index=0]/android.widget.TextView[@index=1]");

	By card_name = By.name("name");
	private SeleniumUtil seleniumUtil;
	private WaitUtil waitUtil;
	


	public By getCardNumberElementByIndex(int index) {
		return By.xpath(String.format(cardButtonPath, index));
		
	}

	public EnrollCardsPageObject(AndroidDriver driver) {
		this.driver = driver;
		this.seleniumUtil = new SeleniumUtil(driver);
		this.waitUtil = new WaitUtil(driver);
	}

	// Click "Toolbar Left" button

	public void clickToolbarLeftButton() {

		driver.findElement(button_ToolbarLeft).click();

	}

	// find Cards for enrollment by name

	public String findCardNumberText(int cardIndex) {
		try {
			return driver.findElement(getCardNumberElementByIndex(cardIndex)).getText();
		} catch (Exception nse) {
			System.out.println("=========== Card index not found. :"
					+ nse.getMessage());
			return null;
		}
	}

	// find card name by name
	/**
	 * 
	 * @param text
	 * @return
	 */
	public WebElement findElementNameByText(String text) {
		try {
			// 2 seconds wait and throws and exception if element is not found.
			// return new WebDriverWait(driver, 2)
			// .until(ExpectedConditions.elementToBeClickable(By.id(text)));

			return driver.findElementByName(text);
		} catch (Exception nse) {
			System.out.println("=========== Card text not found. :"
					+ nse.getMessage());
			return null;
		}
	}

	public void clickOnElementNameText(String text) {
       WebElement element = driver.findElementByName(text);
		if (element.isDisplayed()||element.isEnabled())
			System.out.println( text + "  is captured");
			element.click();
			

	}

	// For Successful enrollment-Click Continue button
	/**
	 * dfdfdfd
	 */
	public SelectDefaultCardPageObject clickContinueButtonForSuccessfullCards() {
		String text ="CONTINUE";
        scrollToText(text);
		WebElement continueButton = driver.findElement(button_Continue);
		if (continueButton.isDisplayed()||continueButton.isEnabled())
			continueButton.click();
		return new SelectDefaultCardPageObject(driver);

	}

	// Card Enrollment Error-Click Continue button

	public CardEnrollmentErrorPageObject clickContinueButtonForErrorCards() {

		WebElement continueButton = driver.findElement(button_Continue);
		if (continueButton.isDisplayed())
			continueButton.click();
		return new CardEnrollmentErrorPageObject(driver);

	}

	// Click "Cancel" button

	public TutorialPageObject clickCancelButton() {
		WebElement cancelButton = driver.findElement(button_Cancel);
		if (cancelButton.isDisplayed()|| cancelButton.isEnabled())
			cancelButton.click();
		return new TutorialPageObject(driver);

	}

	// Get title "EnrollInPNCPay" text

	public String getTitleEnrollInPNCPay() {
    return driver.findElement(title_EnrollInPNCPay).getText();
	}
	
	public boolean verifyEnrollCardsPageTitle() {
		String expectedTitle = "Enroll in PNC Pay";
		return getTitleEnrollInPNCPay().contains(expectedTitle);
	}

	public void scrollToExactText(String text) {
     
		driver.scrollToExact(text);

	}

	public void scrollToText(String text) {
		driver.scrollTo(text);
	}

	
	
	
	public boolean waitForVisibilityOfEnrollInPNCPayPageTitle() {
		return waitUtil.waitForElement(title_EnrollInPNCPay);
	}
	
	

}
