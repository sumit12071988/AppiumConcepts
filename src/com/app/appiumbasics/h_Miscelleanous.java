package com.app.appiumbasics;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class h_Miscelleanous extends a_Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver=capabilities("virtual");
	
	     System.out.println(driver.currentActivity());
	     
	     System.out.println(driver.getContext());
 
	     
	     //views - Native , Hybrid, Webview
	     System.out.println(driver.getOrientation());

	     
	     System.out.println(driver.isDeviceLocked());

	     
	     //  driver.hideKeyboard();
	 	driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	 	
	 	((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
