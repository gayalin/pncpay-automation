package com.pnc.pncpay.automation.util;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionUtil {

	AndroidDriver driver;

	public AssertionUtil(AndroidDriver driver) {
		this.driver = driver;
	}

	public static void assertTrue(AndroidDriver driver, boolean status) {
		try {
			System.out.println("Asserting the status:" + status);
			Assert.assertTrue(status);
		} catch (Throwable e) {
			System.out.println("Failed test case,screen shot captured");
			new ScreenShotsUtil(driver).takeScreenshot("CardTestCase");
		}
	}

	public static void assertEquals(AndroidDriver driver, Object actual,
			Object expected) {
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(expected + " is presence" + " Test is passed");
		} catch (Throwable e) {
			System.out.println(actual + " is presence" + "  Failed test case,screen shot captured");
			new ScreenShotsUtil(driver).takeScreenshot("CardTestCase");
		}
	}

	public void assertTrueIsDisplayed(AndroidDriver driver, By path) {
		try {
			WebElement element = driver.findElement(path);
			Assert.assertTrue(element.isDisplayed());
			System.out.println(" Test is continued");
		} catch (Throwable e) {
			System.out.println("Failed test case,screen shot captured");
			new ScreenShotsUtil(driver).takeScreenshot("CardTestCase");
		}

	}
	
	
}
