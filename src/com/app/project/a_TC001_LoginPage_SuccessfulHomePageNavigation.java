package com.app.project;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class a_TC001_LoginPage_SuccessfulHomePageNavigation extends a_Base {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = null;
		
	// Receiving driver from Base class + Open App
		driver = capabilities("virtual");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	// Positive Scenario
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sumit");
		
		// After all text fields, we need to hide the keyboard
		driver.hideKeyboard();
		
		//Select Radio Btn as "Female"
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		// Select Country dropdown Element
		driver.findElement(By.id("android:id/text1")).click();
		
		// Scroll and select country "India"
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));").click();
		
		// In case above Scroll fails, use the below code
		//driver.findElement(By.xpath("//*[text()='India']")).click();
		
		// Click on "Lets Shop" button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
	}
}
