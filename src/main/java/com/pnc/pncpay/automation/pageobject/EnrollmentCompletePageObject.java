package com.pnc.pncpay.automation.pageobject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EnrollmentCompletePageObject {

	AndroidDriver driver;
	private By button_ok = By
			.id("com.fisglobal.lfi.pnc:id/pncpay_enrollment_complete_all_done_btn");
	private By title_EnrollmentComplete = By
			.xpath("//android.widget.TextView[@text='Enrollment Complete']");

	public EnrollmentCompletePageObject(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public CardHubPageObject clickButtonOk() {
		WebElement oKButton = driver.findElement(button_ok);
		if (oKButton.isDisplayed() || oKButton.isEnabled()) {
			oKButton.click();
		}
		return new CardHubPageObject(driver);
	}

	public String getTitleText() {

		return driver.findElement(title_EnrollmentComplete).getText();

	}

	public void clickButtonContinue() {
		// TODO Auto-generated method stub

	}

}
