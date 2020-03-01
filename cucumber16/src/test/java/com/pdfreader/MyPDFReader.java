package com.pdfreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MyPDFReader {
	
	
	String PDFPath= "E:\\Prajakta's doc\\Gulshan\\Task\\Test Data\\TestData.pdf";
	@Test
	public void PDFReaderTest() throws InvalidPasswordException, IOException{
		File myfile = new File (PDFPath); //Create an object of File class to open file
		FileInputStream fis = new FileInputStream(myfile);//Create an object of FileInputStream class to read 
		PDDocument document =null;
		document= PDDocument.load(fis);
		String pdfcontent= new PDFTextStripper().getText(document);//Retrieving text from PDF document
		System.out.println(pdfcontent);
		Assert.assertTrue(pdfcontent.contains("INR"));
		System.out.println("Passport details found");
		
		ExtentHtmlReporter Ereport = new ExtentHtmlReporter("E:\\Reports\\firstreport.html");//for providing the path where you want to save report//look n feel of report
		//Ereport.config().setDocumentTitle("MyFirstPDFTest");//Title of report
		Ereport.config().setReportName("Functional Report");//name of report
		ExtentReports extent = new ExtentReports();//this class will create report//create entries(Test Case) in report
		extent.attachReporter(Ereport);
		//extent.setSystemInfo(k, v);//to add generic info host name,OS, tester name
		ExtentTest PDFreport1 = extent.createTest("PDFTest");//it is used to give name to test case//update status in report
		PDFreport1.log(Status.INFO,"PDFTest contents");//This is used to get log, here status information and details
	
		PDFreport1.log(Status.PASS,"Passport Details found");//this is use to give the test case which are pass
		//extent.flush();
		ExtentTest PDFreport2 = extent.createTest("PDFTest");//it is used to give name to test case
		PDFreport2.log(Status.INFO,"PDFTest contents");
		PDFreport2.log(Status.FAIL,"Details not found");
		PDFreport2.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath("E:\\Reports\\FailTest.png").build());
		extent.flush();
		
		document.close();
		
		
		
	}

}
