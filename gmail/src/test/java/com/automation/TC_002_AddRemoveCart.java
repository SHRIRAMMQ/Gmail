package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_002_AddRemoveCart {

	
	@Test(enabled = true,description = "This method is used to test Add to Cart and Remove From Cart Functionality",invocationCount = 1)
	public void addRemoeCart() throws Exception {
		
		//Open Browser
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		//Login
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		//AddToCart
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		//Remove From Cart
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

		
		//Logout
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		
		//CloseBrowser
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
