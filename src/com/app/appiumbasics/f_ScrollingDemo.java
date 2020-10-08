package com.app.appiumbasics;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class f_ScrollingDemo extends a_Base {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// Flow --> Views --> Date Widgets --> Inline --> click on Hrs hand --> Hold-N-Swipe Mts hand.
			
			AndroidDriver<AndroidElement> driver = null;
				
		// Launching App on Android device
			driver = capabilities("virtual");
			
		// Navigating till Views
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		// Scrolling down to bring focus till Element "WebView"
		//	Syntax: driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text("TextName"));");
		//		new UiScrollable(new UiSelector()).scrollIntoView(text("WebView")); --> This is an Android code
		//			new UiScrollable(new UiSelector()) is an Object of UiScrollable class
		//			scrollIntoView(text("WebView")) is the method of UiScrollable class
		//		Since double quotes within another double quotes is not allowed, thus we need to add \ next next to each inner double quotes
		
		// Thus final syntax: 
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextName\"));");
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
		// 	new UiScrollable(new UiSelector()) --> Object of UiScrollable class, which accepts object of UiSelector class as i/p parameter
		//	scrollIntoView(text(\"WebView\")) --> Method of UiScrollable class which accepts text("<text>") as i/p parameter

		
	}
}
