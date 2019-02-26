package com.auto.selenium;

import static org.junit.Assert.*;

import java.sql.Driver;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.servlet.http.Cookie;


public class CookieTest {
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/vijay.kumar.albert/Documents/AdvancedSelenium/SeleniumMiniProject/driver/chromedriver");
		driver = new ChromeDriver();
		
	}

	@Test
	public void test() {
		driver.get("https://www.saucelabs.com");
		driver.manage().window().maximize();
		WebElement token = driver.findElement(By.name("lga"));
		Cookie name = new Cookie("Token", token);
		driver.manage().addCookie();
		
		
		
		
	}

}
