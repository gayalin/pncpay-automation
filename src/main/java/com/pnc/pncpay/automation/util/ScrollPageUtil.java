package com.pnc.pncpay.automation.util;

import com.pnc.pncpay.automation.pageobject.EnrollCardsPageObject;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.Dimension;


public class ScrollPageUtil {

	AndroidDriver driver;
	Dimension size;

	public ScrollPageUtil(AndroidDriver driver) {

		this.driver = driver;
	}

	public void verticalScrollTopToBottomUntilTextIsFound(String text)
			throws InterruptedException {

		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find "StartPointY" point which is at bottom side of screen.

		int StartpointY = (int) (size.getHeight() * 0.5);
		System.out.println("Size of scrollStart= " + StartpointY);

		// Find end point which is at top side of screen.
		int scrollEndY = (int) (size.getHeight() * 0.2);
		System.out.println("Size of scrollEnd= " + scrollEndY);

		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = 0;

		// Create "EnrollCardsPage"

		EnrollCardsPageObject enrollCardsPage = new EnrollCardsPageObject(driver);

		for (int i = 0; i < size.getHeight(); i++) {
			System.out.println("swiping bottom to Top is started");
			driver.swipe(startx, scrollEndY, startx, StartpointY, 2000);
			if (enrollCardsPage.findElementNameByText(text) != null)
				break;
		}
		System.out.println("Text is found...by swiping top");
	}

	public void verticalScrollBottomToUpUntilTextIsFound(String text)
			throws InterruptedException {

		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find "StartPointY" point which is at bottom side of screen.

		int StartpointY = (int) (size.getHeight() * 0.5);
		System.out.println("Size of scrollStart= " + StartpointY);

		// Find end point which is at top side of screen.
		int scrollEndY = (int) (size.getHeight() * 0.2);
		System.out.println("Size of scrollEnd= " + scrollEndY);

		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = 0;

		// Create "EnrollCardsPage"

		EnrollCardsPageObject enrollCardsPage = new EnrollCardsPageObject(driver);

		for (int i = 0; i < size.getHeight(); i++) {
			System.out.println("swiping bottom to Top is started");
			driver.swipe(startx, StartpointY, startx, scrollEndY, 2000);
			if (enrollCardsPage.findElementNameByText(text) != null)
				break;
		}
		System.out.println("Text is found..wowwww");
	}

	public void horizontalScrollRightToLeft(double d,double e) throws InterruptedException {

		// Get the size of the screen
		size = driver.manage().window().getSize();
		System.out.println(size);
		// Find swipe start and end point from screen's width and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * d);
		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * e);
		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;
		System.out.println("startx = " + startx + " ,endx = " + endx
				+ " , starty = " + starty);
        //Swipe from Right to Left.
		driver.swipe(startx, starty, endx, starty, 3000);
		Thread.sleep(2000L);
	}

	public void ScrollToText(String text) {

		driver.scrollTo(text);
	}

}
