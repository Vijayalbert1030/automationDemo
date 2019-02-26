package com.pageobjectmodel;

import org.testng.annotations.Test;
import com.pageobjectmodel.HomePage;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

public class BookFlight {

	WebDriver driver;
	HomePage homePage;

	//Test Case
	@Test(dataProvider = "newTourData")
	
	public void bookFlight(String uname, String pwd, String departFrom, String departDate, String fname, String lname,
			String ccNum) {
		// Create an object of HomePage
		homePage = new HomePage(driver);
        /*
         * Test case logic.
         * Notice the return type of methods
         * are objects to next page.
         * */
		homePage.loginUser(uname, pwd);
		homePage.findFlights(departFrom, departDate);
		
		/*.findFlights(departFrom, departDate)
		.reserveFlight()
		.bookFlight(fname, lname, ccNum);*/

	}

	//Driver Initialization
	@BeforeMethod
	public void beforeMethod() {
		// Initialize driver
		driver = new ChromeDriver();
		// Maximize window
		driver.manage().window().maximize();
		// Nvaigate to URL
		driver.get("http://newtours.demoaut.com");
	}

	//Driver closure
	@AfterMethod
	public void afterMethod() {
		// Close and quit the driver to close the Browser
		driver.close();
		driver.quit();
	}

	//Create test data
	@DataProvider
	public Object[ ][ ] newTourData() {
		return new Object[ ][ ] { { "demo", "demo", "Yajiv", "7", "Albert", "Doe", "56465465" } };
	}

	//Setting System property
	@BeforeTest
	public void beforeTest() {
		// Set System Property
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Chrome/chromedriver");
	}
}
