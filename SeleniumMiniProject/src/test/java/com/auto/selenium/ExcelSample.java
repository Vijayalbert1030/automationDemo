package com.auto.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.auto.utility.CaptureScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;


public class ExcelSample {
	
	static WebDriver driver;

	FileInputStream fileReading; 
	XSSFWorkbook workBookforScript1; 
	HSSFWorkbook workBookforScript2;
	
	XSSFSheet sheetDetailsForScript;
	String data1, data2, username, password, login;
	
	
	static ExtentReports extent;
	static ExtentTest logger;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/vijay.kumar.albert/Documents/AdvancedSelenium/SeleniumMiniProject/driver/chromedriver");
	    driver = new ChromeDriver();
	    extent = new ExtentReports ("//Users//vijay.kumar.albert//Desktop//FinalExtentReport1.html", true);
		extent.assignProject("testing");
		extent.addSystemInfo("Host Name", "Automation")
			  .addSystemInfo("Environment", "Demo")
			  .addSystemInfo("User Name", "John");
			                
		extent.loadConfig(new File ("//Users//vijay.kumar.albert//Desktop//extent-config.xml"));
		extent.startTest("Training", "The report generation is happening");


	}

	@Test
	public void test() throws IOException {
		
		
		String filepath  = "//Users//vijay.kumar.albert//Desktop//Userdata.xlsx";
		File fileForScript = new File(filepath);
		
		
		try(FileInputStream fileInputStreamForScript = new FileInputStream(fileForScript);){

			if(filepath.contains("xlsx")) {
				workBookforScript1 = new XSSFWorkbook(fileInputStreamForScript);
			}else{
				workBookforScript2 = new HSSFWorkbook(fileInputStreamForScript);
			}
			sheetDetailsForScript = workBookforScript1.getSheetAt(0);
			int rows = sheetDetailsForScript.getPhysicalNumberOfRows();
		    System.out.println("The number of rows filled is ----->"+rows);
			 
		    
		HSSFWorkbook workbook = new HSSFWorkbook();
		workbook.createSheet("Testing");
		HSSFSheet sheet = workbook.createSheet("FirstSheet");  

        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("No.");
        rowhead.createCell(1).setCellValue("Name");
        
		driver.get("http://www.newtours.demoaut.com/");
		driver.manage().window().maximize();
		
		String a3 = sheetDetailsForScript.getActiveCell();
		System.out.println(a3);
		data1=sheetDetailsForScript.getRow(1).getCell(0).getStringCellValue();
		data2=sheetDetailsForScript.getRow(2).getCell(0).getStringCellValue();
		
		username=sheetDetailsForScript.getRow(1).getCell(1).getStringCellValue();
		password=sheetDetailsForScript.getRow(2).getCell(1).getStringCellValue();
		login=sheetDetailsForScript.getRow(3).getCell(1).getStringCellValue();
		
		driver.findElement(By.name(username)).sendKeys(data1);
		driver.findElement(By.name(password)).sendKeys(data2);
		driver.findElement(By.name(login)).click();
		
		sheetDetailsForScript.getRow(3).getCell(0).setCellValue("Executed");
	    FileOutputStream fileOut = new FileOutputStream(filepath);
	    workBookforScript1.write(fileOut);
	    fileOut.close();
	    
	    String imagePath = "//Users//vijay.kumar.albert//Desktop//Screenshots//screenshot1.png";
	    CaptureScreenshot.captureScreenshot(driver, imagePath);
	    
		workBookforScript1.close();
		workbook.close();

		logger = extent.startTest("Login Scenario");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case is passed");

		
	  }	
		
	 }
		
		@Test
		 public  void step2() {
		 logger.log(LogStatus.PASS, "Test Case  is passed");
		 logger.addScreenCapture(imagePath);
		 logger.assignCategory(categories);
			  
	}
		
		@Test
		 public  void step3() {
		 logger.log(LogStatus.FAIL, "Test Case is failed");
		 
			extent.endTest(logger);
			extent.flush();
			
		  
	}
	
}
	


