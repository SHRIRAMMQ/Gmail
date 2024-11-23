package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_001_AddToCart {

	private WebDriver driver = null;

	// Open Browser
	@Parameters({ "Browser" })
	@BeforeTest
	public void openBrowser(String browser) {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
	}

	@DataProvider(name = "getTestData")
	public String[][] getTestData() {
		String[][] data = { { "standard_user", "secret_sauce" }};
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void addToCart(String userName, String password) throws Exception {

		// Login

		driver.findElement(By.id("user-name")).sendKeys(userName);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("login-button")).click();

		// AddToCart

		Thread.sleep(2000);

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		// Remove From Cart

		Thread.sleep(2000);

		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

		// Logout

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
