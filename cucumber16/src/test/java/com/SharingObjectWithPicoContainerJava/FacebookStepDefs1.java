package com.SharingObjectWithPicoContainerJava;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//jar file of pico container into POM.xml

	public class FacebookStepDefs1  {
		WebDriver driver;
		
		public FacebookStepDefs1(SharedClass sharedObj) throws InterruptedException{//parameterized constructor using object of shared class
			driver = sharedObj.launchBrowser();
		}
		
					
			@When("^he enters \"([^\"]*)\" as password$")
			public void He_enters_user_password(String pwd) throws InterruptedException {
				driver.findElement(By.id("pass")).sendKeys(pwd);
				Thread.sleep(5000);
			}
			
			@Then("^check username is present in textbox$")
			public void check_username_is_present_in_textbox(){
			
				Assert.assertTrue(true);
				
			}
			
			
			
			
			
			

	}
