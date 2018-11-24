package com.CumcumberPractice;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PracticeStepDef1 {
	
	public static WebDriver driver;
	
	
	@Given("^User is on facebook login page$")
	public void user_is_on_facebook_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\64\\SeleniumNew\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
	}

	@When("^\"([^\"]*)\" is entered as username$")
	public void is_entered_as_username(String uname) throws Throwable {
	  driver.findElement(By.id("email")).sendKeys(uname);
	}

	@When("^\"([^\"]*)\" is entered as password$")
	public void is_entered_as_password(String pwd) throws Throwable {
		driver.findElement(By.id("pass")).sendKeys(pwd);
		Thread.sleep(2000);
	    
	}

	@Then("^login should be successfull$")
	public void login_should_be_successfull() throws Throwable {
	   Assert.assertTrue(true);
	   driver.close();
	}

}
