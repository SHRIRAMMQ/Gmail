package com.automation;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;



public class StepDefinitions {

	private WebDriver driver = null;

 	@Before
  public void iOpenTheBrowserAndNavigateToTheURL() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
driver.get("https://opensource-demo.orangehrmlive.com ");

	}

@BeforeStep
 public void iEnterTheUsernameAndPasswordAndClickOnTheLoginButton() {
driver.findElement(By.name("username ")).sendKeys("Admin");
		driver.findElement(By.name("password ")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();

	}



@When(" I add employee ")
	public void iAddEmployee() throws Exception {

		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("menu_pim_addEmployee")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("firstName")).sendKeys("SRIKRISHNA");

		driver.findElement(By.id("lastName")).sendKeys("A");

String id = driver.findElement(By.id("employeeId")).getAttribute("value");

		System.out.println("Employee ID:" + id);

		driver.findElement(By.id("btnSave")).click();

	}

	@When(" I edit employee ")
	public void iEditEmployee() throws Exception {

		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("SRIKRISHNA A");

		driver.findElement(By.id("searchBtn")).click();

		driver.findElement(By.linkText("SRIKRISHNA")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Edit']")).click();

		driver.findElement(By.xpath("//input[@value='Save']")).click();

	}

@When(" I delete employee ")
	public void iDeleteEmployee() throws Exception {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("SRIKRISHNA A");

		driver.findElement(By.id("searchBtn")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("ohrmList_chkSelectAll")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("btnDelete")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("dialogDeleteBtn")).click();

	}


@AfterStep
    	public void iClickOnTheSignOffButton()  throws Exception {

		Thread.sleep(2000);
driver.findElement(By.xpath("(//img[@alt='profile picture'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();

	}

	@After
    	public void iCloseTheBrowser() {
		driver.quit();
	}


}
