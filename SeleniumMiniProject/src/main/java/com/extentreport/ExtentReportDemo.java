package com.extentreport;

import static org.junit.Assert.*;
import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

public class ExtentReportDemo {
	
	static ExtentReports extent;
	ExtentTest logger;

	@BeforeClass
	public static void startReport() throws Exception {
		
		extent = new ExtentReports ("//Users//vijay.kumar.albert//Desktop//FinalExtentReport.html", true);
		
		extent.addSystemInfo("Host Name", "Automation")
			  .addSystemInfo("Environment", "Demo")
			  .addSystemInfo("User Name", "John");
			                
		extent.loadConfig(new File ("//Users//vijay.kumar.albert//Desktop//extent-config.xml"));
		
	}

	@Test
	public void test1() {
		logger = extent.startTest("passTest");
		logger.log(LogStatus.PASS, "Test Case Status is passed");

	}
	public void test2() {
		logger = extent.startTest("passTest");
		logger.log(LogStatus.PASS, "Test Case Status is passed");
		extent.endTest(logger);
		extent.flush();
		extent.close();

	}
	
	

	}


