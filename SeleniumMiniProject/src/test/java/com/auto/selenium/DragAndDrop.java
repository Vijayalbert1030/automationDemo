package com.auto.selenium;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import java.io.FileNotFoundException;
import java.io.IOException;



import org.junit.Before;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class DragAndDrop {
	
	static WebDriver driver;



	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/vijay.kumar.albert/Documents/AdvancedSelenium/SeleniumMiniProject/driver/chromedriver");
	    driver = new ChromeDriver();
	}

	@Test
	public void test() throws Throwable {
		
		driver.get("http://jqueryui.com/droppable/#default");
		driver.manage().window().maximize();
		
		//Creating an instance for an object
		Actions act = new Actions(driver);
		
		WebElement iFrame = driver.findElement(By.tagName("iframe"));
	    System.out.println(iFrame.getSize());
	    driver.switchTo().frame(iFrame);
	    
	   //Web element for Drag
	    WebElement From = driver.findElement(By.id("draggable"));
	    System.out.println(From.getLocation());
	 
	    //Web element for Drop
	    WebElement To = driver.findElement(By.id("droppable"));
	    System.out.println(To.getLocation());

	    //Method1
	    /*act.clickAndHold(From).build().perform();
	    act.moveToElement(To).build().perform();
	    act.release(To).build().perform();*/
	    
	    //Method2
	    /*act.dragAndDropBy(Source, xoffset, yoffset).perform();
	    act.dragAndDropBy(From, 140, 18).build().perform();*/
	    
	    //Method3
	    act.dragAndDrop(From, To);
	    act.build().perform();
	    wait();
	    
	    //For a Context Click
	    wait();
		act.contextClick(To).build().perform();
		//driver.quit();
		

	  }	
		  
	}


