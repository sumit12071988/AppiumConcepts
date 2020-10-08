package com.app.appiumbasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class i_RunningAPPwithoutInstallationInRealNVirtualDevices {

	public static void main(String[] args) throws MalformedURLException {
		
		File appDir = new File("src");
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"25");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"192.168.1.5:5555");
		// 	Actual Device									--> ce061606337acd1903
		//	AVD[Android Virtual Device] Device				--> android9 | emulator-5554
		
		
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.touchboarder.android.api.demos");
		// 	com.android.chrome								--> Chrome Browser
		//	io.appium.android.apis							--> Old API Demos App
		//	com.touchboarder.android.api.demos				--> New API Demos App
		
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.touchboarder.androidapidemos.MainActivity"); 
		// 	com.google.android.apps.chrome.Main				--> Chrome Browser
		//	io.appium.android.apis.ApiDemos					--> Old API Demos App
		//	com.touchboarder.androidapidemos.MainActivity	--> New API Demos App
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
	}

}
