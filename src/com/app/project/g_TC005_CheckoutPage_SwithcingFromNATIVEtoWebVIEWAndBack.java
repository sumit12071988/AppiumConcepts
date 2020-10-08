package com.app.project;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * TO Validate sum of mulitple products chosen in Homepage is appearing in Checkout page
 * @author Batto
 *
 */
public class g_TC005_CheckoutPage_SwithcingFromNATIVEtoWebVIEWAndBack extends a_Base {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = capabilities("virtual");		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//----------- LOGGING IN TO APP ----------
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sumit");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
// ----------PRODUCT SELECTIONS PAGE ----------
		
	// ----- PRODUCT #1 Selection by Scroll and Select ---------
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");
		
		List<AndroidElement> visibleList = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		int count = visibleList.size();
		
		for (int i = 0; i < count; i++) {
			String text = visibleList.get(i).getText();
			
			if (text.equalsIgnoreCase("Jordan 6 Rings")) {
				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}			
		}
		
		

	// ----- PRODUCT #2 Selection by Scroll and Select ---------
		driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))"
						+ ".scrollIntoView(new UiSelector()"
						+ ".textMatches(\"Air Jordan 1 Mid SE\")"
						+ ".instance(0))"));
	
	List<AndroidElement> visibleList2 = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
	int count2 = visibleList2.size();
	
	for (int i = 0; i < count2; i++) {
		String text = visibleList2.get(i).getText();
		
		if (text.equalsIgnoreCase("Air Jordan 1 Mid SE")) {
			
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			break;
		}
	}
		
			
		
	// ----- click on "Add to Cart" btn
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
		
		
// ----------CHECKOUT PAGE ----------		
		
	// ----- Summing up two product prices ----------
		
		// Add a timeout to avoid staleElementException
		Thread.sleep(4000);
		
		 // Tap on the checkbox to send email
		 WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
		 
		 TouchAction touchAction = new TouchAction(driver);
		 touchAction.tap(tapOptions().withElement(element(checkBox))).perform();

		 
		// click on "Visit the website to complete the purchase"
		 driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		 

// --------- SWITCHING FROM NATIVE_APP to WEBVIEW -----------
		 
		 
		 // Collecting all ContextHandles as a Set
		 Set<String> contexts = driver.getContextHandles();
		 
		 // To print all the contexts 
		 for (String context : contexts) {
			System.out.println(context);
		}
		 
		 // Switching to WebView using context names
		 Thread.sleep(7000);
		 driver.context("WEBVIEW_com.androidsample.generalstore");
		 
		 // Elements in WebView will be same as that appearing in Webpage. Thus we can now use Selenium specific attribute as well like
		 //		name, cssSelector etc..

		 driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Cyclone Amphan update");
		 driver.findElement(By.xpath("//button[@class='Tg7LZd']")).click();		 
		 Thread.sleep(5000);
		 
		 // pressing Android "BACK" mechanical button
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
		 // Switching to NATIVE_APP using context names
		 driver.context("NATIVE_APP");
	}
	
}
