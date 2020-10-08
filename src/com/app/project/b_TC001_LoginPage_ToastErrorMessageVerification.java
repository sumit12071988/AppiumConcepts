package com.app.project;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class b_TC001_LoginPage_ToastErrorMessageVerification extends a_Base {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = null;
		
		// Receiving driver from Base class + Open App
		driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Click on "Lets Shop" button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
		
		// Toast Message verification
		String toastErrorMsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toastErrorMsg);
		
		Assert.assertEquals(toastErrorMsg, "Please enter your name");
	}
}
