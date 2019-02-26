package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {

	//Declare WebDriver
	WebDriver driver;
	//Element Locators
	 By onewayRadio = By.xpath("//input[@value='oneway']");
	By fromPortDrop = By.name("fromPort");
	By fromDayDrop = By.name("fromDay");
	By businessRadio = By.xpath("//input[@value='Business']");
	By findFlightsButton = By.name("findFlights");

        //Constructor. Driver Initialization
	public FlightFinderPage(WebDriver driver) {
		this.driver = driver;
	}

	public SelectFlightPage findFlights(String departFrom, String departDate) {
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

		/*
		 * return type of this method is a new object to next page
		 */
		return new SelectFlightPage(driver);
	}
}