package com.RegisterUser;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterUserStepDef {
	WebDriver driver;
	
	@Given("^User should be on Demo home page$")
	public void user_should_be_on_Demo_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\64\\SeleniumNew\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(5000);
	    
	}

	
	@When("^User enters following details$")
	public void user_enters_following_details(DataTable table) throws Throwable {
	
	List<List<String>> data = table.raw();
      System.out.println(data.get(0).get(0)); //print the table column Name OR first element
      
      //reading columns 2nd's values
      System.out.println(data.get(1).get(1));
      System.out.println(data.get(2).get(1));
	      System.out.println(data.get(3).get(1));
	        driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys(data.get(1).get(1));
	      driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(data.get(2).get(1));
	      driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(data.get(3).get(1));
     Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data.get(4).get(1));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys(data.get(5).get(1));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='FeMale']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Movies']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Hockey']")).click();
	      
     Thread.sleep(2000);
    
   
}

	@Then("^User should be able to register demo site$")
	public void user_should_be_able_to_register_demo_site() throws Throwable {
		Assert.assertTrue(true);
	driver.close();
	    
	}



}
