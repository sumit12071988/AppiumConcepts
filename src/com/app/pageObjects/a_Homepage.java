package com.app.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * All the Objects from Homepage will be maintained here
 * @author Batto
 *
 */
public class a_Homepage {
	
	private AndroidDriver<AndroidElement> driver;

	
	// creating a parameterized constructor to receive the driver from TestCase file 
	public a_Homepage(AndroidDriver<AndroidElement> driver) {
		
		this.driver = driver;
		//	All the Elements from this PageFactory class will be INITIALIZED/ Concatenated with driver using the object of AppiumFieldDecoratory.
		//		thus making the code to behave as driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
		//	AppiumFieldDecorator provides the compatibility for Android and iOS platforms
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement preferences;
	
	//	We we specify like above lines, Appium will by-default treat it as the below code
	//		public WebElement Preferences = findElement(By.xpath("//android.widget.TextView[@text='Preference']")); 
	//			Note: driver is missing. This will be concatenated with findElements method using Pagefactory.initElements(driver,this) method
	//	In case of iOS we'll use @IOSFindBy
	
	
	
	
	
	
	
}
