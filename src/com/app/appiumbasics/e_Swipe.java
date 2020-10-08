package com.app.appiumbasics;


//Imports not getting auto-imported from Appium
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class e_Swipe extends a_Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
	// Flow --> Views --> Date Widgets --> Inline --> click on Hrs hand --> Hold-N-Swipe Mts hand.
		
		AndroidDriver<AndroidElement> driver = null;
	
	// Launching App on Android device
		driver = capabilities("real");
		
	// Navigating till Inline section
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		
		
	// Navigate to Mts selection in Timeclock	
		
		//NOTE: if the class/ Tag contains special characters like(!@#$%^&*), then that cannot be used to identify the WebElement. In such cases 
		//	Either use wild card (*) as Tag and search for attribute or use UIAutomator
		//driver.findElementByAndroidUIAutomator("content-desc(\"9\")");
		driver.findElement(By.xpath("//*[@content-desc='9']")).click();
		
		
	
		WebElement mtsHand_15 = driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement mtsHand_45 = driver.findElement(By.xpath("//*[@content-desc='45']"));
		
	// Swiping minute hand from 15 to 45
		
		TouchAction t = new TouchAction(driver);
		// Longpress on element for 2 seconds --> move to another element --> Release
		t.longPress(longPressOptions()
					.withElement(element(mtsHand_15))
					.withDuration(ofSeconds(2)))
		.moveTo(element(mtsHand_45))
		.release()
		.perform();
	}

}
