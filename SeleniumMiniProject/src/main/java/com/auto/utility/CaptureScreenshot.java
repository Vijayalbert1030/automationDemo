package com.auto.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	
	public static void captureScreenshot (WebDriver driver, String imagePath) throws IOException {
		

	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	try {
	
	FileUtils.copyFile(scrFile, new File("imagePath"));	
	
	}
	catch (IOException message)
	
	{
		System.out.println(message.getMessage());
	}
	
	}

}
