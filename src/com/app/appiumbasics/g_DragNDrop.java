package com.app.appiumbasics;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class g_DragNDrop extends a_Base {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// Views --> Drag and Drop --> Drag the central red ball and drop in any of right or Down ball
			
			AndroidDriver<AndroidElement> driver = null;
				
		// Launching App on Android device
			driver = capabilities("virtual");
			
		// Navigating till "Drag And Drop" screen
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		
		
		// Identify Source Element and Target Element
			//WebElement sourceElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
			// Below code cannot use as the id has special character ":,/"
			// Workaround: All app elements share same class name and differs with index. 
			//		We'll capture all the AppElements with same Class name in an Arraylist and use its get(index) to identify AppElement 
			WebElement sourceElement = driver.findElements(By.className("android.view.View")).get(0);
			WebElement destinationElement = driver.findElements(By.className("android.view.View")).get(1);
		
			
		//Longpress on ball(Source) --> move to another ball(Destination) --> release
		TouchAction t = new TouchAction(driver);
		
		//t.longPress(longPressOptions()
		//				.withElement(element(sourceElement)))
		//	.moveTo(element(destinationElement))
		//	.release()
		//	.perform();
			
		//OR
			
		t.longPress(element(sourceElement))
		.moveTo(element(destinationElement))
		.release()
		.perform();
		
		// Above reduced version is only possible if there is only 1 action. If we have to specify duraiton etc.. actions, then we've to switch back 
		//	to long version of longPress action.
		
		
	}
}
