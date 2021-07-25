/**
 * 
 */
package com.AAE.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Raushan
 *
 */
public class SignIn_Password {
	
	WebDriver driver;
	WebDriverWait wait;
	
	/**
	 * @author Raushan
	 * Constructor created below
	 *
	 */
	public SignIn_Password(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
	
	/**
	 * @author Raushan
	 *	Required WebElements located below using different locators
	 */
	
	By password = By.xpath("//input[@name='password']");
	By NextButton = By.xpath("//span[@class='VfPpkd-vQzf8d' and text()='Next']");
	
	
	
	
	
	/**
	 * @author Raushan
	 *	Required methods to perform Login operation 
	 */
	public void loginStep2(String UsersPassword)
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(password));
		
		driver.findElement(password).sendKeys(UsersPassword);
		driver.findElement(NextButton).click();
	}
}
