package com.pageobjectmodel;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class loadableComponent {
	


	public class LoginPageUsingLoadableComponent extends LoadableCompenent<HomePage> {

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
	   

	public LoginPageUsingLoadableComponent(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	public FlightFinderPage loginUser(String uname, String pwd){
	driver.findElement(userName).sendKeys(uname);
		// Enter password
	driver.findElement(password).sendKeys(pwd);
		// Click Login button
	driver.findElement(loginButton).click();
	
	return new FlightFinderPage(driver);
	}

	@Override
	protected void load() {
	driver.get("http://newtours.demoaut.com");
	}

	@Override
	protected void isLoaded() throws Error {
	Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

	}

	LoginPageU

}
