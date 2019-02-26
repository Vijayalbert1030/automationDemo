package com.auto.selenium;

import org.junit.Test;
//import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class FirstScript  {
	
	          @Test
	          public void site_header_is_on_home_page() {

	                   System.setProperty("webdriver.chrome.driver", "/Users/vijay.kumar.albert/Documents/AdvancedSelenium/SeleniumMiniProject/driver/chromedriver");
	                   WebDriver driver = new ChromeDriver();
	                   driver.get("https://www.saucelabs.com");
	                   WebElement href = driver.findElement(By.xpath("//a[@href='/beta/login']"));
	                   assertTrue((href.isDisplayed()));
	                   driver.close();       

	}

	}

