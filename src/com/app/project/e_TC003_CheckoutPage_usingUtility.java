package com.app.project;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * TO Validate sum of mulitple products chosen in Homepage is appearing in Checkout page
 * @author Batto
 *
 */
public class e_TC003_CheckoutPage_usingUtility extends a_Base {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = capabilities("real");		
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
		
		// We notice both products has same id, so we collects both elements in a list and use get(0) and get(1) to perform actions
		List<AndroidElement> productsList = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		// Selecting each item in the List --> Finding the Double version of the amt --> Summing it up to find EXPECTED VALUE
		double expectedSum =0;
		for (int i = 0; i < productsList.size(); i++) {
			String label = productsList.get(i).getText();
			double amt = getAmount(label);		// before this we've created the utility getAmount(String value)
			expectedSum = expectedSum +amt;
		}
		
		// Capturing the price in total shown on app to find ACTUAL VALUE
		 String checkOutTotalLbl = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();		// O/p: "$285.0"
		 double actualSumInApp = getAmount(checkOutTotalLbl);	// This is Actual Amt
	 
		 
		 System.out.println("Actual Sum: "+actualSumInApp);
		 System.out.println("Expected Sum: "+expectedSum);
		 
		 Assert.assertEquals(actualSumInApp,expectedSum );
	}
	

// ***********************  UTILITY CREATION ***************************//

	/**
	 * Creating a Utlity that:
	 * Takes a String -->removes $ using substring() --> parses String to Double --> returns the price as double
	 * @param value
	 * @return
	 */
	public static double getAmount(String value) {
		double productPrice = Double.parseDouble(value.substring(1));
		
		return productPrice;
	}
	
}
