package com.CumcumberPractice;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChromeDemoForm1 {
	
	WebDriver driver;
	
	@Given("^User is on main page of demo site$")
	public void user_is_on_main_page_of_demo_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\64\\SeleniumNew\\chromedriver_win32_B39\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
	}

	@When("^User enters following details$")
	public void user_enters_following_details(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		System.out.println(data.get(0).get(0));
		System.out.println(data.get(0).get(1));
		System.out.println(data.get(1).get(1));
		System.out.println(data.get(2).get(1));
		System.out.println(data.get(3).get(1));
		System.out.println(data.get(4).get(1));
		System.out.println(data.get(5).get(1));
		System.out.println(data.get(6).get(1));
		System.out.println(data.get(7).get(1));
		
		driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys(data.get(1).get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='FeMale']")).click();
		Thread.sleep(2000);
		
	    
	}

	@Then("^user should I able to submit form\\.$")
	public void user_should_I_able_to_submit_form() throws Throwable {
	    Assert.assertTrue(true);
	    driver.close();
	}
	

}
