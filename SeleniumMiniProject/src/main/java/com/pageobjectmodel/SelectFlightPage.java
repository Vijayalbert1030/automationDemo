package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectFlightPage {

	//Declare WebDriver
	WebDriver driver;
	//Element Locators
	By reserveFlightsButton = By.name("reserveFlights");
        
        //Constructor. Driver Initialization
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	// Reserve Flight method
	public BookFlightPage reserveFlight() {
		// Click reserve Flights button
		driver.findElement(reserveFlightsButton).click();
		/*
		 * return type of this method is a new object to next page
		 */
		return new BookFlightPage(driver);
	}
}