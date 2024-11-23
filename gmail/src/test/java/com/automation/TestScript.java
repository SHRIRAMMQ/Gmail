package com.automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		
		driver.manage().window().maximize();
		
		driver.get("https://tax2win.in/efile-income-tax-return/upload-form16");
						
		Thread.sleep(5000);
		
		driver.quit();
	
	}

}
