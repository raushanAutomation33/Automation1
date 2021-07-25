/**
 * 
 */
package com.AAE.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 * @author Raushan Pandey
 *
 */
public class SignIn_EmailID {

	WebDriver driver;
	
	/**
	 * @author Raushan
	 * Constructor created below
	 *
	 */
	
	public SignIn_EmailID(WebDriver driver) 
	{
		this.driver= driver;
	}
	
	/**
	 * @author Raushan
	 *	Required WebElements located below using different locators
	 */
	
	By EmailID_InputField = By.id("identifierId");
	By NextButton = By.xpath("//span[@class='VfPpkd-vQzf8d' and text()='Next']");
	
	
	
	/**
	 * @author Raushan
	 *	Required methods to perform login operation 
	 */
	public void LoginStep1(String EmailID) 
	{
		
		driver.findElement(EmailID_InputField).sendKeys(EmailID);
		driver.findElement(NextButton).click();
	}
	
	
}
