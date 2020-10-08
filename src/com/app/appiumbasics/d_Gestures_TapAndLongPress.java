package com.app.appiumbasics;


//Imports not getting auto-imported from Appium
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class d_Gestures_TapAndLongPress extends a_Base {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = null;
		
		// Launching App on Android device
		driver = capabilities("virtual");
		
		
		// In App click on Views --> Expandable lists --> Custom Adapter --> Press-N-Hold "People Names" we'll get a pop-up with "Sample menu" and 
		//	"Sample action"
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		WebElement expandList = driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		
		
		// *************** TAP GESTURES *************** 
			//It is different from Click. We normally use Tap action in App not click action HOWEVER both will perform same activity
			//	For gestures appium has developer TouchActions class
			TouchAction t = new TouchAction(driver);
			
			// import in top --> import static io.appium.java_client.touch.TapOptions.tapOptions;
			//	t.tap(TapOptions tapOptions) --> We can only pass methods residing inside the class TapOptions with its object reference
			
			// tapping on a Element in any position
			t.tap(tapOptions()
					.withElement(element(expandList)))
			.perform();
			
			// tapping on a Element in any specific position
			//t.tap(tapOptions().withElement(element(expandList)).withPosition(positionOption)).perform();
						
			// Identfying and TAP on "Custom Adapter"	
			WebElement customAdapter = driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
			t.tap(tapOptions()
					.withElement(element(customAdapter)))
			.perform();
			
		
		
		
		// *************** LONGPRESS GESTURES *************** 
		
			// Identify and LONGPRESS on "People Names"
			WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
			t.longPress(longPressOptions()
					.withElement(element(peopleNames))
					.withDuration(ofSeconds(2)))
			.release()
			.perform();
				
			
			System.out.println(driver.findElement(By.id("android:id/title")).getText());
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	}
}
