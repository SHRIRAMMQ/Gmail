package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_003_AddRemoveCart {
	
	private WebDriver driver = null;

	// Open Browser
	@BeforeTest
	public void openBrowser() {

		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
	}

	// Login
	@BeforeMethod
	public void login() {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

	}

	@Test(priority =1 )
	public void addToCart() throws Exception {
		
		//AddToCart
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		
	}
	
	@Test(priority = 2)
	public void addRemoeCart() throws Exception {
		
	
		//Remove From Cart
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

		
			
	}
	
	// Logout
	@AfterMethod
	public void logout() throws Exception {

		driver.findElement(By.id("react-burger-menu-btn")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("logout_sidebar_link")).click();

	}

	// CloseBrowser
	@AfterTest
	public void closeBrowser() throws Exception {

		Thread.sleep(5000);

		driver.quit();
	}




}
