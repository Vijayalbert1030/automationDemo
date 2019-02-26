package com.auto.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptExec {

	 static WebDriver driver;
	 
	 @BeforeClass
		public void setUpBeforeClass() throws Exception {
			System.setProperty("webdriver.chrome.driver", "/Users/vijay.kumar.albert/Documents/AdvancedSelenium/SeleniumMiniProject/driver/chromedriver");
		    driver = new ChromeDriver();
		}
	 @Test
	public void test() {
		// TODO Auto-generated method stub
		driver.get("https://www.saucelabs.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("lga")).click();
		WebElement href = driver.findElement(By.name("lga"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("argument[0].click();", href);
		jse.executeAsyncScript("argument[0].click();", href);
		String domain_name=(String) jse.executeScript("return document.domain");

        System.out.println(domain_name);
			

	}

}
