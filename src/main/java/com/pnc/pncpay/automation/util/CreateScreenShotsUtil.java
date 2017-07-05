package com.pnc.pncpay.automation.util;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CreateScreenShotsUtil {

	private AndroidDriver driver;
	private static final String PATH = "C:\\Apium\\Screenshots\\";

	public CreateScreenShotsUtil(AndroidDriver driver) {
		super();
		this.driver = driver;
	}

	public void takeScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		System.out.println("Taking Screenshot");
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		try {
			FileUtils.copyFile(scrFile, new File(PATH + fileName + ".png"));
		} catch (IOException e) {
			System.out.println("Unable to take screenshot. Error:"
					+ e.getMessage());
		}

	}

}
