package com.extentreport;

import java.io.File;
	 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportgenaration {
		
		 ExtentReports extent;
		 ExtentTest logger;
		 
	public void startReport(){
		 
	extent = new ExtentReports ("//Users//vijay.kumar.albert//Desktop//STMExtentReport.html", true);
		
	extent.addSystemInfo("Host Name", "SoftwareTestingMaterial")
		  .addSystemInfo("Environment", "Automation Testing")
		  .addSystemInfo("User Name", "Rajkumar SM");
		                
	//extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	extent.loadConfig(new File ("//Users//vijay.kumar.albert//Desktop//extent-config.xml"));
	logger = extent.startTest("passTest");
	extent.endTest(logger);
	extent.flush();
	extent.close();
		 }
	

	public void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExtentReportgenaration eg = new ExtentReportgenaration();
		eg.startReport();

	}
	
}


