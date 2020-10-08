package com.app.appiumbasics;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Using AndroidUIAutomator to locate App Elements
 * @author Batto
 *
 */
public class c_UIAutomatorTest extends a_Base {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = capabilities("virtual");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// SYNTAX:
		//driver.findElementByAndroidUIAutomator("attribute(\"value\")");
		
			// AndroidUiAutomator is more convenient than xpath
		
		
		// Test Step | click on "Views" in API Demos 1st Page
		
		//driver.findElementByAndroidUIAutomator("text("Views")").click();
		//		Java doesn't allow multiple double quotes i.e double quote " within another double quote.
		//		To make it accept, you need to add \ next to 2nd double quote so that Java ignores that
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		
		
		
		
		// Test Step | Click on "Animation"
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		
		// Advantage of using AndroidUIAutomator locator:
		//		Using this locator we can identify objects using those attributes
		
		
		
		
		// Validating all the elements "click-a-bility" in the screen
		//		Syntax of using property method from UiSelector class :
		//		1. 	UiSelector obj = new UiSelector();
		//			obj.property(<boolean>);
		//		2. 	new UiSelector().property(<boolean>)
		
		
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
		// This should return 0 since the screen from which we're finding Elements, all the elements property clickable is set as false
		// new UiSelector().clickable(true) is Android code, not APPIUM code
		
		
	}

}
