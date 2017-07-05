package com.pnc.pncpay.automation.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;


public class SeleniumDriverUtil {

	private static AndroidDriver driver;

	public SeleniumDriverUtil(AndroidDriver driver) {
		this.driver =driver;
	}

	public static void initialize()throws MalformedURLException {
		//String appPath = "C:\\Apium\\apk\\app-dev-debug_auto_5.apk";
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android deviceName desired capability. Set your device name.
		capabilities.setCapability("deviceName", "03157df388c7b934");

		// Set BROWSER_NAME desired capability. It's Android in our case
		// here.
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		// Set android VERSION desired capability. Set your mobile device's
		// OS
		// version.
		capabilities.setCapability("platformVersion","6.0.1");

		//capabilities.setCapability("app",appPath);
		// Set android platformName desired capability. It's Android in our
		// case
		// here.
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("autoAcceptAlerts", "true");

		// Set android appPackage desired capability. It is
		// com.android.calculator2 for calculator application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appPackage", "com.pnc.ecommerce.mobile.finder");
		capabilities.setCapability("appActivity",
				"com.fisglobal.lfi.pnc.ui.MainActivity");

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);

			System.out.println("Driver Created");

		} catch (MalformedURLException e) {
			e.printStackTrace();
			//throw new RuntimeException("Driver initialization failed", e);
		}

		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
	}

	public static void close() {
		driver.quit();
	}

	public static AndroidDriver getDriver() {
		return driver;
	}
}
