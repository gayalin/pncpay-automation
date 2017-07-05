package com.pnc.pncpay.automation.base;

import com.pnc.pncpay.automation.util.SeleniumDriverUtil;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;


public class  BaseTest {

	protected AndroidDriver driver;
	protected SeleniumDriverUtil seleniumDriverUtil;

	@BeforeClass
	public void initializeDriver()throws MalformedURLException {
		System.out.println("Initializing the driver");
		SeleniumDriverUtil.initialize();
		driver = SeleniumDriverUtil.getDriver();
	}

	@AfterClass
	public void cleanupDriver() {
		System.out.println("Closing the driver");
		SeleniumDriverUtil.close();
	}

}
