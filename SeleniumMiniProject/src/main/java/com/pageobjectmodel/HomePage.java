package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	//Element Locators
	By userName = By.name("userName");
	By password = By.name("password");
	By loginButton = By.name("login");
	By onewayRadio = By.xpath("//input[@value='oneway']");
	By fromPortDrop = By.name("fromPort");
	By fromDayDrop = By.name("fromDay");
	By businessRadio = By.xpath("//input[@value='Business']");
	By findFlightsButton = By.name("findFlights");
   
	
	public HomePage(WebDriver driver) {
		this.driver = driver;


	}

	// Login method
	public void loginUser(String uname, String pwd) {
		// Enter username
	driver.findElement(userName).sendKeys(uname);
		// Enter password
	driver.findElement(password).sendKeys(pwd);
		// Click Login button
	driver.findElement(loginButton).click();
	
	//return new FlightFinderPage(driver);
	
	}
	

	}
}
	
	public BookFlightPage findFlights(String departFrom, String departDate) {
		// Click one way radio button
		driver.findElement(onewayRadio).click();
		// Select Departing From dropdown
		Select dropFrom = new Select(driver.findElement(fromPortDrop));
		dropFrom.selectByValue(departFrom);

		// Select Departing Day dropdown
		Select dropDay = new Select(driver.findElement(fromDayDrop));
		dropDay.selectByValue(departDate);

		// Click business class
		driver.findElement(businessRadio).click();

		// Click Find Flights button
		driver.findElement(findFlightsButton).click();

		return new BookFlightPage(driver);
	
	}
}
