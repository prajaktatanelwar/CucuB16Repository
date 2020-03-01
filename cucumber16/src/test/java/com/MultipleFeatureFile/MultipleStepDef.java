package com.MultipleFeatureFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MultipleStepDef {
	public static WebDriver driver;
	@Given("open facebook page")//when we are entering ^ and $ then it will restrict the data
	public void OpenFacebookPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\64\\SeleniumNew\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		
	}
	
	@When("^I enter login name$")
	public void i_enter_login_name() throws Throwable {
		
	driver.findElement(By.id("email")).sendKeys("Prajakta");
	    
	}

	@Then("^I verify textbox value$")
	public void i_verify_textbox_value() throws Throwable {
	   driver.close();
	}


}
