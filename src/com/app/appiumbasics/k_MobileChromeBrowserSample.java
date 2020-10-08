package com.app.appiumbasics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class k_MobileChromeBrowserSample extends j_BaseChrome {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// receive driver + Empty browser opened
		AndroidDriver<AndroidElement> driver = capabilities("virtual");
		
		// get the URL in the empty browser
//		driver.get("https://www.facebook.com");
//		driver.findElement(By.xpath("//input[@id='m_login_email']")).sendKeys("sumit.saha.1988@gmail.com"); 
//		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("#Adm4n2020");	
		
		// Auto redirection from URL to Mobile version of URL since the webpage is NOT WEB-RESPONSIVE
		driver.get("https://www.cricbuzz.com");
		
		// Click on "Menu" on right side
		driver.findElement(By.xpath("//a[@href='#menu']")).click();
		
		//Click on "Home" link
		driver.findElement(By.xpath("//a[@title='Cricbuzz Home']")).click();

		// verifying the actual url accessed by Mobile Browser
		System.out.println(driver.getCurrentUrl());
	}
}
