package com.app.appiumbasics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class l_MobileChromeBrowser_ScrollToView extends j_BaseChrome {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// receive driver + Empty browser opened
		AndroidDriver<AndroidElement> driver = capabilities("virtual");
		
		// Auto redirection from URL to Mobile version of URL since the webpage is NOT WEB-RESPONSIVE
		driver.get("https://www.cricbuzz.com");
		
		// Click on "Menu" on right side
		driver.findElement(By.xpath("//a[@href='#menu']")).click();
		
		//Click on "Home" link
		driver.findElement(By.xpath("//a[@title='Cricbuzz Home']")).click();

		// Scrolling Down to VIEW a particular element
		WebElement element_AndroidLink = driver.findElement(By.xpath("//a[text()='Android']"));
		
		JavascriptExecutor js = (driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element_AndroidLink);
		
		if (element_AndroidLink.isDisplayed()){
			element_AndroidLink.click();
		}

	}
}
