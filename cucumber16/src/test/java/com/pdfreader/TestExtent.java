package com.pdfreader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class TestExtent {
	
	public WebDriver driver;
	public ExtentHtmlReporter Report;//giving path to report
	public ExtentReports extent;// generating reports
	public ExtentTest test;//update status in report
	
	
	@BeforeTest
	public void extentreportsetup(){
		Report = new ExtentHtmlReporter("E:\\Prajakta's doc\\Gulshan\\Task\\ExtentReport1.html");
		Report.config().setReportName("Functional Testing");
		extent = new ExtentReports();
		extent.attachReporter(Report);
		
	}
	
	@AfterTest
	public void cleanup(){
		extent.flush();
	}
	
 @BeforeMethod
 public void setup(){
	 System.setProperty("webdriver.chrome.driver", "C:\\64\\SeleniumNew\\chromedriver_win32_B39\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.facebook.com/");
	 
	 
 }
	
	
	@Test
	public void Mylogin1() throws InterruptedException{
		test =extent.createTest("NewTest1");
//		String title = driver.getTitle();
//		System.out.println(title);
//		Assert.assertEquals(title, "Facebook-log in or sign up");
        WebElement web = driver.findElement(By.id("email"));
        web.sendKeys("prajakta@gmail.com");
        WebElement web2= driver.findElement(By.id("pass"));
        web2.sendKeys("test");
        driver.findElement(By.id("u_0_a")).click();
        Thread.sleep(4000);
        Boolean status = driver.findElement(By.xpath("//a[text()='Home']")).isDisplayed();
        Assert.assertTrue(status);
        driver.close();
        //test.log(Status.FAIL, "Loginfail");
		
	}
	@Test
	public void Mylogin2() throws InterruptedException{
		test =extent.createTest("NewTest2");
        WebElement web = driver.findElement(By.id("email"));
        web.sendKeys("prajaktatanelwar@gmail.com");
        WebElement web2= driver.findElement(By.id("pass"));
        web2.sendKeys("shreeram@123");
        driver.findElement(By.id("u_0_a")).click();
        Thread.sleep(5000);
        Boolean status = driver.findElement(By.xpath("//a[text()='Home']")).isDisplayed();
        Assert.assertTrue(status);
        driver.close();
        //test.log(Status.PASS, "LoginSuccessfull");
}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL,"TestCase Failed is"+result.getName());//to add name in extent report
			test.log(Status.FAIL,"TestCase Failed is"+result.getThrowable());//to add error/exception
			String screenshotpath = TestExtent.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
			
			
		}else if(result.getStatus()==ITestResult.SKIP){
			test.log(Status.SKIP, "TestCase Skipped is"+result.getName());
			
		}else if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS, "TestCase passed is"+result.getName());
		}
		
	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotname) throws IOException{
		String date= new SimpleDateFormat("ddMMyyyy").format(new Date());
		TakesScreenshot obj= (TakesScreenshot)driver;
		File srcfile = obj.getScreenshotAs(OutputType.FILE);
		String dsnt ="E:\\Prajakta's doc\\ExtentReport\\ "  +screenshotname + date+".png";
		File finaldsnt = new File(dsnt);
		FileUtils.copyFile(srcfile,finaldsnt);
		return dsnt;
		
		
		
	}
}
