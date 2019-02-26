package com.pageobjectmodel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FlightConfirmationPage {

	//Declare WebDriver
	WebDriver driver;
	//Element Locators
	By confirmationText = By.xpath("//font[contains(text(),'Confirmation')]");
	By logOutButton = By.xpath("//img[@src='/images/forms/Logout.gif']");

	//Constructor. Driver Initialization
	public FlightConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	//Verify and Log out method
	public void clickLogOut() {
		// Assert if Confirmation text is displayed
		Assert.assertTrue(driver.findElement(confirmationText).isDisplayed());
		// Click Logout button
		driver.findElement(logOutButton).click();
	}
}
