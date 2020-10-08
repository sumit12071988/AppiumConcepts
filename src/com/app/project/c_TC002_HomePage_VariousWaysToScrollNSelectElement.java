package com.app.project;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class c_TC002_HomePage_VariousWaysToScrollNSelectElement extends a_Base {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = null;
		
	// Receiving driver from Base class + Open App
		driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	// Positive Scenario
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sumit");
		
		// After all text fields, we need to hide the keyboard
		driver.hideKeyboard();
		
		//Select Radio Btn as "Female"
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		// Select Country dropdown Element
		driver.findElement(By.id("android:id/text1")).click();
		
		// Scroll and select country "Antarctica"
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
				// 	new UiScrollable(new UiSelector()) --> Object of UiScrollable class, which accepts object of UiSelector class as i/p parameter
				//	scrollIntoView(text(\"Antarctica\")) --> Parameterized Method of UiScrollable class which accepts text("<text>") as i/p parameter
		
		// In case above Scroll fails, use the below code
		//driver.findElement(By.xpath("//*[text()='India']")).click();
		
		// Click on "Lets Shop" button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		
		
//************* VARIOUS WAYS TO SCROLL-N-SELECT A PARTICULAR ELEMENT IN APP **************
		
		// OPTION #1: | Problem: Scrolls only 1 way i.e from up to down
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");
		
		
		// OPTION #2: | Scrolls up to down as well as vice versa
			// Here we're first selecting the frame inside which all elements resides and then from there we're scrolling to identify particular element.
			// com.androidsample.generalstore:id/rvProductList is the resource-id of the entire FRAME inside which all the Elements resides
		
		driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))"
						+ ".scrollIntoView(new UiSelector()"
						+ ".textMatches(\"Jordan 6 Rings\")"
						+ ".instance(0))"));
		
		
		// OPTION #3: | Scrolls up to down as well as vice versa
			// Here we're first selecting the frame inside which all elements resides and then from there we're scrolling to identify particular element.
//		driver
//        .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
//        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))"
//        + ".scrollIntoView(new UiSelector()"
//        + ".text(\"Jordan 6 Rings\"));");
		
	
		
		
		// resource-id for all products are same i.e. com.androidsample.generalstore:id/productName
		//	using this we can find the count of products, however count will be based on how many products visible to Appium in App screen
		
		// Collect all visible products inside a list
		List<AndroidElement> visibleList = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		
		int count = visibleList.size(); 
		// prints only 2 as 2 elements are visible using all the options.
		
		
		// now since we got to know that  when we run line 81, Appium will collect all the Elements which are visible and store in memory
		//	driver.findElements(<XXXX) is of List Type
		//	we'll add a loop and traverse within the loop to identify our Element using its text
		
		for (int i = 0; i < count; i++) {
			String text = visibleList.get(i).getText();
			
			// We'll check if the products text from the list mathces. 
			if (text.equalsIgnoreCase("Jordan 6 Rings")) {
				
				// If text matches, we'll click on its "Add to Cart" button.
				// both elements resource-id matches, thus we'll CLICK on our Element using List(Welelemnts).get(index).click()
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				
				// break the IF loop if the element is identified in 1st attmept itself. 
				break;
			}			
		}
		
		
		// Click on "Checkout" button on the Top Right Hand Side
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		 
		
	}
}
