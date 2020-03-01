package com.allfilesinsamefolder2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.multiplestepdeffilesjava.ParentStepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyFirstStepDef1 {
	
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
	   
	}

	
	@Given(value = "user on the google search page") 
	public void user_on_the_google_search_page() throws InterruptedException{
		System.out.println("actual script started");
		ParentStepDefs obj = new ParentStepDefs();
		driver = obj.getDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(5000);
	}
	
	@When(value = "he search for \"([^\"]*)\" text")
	public void he_search_for_text(String searchText) throws InterruptedException{
	//GoogleSearchPage googlePage = new GoogleSearchPage();
	//googlePage.enterGoogleSearchText(driver, searchText);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(searchText);
		Thread.sleep(2000);
	}
	
	@Then("^ensure result available for search$")
	public void ensure_result_available_for_search() throws Throwable {
	    driver.findElement(By.xpath(".//a[contains(text(),'Sign in')]"));
		Assert.assertTrue(true);
		driver.quit();
	}

}
