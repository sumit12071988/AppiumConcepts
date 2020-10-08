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
public class d_TC003_CheckoutPage extends a_Base {
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
		
		// Collect individual Strings for price
		 String product1PriceLbl = productsList.get(0).getText();	// o/p: "$165.0"
		 String product2PriceLbl = productsList.get(1).getText();	// o/p: "$120.0"
		 String checkOutTotalLbl = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();		// O/p: "$285.0"
		 
		// Separating $ from price
		 String product1Price = product1PriceLbl.substring(1);		// O/p: "165.0"
		 String product2Price = product2PriceLbl.substring(1);		// O/p: "120.0"
		 String checkOutTotal = checkOutTotalLbl.substring(1);		// O/p: "285.0"
		 
		 // Parsing String to Double
		 Double product1cost = Double.parseDouble(product1Price);	// O/p: 165
		 Double product2cost = Double.parseDouble(product2Price);	// O/p: 120
		 Double actualSumDisplayed = Double.parseDouble(checkOutTotal);	// This is Actual Amt
		
		 // Adding the Double values
		 Double expectedSum = product1cost + product2cost;			// This is Expected Amt		 
		 
		 System.out.println("Actual Sum: "+actualSumDisplayed);
		 System.out.println("Expected Sum: "+expectedSum);
		 
		 Assert.assertEquals(actualSumDisplayed,expectedSum );
	}
	
	
	public Double getAmount(String value) {
		Double productPrice = Double.parseDouble(value.substring(1));
		
		return productPrice;
	}
	
}
