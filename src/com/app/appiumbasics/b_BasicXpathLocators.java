package com.app.appiumbasics;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.app.pageObjects.a_Homepage;
import com.app.pageObjects.b_Preferences;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/**
 * LOCATING ELEMENT FROM APP WITH SAME ATTRIBUTES USING XPATH-INDEXING
 * LOCATING ELEMENT FROM APP WITH SAME ATTRIBUTES USING ARRAYLIST
 * @author Batto
 *
 */
public class b_BasicXpathLocators extends a_Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		AndroidDriver<AndroidElement> driver = null;
		
		driver = capabilities("virtual");		// this will give driver to this class
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
	    


		
		// XPATH = //tagName[@attribute='']
		
		
		// Test Step1 | Click on “Preference”
		a_Homepage h = new a_Homepage(driver);
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		h.preferences.click();
		
		
		
		// Test Step2 | Click on “Preference Dependencies”
		b_Preferences p = new b_Preferences(driver);
		// driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		p.depencencies.click();
		
		
		
		// Test Step3 | Click on “WiFI” checkbox
		// id is resource-id in the uiAutomator tool.
		//driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		// Test Step4 | Click on "Wifi Settings
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		// Test Step5 | Type "testing"
		driver.findElement(By.id("android:id/edit")).sendKeys("Testing CANCEL");
		
		// Test Step6 | Click on “OK”		
		WebElement oKButton,cancelButton;
//		oKButton = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
		
//		********** LOCATING ELEMENT FROM APP WITH SAME ATTRIBUTES USING XPATH-INDEXING ***************
//		oKButton = driver.findElement(By.xpath("(//android.widget.Button)[2]"));

//		********** LOCATING ELEMENT FROM APP WITH SAME ATTRIBUTES USING ARRAYLIST ***************
		// Strategy: 	1. Locate a Wrapper/ container/ list which has all App elements with same class name in  a ArrayList
		//				2. Use get method with indexes to locate the WebElement
		
		// Collect both elements CANCEL and OK buttons inside an ArrayList.
		List<AndroidElement> buttonList = driver.findElements(By.className("android.widget.Button"));	

		// use ArrayList get(<index>) method to fetch the button	
		cancelButton = buttonList.get(0);
		oKButton = buttonList.get(1);
		
		cancelButton.click();
		//oKButton.click();
			
	}	
}
