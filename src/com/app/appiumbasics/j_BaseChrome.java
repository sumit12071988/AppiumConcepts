package com.app.appiumbasics;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;



/**
 * This is created to get driver from capabilities() method
 * Used as an Interface by other classes
 * Prerequisites:
 * a) Mobile configuration and  detection with the command adb devices
 * b) chromedriver.exe file in local machine
 * 
 * @author Batto
 */
public class j_BaseChrome {

	
	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver ;
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Desired Capabilities is a class which takes the information from my class file in JSON structure and gives the information to APPIUM SERVER
		
		
		
		// Set which Device/Emulator to use | APPIUM SERVER to IDENTIFY my EMULATOR/ REAL DEVICE 		
		if (device.equalsIgnoreCase("emulator")) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android9");	
		}
		else if(device.equalsIgnoreCase("real")) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.1.5:5555");	
		}				
			// android9 		--> My Emulator name.
			// 192.168.1.5:5555 -->	My Real Device in Wifi Mode
		
		
		// Set which BROWSER to be invoked in Mobile
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Batto\\Desktop\\JARS\\ChromeDriver\\v85\\chromedriver.exe");
		
		
		// Set which elements of Android will be accessed | uiautomator2 elements
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
			//	Android updated its internal framework to uiautomator2 and through Appium code, we need to tell that we need to access uiautomator2 elements of Android	
		

		
		
		
		
// ******************** ESTABLISHING CONNECTION B/W APPIUM SERVER & EMULATOR | ESTABLISHING SESSION ***********************
		
		//AndroidDriver driver = new AndroidDriver(<connectiontoserverlink>,cap);
			// using "cap" object, driver receives all the desired capabilities set previously
			// "driver" class reference will be responsible for executing RunningBATFile cases from next step.
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			// Appium Server is staying in http://127.0.0.1:4723 IP address. If you refer Appium Server in CMD, it says "Appium REST http interface listener started on 0.0.0.0:4723"
			//	0.0.0.0 is the localhost. Localhost IP address is 127.0.0.1. 4723 is the port from where APPIUM SERVER is listening
			//	wd is WebDriver
			//	hub is where we're setting and invoking connection to appium server
			// This way we're invoking Appium server and passing all  desired capabilities it has to remember when running tests on app.
		
		
		// Once the code is executed, we'll see the emulator has the new app installed and opened. After the program is completed, we'll notice that Appium Server takes 60 sec
		//	to close the session. Thus before 60 seconds if we try to run AGAIN, then the program will FAIL with message that the connection is STILL open. Thus always wait 60 secs
		//	before running another RunningBATFile. If we've to run the script again before 60 seconds, then we need to closr the APPIUM Server (CTRL+C) and open it again
		

		return driver;		
	}
}
