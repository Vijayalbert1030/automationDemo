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

public class ActionsSampleScript {
	
	static WebDriver driver;



	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/vijay.kumar.albert/Documents/AdvancedSelenium/SeleniumMiniProject/driver/chromedriver");
	    driver = new ChromeDriver();
	}

	@Test
	public void test() {
		
		driver.get("http://jqueryui.com/droppable/#default");
		driver.manage().window().maximize();
		driver.findElement(By.name("userName")).sendKeys("demoUser1");
		driver.findElement(By.name("password")).sendKeys("demoPassword");

		Actions ac = new Actions(driver);
		WebElement login = driver.findElement(By.name("login"));
		ac.moveToElement(login).click().keyDown(login);
		ac.build();
		ac.perform();
	  }	
		  
	}


