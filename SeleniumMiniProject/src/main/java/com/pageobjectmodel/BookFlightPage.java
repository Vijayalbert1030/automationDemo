package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookFlightPage {

	//Declare WebDriver
	WebDriver driver;
	//Element Locators
	 By firstNameTextBox = By.name("passFirst0");
	By lastNameTextBox = By.name("passLast0");
	By ccNumberTextBox = By.name("creditnumber");
	By buyFlightsButton = By.name("buyFlights");

	//Constructor. Driver Initialization
	public BookFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	public FlightConfirmationPage bookFlight(String fname, String lname, String ccNumber) {
		// Enter first name
		driver.findElement(firstNameTextBox).sendKeys(fname);
		// Enter last name
		driver.findElement(lastNameTextBox).sendKeys(lname);
		// Enter credit card number
		driver.findElement(ccNumberTextBox).sendKeys(ccNumber);
		// Confirm purchase
		driver.findElement(buyFlightsButton).click();
		/*
		 * return type of this method is a new object to next page
		 */
		return new FlightConfirmationPage(driver);
	}
}