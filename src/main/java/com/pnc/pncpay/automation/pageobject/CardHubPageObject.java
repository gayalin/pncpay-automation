package com.pnc.pncpay.automation.pageobject;

import com.pnc.pncpay.automation.util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class CardHubPageObject {

	AndroidDriver driver;
	By button_seeMore = By.id("com.fisglobal.lfi.pnc:id/tv_see_more_cards");
	By titleCardHub_toolbar = By
			.id("com.fisglobal.lfi.pnc:id/toolbar_title_text");
	By button_seeless = By
			.xpath("//android.widget.TextView/[@text='See Less']");
	By textlink_TandCs = By
			.id("com.fisglobal.lfi.pnc:id/pncpay_cardhub_terms_button");
	By buttonClose_TandCs = By
			.id("com.fisglobal.lfi.pnc:id/pncpay_terms_close_button");
	By titleTandCs_toolbar = By
			.xpath("//android.widget.TextView[contains(@resource-id,'com.fisglobal.lfi.pnc:id/toolbar_title_text')]");
	By button_HamBurger = By
			.xpath("//android.widget.ImageView[contains(@resource-id,'com.fisglobal.lfi.pnc:id/image_navigation')]");
	By button_cards = By.xpath("//android.widget.Button/[@text='CARDS')]");
	By button_enrollCardsInPNCPay = By
			.xpath("//android.widget.Button[contains(@resource-id,'com.fisglobal.lfi.pnc:id/pncpay_cardhub_enroll_button')]");

	By button_SecondaryEnrollment = By.xpath("//android.widget.FrameLayout[@index=1]/android.widget.RelativeLayout[@index=0]/android.widget.LinearLayout[@index=1]/android.widget.LinearLayout[@index=0]/android.widget.TextView[@index=1]");
	By text_DefaultCard = By.xpath("//android.widget.Button/[@text='CARDS')]");
	private WaitUtil waitUtil;


	public CardHubPageObject(AndroidDriver driver) {

		this.driver = driver;

	}

	public String getCardHubToolbarTitleText() {

		return driver.findElement(titleCardHub_toolbar).getText();

	}

	public void clickSeeMore() {

		driver.findElement(button_seeMore).click();

	}

	public CardHubTandCsPageObject clickTandCsTextLink() {

		WebElement element=driver.findElement(textlink_TandCs);
		if(element.isDisplayed()||element.isEnabled())
			element.click();
		return new CardHubTandCsPageObject(driver);
		

	}


	public boolean waitForVisibilityOfHeaderText(){
		   return waitUtil.waitForElement(titleCardHub_toolbar);
	}

	public void clickTandCsCloseButton() {

		driver.findElement(buttonClose_TandCs).click();

	}

	public void clickSeeLessCardHubPage() {

		driver.findElement(button_seeless).click();

	}

	public void clickOnElementNameText(String text) {

		driver.findElementByName(text).click();

	}

	public void clickEnrollCardsInPNCPay() {

		driver.findElement(button_enrollCardsInPNCPay).click();

	}
	
	public void clickForSecondaryEnrollment() {

		driver.findElement(button_SecondaryEnrollment).click();

	}
}
