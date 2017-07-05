package com.pnc.pncpay.automation.util;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SeleniumUtil {

	private AndroidDriver driver;
	private String[] myList2 = { "�����7748" };

	public SeleniumUtil(AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickOnButtonAfterWaitToBeVisible(By locator) {
		WaitUtil waitUtil = new WaitUtil(driver);
		waitUtil.waitForElement(locator);
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed())
			element.click();

	}

	public boolean isPresent(By locator) {
		WaitUtil waitUtils = new WaitUtil(driver);
		WebElement element = driver.findElement(locator);
		if (waitUtils.waitForElement(locator)) {
			System.out.println(element.getText() + " text is captured");
			return true;
		} else {
			System.out.println("Not Found");
			return false;
		}
	}

	public String getArrayValue(int index) {
		return myList2[index];
	}
	
	 public static void fnHighlightMe(AndroidDriver driver,WebElement element) throws InterruptedException{
		  //Creating JavaScriptExecuter Interface
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   for (int iCnt = 0; iCnt < 3; iCnt++) {
		      //Execute javascript
		         js.executeScript("arguments[0].style.border='4px groove green'", element);
		         Thread.sleep(1000);
		         js.executeScript("arguments[0].style.border=''", element);
		   }
		 }
}
